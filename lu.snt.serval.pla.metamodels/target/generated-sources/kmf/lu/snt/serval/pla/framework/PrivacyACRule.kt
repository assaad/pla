package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait PrivacyACRule : org.kevoree.modeling.api.KMFContainer {
public open var cloakingAlgorithm : String?
public open var generated_KMF_ID : String?
open var dataType : lu.snt.serval.pla.framework.DataType?
open var timeBluring : lu.snt.serval.pla.framework.TimeBluring?
open var valueBluring : lu.snt.serval.pla.framework.ValueBluring?
}
