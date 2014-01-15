package lu.snt.serval.pla.api;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class QueryUserProfile extends QueryBody {
    private String dataTypeName;
    private String location;
    private String userId;

    public String getDataTypeName() {
        return dataTypeName;
    }



    public String getLocation() {
        return location;
    }



    public String getUserId() {
        return userId;
    }




    public  QueryUserProfile(String userId, String dataTypeName, String location)
    {
        this.userId=userId;
        this.dataTypeName=dataTypeName;
        this.location=location;
    }

}
