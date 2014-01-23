package lu.snt.serval.pla.blurring.value;

import lu.snt.serval.pla.blurring.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.Param;
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
           signal.setValue(round(signal.getValue(),digit));

          /* TrimBlurring tb= BlurringComp.factory.createTrimBlurring();
           tb.setPrecision(digits);


           //Add information about the current blurring
           signal.addBlurrings(tb);
                                    */
           //Add information about the current blurring
           // signal.addBlurrings();

           blurringOut.send(signal);

        }
        catch (Exception ex)
        {
            Log.info(ex.getMessage());
        }
    }
}
