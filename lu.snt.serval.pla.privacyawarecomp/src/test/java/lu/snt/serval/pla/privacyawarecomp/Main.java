package lu.snt.serval.pla.privacyawarecomp;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        Server server = new Server();
        server.start();
    }


}
