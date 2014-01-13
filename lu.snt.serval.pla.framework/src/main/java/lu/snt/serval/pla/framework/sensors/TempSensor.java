package lu.snt.serval.pla.framework.sensors;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 18/09/13
 * Time: 09:58
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.DataType;
import lu.snt.serval.pla.model.TempRecord;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
import org.kevoree.annotation.*;



//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public class TempSensor implements TempListener {


    @Output
    private org.kevoree.api.Port tempOut;

    @Output
    private org.kevoree.api.Port consOut;


    @Param (defaultValue = "2000")
    int periodInMs=2000;

    @Param (defaultValue = "5")
    int stepInMin = 5;

    @Param (defaultValue = "5")
    int startDay = 5;

    @Param (defaultValue = "Room1")
    String location = "Room1";



    private DefaultModelFactory factory = new DefaultModelFactory();
    //Starting
    public TempSensor() {

    }


    //To send Message to Console
    public void temperatureUpdated(TempRecord record) {
        DataType dt = factory.createDataType();
        dt.setName("Temperature");
        dt.setLocation(location);
        record.setDataType(dt);

        tempOut.send(record);

        consOut.send(record.print());

    }


    @Start
    public void start() {

        TempProvider t = TempGenerator.getInstance();

        TempGenerator.setSTEP(stepInMin);
        t.registerTempListener(this);
        t.setSensingPeriod(periodInMs);
        t.setLocation(location);
        t.setTime(startDay);



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

