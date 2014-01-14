package lu.snt.serval.pla.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 26/09/13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.AnswerDataType;
import lu.snt.serval.pla.model.DataType;
import lu.snt.serval.pla.model.QuerySensorDb;
import org.kevoree.annotation.*;
import org.kevoree.log.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;




//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public class SensorDb {
    private Collection<AnswerDataType> sensorData;

    @Output
    private org.kevoree.api.Port dataOut;


    @Input
    public void dataQueryIn(Object o) {
        QuerySensorDb qsdb = (QuerySensorDb) o;
        DataType dt = qsdb.getDataType();

        long dateFrom=qsdb.getDateTimeFrom().getTime();
        long dateTo=qsdb.getDateTimeTo().getTime();
        ArrayList<AnswerDataType> ansdb = new ArrayList<AnswerDataType>();

        Iterator iter = sensorData.iterator();

        while (iter.hasNext())
        {
            AnswerDataType element = (AnswerDataType) iter.next();
            if(include(element,dt,dateFrom,dateTo))
                ansdb.add(element);
        }

        dataOut.send(ansdb);
            Log.debug("Found in DB "+ansdb.size() + " elements");


    }

    private boolean compare (AnswerDataType adt, DataType dt)
    {
        if(adt.getDataType()==null)
            Log.debug("Inside compare adt is null");
        if(dt==null)
            Log.debug("Inside compare dt is null");
        if(adt.getDataType().getName().equals(dt.getName()) && adt.getDataType().getLocation().equals(dt.getLocation()))
            return true;
        return false;
    }

    private boolean include(AnswerDataType adt, DataType dt, long dateFrom, long dateTo )
    {
        if(compare(adt,dt)==false)
            return false;
        else
        {
            if(adt.getDateTime().getTime()>=dateFrom && adt.getDateTime().getTime()<=dateTo)
                return true;
        }
        return  false;
    }

    @Input
    public void sensorIn(Object o) {
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
