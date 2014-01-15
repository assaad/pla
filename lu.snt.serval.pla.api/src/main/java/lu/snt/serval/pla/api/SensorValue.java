package lu.snt.serval.pla.api;

import java.util.Date;

/**
 * User: assaad.moawad
 * Date: 15/01/14
 * Time: 11:19
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class SensorValue {
    private double value;
    private String type;
    private String sensorID;

    private long time;

    public void setTime(long time) {
        this.time = time;
    }

    public void setValue( double value){
        this.value=value;
    }
    public void setType(String type){
        this.type=type;
    }
    public void  setSensorID(String sensorID)         {
        this.sensorID=sensorID;
    }

    public double getValue() {
        return value;
    }

    public long getTime() {
        return time;
    }

    public String getSensorID() {
        return sensorID;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        String s="Sensor ID: "+sensorID+" , Type: "+ type+" , Time: "+ (new Date(time)).toString()+", Value: "+ value;
        return s;
    }
}
