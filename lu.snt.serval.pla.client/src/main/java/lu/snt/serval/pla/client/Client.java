/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 09/09/13
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
package lu.snt.serval.pla.client;

import org.kevoree.annotation.*;


@Provides({

        @ProvidedPort(name = "ResponseIn", type = PortType.MESSAGE)
})

@Requires({
        @RequiredPort(name = "QueryOut", type = PortType.MESSAGE, optional = true)
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
public class Client extends org.kevoree.framework.AbstractComponentType {

    //Starting
    public Client() {

      FrameworkFactory factory = new DefaultFrameworkFactory();
    }

    @Port(name = "ResponseIn")
    public void incomingResponse(Object o) {
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

