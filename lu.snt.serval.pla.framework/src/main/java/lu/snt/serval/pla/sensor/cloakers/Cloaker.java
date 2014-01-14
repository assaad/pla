package lu.snt.serval.pla.sensor.cloakers; /**
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
import org.kevoree.api.Context;
import org.kevoree.log.Log;

import java.util.ArrayList;





@ComponentType
@Library(name = "Serval_PLA")
public abstract class Cloaker {
    protected ModelFactory factory;
    protected QueryCloaker qc;

    protected  AnswerDataType ans;
    //Starting

    @Output
    private org.kevoree.api.Port cloakerOut;
    @Output
    private org.kevoree.api.Port dataOut;

    @KevoreeInject
    private Context mycontext;

    @Input
    public void queryIn(Object o)
    {
        try
        {
            Log.debug(o.getClass().getName());
            qc =   (QueryCloaker) o;
            if (qc.getPrivacyRule().getBlurringAlgorithm().equals(mycontext.getInstanceName()))
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
        cloakerOut.send(o);
        System.out.println("Cloaker "+ mycontext.getInstanceName() + " returning result");

    }

    protected void askSensorDb(Object o)
    {
        dataOut.send(o);

    }


    @Input
    public void DataIn(Object o)
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

