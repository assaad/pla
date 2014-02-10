package lu.snt.serval.pla.sensor.value;

import lu.snt.serval.pla.sensor.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.Library;
import org.kevoree.log.Log;

/**
 * User: assaad.moawad
 * Date: 13/01/14
 * Time: 14:07
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

@ComponentType
@Library(name = "PLA_Blurring")
public class CompGaussianNoise extends Noise {

    private java.util.Random r = new java.util.Random();


    @Input
    public void sensorIn(Object o) {
        double noise = r.nextGaussian() * Math.sqrt(value);
         try {
             SensorValue signal = (SensorValue) o;
             signal.setValue(signal.getValue()+noise);


             blurringOut.send(signal);

         }
         catch (Exception ex)
         {
             Log.debug(ex.getMessage());
         }
    }
}
