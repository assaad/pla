package lu.snt.serval.pla.sensors;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 18/09/13
 * Time: 09:58
 * To change this template use File | Settings | File Templates.
 */

import org.kevoree.framework.MessagePort;

import java.util.Hashtable;


import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;

import java.util.Hashtable;


@Provides({

})

@Requires({
        @RequiredPort(name = "TempOut", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "ConsOut", type = PortType.MESSAGE, optional = true),
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
public class TempSensor extends org.kevoree.framework.AbstractComponentType implements TempListener {


    //Starting
    public TempSensor() {
        //tempGenerator.run();


    }


    //To send Message to Console
    public void temperatureUpdated(TempRecord record) {
        MessagePort prodPort = getPortByName("TempOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(record);
        }

        prodPort = getPortByName("ConsOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(record.print());
        }
    }


    @Start
    public void start() {

        TempGenerator.getInstance().registerTempListener(this);

       // tempGenerator.run();
    }

    @Stop
    public void stop() {
        TempGenerator.getInstance().unregisterTempListener(this);

    }

    @Update
    public void update() {
        stop();
        start();
    }


}

