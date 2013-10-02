package lu.snt.serval.pla.privacyawarecomp;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 30/09/13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.*;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
import org.kevoree.framework.MessagePort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;


import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.log.Log;

import java.util.Hashtable;


@Provides({
        @ProvidedPort(name = "PrivacyProfileIn", type = PortType.MESSAGE),
        @ProvidedPort(name = "CloakerIn", type = PortType.MESSAGE),
})

@Requires({
        @RequiredPort(name = "PrivacyProfileOut", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "CloakerOut", type = PortType.MESSAGE, optional = true),
})


@DictionaryType({
//        @DictionaryAttribute(name = "StepInMin", optional = true),
        //      @DictionaryAttribute(name = "PeriodInMs", optional = true),

})


//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public class PrivacyAwareComp extends  org.kevoree.framework.AbstractComponentType implements PlaInterface {

    private Server server;
    private Drop d;
    private Query q;
    private int queryCount  ;
    private ModelFactory factory;

    public PrivacyAwareComp() {
        factory = new DefaultModelFactory();
    }

    public void runQuery()
    {
        if(queryCount<q.getQueryRequests().size())
        {
            Query temp = factory.createQuery();
            QueryPrivacyProfile qpp =   factory.createQueryPrivacyProfile();
            temp.setUserProfile(q.getUserProfile());
            qpp.setOwningQuery(temp);
            QueryDataType qr = (QueryDataType) q.getQueryRequests().get(queryCount);
            qpp.setDataType(qr.getDataType());
            MessagePort prodPort =  getPortByName("PrivacyProfileOut", MessagePort.class);
            if (prodPort != null) {
                prodPort.process(qpp);
            }
        }
        else
        {
            //Return the answer to the server, which will return it to the client
            d.put(q);
        }

    }

    @Port(name = "CloakerIn")
    public void incomingCloaker(Object o) {
        AnswerDataType ans = (AnswerDataType) o;
        q.addAnswers(ans);
        queryCount++ ;
        runQuery();

    }

    @Port(name = "PrivacyProfileIn")
    public void incomingPrivacyProfile(Object o) {
        System.out.println("Incoming privacy profile");

        AnswerPrivacyProfile app = (AnswerPrivacyProfile) o;
        QueryCloaker qc = factory.createQueryCloaker();
        qc.setPrivacyRule(app.getPrivacyRule());
        QueryDataType qr = (QueryDataType) q.getQueryRequests().get(queryCount);
        qc.setQueriedDataType(qr);

        MessagePort prodPort =  getPortByName("CloakerOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(qc);
        }

    }

    public void receiveQuery(Query q, Drop d) {
        System.out.println("Server has Received a query")   ;
        this.d=d;
        this.q=q;
        queryCount=0;
        runQuery();


     /*   MessagePort prodPort = getPortByName("PrivacyProfileOut", MessagePort.class);
        prodPort = getPortByName("ConsOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process();
        }   */


    }

    @Start
    public void start() {
        server = new Server(this);
        server.start();
        Log.debug("Privacy Aware component Started");
    }

    @Stop
    public void stop() {
        server.stop();
    }

    @Update
    public void update() {
        stop();
        start();
    }



}
