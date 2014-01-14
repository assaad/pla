package lu.snt.serval.pla.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class QueryCloakers extends QueryBody {
    private AnswerUserProfile userProfile;
    private QueryDataType queryDataType;


    public QueryDataType getQueryDataType() {
        return queryDataType;
    }
    public AnswerUserProfile getUserProfile() {
        return userProfile;
    }

}
