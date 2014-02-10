package lu.snt.serval.pla.sensor.value;

import lu.snt.serval.pla.sensor.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Library;
import org.kevoree.log.Log;

import java.math.BigDecimal;

/**
 * User: assaad.moawad
 * Date: 13/01/14
 * Time: 15:28
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
@ComponentType
@Library(name = "PLA_Blurring")
public class CompTrim extends Trim {


    public static double round(double n, int digits) {
        return BigDecimal.valueOf(n).setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public void sensorIn(Object o) {

       try {


           SensorValue signal = (SensorValue) o;
           signal.setValue(round(signal.getValue(),(int) value));

          /* TrimBlurring tb= BlurringComp.factory.createTrimBlurring();
           tb.setPrecision(digits);


           //Add information about the current sensor
           signal.addBlurrings(tb);
                                    */
           //Add information about the current sensor
           // signal.addBlurrings();

           blurringOut.send(signal);

        }
        catch (Exception ex)
        {
            Log.info(ex.getMessage());
        }
    }
}
