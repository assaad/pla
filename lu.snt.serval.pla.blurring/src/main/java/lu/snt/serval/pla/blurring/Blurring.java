package lu.snt.serval.pla.blurring;

import org.kevoree.annotation.Input;
import org.kevoree.annotation.Output;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 18:02
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public abstract class Blurring {

    @Input
    public abstract void sensorIn(Object o);
    @Output
    protected org.kevoree.api.Port blurringOut=null;
}
