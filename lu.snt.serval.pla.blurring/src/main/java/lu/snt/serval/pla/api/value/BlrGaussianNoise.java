package lu.snt.serval.pla.api.value;

import lu.snt.serval.pla.api.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.Param;
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
public class BlrGaussianNoise extends ValueBlurring {

    private java.util.Random r = new java.util.Random();


    @Param(defaultValue = "0")
    double mean = 0;

    @Param(defaultValue = "1")
    double variance = 1;




    @Override
    public void sensorIn(Object o) {
        double noise = r.nextGaussian() * Math.sqrt(variance) + mean;
         try {
             SensorValue signal = (SensorValue) o;
             signal.setValue(signal.getValue()+noise);


             resultOut.send(signal);

         }
         catch (Exception ex)
         {
             Log.debug(ex.getMessage());
         }
    }
}
