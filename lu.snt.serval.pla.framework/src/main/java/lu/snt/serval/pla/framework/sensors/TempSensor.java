package lu.snt.serval.pla.framework.sensors;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 18/09/13
 * Time: 09:58
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.TempRecord;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;


@Provides({

})

@Requires({
        @RequiredPort(name = "TempOut", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "ConsOut", type = PortType.MESSAGE, optional = true),
})


@DictionaryType({
        @DictionaryAttribute(name = "StepInMin",defaultValue = "5", optional = true),
        @DictionaryAttribute(name = "PeriodInMs",defaultValue = "2000", optional = true),
        @DictionaryAttribute(name = "StartDay", defaultValue = "5", optional = true),
        @DictionaryAttribute(name = "Location", defaultValue = "Room1", optional = true),

})


//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public class TempSensor extends org.kevoree.framework.AbstractComponentType implements TempListener {


    //Starting
    public TempSensor() {

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

        TempProvider t = TempGenerator.getInstance();
        int step;
        long period;
        int day;
        String location="";

        try
        {
            step = Integer.parseInt((String) getDictionary().get("StepInMin"));
            period = Long.parseLong((String) getDictionary().get("PeriodInMs"));
            day = Integer.parseInt((String) getDictionary().get("StartDay"));
            location = (String)   getDictionary().get("Location");
        }
        catch  (Exception ex)
        {
                System.out.println("HHHH" + ex.getMessage());
            step=70;
            period=2000;
            day=5;
            location="Room1";
        }
        TempGenerator.setSTEP(step);
        t.registerTempListener(this);
        t.setSensingPeriod(period);
        t.setLocation(location);
        t.setTime(day);



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

