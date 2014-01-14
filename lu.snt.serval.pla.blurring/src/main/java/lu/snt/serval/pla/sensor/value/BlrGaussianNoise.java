package lu.snt.serval.pla.sensor.value;

import lu.snt.serval.pla.model.DoubleValueAnswer;
import lu.snt.serval.pla.model.NoiseBlurring;
import lu.snt.serval.pla.sensor.BlurringComp;
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
             DoubleValueAnswer signal = (DoubleValueAnswer) o;
             signal.setValue(signal.getValue()+noise);

             NoiseBlurring nb= BlurringComp.factory.createNoiseBlurring();
             nb.setTypeOfNoise("Gaussian Noise");
             nb.setVariance(variance);
             nb.setMean(mean);

             //Add information about the current sensor
             signal.addBlurrings(nb);

             resultOut.send(signal);

         }
         catch (Exception ex)
         {
             Log.debug(ex.getMessage());
         }
    }
}
