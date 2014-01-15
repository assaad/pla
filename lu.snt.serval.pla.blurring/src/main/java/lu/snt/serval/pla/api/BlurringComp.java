package lu.snt.serval.pla.api;

import org.kevoree.annotation.Input;
import org.kevoree.annotation.Output;

/**
 * User: assaad.moawad
 * Date: 13/01/14
 * Time: 13:36
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */


public abstract class BlurringComp {

    @Output
    public org.kevoree.api.Port resultOut;

    @Input
    public abstract void sensorIn(Object o);



}
