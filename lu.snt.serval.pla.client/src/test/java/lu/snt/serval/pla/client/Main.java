package lu.snt.serval.pla.client;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import lu.snt.serval.pla.model.ModelFactory;
import lu.snt.serval.pla.model.Query;
import lu.snt.serval.pla.model.QueryRequest;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;

public class Main {


    public static void main(String[] args) {

        ModelFactory factory = new DefaultModelFactory();
        Query query = factory.createQuery();
        QueryRequest request1 = factory.createQueryDataType();

        //request1.setDataType(factory.createDataType());

        query.addQueryRequests(request1);

        Client c = new Client();
        Query queryWithAnswer = c.sendQuery(query);

    }


}
