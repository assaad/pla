package lu.snt.serval.pla.sensor.value;

import org.kevoree.annotation.Param;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 18:01
 * University of Luxembourg - Snt
 * assaad.moawad@gmail.com
 */
public abstract class Trim extends ValueBlurring {
    Trim(){
        paramName="trim";
        value=2;
        min=1;
        max=6;
        isDouble=false;

    }
}
