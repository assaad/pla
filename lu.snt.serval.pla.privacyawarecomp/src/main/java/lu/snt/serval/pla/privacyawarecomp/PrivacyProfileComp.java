package lu.snt.serval.pla.privacyawarecomp;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 30/09/13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.*;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
import org.kevoree.framework.MessagePort;

import java.util.*;


import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.log.Log;

import java.util.Hashtable;


@Provides({
        @ProvidedPort(name = "PrivacyProfileIn", type = PortType.MESSAGE),
})

@Requires({
        @RequiredPort(name = "PrivacyProfileOut", type = PortType.MESSAGE, optional = true),
})


@ComponentType
@Library(name = "Serval_PLA")
public class PrivacyProfileComp extends  org.kevoree.framework.AbstractComponentType {

    private PrivacyProfileDb ppDb;
    private ModelFactory factory;



    @Port(name = "PrivacyProfileIn")
    public void incomingPrivacyProfile(Object o) {
        Log.debug("Privacy component received a query");
          QueryPrivacyProfile qpp =  (QueryPrivacyProfile) o;
        PrivacyProfile pp =   getByUserProfile(qpp.getOwningQuery().getUserProfile()) ;
        AnswerPrivacyProfile ans= factory.createAnswerPrivacyProfile();
        ans.setPrivacyRule(getRule(pp,qpp.getDataType()));
        SendResult(ans);
        Log.debug("Privacy component sending answer");


    }

    private PrivacyRule getRule(PrivacyProfile pp, DataType dt)
    {
        if(pp==null||dt==null)
        {
            Log.debug("Returning empty Rule");
            return factory.createEmptyRule();
        }
        Iterator iter = pp.getPrivacyRules().iterator();
        while(iter.hasNext()) {
            PrivacyRule element = (PrivacyRule)  iter.next();
            DataType current = element.getDataType();
            if(current.getName().equals(dt.getName()) && current.getLocation().equals(dt.getLocation()))
            {
                Log.debug("Returning a rule");
                return element;
            }
        }
        return factory.createEmptyRule();

    }

    private void SendResult(AnswerPrivacyProfile ans)
    {
        MessagePort prodPort =  getPortByName("PrivacyProfileOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(ans);
        }
    }


    private PrivacyProfile getByUserProfile (UserProfile user)  {
        Iterator iter =        ppDb.getProfiles().iterator() ;
        while(iter.hasNext()) {
            PrivacyProfile element = (PrivacyProfile) iter.next();
            if(element.getUserProfile().getId().equals(user.getId()) && element.getUserProfile().getName().equals(user.getName()))
                return element;
        }
        return null;
    }



    @Start
    public void start() {
        factory = new DefaultModelFactory();

        ppDb=  factory.createPrivacyProfileDb();

        UserProfile up1 = factory.createUserProfile();
        up1.setName("user1");
        up1.setId("123456789");
        PrivacyProfile pp1 = factory.createPrivacyProfile();
        pp1.setUserProfile(up1);


        PrivacyRule pr1 = factory.createPrivacyRule();
        pr1.setBlurringAlgorithm("NormalTimeIntervalBlur");

        DataType dt = factory.createDataType();
        dt.setName("Temperature");
        dt.setLocation("Room1");

        TimeAveraging ta = factory.createTimeAveraging();
        ta.setDuration(5*60*1000.0); //5 min average

        IntervalBlurring ib = factory.createIntervalBlurring();
        ib.setIntervalLength(2.0);

        pr1.setTimeBlurring(ta);
        pr1.setValueBlurring(ib);

        pp1.addPrivacyRules(pr1);
        ppDb.addProfiles(pp1);



        UserProfile up2 = factory.createUserProfile();
        up2.setName("user2");
        up2.setId("987654321");
        PrivacyProfile pp2 = factory.createPrivacyProfile();
        pp2.setUserProfile(up2);

        PrivacyRule pr2 = factory.createPrivacyRule();
        pr2.setBlurringAlgorithm("NoiseBlur");

        DataType dt2 = factory.createDataType();
        dt2.setName("Temperature");
        dt2.setLocation("Room1");

        NoiseBlurring nb = factory.createNoiseBlurring();
        nb.setTypeOfNoise("Gauss");
        nb.setVariance(2.0);

        pr2.setValueBlurring(nb);

        pp2.addPrivacyRules(pr2);
        ppDb.addProfiles(pp2);
    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }

}
