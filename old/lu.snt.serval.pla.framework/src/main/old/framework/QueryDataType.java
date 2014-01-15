package lu.snt.serval.pla.api;

import lu.snt.serval.pla.userprofile.TimeAccuracy;
import lu.snt.serval.pla.userprofile.ValueAccuracy;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class QueryDataType extends QueryBody {

    private String dataTypeName;
    private String location;
    private TimeAccuracy timeAccuracy;
    private ValueAccuracy valueAccuracy;
    private Date queryDate;

    public String getDataTypeName() {
        return dataTypeName;
    }



    public String getLocation() {
        return location;
    }



    public TimeAccuracy getTimeAccuracy() {
        return timeAccuracy;
    }



    public ValueAccuracy getValueAccuracy() {
        return valueAccuracy;
    }



    public Date getQueryDate() {
        return queryDate;
    }




    public QueryDataType(String dataTypeName, String location, Date queryDate, TimeAccuracy timeAccuracy, ValueAccuracy valueAccuracy) {
        this.dataTypeName = dataTypeName;
        this.location = location;
        this.queryDate=queryDate;
        this.timeAccuracy = timeAccuracy;
        this.valueAccuracy = valueAccuracy;
    }


}
