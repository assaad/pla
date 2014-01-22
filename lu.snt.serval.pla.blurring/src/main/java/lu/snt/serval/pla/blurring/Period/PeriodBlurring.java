package lu.snt.serval.pla.blurring.period;

import lu.snt.serval.pla.blurring.Blurring;
import org.kevoree.annotation.Param;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 17:52
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public abstract class PeriodBlurring extends Blurring{
    @Param(defaultValue = "900000")
    public  long timewindow = 15*60*1000;
}
