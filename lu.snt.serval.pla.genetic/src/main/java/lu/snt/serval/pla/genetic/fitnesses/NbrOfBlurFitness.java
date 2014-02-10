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
 * Date: 2/3/14
 * Time: ${Time}
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class NbrOfBlurFitness  extends DomainConfiguration implements FitnessFunction<ContainerRoot> {

    @Override
    public double evaluate(@JetValueParameter(name = "model") @NotNull ContainerRoot model, @JetValueParameter(name = "context") @NotNull GenerationContext<ContainerRoot> containerRootGenerationContext) {
        int x=0;
        ArrayList<ComponentInstance> ls = getSensors(model);
        for(ComponentInstance sensor: ls)
        {
            x+= getAttachedBlurComp(model,sensor).size();
        }
        return x;
    }

    @Override
    public double max() {
        return 9;
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