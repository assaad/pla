package lu.snt.serval.pla.client;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import lu.snt.serval.pla.model.*;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;

public class Main {


    public static void main(String[] args) {

        ModelFactory factory = new DefaultModelFactory();
       Query query = factory.createQuery();


        UserProfile user = factory.createUserProfile();

        user.setName("user1");
        user.setId("123456789");

        query.setUserProfile(user);

        //TEST WITHOUT REQUESTS
        Client c = new Client();
        Query queryWithAnswer = c.sendQuery(query);



        QueryDataType request1 = factory.createQueryDataType();
        request1.setOwningQuery(query);



        DataType dt = factory.createDataType();
        dt.setName("Temperature");
        dt.setLocation("Room1");


        request1.setDataType(dt);

         IntervalBlurring ib = factory.createIntervalBlurring();
        ib.setIntervalLength(0.0);

        request1.setRequestedValueBlurring(ib);

        //request1.setDataType(factory.createDataType());

        query.addQueryRequests(request1);



    }


}
