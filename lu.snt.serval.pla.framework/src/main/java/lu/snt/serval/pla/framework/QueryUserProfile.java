package lu.snt.serval.pla.framework;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class QueryUserProfile extends QueryBody {
    public String getDataTypeName() {
        return dataTypeName;
    }

    private String dataTypeName;

    public String getLocation() {
        return location;
    }

    private String location;

    public String getUserId() {
        return userId;
    }

    private String userId;


    public  QueryUserProfile(String userId, String dataTypeName, String location)
    {
        this.userId=userId;
        this.dataTypeName=dataTypeName;
        this.location=location;
    }

}
