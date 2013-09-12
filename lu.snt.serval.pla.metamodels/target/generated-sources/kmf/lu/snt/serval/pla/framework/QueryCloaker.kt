package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait QueryCloaker : org.kevoree.modeling.api.KMFContainer , lu.snt.serval.pla.framework.QueryRequest {
open var queriedDataType : lu.snt.serval.pla.framework.QueryDataType?
open var privacyPr : lu.snt.serval.pla.framework.AnswerPrivacyProfile?
open var privacyRule : lu.snt.serval.pla.framework.PrivacyACRule?
}
