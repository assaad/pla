package lu.snt.serval.pla.sensor;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 10/09/13
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */


public class Query implements Serializable {
    private QueryBody querybody;
    //private boolean initiatorIsConsole;


    private String nameowner;  //the component that created this query
    private String namedestination;
    private int processId;     // like the port processing the query in the Owner


    public Query(String owner, boolean initiatorIsConsole, String destination, QueryBody querybody, Collection history) {
        this.nameowner = owner;

        this.namedestination = destination;
        this.querybody = querybody;
    }


    public String getOwner() {
        return nameowner;
    }

    public String getDestinator() {
        return namedestination;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getProcessId() {
        return processId;
    }

    public QueryBody getQuerybody() {
        return (this.querybody);
    }

}
