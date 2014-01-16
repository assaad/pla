package lu.snt.serval.pla.blurring.value;

import org.kevoree.annotation.Param;

/**
 * User: assaad.moawad
 * Date: 16/01/14
 * Time: 18:01
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public abstract class Threshold extends ValueBlurring {
    @Param(defaultValue = "6")
    double threshold =6;

    @Param(defaultValue = "true")
    boolean greaterThan =true;
}
