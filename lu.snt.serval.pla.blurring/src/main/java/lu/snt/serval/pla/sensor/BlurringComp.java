package lu.snt.serval.pla.sensor;

import lu.snt.serval.pla.model.ModelFactory;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
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

    protected static ModelFactory factory = new DefaultModelFactory();
    @Output
    public org.kevoree.api.Port resultOut;

    @Input
    public abstract void sensorIn(Object o);



}
