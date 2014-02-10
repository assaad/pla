package lu.snt.serval.pla.sensor.value;

import org.kevoree.annotation.Param;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 18:01
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public abstract class Threshold extends ValueBlurring {

    Threshold()
    {
        paramName="threshold";
        value=50;
        min=0;
        max=100;
        isDouble=true;
    }
}
