package lu.snt.serval.pla.framework.cloakers;

import lu.snt.serval.pla.model.*;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Library;
import org.kevoree.log.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 03/10/13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */

@ComponentType
@Library(name = "Serval_PLA")
public class CloakerIntervalBlur extends Cloaker {
    public void prepareRequest ()
    {

        Log.debug("Inside prepare Request");
        ans = factory.createIntervalFloatAnswer();

        ans.setDataType(qc.getQueriedDataType().getDataType());
        ans.setDateTime(qc.getQueriedDataType().getDateTime());


        QuerySensorDb q =factory.createQuerySensorDb();
        q.setDataType(qc.getQueriedDataType().getDataType());
        q.setDateTimeTo(qc.getQueriedDataType().getDateTime());

        if(q.getDataType()==null)
            Log.debug("STOOOP");

       long initTime=0;
        if(qc.getQueriedDataType().getRequestedTimeBlurring()==null)
        {
            Log.debug("1");
            if  (qc.getPrivacyRule().getTimeBlurring()==null)
                initTime=60*1000; //1 minute precision
            else
                initTime=((TimeAveraging)qc.getPrivacyRule().getTimeBlurring()).getDuration();
        }
            else
        {
            Log.debug("2");
            if  (qc.getPrivacyRule().getTimeBlurring()==null)
                initTime= ((TimeAveraging) qc.getQueriedDataType().getRequestedTimeBlurring()).getDuration();
            else
                initTime= Math.max(((TimeAveraging) qc.getQueriedDataType().getRequestedTimeBlurring()).getDuration(),((TimeAveraging)qc.getPrivacyRule().getTimeBlurring()).getDuration());

        }
        Log.debug("3");
        TimeAveraging tb=factory.createTimeAveraging();
        tb.setDuration(initTime);
        Log.debug("init time" + initTime);
        ans.addBlurrings(tb);

        Date m = new Date();
        m.setTime(q.getDateTimeTo().getTime()-initTime);
        q.setDateTimeFrom(m);
        Log.debug("4");
        askSensorDb(q);
        Log.debug("5");
    }


    public void blur (ArrayList<AnswerDataType> rawAnswers)
    {
        Iterator iter = rawAnswers.iterator();

        if(rawAnswers==null || rawAnswers.size()==0)
        {
            returnResult(factory.createNoAnswer());
            return;
        }
        float result = (float) 0;
        while (iter.hasNext())
        {
            DoubleValueAnswer element = (DoubleValueAnswer) iter.next();
            result+=  element.getValue();
        }
        result=result/(rawAnswers.size());

        IntervalFloatAnswer ifa = (IntervalFloatAnswer) ans;

        if((IntervalBlurring) qc.getPrivacyRule().getValueBlurring()==null && qc.getQueriedDataType().getRequestedValueBlurring()==null)
        {
            ifa.setMax(result);
            ifa.setMin(result);
        }
        else
        {
            float len;
            if((IntervalBlurring) qc.getPrivacyRule().getValueBlurring()!=null && qc.getQueriedDataType().getRequestedValueBlurring()==null)
                len=  ((IntervalBlurring) qc.getPrivacyRule().getValueBlurring()).getIntervalLength();
            else if ((IntervalBlurring) qc.getPrivacyRule().getValueBlurring()==null && qc.getQueriedDataType().getRequestedValueBlurring()!=null)
                len =   ((IntervalBlurring) qc.getQueriedDataType().getRequestedValueBlurring()).getIntervalLength();
            else
                len = Math.max(((IntervalBlurring) qc.getPrivacyRule().getValueBlurring()).getIntervalLength(),((IntervalBlurring) qc.getQueriedDataType().getRequestedValueBlurring()).getIntervalLength());

            if(len==0)
            {
                ifa.setMax(result);
                ifa.setMin(result);
            }
            else
            {
                float min=0;
                float max=0;
                if(result>=0)
                {
                    do {
                        min=max;
                        max=max+len;
                    }
                    while(result>max);
                }
                else
                {
                    do {
                        max=min;
                        min=min-len;
                    }
                    while(result<min);

                }
                ifa.setMin(min);
                ifa.setMax(max);
            }
        }
        returnResult(ans);
    }
}
