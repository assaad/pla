package lu.snt.serval.pla.privacyawarecomp;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import lu.snt.serval.kmf.loader.JSONModelLoader;
import lu.snt.serval.kmf.serializer.JSONModelSerializer;
import lu.snt.serval.pla.model.ModelFactory;
import lu.snt.serval.pla.model.Query;
import lu.snt.serval.pla.model.impl.DefaultModelFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start() {


        ServerSocket welcomeSocket = null;
        try {
            welcomeSocket = new ServerSocket(9000);
            System.out.println("Server waiting connections ");
            Socket connectionSocket = welcomeSocket.accept();

            System.out.println("Server got a connection");
            JSONModelLoader loader = new JSONModelLoader();
            JSONModelSerializer serializer = new JSONModelSerializer();
            InputStream serverInpuStream = connectionSocket.getInputStream();
            OutputStream serverOutputStream = connectionSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(serverInpuStream));
            StringBuilder requestString = new StringBuilder();
            String line = reader.readLine();
            System.out.println(line);
            do{
                requestString.append(line);
                line = reader.readLine();
                System.out.println(line);
            } while (line != null && !line.equals("<END_OF_REQUEST/>"));
            Query query = (Query) loader.loadModelFromString(requestString.toString()).get(0);

//            Query query = (Query) loader.loadModelFromStream(serverInpuStream).get(0);

            System.out.println("Server received query:");

            ModelFactory factory = new DefaultModelFactory();
            query.addAnswers(factory.createValueAnswer());

            System.out.println("Server sending answer");
            String response = serializer.serialize(query);
            System.out.println(response);
            PrintWriter pr = new PrintWriter(new OutputStreamWriter(serverOutputStream));
            pr.println(response);
            pr.close();
            //Thread.sleep(5000);
            serverOutputStream.close();
            connectionSocket.close();


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {

                welcomeSocket.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }


    }



}
