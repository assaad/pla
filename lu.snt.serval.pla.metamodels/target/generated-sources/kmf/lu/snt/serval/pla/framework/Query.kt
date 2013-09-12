package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait Query : org.kevoree.modeling.api.KMFContainer {
public open var generated_KMF_ID : String?
open var userProfile : lu.snt.serval.pla.framework.UserProfile?
open var queryRequests : List<lu.snt.serval.pla.framework.QueryRequest>
fun addQueryRequests(queryRequests : lu.snt.serval.pla.framework.QueryRequest)
fun addAllQueryRequests(queryRequests :List<lu.snt.serval.pla.framework.QueryRequest>)
fun removeQueryRequests(queryRequests : lu.snt.serval.pla.framework.QueryRequest)
fun removeAllQueryRequests()
fun findQueryRequestsByID(key : String?) : lu.snt.serval.pla.framework.QueryRequest?
open var answers : List<lu.snt.serval.pla.framework.Answer>
fun addAnswers(answers : lu.snt.serval.pla.framework.Answer)
fun addAllAnswers(answers :List<lu.snt.serval.pla.framework.Answer>)
fun removeAnswers(answers : lu.snt.serval.pla.framework.Answer)
fun removeAllAnswers()
fun findAnswersByID(key : String?) : lu.snt.serval.pla.framework.Answer?
}
