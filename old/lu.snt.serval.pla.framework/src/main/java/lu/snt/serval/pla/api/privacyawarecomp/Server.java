package lu.snt.serval.pla.api.privacyawarecomp;
/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import lu.snt.serval.pla.loader.JSONModelLoader;
import lu.snt.serval.pla.model.Query;
import lu.snt.serval.pla.serializer.JSONModelSerializer;
import org.kevoree.log.Log;
import org.kevoree.modeling.api.KMFContainer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ServerSocket welcomeSocket = null;
    private PlaInterface plaInterface;
    private ExecutorService executor;
    private JSONModelLoader loader = new JSONModelLoader();
    private JSONModelSerializer serializer = new JSONModelSerializer();

    public Server(PlaInterface plaInterface) {
        this.plaInterface=plaInterface;
        executor = Executors.newSingleThreadExecutor();
    }

    public void run() {
        try {
            Socket connectionSocket = welcomeSocket.accept();

            System.out.println("Server got a connection");

            InputStream serverInpuStream = connectionSocket.getInputStream();
            OutputStream serverOutputStream = connectionSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(serverInpuStream));
            StringBuilder requestString = new StringBuilder();
            String line = reader.readLine();
            //System.out.println(line);
            do{
                requestString.append(line);
                line = reader.readLine();
               // System.out.println(line);
            } while (line != null && !line.equals("<END_OF_REQUEST/>"));

            Log.debug("Server received\n" + requestString.toString());

            List<KMFContainer> loaded = loader.loadModelFromString(requestString.toString());
            Log.debug("Request Loaded");
            Query query = (Query) loaded.get(0);
            Log.debug("Request Loaded");
//            Query query = (Query) loader.loadModelFromStream(serverInpuStream).get(0);

            //System.out.println("Server received query:");
            Drop drop = new Drop();
            Log.debug("Calling the PLA Interface");
            plaInterface.receiveQuery(query,drop);
            Log.debug("Locking on DROP");
            query = drop.take();


            System.out.println("Server sending answer");
            String response = serializer.serialize(query);
            System.out.println(response);
            PrintWriter pr = new PrintWriter(new OutputStreamWriter(serverOutputStream));
            pr.println(response);
            pr.close();
            //Thread.sleep(5000);
            serverOutputStream.close();
            connectionSocket.close();
            executor.submit(this);

        } catch (IOException e) {
            Log.error("Socket Exception::" + e.getMessage());
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void start() {
        try {
            welcomeSocket = new ServerSocket(9000);
            //executor.submit(this);
            new Thread(this).start();
            System.out.println("Server waiting connections ");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void stop() {
        try {
            executor.shutdownNow();
            welcomeSocket.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


}


