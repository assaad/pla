package lu.snt.serval.pla.genetic.fitnesses;

/**
 * User: assaad.moawad
 * Date: 2/3/14
 * Time: ${Time}
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

import lu.snt.serval.pla.Architecture;
import lu.snt.serval.pla.Blurring;
import lu.snt.serval.pla.genetic.DomainConfiguration;
import lu.snt.serval.pla.genetic.RiskCalculation;
import lu.snt.serval.pla.genetic.SampleRunner;
import org.kevoree.*;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.loader.JSONModelLoader;
import org.kevoree.log.Log;
import org.kevoree.modeling.optimization.api.GenerationContext;
import org.kevoree.modeling.optimization.api.fitness.FitnessFunction;
import org.kevoree.modeling.optimization.api.fitness.FitnessOrientation;

import java.util.ArrayList;


public class RiskFitness  extends DomainConfiguration implements FitnessFunction<ContainerRoot> {

       public static int numberOfBlur(ContainerRoot model)
    {
        int x=0;
        ArrayList<ComponentInstance> ls = getSensors(model);
        for(ComponentInstance sensor: ls)
        {
            x+= getAttachedBlurComp(model,sensor).size();
        }
        return x;

    }

    public static void changeBlur(ContainerRoot model)
    {
        try
        {
            ArrayList<ComponentInstance> ls = getSensors(model);
            ComponentInstance sensor= ls.get(random.nextInt(ls.size()));
            ArrayList<ComponentInstance> already= getAttachedBlurComp(model, sensor);
            if(already.size()>0)
            {
                ComponentInstance toChange =already.get(random.nextInt(already.size()));
                double min = Double.parseDouble(toChange.getDictionary().findValuesByID("min").getValue());
                double max= Double.parseDouble(toChange.getDictionary().findValuesByID("max").getValue());
                boolean isDouble = toChange.getDictionary().findValuesByID("isDouble").getValue().equals("true");
                double val=0;
                if(isDouble)
                    val=random.nextDouble()*(max-min)+min;
                else
                    val=random.nextInt((int)(max-min))+min;
                toChange.getDictionary().findValuesByID("value").setValue(Double.toString(val));
            }
        }
        catch (Exception ex)
    {
        Log.debug(ex.getMessage());
        System.out.println(ex.getMessage());
    }

    }

    public static void addBlur(ContainerRoot model)
    {
        ArrayList<ComponentInstance> ls = getSensors(model);
        ComponentInstance sensor= ls.get(random.nextInt(ls.size()));
        ArrayList<Blurring> possible=getPossibleBlur(sensor.getDictionary().findValuesByID("id").getValue());

        ArrayList<String> already= getAttachedBlur(model,sensor);
        if(already.size()>0)
        {
            for(String s:already)
            {
                for(Blurring b: possible)
                {
                    if(b.getName().equals(s))
                    {
                        possible.remove(b);
                        break;
                    }
                }
            }
        }


        if(possible.size()>0)
        {
            Blurring toAdd = possible.get(random.nextInt(possible.size()));
            //System.out.println(toAdd.getName());
            KevScriptEngine engine = new KevScriptEngine();
            try
            {

                String compName= toAdd.getName().substring(0,8)+ random.nextInt(10000);
                String command = "add node0."+compName+" : "+toAdd.getName();
                engine.execute(command,model);

                command = "set node0."+compName+".min = \""+toAdd.getParamMin()+"\"";
                engine.execute(command,model);
                command = "set node0."+compName+".max = \""+toAdd.getParamMax()+"\"";
                engine.execute(command,model);
                command = "set node0."+compName+".value = \""+toAdd.getParamValue()+"\"";
                engine.execute(command,model);
                command = "set node0."+compName+".paramName = \""+toAdd.getParamName()+"\"";
                engine.execute(command,model);
                if(toAdd.getIsDouble())
                    command = "set node0."+compName+".isDouble = \"true\"";
                else
                    command = "set node0."+compName+".isDouble = \"false\"";
                engine.execute(command,model);
                command = "set node0."+compName+".started = \"true\"";
                engine.execute(command,model);

                Channel channel = sensor.getRequired().get(0).getBindings().get(0).getHub();
                ComponentInstance next=sensor;

                for(MBinding c:channel.getBindings())
                {
                    Port d = c.getPort();
                    next= (ComponentInstance)  d.eContainer();
                    if(next==sensor)
                        continue;
                    else
                        break;
                }
                command = "unbind  node0."+ next.getName()+"."+next.getProvided().get(0).getPortTypeRef().getName() +" " +channel.getName();
                engine.execute(command,model);

                command = "bind node0."+ compName+".sensorIn "  +channel.getName();
                engine.execute(command,model);


                String channel1;
                channel1="AsyncBroa"+random.nextInt(10000);


                command = "add "+channel1 +" : " +"AsyncBroadcast";
                engine.execute(command,model);
                command = "set "+channel1 +".started = \"true\"";
                engine.execute(command,model);

                command = "bind node0."+ compName+".blurringOut "  +channel1;
                engine.execute(command,model);

                command = "bind node0."+ next.getName()+"."+next.getProvided().get(0).getPortTypeRef().getName() +" "  +channel1;
                engine.execute(command,model);
                //System.out.println("done");





            }
            catch (Exception ex)
            {
                Log.debug(ex.getMessage());
                System.out.println(ex.getMessage());
            }
        }
    }


    public static void removeBlur(ContainerRoot model){
        try
        {
        ArrayList<ComponentInstance> ls = getSensors(model);
        ComponentInstance sensor= ls.get(random.nextInt(ls.size()));
         ArrayList<ComponentInstance> already= getAttachedBlurComp(model, sensor);
        if(already.size()>0)
        {
            ComponentInstance toRemove =already.get(random.nextInt(already.size()));
            Channel before=toRemove.getProvided().get(0).getBindings().get(0).getHub();
            Channel after=toRemove.getRequired().get(0).getBindings().get(0).getHub();

            ComponentInstance next=toRemove;

            for(MBinding c:after.getBindings())
            {
                Port d = c.getPort();
                next= (ComponentInstance)  d.eContainer();
                if(next==toRemove)
                    continue;
                else
                    break;
            }
            KevScriptEngine engine = new KevScriptEngine();

            String command = "unbind node0."+toRemove.getName()+"."+toRemove.getProvided().get(0).getPortTypeRef().getName() +" "+before.getName();
            engine.execute(command,model);
            command = "unbind node0."+toRemove.getName()+"."+toRemove.getRequired().get(0).getPortTypeRef().getName() +" "+after.getName();
            engine.execute(command,model);
            command = "remove node0." +toRemove.getName();
            engine.execute(command,model);
            command = "unbind node0."+next.getName()+"."+next.getProvided().get(0).getPortTypeRef().getName() +" "+after.getName();
            engine.execute(command,model);
            command = "bind node0."+next.getName()+"."+next.getProvided().get(0).getPortTypeRef().getName() +" "+before.getName();
            engine.execute(command,model);

        }
        }
        catch (Exception ex)
        {
            Log.debug(ex.getMessage());
            System.out.println(ex.getMessage());

        }

    }


    public static void main(String [] args)
    {
        domain = SampleRunner.init();
        JSONModelLoader loader = new JSONModelLoader();
        ContainerRoot model = (ContainerRoot) loader.loadModelFromStream(RiskFitness.class.getClassLoader().getResourceAsStream("kevInit.json")).get(0);
        Architecture test1= getArchitecture(model);
        double risk= RiskCalculation.calculateRisk(test1);
        System.out.println(risk);

        for(int i=0;i<100;i++)
        {
            addBlur(model);
            Architecture test2= getArchitecture(model);
            double risk2= RiskCalculation.calculateRisk(test2);
            System.out.println(risk2);

        }
        Architecture test2= getArchitecture(model);

        System.out.println("Number of Blur is " + numberOfBlur(model));
        System.out.println("Changing blur");

        for(int i=0;i<30;i++)
        {
            changeBlur(model);
             test2= getArchitecture(model);
            double risk2= RiskCalculation.calculateRisk(test2);
            System.out.println(risk2);

        }
          test2= getArchitecture(model);

        System.out.println("Deleting blur");




        for(int i=0;i<30;i++)
        {
            removeBlur(model);
             test2= getArchitecture(model);
            double risk2= RiskCalculation.calculateRisk(test2);
            System.out.println(risk2);

        }
         test2= getArchitecture(model);

System.out.println("done");







    }


    @Override
    public double evaluate(ContainerRoot model, GenerationContext<ContainerRoot> cloudGenerationContext) {
        Architecture test= getArchitecture(model);
        return RiskCalculation.calculateRisk(test);
    }
    @Override
    public double min() {

        return 0.0;
    }
    public double max() {

        return 1;
    }
    public FitnessOrientation orientation() {

        return FitnessOrientation.MINIMIZE;
    }
}
