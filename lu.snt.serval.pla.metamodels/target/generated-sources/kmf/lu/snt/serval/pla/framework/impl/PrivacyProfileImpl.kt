package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class PrivacyProfileImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.PrivacyProfile { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
_privacyRules?.clear()
userProfile = null
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

internal val _privacyRules : java.util.HashMap<String,lu.snt.serval.pla.framework.PrivacyACRule> = java.util.HashMap<String,lu.snt.serval.pla.framework.PrivacyACRule>()
override var privacyRules:List<lu.snt.serval.pla.framework.PrivacyACRule>
	  get(){
		  return _privacyRules.values().toList()
	  }
	 set(privacyRulesP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(privacyRulesP == null){ throw IllegalArgumentException(lu.snt.serval.kmf.util.Constants.LIST_PARAMETER_OF_SET_IS_NULL_EXCEPTION) }
internal_privacyRules(privacyRulesP, true, true)
}
fun internal_privacyRules(privacyRulesP : List<lu.snt.serval.pla.framework.PrivacyACRule>, setOpposite : Boolean, fireEvents : Boolean ) {
if(_privacyRules.values()!= privacyRulesP){
_privacyRules.clear()
for(el in privacyRulesP){
val elKey = (el as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()
if(elKey == null){throw Exception(lu.snt.serval.kmf.util.Constants.ELEMENT_HAS_NO_KEY_IN_COLLECTION)}
_privacyRules.put(elKey!!,el)
(el as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(this,lu.snt.serval.kmf.container.RemoveFromContainerCommand(this, org.kevoree.modeling.api.util.ActionType.REMOVE, lu.snt.serval.kmf.util.Constants.Ref_privacyRules, el),lu.snt.serval.kmf.util.Constants.Ref_privacyRules)
}
}
}


private fun doAddPrivacyRules(privacyRulesP : lu.snt.serval.pla.framework.PrivacyACRule) {
val _key_ = (privacyRulesP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()
if(_key_ == "" || _key_ == null){ throw Exception(lu.snt.serval.kmf.util.Constants.EMPTY_KEY) }
if(!_privacyRules.containsKey(_key_)) {
_privacyRules.put(_key_,privacyRulesP)
(privacyRulesP as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(this,lu.snt.serval.kmf.container.RemoveFromContainerCommand(this, org.kevoree.modeling.api.util.ActionType.REMOVE, lu.snt.serval.kmf.util.Constants.Ref_privacyRules, privacyRulesP),lu.snt.serval.kmf.util.Constants.Ref_privacyRules)
}
}

override fun addPrivacyRules(privacyRulesP : lu.snt.serval.pla.framework.PrivacyACRule) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
doAddPrivacyRules(privacyRulesP)
}

override fun addAllPrivacyRules(privacyRulesP :List<lu.snt.serval.pla.framework.PrivacyACRule>) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
for(el in privacyRulesP){
doAddPrivacyRules(el)
}
}


override fun removePrivacyRules(privacyRulesP : lu.snt.serval.pla.framework.PrivacyACRule) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(_privacyRules.size() != 0 && _privacyRules.containsKey((privacyRulesP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey())) {
_privacyRules.remove((privacyRulesP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey())
(privacyRulesP!! as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(null,null,null)
}
}

override fun removeAllPrivacyRules() {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
val temp_els = privacyRules!!
for(el in temp_els!!){
(el as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(null,null,null)
}
_privacyRules.clear()
}

override var userProfile:lu.snt.serval.pla.framework.UserProfile?=null
	 set(userProfileP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_userProfile(userProfileP, true, true)
}
fun internal_userProfile(userProfileP : lu.snt.serval.pla.framework.UserProfile?, setOpposite : Boolean, fireEvents : Boolean ) {
if($userProfile!= userProfileP){
$userProfile = userProfileP
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Ref_privacyRules -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.ADD -> {
this.addPrivacyRules(value as lu.snt.serval.pla.framework.PrivacyACRule)
}
org.kevoree.modeling.api.util.ActionType.ADD_ALL -> {
this.addAllPrivacyRules(value as List<lu.snt.serval.pla.framework.PrivacyACRule>)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
        this.removePrivacyRules(value as lu.snt.serval.pla.framework.PrivacyACRule)
}
org.kevoree.modeling.api.util.ActionType.REMOVE_ALL -> {
        this.removeAllPrivacyRules()
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
if(_privacyRules.size() != 0 && _privacyRules.containsKey(value)) {
val obj = _privacyRules.get(value)
val objNewKey = (obj as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()

if(objNewKey == null){throw Exception("Key newed to null "+obj)}

_privacyRules.remove(value)
_privacyRules.put(objNewKey,obj)
}
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
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
    else -> { throw Exception("Can reflexively "+mutationType+" for "+refName + " on "+ this) }
}
}
override fun internalGetKey() : String? {
return  generated_KMF_ID
}
override fun findPrivacyRulesByID(key : String?) : lu.snt.serval.pla.framework.PrivacyACRule? {
return _privacyRules.get(key)
}
override fun findByID(relationName:String,idP : String) : org.kevoree.modeling.api.KMFContainer? {when(relationName) {
lu.snt.serval.kmf.util.Constants.Ref_privacyRules -> {
return findPrivacyRulesByID(idP)}
lu.snt.serval.kmf.util.Constants.Ref_userProfile -> {
val objFound = userProfile
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
else -> {return null}
}
}





override fun visit(visitor : org.kevoree.modeling.api.util.ModelVisitor, recursive : Boolean, containedReference : Boolean,nonContainedReference : Boolean){
            visitor.beginVisitElem(this)
                                                    if(containedReference){
                                                    visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_privacyRules, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyACRule)
                                    for(KMFLoopEntryKey in _privacyRules.keySet()){
                        internal_visit(visitor,_privacyRules.get(KMFLoopEntryKey),recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_privacyRules)
                    }
                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_privacyRules)
                                    }
                                                                                                                       if(nonContainedReference){
                                                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_userProfile, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_UserProfile)
                                                    internal_visit(visitor,userProfile,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_userProfile)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_userProfile)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyProfile;
}
}
