package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class QueryPrivacyProfileImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.QueryPrivacyProfile { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
userProfile = null
queriedDataType = null
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

override var userProfile:lu.snt.serval.pla.framework.UserProfile?=null
	 set(userProfileP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_userProfile(userProfileP, true, true)
}
fun internal_userProfile(userProfileP : lu.snt.serval.pla.framework.UserProfile?, setOpposite : Boolean, fireEvents : Boolean ) {
if($userProfile!= userProfileP){
$userProfile = userProfileP
}
}

override var queriedDataType:lu.snt.serval.pla.framework.DataType?=null
	 set(queriedDataTypeP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_queriedDataType(queriedDataTypeP, true, true)
}
fun internal_queriedDataType(queriedDataTypeP : lu.snt.serval.pla.framework.DataType?, setOpposite : Boolean, fireEvents : Boolean ) {
if($queriedDataType!= queriedDataTypeP){
$queriedDataType = queriedDataTypeP
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Ref_userProfile -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.userProfile = (value as? lu.snt.serval.pla.framework.UserProfile)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.userProfile = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.userProfile = (value as? lu.snt.serval.pla.framework.UserProfile)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_queriedDataType -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.queriedDataType = (value as? lu.snt.serval.pla.framework.DataType)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.queriedDataType = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.queriedDataType = (value as? lu.snt.serval.pla.framework.DataType)
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
lu.snt.serval.kmf.util.Constants.Ref_userProfile -> {
val objFound = userProfile
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_queriedDataType -> {
val objFound = queriedDataType
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
                                                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_userProfile, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_UserProfile)
                                                    internal_visit(visitor,userProfile,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_userProfile)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_userProfile)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queriedDataType, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_DataType)
                                                    internal_visit(visitor,queriedDataType,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_queriedDataType)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queriedDataType)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryPrivacyProfile;
}
}
