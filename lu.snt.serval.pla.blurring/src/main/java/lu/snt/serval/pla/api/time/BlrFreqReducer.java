package lu.snt.serval.pla.api.time;

import lu.snt.serval.pla.api.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.Param;

import java.util.List;

/**
 * User: assaad.moawad
 * Date: 15/01/14
 * Time: 14:09
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

@ComponentType
@Library(name = "PLA_Blurring")
public class BlrFreqReducer  extends TimeBlurring {
    @Param(defaultValue = "900000")
    long timewindow = 15*60*1000; //15 minutes in milliseconds

    private SensorValue previous=null;


    @Override
    public void sensorIn(Object o) {
        if(previous==null)
        {
            previous=(SensorValue) o;
            resultOut.send(previous);
        }
        else
        {
            SensorValue newElem = (SensorValue) o;
            if((newElem.getTime()-previous.getTime())>=timewindow)
            {
                previous=newElem;
                resultOut.send(previous);
            }
        }

    }
}
