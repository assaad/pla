package lu.snt.serval.pla.genetic;

import org.kevoree.ContainerRoot;
import org.kevoree.factory.DefaultKevoreeFactory;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.modeling.api.ModelCloner;
import org.kevoree.modeling.api.compare.ModelCompare;
import org.kevoree.modeling.optimization.api.PopulationFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * User: assaad.moawad
 * Date: 2/7/14
 * Time: ${Time}
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class DefaultPopulation extends DomainConfiguration implements PopulationFactory<ContainerRoot> {


    private Integer size = 4;
    public static int MAX = 12;

    public DefaultPopulation setSize(Integer nSize) {
        size = nSize;
        return this;
    }

    @Override
    public List<ContainerRoot> createPopulation() {
        ArrayList<ContainerRoot> populations = new ArrayList<ContainerRoot>();
        KevScriptEngine engine = new KevScriptEngine();
        ContainerRoot root = new DefaultKevoreeFactory().createContainerRoot();
        try {
            engine.executeFromStream(DefaultPopulation.class.getClassLoader().getResourceAsStream("kevInit.kevs"), root);
            populations.add(root);
            System.out.println("InitialPopulation reading kev done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            populations.add(getCloner().clone(root));
        }
        System.out.println("InitialPopulation done");
        return populations;
    }

    @Override
    public ModelCloner getCloner() {
        return new ModelCloner(new DefaultKevoreeFactory());
    }

    @Override
    public ModelCompare getModelCompare() {
        return new ModelCompare(new DefaultKevoreeFactory());
    }
}
