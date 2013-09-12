package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class TimeAveragingImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.TimeAveraging { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
EReference0 = null
}
public override var generated_KMF_ID : String? = ""+hashCode() + java.util.Date().getTime()
	 set(iP : String?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != generated_KMF_ID){
val oldId = internalGetKey()
val previousParent = eContainer();
val previousRefNameInParent = getRefInParent();
$generated_KMF_ID = iP
if(previousParent!=null){
previousParent.reflexiveMutator(org.kevoree.modeling.api.util.ActionType.RENEW_INDEX, previousRefNameInParent!!, oldId,false,false);
}
}
	}//end of setter

public override var duration : Double? = null
	 set(iP : Double?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != duration){
$duration = iP
}
	}//end of setter

override var EReference0:lu.snt.serval.pla.framework.Bluring?=null
	 set(EReference0P){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_EReference0(EReference0P, true, true)
}
fun internal_EReference0(EReference0P : lu.snt.serval.pla.framework.Bluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($EReference0!= EReference0P){
$EReference0 = EReference0P
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_duration -> {
this.duration = (value.toString().toDouble())
}
lu.snt.serval.kmf.util.Constants.Ref_EReference0 -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.EReference0 = (value as? lu.snt.serval.pla.framework.Bluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.EReference0 = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.EReference0 = (value as? lu.snt.serval.pla.framework.Bluring)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
    else -> { throw Exception("Can reflexively "+mutationType+" for "+refName + " on "+ this) }
}
}
override fun internalGetKey() : String? {
return  generated_KMF_ID
}
override fun findByID(relationName:String,idP : String) : org.kevoree.modeling.api.KMFContainer? {when(relationName) {
lu.snt.serval.kmf.util.Constants.Ref_EReference0 -> {
val objFound = EReference0
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
else -> {return null}
}
}





override fun visit(visitor : org.kevoree.modeling.api.util.ModelVisitor, recursive : Boolean, containedReference : Boolean,nonContainedReference : Boolean){
            visitor.beginVisitElem(this)
                                                                                                           if(nonContainedReference){
                                                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_EReference0, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_Bluring)
                                                    internal_visit(visitor,EReference0,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_EReference0)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_EReference0)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(duration,lu.snt.serval.kmf.util.Constants.Att_duration,this)
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_TimeAveraging;
}
}
