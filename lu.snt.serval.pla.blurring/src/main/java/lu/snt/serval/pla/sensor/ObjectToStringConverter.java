package lu.snt.serval.pla.sensor;

import lu.snt.serval.pla.model.DoubleValueAnswer;
import lu.snt.serval.pla.model.ModelFactory;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
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

    protected static ModelFactory factory = new DefaultModelFactory();
    @Output
    public org.kevoree.api.Port resultOut;

    @Input
    public void resultIn(Object o) {
        DoubleValueAnswer signal = (DoubleValueAnswer) o;

        String s = signal.getDateTime().toString()+" "+ signal.getValue().toString();
        resultOut.send(s);
    }
}
