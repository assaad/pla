package lu.snt.serval.pla.sensor;

import org.kevoree.annotation.*;

@ComponentType
@Library(name = "Java")
public class SensorGateway {

    @Param(defaultValue = "Default Content")
    String message;

    @KevoreeInject
    org.kevoree.api.Context context;


    @Input
    public String in(Object i) {
        String msg = message+" from "+context.getInstanceName()+"@"+context.getNodeName();
        System.out.println(msg);
        return msg;
    }

    @Start
    public void start() {}

    @Stop
    public void stop() {}

    @Update
    public void update() {System.out.println("Param updated!");}

}



