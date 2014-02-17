package lu.snt.serval.pla.sensor;

import org.kevoree.annotation.Input;
import org.kevoree.annotation.Output;
import org.kevoree.annotation.Param;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 18:02
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public abstract class Blurring {

    @Param(defaultValue = "paramName")
    public String paramName;

    @Param(defaultValue = "true")
    public Boolean isDouble=true;

    @Param(defaultValue = "0")
    public double min =0;

    @Param(defaultValue = "2")
    public double max =2;

    @Param(defaultValue = "1")
    public double value=1;

    @Param(defaultValue =  "10000")
    public int execTime=10000;


    @Input
    public abstract void sensorIn(Object o);
    @Output
    protected org.kevoree.api.Port blurringOut=null;
}
