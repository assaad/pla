/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 09/09/13
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
package lu.snt.serval.pla.client;

import lu.snt.serval.pla.loader.JSONModelLoader;
import lu.snt.serval.pla.model.ModelFactory;
import lu.snt.serval.pla.model.Query;
import lu.snt.serval.pla.model.QueryDataType;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;
import lu.snt.serval.pla.serializer.JSONModelSerializer;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;

/*

@Provides({

        @ProvidedPort(name = "ResponseIn", type = PortType.MESSAGE)
})

@Requires({
        @RequiredPort(name = "QueryOut", type = PortType.MESSAGE, optional = true)
})


@DictionaryType({
        @DictionaryAttribute(name = "Name", optional = false),
        @DictionaryAttribute(name = "InitialKnowledgeBaseFile", optional = true),
        @DictionaryAttribute(name = "InitialTrustFile", optional = true),

})


//((MessagePort)getPortByName("QueryOut")).process(object data);

@ComponentType
@Library(name = "Serval_PLA")
*/
public class Client {//extends org.kevoree.sensor.AbstractComponentType {

    //Starting
    public Client() {

           ModelFactory factory = new DefaultModelFactory();

    }
    public Query sendQuery(Query queryToSend) {



        Query answer = null;
        Socket socket = null;
        try{
            //Patching date
            Iterator iter = queryToSend.getQueryRequests().iterator();
            while(iter.hasNext())
            {
                QueryDataType qdt = (QueryDataType) iter.next();
                qdt.setDateTimeLong(qdt.getDateTime().getTime());
            }
            //Patching date done

            System.out.println("Client connecting");
            socket = new Socket("localhost", 9000);
            InputStream socketInput = socket.getInputStream();
            OutputStream socketOutput = socket.getOutputStream();
            JSONModelSerializer serializer = new JSONModelSerializer();
            JSONModelLoader loader = new JSONModelLoader();

            System.out.println("Client sending query");
            String request = serializer.serialize(queryToSend);
            PrintWriter pr = new PrintWriter(new OutputStreamWriter(socketOutput));
            pr.println(request);
            pr.println("<END_OF_REQUEST/>");
            pr.flush();
            System.out.println("Client waiting answer");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socketInput));
            StringBuilder requestString = new StringBuilder();
            String line = reader.readLine();
            do{
                requestString.append(line);
                line = reader.readLine();
            } while (line != null);

            answer = (Query) loader.loadModelFromString(requestString.toString()).get(0);

            System.out.println("Client received answer:");
            System.out.println(serializer.serialize(answer));

            System.out.println("Client sent query was:");
            System.out.println(serializer.serialize(queryToSend));

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return answer;

    }


}

