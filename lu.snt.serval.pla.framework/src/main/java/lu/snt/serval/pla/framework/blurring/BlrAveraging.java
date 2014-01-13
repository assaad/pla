package lu.snt.serval.pla.framework.blurring;

import lu.snt.serval.pla.model.DoubleValueAnswer;
import lu.snt.serval.pla.model.NoiseBlurring;
import lu.snt.serval.pla.model.TimeAveraging;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.Param;
import org.kevoree.log.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: assaad.moawad
 * Date: 13/01/14
 * Time: 16:19
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */

@ComponentType
@Library(name = "PLA_Blurring")
public class BlrAveraging extends TimeBlurring {
    @Param(defaultValue = "1")
    long timewindow = 15*60*1000; //15 minutes in microseconds

    private List<DoubleValueAnswer> ls;


    @Override
    public void sensorIn(Object o) {

        try {
            DoubleValueAnswer signal = (DoubleValueAnswer) o;
            if(ls==null)
            {
                ls= new ArrayList<DoubleValueAnswer>();
                ls.add(signal);
                return;
            }
            else
            {
                if((signal.getDateTime().getTime()-ls.get(0).getDateTime().getTime())>timewindow)
                {
                    //Do the average and send it

                    DoubleValueAnswer res = factory.createDoubleValueAnswer();
                    double sum=0;
                    Iterator iter = ls.iterator();
                    while (iter.hasNext())
                    {
                        DoubleValueAnswer temp= (DoubleValueAnswer) iter.next();
                        sum+=temp.getValue();
                    }
                    sum=sum/ls.size();
                    res.setValue(sum);
                    res.setDateTime(ls.get(0).getDateTime());

                    TimeAveraging ta = factory.createTimeAveraging();
                    ta.setDuration(timewindow);

                    res.addBlurrings(ta);

                    resultOut.send(res);

                    // Clear the list and add the new element
                    ls.clear();
                    ls.add(signal);
                }
                else
                {
                    ls.add(signal);
                    return;
                }
            }




           // resultOut.send(signal);

        }
        catch (Exception ex)
        {
            Log.debug(ex.getMessage());
        }

    }


}
