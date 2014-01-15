package lu.snt.serval.pla.client;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import lu.snt.serval.pla.model.*;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;

import java.util.Date;

public class Main {


    public static void main(String[] args) {

        ModelFactory factory = new DefaultModelFactory();
       Query query = factory.createQuery();


        UserProfile user = factory.createUserProfile();

        user.setName("user1");
        user.setId("123456789");

        query.setUserProfile(user);

        QueryDataType request1 = factory.createQueryDataType();




        DataType dt = factory.createDataType();
        dt.setName("Temperature");
        dt.setLocation("Room1");
        query.addDataTypes(dt);


        request1.setDataType(dt);

        Date d = new Date();
        d.setTime(d.getTime()-5*24*60*60*1000+25*60*1000);   //20 minutes from 5 days ago

        request1.setDateTime(d);


        IntervalBlurring ib = factory.createIntervalBlurring();
        ib.setIntervalLength((float)0.0);

        request1.setRequestedValueBlurring(ib);
        query.addQueryRequests(request1);

        System.out.println(request1.getOwningQuery()==query);
        //request1.setOwningQuery(query);

        //request1.setDataType(factory.createDataType());




        Client c = new Client();
        Query queryWithAnswer = c.sendQuery(query);




    }


}
