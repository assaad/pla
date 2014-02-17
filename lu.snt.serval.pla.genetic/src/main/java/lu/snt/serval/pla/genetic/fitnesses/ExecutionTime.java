package lu.snt.serval.pla.genetic.fitnesses;

import jet.runtime.typeinfo.JetValueParameter;
import lu.snt.serval.pla.genetic.DomainConfiguration;
import org.jetbrains.annotations.NotNull;
import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.modeling.optimization.api.GenerationContext;
import org.kevoree.modeling.optimization.api.fitness.FitnessFunction;
import org.kevoree.modeling.optimization.api.fitness.FitnessOrientation;

import java.util.ArrayList;

/**
 * User: assaad.moawad
 * Date: 2/17/14
 * Time: ${Time}
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class ExecutionTime extends DomainConfiguration implements FitnessFunction<ContainerRoot> {

    @Override
    public double evaluate(@JetValueParameter(name = "model") @NotNull ContainerRoot model, @JetValueParameter(name = "context") @NotNull GenerationContext<ContainerRoot> containerRootGenerationContext) {
        ArrayList<ComponentInstance> ls = getSensors(model);
        int localmax=0;
        int cur=0;
        for(ComponentInstance sensor: ls)
        {
            cur=0;
            ArrayList<ComponentInstance> bl = getAttachedBlurComp(model,sensor);
            for(ComponentInstance blur:bl)
            {
                String s=blur.getDictionary().findValuesByID("execTime").getValue();
                cur+=Integer.decode(s);
            }
            if(cur>localmax)
                localmax=cur;
        }
        return localmax;
    }

    @Override
    public double max() {
        return 20000;
    }

    @Override
    public double min() {
        return 0;
    }

    @NotNull
    @Override
    public FitnessOrientation orientation() {
        return FitnessOrientation.MINIMIZE;
    }
}