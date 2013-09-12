package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait AnswerPrivacyProfile : org.kevoree.modeling.api.KMFContainer , lu.snt.serval.pla.framework.Answer , lu.snt.serval.pla.framework.PrivacyACRule {
open var relatedPrivacyProfile : lu.snt.serval.pla.framework.PrivacyProfile?
open var relatedPrivacyRule : lu.snt.serval.pla.framework.PrivacyACRule?
}
