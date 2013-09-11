package lu.snt.serval.pla.privacyawarecomp;

import lu.snt.serval.pla.framework.Answer;
import lu.snt.serval.pla.framework.Drop;
import lu.snt.serval.pla.framework.Query;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */


public class QueryProcessor extends Thread {

  //  protected QueryInterface QI;

    private int id;
    protected Query query;
    protected Answer answer;
    protected Drop drop;
    protected QueryInterface qi;

    public  QueryProcessor(QueryInterface qi, Query query, int id, Drop drop) {
        this.qi=qi;
        this.drop = drop;
        this.id = id;
        this.query = query;
    }

    public void run() {
    }

}
