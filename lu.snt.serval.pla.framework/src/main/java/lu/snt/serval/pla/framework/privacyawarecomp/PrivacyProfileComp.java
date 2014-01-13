package lu.snt.serval.pla.framework.privacyawarecomp;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 30/09/13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */

import lu.snt.serval.pla.model.*;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
import org.kevoree.annotation.*;
import org.kevoree.log.Log;

import java.util.Iterator;





@ComponentType
@Library(name = "Serval_PLA")
public class PrivacyProfileComp {

    @Output
    private org.kevoree.api.Port privacyProfileOut;

    private PrivacyProfileDb ppDb;
    private ModelFactory factory;



    @Input
    public void privacyProfileIn(Object o) {
        Log.debug("Privacy component received a query");
          QueryPrivacyProfile qpp =  (QueryPrivacyProfile) o;
        PrivacyProfile pp =   getByUserProfile(qpp.getOwningQuery().getUserProfile()) ;

        AnswerPrivacyProfile ans= factory.createAnswerPrivacyProfile();
        ans.setPrivacyRule(getRule(pp,qpp.getDataType()));
        SendResult(ans);
        Log.debug("Privacy component sending answer");


    }

    private PrivacyRule getRule(PrivacyProfile pp, DataType dt)
    {
        Log.debug("Inside getRule");
try
{
        Iterator iter = pp.getPrivacyRules().iterator();

        while(iter.hasNext()) {
            PrivacyRule element = (PrivacyRule)  iter.next();
            DataType current = element.getDataType();
            if(current.getName().equals(dt.getName()) && current.getLocation().equals(dt.getLocation()))
            {
                Log.debug("Returning a rule");
                return element;
            }
        }
    Log.debug("No rules found");
    return factory.createEmptyRule();
}
catch (Exception ex)
{
    Log.debug("Returning empty Rule because of exception: " + ex.getMessage());
    return factory.createEmptyRule();
}


    }

    private void SendResult(AnswerPrivacyProfile ans)
    {
        privacyProfileOut.send(ans);

    }


    private PrivacyProfile getByUserProfile (UserProfile user)  {
        Iterator iter =        ppDb.getProfiles().iterator() ;
        while(iter.hasNext()) {
            PrivacyProfile element = (PrivacyProfile) iter.next();
            if(element.getUserProfile().getId().equals(user.getId()) && element.getUserProfile().getName().equals(user.getName()))
            {
                Log.debug("User Privacy profile found");
                return element;
            }
        }
        Log.debug("User Privacy profile NOT found");
        return null;
    }



    @Start
    public void start() {
        factory = new DefaultModelFactory();

        ppDb=  factory.createPrivacyProfileDb();

        UserProfile up1 = factory.createUserProfile();
        up1.setName("user1");
        up1.setId("123456789");
        PrivacyProfile pp1 = factory.createPrivacyProfile();
        pp1.setUserProfile(up1);


        PrivacyRule pr1 = factory.createPrivacyRule();
        pr1.setBlurringAlgorithm("IntervalBlur");

        DataType dt = factory.createDataType();
        dt.setName("Temperature");
        dt.setLocation("Room1");

        TimeAveraging ta = factory.createTimeAveraging();
        ta.setDuration((long)20*60*1000); //20min average

        IntervalBlurring ib = factory.createIntervalBlurring();
        ib.setIntervalLength((float)2);
        pr1.setDataType(dt);

        pr1.setTimeBlurring(ta);
        pr1.setValueBlurring(ib);

        pp1.addPrivacyRules(pr1);
        ppDb.addProfiles(pp1);



        UserProfile up2 = factory.createUserProfile();
        up2.setName("user2");
        up2.setId("987654321");
        PrivacyProfile pp2 = factory.createPrivacyProfile();
        pp2.setUserProfile(up2);

        PrivacyRule pr2 = factory.createPrivacyRule();
        pr2.setBlurringAlgorithm("NoiseBlur");

        DataType dt2 = factory.createDataType();
        dt2.setName("Temperature");
        dt2.setLocation("Room1");

        NoiseBlurring nb = factory.createNoiseBlurring();
        nb.setTypeOfNoise("Gauss");
        nb.setVariance(2.0);

        pr2.setValueBlurring(nb);

        pp2.addPrivacyRules(pr2);
        ppDb.addProfiles(pp2);
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
