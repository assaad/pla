package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait QueryPrivacyProfile : org.kevoree.modeling.api.KMFContainer , lu.snt.serval.pla.framework.QueryRequest {
open var userProfile : lu.snt.serval.pla.framework.UserProfile?
open var queriedDataType : lu.snt.serval.pla.framework.DataType?
}
