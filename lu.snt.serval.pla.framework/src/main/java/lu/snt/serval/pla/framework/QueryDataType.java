package lu.snt.serval.pla.framework;

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
    public String getDataTypeName() {
        return dataTypeName;
    }

    private String dataTypeName;

    public String getLocation() {
        return location;
    }

    private String location;

    public TimeAccuracy getTimeAccuracy() {
        return timeAccuracy;
    }

    private TimeAccuracy timeAccuracy;

    public ValueAccuracy getValueAccuracy() {
        return valueAccuracy;
    }

    private ValueAccuracy valueAccuracy;

    public Date getQueryDate() {
        return queryDate;
    }

    private Date queryDate;


    public QueryDataType(String dataTypeName, String location, Date queryDate, TimeAccuracy timeAccuracy, ValueAccuracy valueAccuracy) {
        this.dataTypeName = dataTypeName;
        this.location = location;
        this.queryDate=queryDate;
        this.timeAccuracy = timeAccuracy;
        this.valueAccuracy = valueAccuracy;
    }


}
