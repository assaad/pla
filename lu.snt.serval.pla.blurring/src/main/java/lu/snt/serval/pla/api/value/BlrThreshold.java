package lu.snt.serval.pla.api.value;

import lu.snt.serval.pla.api.SensorValue;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.Param;
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
public class BlrThreshold extends ValueBlurring {


    @Param(defaultValue = "6")
    double threshold =6;

    @Param(defaultValue = "true")
    boolean greaterThan =true;

    @Override
    public void sensorIn(Object o) {
        try {
            SensorValue signal = (SensorValue) o;
            if(greaterThan)
            {
                if(signal.getValue()>=threshold)
                    resultOut.send(signal);
            }
            else
            {
                if(signal.getValue()<=threshold)
                    resultOut.send(signal);
            }
        }
        catch (Exception ex)
        {
            Log.debug(ex.getMessage());
        }
    }
}
