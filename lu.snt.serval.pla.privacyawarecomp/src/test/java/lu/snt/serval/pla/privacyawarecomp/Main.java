package lu.snt.serval.pla.privacyawarecomp;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 12/09/13
*/

import org.kevoree.log.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        Log.DEBUG();

        PrivacyAwareComp component = new PrivacyAwareComp();
        component.start();


        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        component.stop();

    }


}
