package lu.snt.serval.pla.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 18/09/13
 * Time: 09:58
 * To change this template use File | Settings | File Templates.
 */

import org.kevoree.annotation.*;

//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "PLA_Sensor")
public class Sensor implements TempListener {


    @Output
    private org.kevoree.api.Port sensorOut;



    @Param (defaultValue = "2000")
    int periodInMs=2000;

    @Param (defaultValue = "5")
    int stepInMin = 5;

    @Param (defaultValue = "5")
    int startDay = 5;


    @Param (defaultValue = "1")
    String id = "1";

    @Param (defaultValue = "Temperature")
    String type = "Temperature";

    private TempProvider t;

   //Starting
    public Sensor() {

    }


    //To send Message to Console
    public void temperatureUpdated(SensorValue s) {

        s.setType(type);
        s.setSensorID(id);

       // JSONObject jsonObject = new JSONObject(s);
        sensorOut.send(s);

    }


    @Start
    public void start() {
        t = new TempGenerator();
        t.setStep(stepInMin);
        t.setTime(startDay);
        t.registerTempListener(this);
        t.setSensingPeriod(periodInMs);






        // tempGenerator.run();
    }

    @Stop
    public void stop() {
        t.unregisterTempListener(this);

    }

    @Update
    public void update() {
        stop();
        start();
    }


}

