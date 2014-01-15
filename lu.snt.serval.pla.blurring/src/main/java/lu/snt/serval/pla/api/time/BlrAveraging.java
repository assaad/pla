package lu.snt.serval.pla.api.time;

import lu.snt.serval.pla.api.SensorValue;
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
    @Param(defaultValue = "900000")
    long timewindow = 15*60*1000; //15 minutes in milliseconds

    private List<SensorValue> ls;


    @Override
    public void sensorIn(Object o) {

        try {
            SensorValue signal = (SensorValue) o;

            if(ls==null)
            {
                ls= new ArrayList<SensorValue>();
                ls.add(signal);
                return;
            }
            else
            {
                if((signal.getTime()-ls.get(0).getTime())>timewindow)
                {
                    //Do the average and send it

                    SensorValue res = new SensorValue();
                    double sum=0;
                    Iterator iter = ls.iterator();
                    while (iter.hasNext())
                    {
                        SensorValue temp= (SensorValue) iter.next();
                        sum+=temp.getValue();
                    }
                    sum=sum/ls.size();
                    res.setValue(sum);
                    res.setTime(ls.get(0).getTime());
                    res.setSensorID(ls.get(0).getSensorID());
                    res.setType(ls.get(0).getType());


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
