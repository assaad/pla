package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait QueryDataType : org.kevoree.modeling.api.KMFContainer , lu.snt.serval.pla.framework.QueryRequest , lu.snt.serval.pla.framework.DataType {
public open var dateTime : java.util.Date?
open var queriedDataType : lu.snt.serval.pla.framework.DataType?
open var requestedTimeBluring : lu.snt.serval.pla.framework.TimeBluring?
open var requestedValueBluring : lu.snt.serval.pla.framework.ValueBluring?
}
