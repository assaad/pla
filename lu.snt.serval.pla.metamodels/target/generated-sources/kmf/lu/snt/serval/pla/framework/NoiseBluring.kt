package lu.snt.serval.pla.framework

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
trait NoiseBluring : org.kevoree.modeling.api.KMFContainer , lu.snt.serval.pla.framework.ValueBluring {
public open var variance : Double?
public open var TypeOfNoise : String?
}
