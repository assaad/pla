





package lu.snt.serval.kmf.cloner

class DefaultModelCloner() : org.kevoree.modeling.api.ModelCloner {

override fun createContext(): MutableMap<org.kevoree.modeling.api.KMFContainer, org.kevoree.modeling.api.KMFContainer> {
                return java.util.IdentityHashMap<org.kevoree.modeling.api.KMFContainer,org.kevoree.modeling.api.KMFContainer>()
            }

    override var mainFactory : org.kevoree.modeling.api.KMFFactory = lu.snt.serval.kmf.factory.MainFactory()

}
