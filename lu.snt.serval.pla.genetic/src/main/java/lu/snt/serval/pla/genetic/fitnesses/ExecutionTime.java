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
public class ExecutionTime extends DomainConfiguration implements FitnessFunction<ContainerRoot> {

    @Override
    public double evaluate(@JetValueParameter(name = "model") @NotNull ContainerRoot model, @JetValueParameter(name = "context") @NotNull GenerationContext<ContainerRoot> containerRootGenerationContext) {

        ArrayList<ComponentInstance> ls = getSensors(model);
        double localmax=0;
        double cur=0;
        String name="";
        double value;


        try{
        for(ComponentInstance sensor: ls)
        {
            cur=0;
            ArrayList<ComponentInstance> bl = getAttachedBlurComp(model,sensor);
            for(ComponentInstance blur:bl)
            {
                name = blur.getTypeDefinition().getName();
                value = Double.parseDouble(blur.getDictionary().findValuesByID("value").getValue());
                cur+=getTime(name,value);
            }
            if(cur>localmax)
                localmax=cur;
        }

        if(localmax>1500)
        {
            localmax=1500;
        }
        }
        catch (Exception ex)
        {
            System.out.println("Error in name " + name + " Ex:" + ex.getMessage());

        }

        return localmax;
    }

    private double getTime(String name, double value) {
        for(Blurring b: domain.getBlurrings())
        {
            if(b.getName().equals(name))
            {
                double aa= (b.getExecTimeMax()-b.getExecTimeMin())/(b.getParamMax()-b.getParamMin());
                double bb= b.getExecTimeMax()-aa*b.getParamMax();
                double time = aa*value+bb;
                if(time<0)
                    time=0;
                if(time>1500)
                    return 1500;
                return time;

            }
        }
        return 0;

    }


}