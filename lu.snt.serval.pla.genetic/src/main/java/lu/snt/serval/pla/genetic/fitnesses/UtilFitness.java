package lu.snt.serval.pla.genetic.fitnesses;

import jet.runtime.typeinfo.JetValueParameter;
import lu.snt.serval.pla.genetic.DomainConfiguration;
import org.jetbrains.annotations.NotNull;
import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.modeling.optimization.api.GenerationContext;
import org.kevoree.modeling.optimization.api.fitness.FitnessFunction;
import pla.Blurring;

import java.util.ArrayList;

/**
 * User: assaad.moawad
 * Date: 2/17/14
 * Time: ${Time}
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class UtilFitness extends DomainConfiguration implements FitnessFunction<ContainerRoot> {

    @Override
    public double evaluate(@JetValueParameter(name = "model") @NotNull ContainerRoot model, @JetValueParameter(name = "context") @NotNull GenerationContext<ContainerRoot> containerRootGenerationContext) {
        ArrayList<ComponentInstance> ls = getSensors(model);
        double localmax=1;
        double cur=1;
        for(ComponentInstance sensor: ls)
        {
            cur=1;
            ArrayList<ComponentInstance> bl = getAttachedBlurComp(model,sensor);
            for(ComponentInstance blur:bl)
            {
                    String name = blur.getTypeDefinition().getName();
                try {
                    double value = Double.parseDouble(blur.getDictionary().findValuesByID("value").getValue());
                    cur = cur * getUtil(name, value);
                }
                catch (Exception x){
                    System.out.println(x.getMessage()+" AT: " + name);
                }
            }
            if(cur<localmax)
                localmax=cur;
        }
        return localmax;
    }

    private double getUtil(String name, double value) {
        for(Blurring b: domain.getBlurrings())
        {
            if(b.getName().equals(name))
            {
                double aa= (b.getUtilMax()-b.getUtilMin())/(b.getParamMax()-b.getParamMin());
                double bb= b.getUtilMax()-aa*b.getParamMax();
                double util = aa*value+bb;
                //System.out.println("Util fitness: "+util);
                return util;

            }
        }
        return 1;

    }


}