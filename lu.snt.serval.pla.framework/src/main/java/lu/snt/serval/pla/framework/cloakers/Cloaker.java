package lu.snt.serval.pla.framework.cloakers; /**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 10/09/13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.AnswerDataType;
import lu.snt.serval.pla.model.ModelFactory;
import lu.snt.serval.pla.model.QueryCloaker;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.log.Log;

import java.util.ArrayList;



@Provides({

        @ProvidedPort(name = "CloakerIn", type = PortType.MESSAGE),
        @ProvidedPort(name = "DataIn", type = PortType.MESSAGE),
})

@Requires({
        @RequiredPort(name = "CloakerOut", type = PortType.MESSAGE, optional = true),
        @RequiredPort(name = "DataOut", type = PortType.MESSAGE, optional = true),
})



/*@DictionaryType({
        @DictionaryAttribute(name = "Name", optional = false),
   //     @DictionaryAttribute(name = "InitialKnowledgeBaseFile", optional = true),
     //   @DictionaryAttribute(name = "InitialTrustFile", optional = true),

})  */


//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
public abstract class Cloaker extends org.kevoree.framework.AbstractComponentType {
    protected ModelFactory factory;
    protected QueryCloaker qc;

    protected  AnswerDataType ans;
    //Starting


    @Port(name = "CloakerIn")
    public void incomingQuery(Object o)
    {
        try
        {
            Log.debug(o.getClass().getName());
            qc =   (QueryCloaker) o;
            if (qc.getPrivacyRule().getBlurringAlgorithm().equals(this.getName()))
            {
                    prepareRequest();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error inside cloaker, "+ex.getMessage());
            returnResult(factory.createNoAnswer());
        }
    }

    public abstract void prepareRequest ();
    public abstract void blur (ArrayList<AnswerDataType> rawAnswers) ;


    protected void returnResult(Object o)
    {
        MessagePort prodPort =  getPortByName("CloakerOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(o);
            System.out.println("Cloaker "+ this.getName() + " returning result");
        }
    }

    protected void askSensorDb(Object o)
    {
        MessagePort prodPort =  getPortByName("DataOut", MessagePort.class);
        if (prodPort != null) {
            prodPort.process(o);
            //System.out.println("Cloaker "+ this.getName() + " returning result");
        }

    }


    @Port(name = "DataIn")
    public void incomingData(Object o)
    {
        ArrayList<AnswerDataType> rawAnswers = (ArrayList<AnswerDataType>) o;
        blur(rawAnswers);
    }



    @Start
    public void start() {
        factory = new DefaultModelFactory();

    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }


}

