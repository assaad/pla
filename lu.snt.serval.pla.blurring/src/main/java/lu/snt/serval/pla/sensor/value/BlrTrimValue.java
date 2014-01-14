package lu.snt.serval.pla.sensor.value;

import lu.snt.serval.pla.model.DoubleValueAnswer;
import lu.snt.serval.pla.model.TrimBlurring;
import lu.snt.serval.pla.sensor.BlurringComp;
import org.kevoree.annotation.ComponentType;
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
public class BlrTrimValue extends ValueBlurring {


    @Param(defaultValue = "2")
    int digits =2;


    public static double round(double n, int digits) {
        return BigDecimal.valueOf(n).setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public void sensorIn(Object o) {
        Log.debug("Inside override");
       try {

           DoubleValueAnswer signal = (DoubleValueAnswer) o;
           signal.setValue(round(signal.getValue(),digits));

           TrimBlurring tb= BlurringComp.factory.createTrimBlurring();
           tb.setPrecision(digits);


           //Add information about the current sensor
           signal.addBlurrings(tb);

           //Add information about the current sensor
           // signal.addBlurrings();

           resultOut.send(signal);

        }
        catch (Exception ex)
        {
            Log.debug(ex.getMessage());
        }
    }
}
