package lu.snt.serval.kmf.factory
object Package {
 public val LU_SNT_SERVAL_PLA_FRAMEWORK : Int = 0
fun getPackageForName(metaClassName : String) : Int {
 if(metaClassName.startsWith("lu.snt.serval.pla.framework")){return 0}
return -1
}
}
