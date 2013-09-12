package lu.snt.serval.kmf.factory
class MainFactory : org.kevoree.modeling.api.KMFFactory {

private var factories : Array<org.kevoree.modeling.api.KMFFactory?> = Array<org.kevoree.modeling.api.KMFFactory?>(1, {i -> null});

{
factories.set(Package.LU_SNT_SERVAL_PLA_FRAMEWORK, lu.snt.serval.pla.framework.impl.DefaultFrameworkFactory())
}
fun getFactoryForPackage( pack : Int) : org.kevoree.modeling.api.KMFFactory? {
return factories.get(pack)
}
fun getFrameworkFactory() : lu.snt.serval.pla.framework.FrameworkFactory {
return factories.get(Package.LU_SNT_SERVAL_PLA_FRAMEWORK) as lu.snt.serval.pla.framework.FrameworkFactory
}

fun setFrameworkFactory( fct : lu.snt.serval.pla.framework.FrameworkFactory) {
factories.set(Package.LU_SNT_SERVAL_PLA_FRAMEWORK,fct)
}


override fun create(metaClassName : String) : org.kevoree.modeling.api.KMFContainer? {
val pack = Package.getPackageForName(metaClassName)
    if(pack != -1) {
        return getFactoryForPackage(pack)?.create(metaClassName)
    } else {
        for(i in factories.indices) {
            val obj = factories[i]!!.create(metaClassName)
            if(obj != null) {
                return obj;
            }
        }
        return null
    }
}
}
