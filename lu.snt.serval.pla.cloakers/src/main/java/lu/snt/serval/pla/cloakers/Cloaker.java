package lu.snt.serval.pla.cloakers; /**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 10/09/13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;


@Provides({

        @ProvidedPort(name = "QueryCloakerIn", type = PortType.MESSAGE),
})

@Requires({
        @RequiredPort(name = "ResponseCloakerOut", type = PortType.MESSAGE, optional = true),
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
public abstract class Cloaker extends org.kevoree.framework.AbstractComponentType {

    //Starting
    public Cloaker() {


    }

    @Port(name = "QueryCloakerIn")
    public void incomingQuery(Object o) {
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

