package lu.snt.serval.pla.sensors;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 26/09/13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.AnswerDataType;
import lu.snt.serval.pla.model.TempRecord;
import org.kevoree.framework.MessagePort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;


import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.framework.service.handler.ModelListenerAdapter;

import java.util.Hashtable;


@Provides({
        @ProvidedPort(name = "QueryIn", type = PortType.MESSAGE),
        @ProvidedPort(name = "SensorIn", type = PortType.MESSAGE),
})

@Requires({
        @RequiredPort(name = "QueryOut", type = PortType.MESSAGE, optional = true),
       // @RequiredPort(name = "ConsOut", type = PortType.MESSAGE, optional = true),
})


@DictionaryType({
//        @DictionaryAttribute(name = "StepInMin", optional = true),
  //      @DictionaryAttribute(name = "PeriodInMs", optional = true),

})


//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public class SensorDb extends org.kevoree.framework.AbstractComponentType {
    private Collection<AnswerDataType> sensorData;


    @Port(name = "QueryIn")
    public void incomingQuery(Object o) {


    }

    @Port(name = "SensorIn")
    public void incomingSensorInfo(Object o) {
        try{
            AnswerDataType temp = (AnswerDataType) o;
            sensorData.add(temp);
        }
        catch (Exception e)
        {
           System.out.println(e.getMessage());
        }


    }


    @Start
    public void start() {
        sensorData= new ArrayList<AnswerDataType>();

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
