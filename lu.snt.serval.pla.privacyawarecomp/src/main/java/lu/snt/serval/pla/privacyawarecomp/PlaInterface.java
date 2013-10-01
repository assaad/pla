package lu.snt.serval.pla.privacyawarecomp;

import lu.snt.serval.pla.model.Query;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 30/09/13
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public interface PlaInterface {
    public void receiveQuery(Query q, Drop d);
}
