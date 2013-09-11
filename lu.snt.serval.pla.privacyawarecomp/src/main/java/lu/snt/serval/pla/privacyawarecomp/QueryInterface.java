package lu.snt.serval.pla.privacyawarecomp;

import lu.snt.serval.pla.framework.Answer;
import lu.snt.serval.pla.framework.Query;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */



public interface QueryInterface {
    public void askPrivacyPofile(Query qProfile);
    public void askCloakers(Query qCloak);
    public void sendResult(Answer answer);

}
