package lu.snt.serval.kmf.loader
class XMIModelLoader : org.kevoree.modeling.api.xmi.XMIModelLoader() {
override var factory : org.kevoree.modeling.api.KMFFactory? = lu.snt.serval.kmf.factory.MainFactory()
}
