package lu.snt.serval.pla.blurring.value;

import lu.snt.serval.pla.blurring.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.Library;
import org.kevoree.log.Log;

/**
 * User: assaad.moawad
 * Date: 13/01/14
 * Time: 15:43
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

@ComponentType
@Library(name = "PLA_Blurring")
public class CompThresholdLower extends Threshold {
    @Input
    public void sensorIn(Object o) {
        try {
            SensorValue signal = (SensorValue) o;
                if(signal.getValue()<=threshold)
                    blurringOut.send(signal);
        }
        catch (Exception ex)
        {
            Log.debug(ex.getMessage());
        }
    }
}
