package lu.snt.serval.pla.api;


import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.Output;

/**
 * User: assaad.moawad
 * Date: 14/01/14
 * Time: 14:09
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
@ComponentType
@Library(name = "PLA_Blurring")
public class ObjectToStringConverter  {

    @Output
    public org.kevoree.api.Port resultOut;

    @Input
    public void resultIn(Object o) {
        SensorValue sensor= (SensorValue)   o;
       resultOut.send(sensor.toString());
    }
}
