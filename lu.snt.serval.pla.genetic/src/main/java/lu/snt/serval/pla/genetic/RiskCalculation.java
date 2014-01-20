package lu.snt.serval.pla.genetic;

import jet.runtime.typeinfo.JetValueParameter;
import lu.snt.serval.pla.*;
import lu.snt.serval.pla.impl.DefaultPlaFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kevoree.modeling.api.KMFContainer;
import org.omg.DynamicAny._DynAnyFactoryStub;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * User: assaad.moawad
 * Date: 20/01/14
 * Time: 12:39
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class RiskCalculation {
     private static DefaultPlaFactory factory = new DefaultPlaFactory();
    private Domain domain;

    public RiskCalculation(Domain domain)
    {
        this.domain=domain;
    }

    private double calculateImpact1cm(Setting setting, Blurring blurring)
    {
        if(blurring.getParamName().equals(setting.getParamName()))
        {
            if(setting.getParamValue0()<setting.getParamValue1())
            {
                if(blurring.getParamValue()<setting.getParamValue0())
                    return setting.getImpact0();
                if(blurring.getParamValue()>setting.getParamValue1())
                    return setting.getImpact1();
            }
            else
            {
                if(blurring.getParamValue()>setting.getParamValue0())
                    return setting.getImpact0();
                if(blurring.getParamValue()<setting.getParamValue1())
                    return setting.getImpact1();
            }
            double x0=setting.getParamValue0();
            double x1= setting.getParamValue1();
            double y0=setting.getImpact0();
            double y1=setting.getImpact1();

            if(setting.getProfile()==Profile.LINEAR)
            {
                double a=(y0-y1)/(x0-x1);
                double b=y0-a*x0;
                double res=a*blurring.getParamValue()+b;
                return  res;
            }
            else if  (setting.getProfile()==Profile.EXPONENTIAL)
            {

            }
        }
        else
            return 0;

     return 0;
    }


    private SensorKind getSensorById(String sensorId)
    {
        if(domain.getSensors().size()==0)
            return null;

        Iterator iter = domain.getSensors().iterator();
        while (iter.hasNext())
        {
            SensorKind sk= (SensorKind) iter.next();
            if(sk.getId().equals(sensorId))
                return sk;
        }
        return null;
    }


    private Blurring findBlurringByName( List<Blurring> blrList,  String name)
    {
      Iterator blurIterator = blrList.iterator();
        while (blurIterator.hasNext())
        {
            Blurring b = (Blurring) blurIterator.next();
            if(b.getName().equals(name))
                return b;
        }
        return null;
    }



    private double calculateRisk(Risk risk, List<Blurring> blrList)
    {
        List<CounterMeasure> lc = risk.getCounterMeasures();
        if(lc.size()==0|| blrList.size()==0)
            return 1;

        Iterator cmIterator= lc.iterator();
        Double minRisk=1.0;
        while (cmIterator.hasNext())
        {
            CounterMeasure cm= (CounterMeasure) cmIterator.next();
            Blurring b = findBlurringByName(blrList, cm.getBlurring().getName());
            if(b!=null)
            {
                 double current = 1- calculateImpact1cm(cm.getSetting(),b);
               minRisk = Math.min(minRisk,current);
            }
        }
        return minRisk;
    }

    public double calculateRiskOnSensor(String sensorId, List<Blurring> blrList)
    {
        SensorKind sensorKind = getSensorById(sensorId);
        if(sensorKind==null)
            return -1;

        List<Risk> lr = sensorKind.getRisks();
        if(lr.size()==0)
            return 0;

        Iterator riskIterator = lr.iterator();
        int totalWeight=0;
        double finalrisk=0;
        while (riskIterator.hasNext())
        {
            Risk risk = (Risk) riskIterator.next();
            totalWeight+= risk.getImpact();
            finalrisk += risk.getImpact()*calculateRisk(risk, blrList);
        }
        finalrisk = finalrisk/totalWeight;
        return finalrisk;


    }
}
