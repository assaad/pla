package lu.snt.serval.pla.genetic.fitnesses;

/**
 * User: assaad.moawad
 * Date: 2/3/14
 * Time: ${Time}
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

import lu.snt.serval.pla.genetic.DomainConfiguration;
import lu.snt.serval.pla.genetic.RiskCalculation;
import org.kevoree.*;
import org.kevoree.modeling.optimization.api.GenerationContext;
import org.kevoree.modeling.optimization.api.fitness.FitnessFunction;
import pla.Architecture;

public class RiskFitness  extends DomainConfiguration implements FitnessFunction<ContainerRoot> {

    @Override
    public double evaluate(ContainerRoot model, GenerationContext<ContainerRoot> cloudGenerationContext) {
        Architecture test= getArchitecture(model);
        //Calculate absolute risk
        double risk= RiskCalculation.calculateRisk(test);
        if(risk<0.0)
        {
            System.out.println("Error inside fitness 1");
        };
        if(risk>1)
        {
            System.out.println("Error inside fitness 2");
            risk=1;
        };

       risk= 1-Math.exp(-(risk-tolerated)*(risk-tolerated)/0.03);


        System.out.println("Risk fitness: "+risk);
        return risk;
    }

}
