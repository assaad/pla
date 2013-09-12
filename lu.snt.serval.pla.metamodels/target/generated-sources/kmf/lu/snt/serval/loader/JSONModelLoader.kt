package lu.snt.serval.kmf.loader
class JSONModelLoader : org.kevoree.modeling.api.json.JSONModelLoader() {
override var factory : org.kevoree.modeling.api.KMFFactory? = lu.snt.serval.kmf.factory.MainFactory()
}
