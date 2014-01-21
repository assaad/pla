import lu.snt.serval.pla.*;
import lu.snt.serval.pla.genetic.RiskCalculation;
import lu.snt.serval.pla.impl.DefaultPlaFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by assaad.moawad on 1/21/14.
 */
public class AbstractTest {

    private static DefaultPlaFactory factory = new DefaultPlaFactory();

    private static Domain domain;

    public static void init()
    {
        domain = factory.createDomain();
        domain.setName("AAL");

        SensorKind sensor0 = factory.createSensorKind();
        sensor0.setId("sensor0");
        sensor0.setType("Temperature");
        domain.addSensors(sensor0);

        Risk risk0=factory.createRisk();
        risk0.setId("risk0");
        risk0.setDescription("Detection of presence of person in the room");
        risk0.setImpact(1);         //WHAt is impact ???
        //domain.addRisks(risk0);
        sensor0.addRisks(risk0);

        CounterMeasure cm = factory.createCounterMeasure();
        cm.setId("CM0");
        cm.setDescription("Reducing precision of the sensor");

        Setting setting0= factory.createSetting();
        setting0.setParamName("digit");
        setting0.setParamValue0(1.0);
        setting0.setImpact0(1.0);
        setting0.setParamValue1(7.0);
        setting0.setImpact1(0.000001);
        setting0.setProfile(Profile.LINEAR);

        cm.setSetting(setting0);
        cm.setRisk(risk0);

        Blurring blr0 = factory.createBlurring();
        blr0.setName("Trim");
        cm.setBlurring(blr0);
        //  domain.addCounterMeasures(cm);
    }

    public static void main(String [] args) {
        init();
        RiskCalculation rc= new RiskCalculation(domain);

        List<Blurring> lb=new ArrayList<Blurring>();

        Blurring bc = factory.createBlurring();
        bc.setName("Trim");
        bc.setParamName("digit");
        bc.setParamValue(5.0);
        lb.add(bc);

        double risk = rc.calculateRiskOnSensor("sensor0",lb);
        System.out.println(risk);


    }
}
