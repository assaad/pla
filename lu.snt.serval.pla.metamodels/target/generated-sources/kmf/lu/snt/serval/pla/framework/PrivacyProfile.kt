package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait PrivacyProfile : org.kevoree.modeling.api.KMFContainer {
public open var generated_KMF_ID : String?
open var privacyRules : List<lu.snt.serval.pla.framework.PrivacyACRule>
fun addPrivacyRules(privacyRules : lu.snt.serval.pla.framework.PrivacyACRule)
fun addAllPrivacyRules(privacyRules :List<lu.snt.serval.pla.framework.PrivacyACRule>)
fun removePrivacyRules(privacyRules : lu.snt.serval.pla.framework.PrivacyACRule)
fun removeAllPrivacyRules()
fun findPrivacyRulesByID(key : String?) : lu.snt.serval.pla.framework.PrivacyACRule?
open var userProfile : lu.snt.serval.pla.framework.UserProfile?
}
