import lu.snt.serval.pla.sensor.SensorValue;

import java.util.Date;

/**
 * User: assaad.moawad
 * Date: 15/01/14
 * Time: 14:00
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class main {
    public static void main(String [] args) {

        SensorValue temp = new SensorValue();
        temp.setSensorID("1");
        temp.setTime(new Date().getTime());
        temp.setType("Temperature");
        temp.setValue(7.2);

        String s= temp.toJSON();
        System.out.println(s);

        SensorValue t2= SensorValue.fromJSON(s);
        System.out.println(t2.toString());

    }
}
