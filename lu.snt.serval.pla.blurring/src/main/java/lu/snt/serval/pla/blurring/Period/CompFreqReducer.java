package lu.snt.serval.pla.blurring.period;

import lu.snt.serval.pla.blurring.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.Library;

/**
 * User: assaad.moawad
 * Date: 15/01/14
 * Time: 14:09
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

@ComponentType
@Library(name = "PLA_Blurring")
public class CompFreqReducer extends FreqReducer {

    private SensorValue previous=null;


    @Input
    public void sensorIn(Object o) {
        if(previous==null)
        {
            previous=(SensorValue) o;
            blurringOut.send(previous);
        }
        else
        {
            SensorValue newElem = (SensorValue) o;
            if((newElem.getTime()-previous.getTime())>=timewindow)
            {
                previous=newElem;
                blurringOut.send(previous);
            }
        }

    }
}
