/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 03/09/13
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */

package lu.snt.serval.pla.privacyawarecomp;

import lu.snt.serval.pla.framework.*;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;

import java.util.Hashtable;


@Provides({

        @ProvidedPort(name = "QueryIn", type = PortType.MESSAGE),
        @ProvidedPort(name = "ResponseProfileIn", type = PortType.MESSAGE),
        @ProvidedPort(name = "ResponseCloakersIn", type = PortType.MESSAGE),
})

@Requires({
        @RequiredPort(name = "ResponseOut", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "QueryProfileOut", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "QueryCloakersOut", type = PortType.MESSAGE, optional = true),
})


/*
@DictionaryType({
        @DictionaryAttribute(name = "Name", optional = false),
        @DictionaryAttribute(name = "InitialKnowledgeBaseFile", optional = true),
        @DictionaryAttribute(name = "InitialTrustFile", optional = true),

})
*/

//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public class PrivacyAwareComp extends org.kevoree.framework.AbstractComponentType implements QueryInterface {


    private Hashtable qsArray = new Hashtable();
    private Hashtable drArray = new Hashtable();
    private int idGen = 0;

    private int getNewId() {
        return (++idGen);
    }


    //Starting
    public PrivacyAwareComp() {


    }

    @Port(name = "QueryIn")
    public void incomingQuery(Object o) {

        try {
            Query x = (Query) o;

            int id = getNewId();
            x.setProcessId(id);
            Drop dr = new Drop();
            QueryProcessor qp = new QueryProcessor(this, x, id, dr);
            qsArray.put(id, qp);
            drArray.put(id, dr);
            qp.start();

        } catch (Exception ex) {
            System.out.println(" Exception: " + ex.getMessage());
        }

    }

    public void askPrivacyPofile(Query qProfile)
    {
        MessagePort prodPort = getPortByName("QueryProfileOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(qProfile);
        }
    }

    public void askCloakers(Query qCloak)
    {
        MessagePort prodPort = getPortByName("QueryCloakersOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(qCloak);
        }
    }

    public void sendResult(Answer answer)
    {
        MessagePort prodPort = getPortByName("ResponseOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(answer);
        }
    }


    private void killQueryServant(int qpId) {
        try {
            QueryProcessor qp = (QueryProcessor) qsArray.get(qpId);
            //Kill qp or make sure it is done here -  to implement - ????

            qsArray.remove(qpId);
        } catch (Exception ex) {
            System.out.println("Can't remove process");
        }

    }



    @Port(name = "ResponseProfileIn")
    public void incomingProfile(Object o) {
    }

    @Port(name = "ResponseCloakersIn")
    public void incomingCloakers(Object o) {
    }

    @Start
    public void start() {

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
