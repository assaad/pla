package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait AnswerDataType : org.kevoree.modeling.api.KMFContainer , lu.snt.serval.pla.framework.Answer {
public open var dateTime : java.util.Date?
open var resultedTimeBluring : lu.snt.serval.pla.framework.TimeBluring?
open var ResultedValueBluring : lu.snt.serval.pla.framework.ValueBluring?
}
