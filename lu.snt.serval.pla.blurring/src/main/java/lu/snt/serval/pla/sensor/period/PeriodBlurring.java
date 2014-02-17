package lu.snt.serval.pla.sensor.period;

import lu.snt.serval.pla.sensor.Blurring;
import org.kevoree.annotation.Param;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 17:52
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public abstract class PeriodBlurring extends Blurring{
    protected PeriodBlurring()
    {
        paramName="timewindow";
        isDouble=false;
        min=5;
        max=3600*1000;
        value= 15*60*1000;

    }
}
