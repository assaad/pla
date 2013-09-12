package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class QueryImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.Query { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
userProfile = null
_queryRequests?.clear()
_answers?.clear()
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
if($userProfile != null){
($userProfile!! as lu.snt.serval.kmf.container.KMFContainerImpl ).setEContainer(null, null,null)
}
if(userProfileP!=null){
(userProfileP as lu.snt.serval.kmf.container.KMFContainerImpl ).setEContainer(this,null,lu.snt.serval.kmf.util.Constants.Ref_userProfile)
}
$userProfile = userProfileP
}
}

internal val _queryRequests : java.util.HashMap<String,lu.snt.serval.pla.framework.QueryRequest> = java.util.HashMap<String,lu.snt.serval.pla.framework.QueryRequest>()
override var queryRequests:List<lu.snt.serval.pla.framework.QueryRequest>
	  get(){
		  return _queryRequests.values().toList()
	  }
	 set(queryRequestsP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(queryRequestsP == null){ throw IllegalArgumentException(lu.snt.serval.kmf.util.Constants.LIST_PARAMETER_OF_SET_IS_NULL_EXCEPTION) }
internal_queryRequests(queryRequestsP, true, true)
}
fun internal_queryRequests(queryRequestsP : List<lu.snt.serval.pla.framework.QueryRequest>, setOpposite : Boolean, fireEvents : Boolean ) {
if(_queryRequests.values()!= queryRequestsP){
_queryRequests.clear()
for(el in queryRequestsP){
val elKey = (el as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()
if(elKey == null){throw Exception(lu.snt.serval.kmf.util.Constants.ELEMENT_HAS_NO_KEY_IN_COLLECTION)}
_queryRequests.put(elKey!!,el)
(el as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(this,lu.snt.serval.kmf.container.RemoveFromContainerCommand(this, org.kevoree.modeling.api.util.ActionType.REMOVE, lu.snt.serval.kmf.util.Constants.Ref_queryRequests, el),lu.snt.serval.kmf.util.Constants.Ref_queryRequests)
}
}
}


private fun doAddQueryRequests(queryRequestsP : lu.snt.serval.pla.framework.QueryRequest) {
val _key_ = (queryRequestsP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()
if(_key_ == "" || _key_ == null){ throw Exception(lu.snt.serval.kmf.util.Constants.EMPTY_KEY) }
if(!_queryRequests.containsKey(_key_)) {
_queryRequests.put(_key_,queryRequestsP)
(queryRequestsP as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(this,lu.snt.serval.kmf.container.RemoveFromContainerCommand(this, org.kevoree.modeling.api.util.ActionType.REMOVE, lu.snt.serval.kmf.util.Constants.Ref_queryRequests, queryRequestsP),lu.snt.serval.kmf.util.Constants.Ref_queryRequests)
}
}

override fun addQueryRequests(queryRequestsP : lu.snt.serval.pla.framework.QueryRequest) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
doAddQueryRequests(queryRequestsP)
}

override fun addAllQueryRequests(queryRequestsP :List<lu.snt.serval.pla.framework.QueryRequest>) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
for(el in queryRequestsP){
doAddQueryRequests(el)
}
}


override fun removeQueryRequests(queryRequestsP : lu.snt.serval.pla.framework.QueryRequest) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(_queryRequests.size() != 0 && _queryRequests.containsKey((queryRequestsP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey())) {
_queryRequests.remove((queryRequestsP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey())
(queryRequestsP!! as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(null,null,null)
}
}

override fun removeAllQueryRequests() {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
val temp_els = queryRequests!!
for(el in temp_els!!){
(el as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(null,null,null)
}
_queryRequests.clear()
}

internal val _answers : java.util.HashMap<String,lu.snt.serval.pla.framework.Answer> = java.util.HashMap<String,lu.snt.serval.pla.framework.Answer>()
override var answers:List<lu.snt.serval.pla.framework.Answer>
	  get(){
		  return _answers.values().toList()
	  }
	 set(answersP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(answersP == null){ throw IllegalArgumentException(lu.snt.serval.kmf.util.Constants.LIST_PARAMETER_OF_SET_IS_NULL_EXCEPTION) }
internal_answers(answersP, true, true)
}
fun internal_answers(answersP : List<lu.snt.serval.pla.framework.Answer>, setOpposite : Boolean, fireEvents : Boolean ) {
if(_answers.values()!= answersP){
_answers.clear()
for(el in answersP){
val elKey = (el as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()
if(elKey == null){throw Exception(lu.snt.serval.kmf.util.Constants.ELEMENT_HAS_NO_KEY_IN_COLLECTION)}
_answers.put(elKey!!,el)
(el as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(this,lu.snt.serval.kmf.container.RemoveFromContainerCommand(this, org.kevoree.modeling.api.util.ActionType.REMOVE, lu.snt.serval.kmf.util.Constants.Ref_answers, el),lu.snt.serval.kmf.util.Constants.Ref_answers)
}
}
}


private fun doAddAnswers(answersP : lu.snt.serval.pla.framework.Answer) {
val _key_ = (answersP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()
if(_key_ == "" || _key_ == null){ throw Exception(lu.snt.serval.kmf.util.Constants.EMPTY_KEY) }
if(!_answers.containsKey(_key_)) {
_answers.put(_key_,answersP)
(answersP as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(this,lu.snt.serval.kmf.container.RemoveFromContainerCommand(this, org.kevoree.modeling.api.util.ActionType.REMOVE, lu.snt.serval.kmf.util.Constants.Ref_answers, answersP),lu.snt.serval.kmf.util.Constants.Ref_answers)
}
}

override fun addAnswers(answersP : lu.snt.serval.pla.framework.Answer) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
doAddAnswers(answersP)
}

override fun addAllAnswers(answersP :List<lu.snt.serval.pla.framework.Answer>) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
for(el in answersP){
doAddAnswers(el)
}
}


override fun removeAnswers(answersP : lu.snt.serval.pla.framework.Answer) {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(_answers.size() != 0 && _answers.containsKey((answersP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey())) {
_answers.remove((answersP as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey())
(answersP!! as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(null,null,null)
}
}

override fun removeAllAnswers() {
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
val temp_els = answers!!
for(el in temp_els!!){
(el as lu.snt.serval.kmf.container.KMFContainerImpl).setEContainer(null,null,null)
}
_answers.clear()
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
lu.snt.serval.kmf.util.Constants.Ref_queryRequests -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.ADD -> {
this.addQueryRequests(value as lu.snt.serval.pla.framework.QueryRequest)
}
org.kevoree.modeling.api.util.ActionType.ADD_ALL -> {
this.addAllQueryRequests(value as List<lu.snt.serval.pla.framework.QueryRequest>)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
        this.removeQueryRequests(value as lu.snt.serval.pla.framework.QueryRequest)
}
org.kevoree.modeling.api.util.ActionType.REMOVE_ALL -> {
        this.removeAllQueryRequests()
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
if(_queryRequests.size() != 0 && _queryRequests.containsKey(value)) {
val obj = _queryRequests.get(value)
val objNewKey = (obj as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()

if(objNewKey == null){throw Exception("Key newed to null "+obj)}

_queryRequests.remove(value)
_queryRequests.put(objNewKey,obj)
}
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_answers -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.ADD -> {
this.addAnswers(value as lu.snt.serval.pla.framework.Answer)
}
org.kevoree.modeling.api.util.ActionType.ADD_ALL -> {
this.addAllAnswers(value as List<lu.snt.serval.pla.framework.Answer>)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
        this.removeAnswers(value as lu.snt.serval.pla.framework.Answer)
}
org.kevoree.modeling.api.util.ActionType.REMOVE_ALL -> {
        this.removeAllAnswers()
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
if(_answers.size() != 0 && _answers.containsKey(value)) {
val obj = _answers.get(value)
val objNewKey = (obj as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey()

if(objNewKey == null){throw Exception("Key newed to null "+obj)}

_answers.remove(value)
_answers.put(objNewKey,obj)
}
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
override fun findQueryRequestsByID(key : String?) : lu.snt.serval.pla.framework.QueryRequest? {
return _queryRequests.get(key)
}
override fun findAnswersByID(key : String?) : lu.snt.serval.pla.framework.Answer? {
return _answers.get(key)
}
override fun findByID(relationName:String,idP : String) : org.kevoree.modeling.api.KMFContainer? {when(relationName) {
lu.snt.serval.kmf.util.Constants.Ref_userProfile -> {
val objFound = userProfile
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_queryRequests -> {
return findQueryRequestsByID(idP)}
lu.snt.serval.kmf.util.Constants.Ref_answers -> {
return findAnswersByID(idP)}
else -> {return null}
}
}





override fun visit(visitor : org.kevoree.modeling.api.util.ModelVisitor, recursive : Boolean, containedReference : Boolean,nonContainedReference : Boolean){
            visitor.beginVisitElem(this)
                                                    if(containedReference){
                                                    visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_userProfile, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_UserProfile)
                                    internal_visit(visitor,userProfile,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_userProfile)
                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_userProfile)
                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queryRequests, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryRequest)
                                    for(KMFLoopEntryKey in _queryRequests.keySet()){
                        internal_visit(visitor,_queryRequests.get(KMFLoopEntryKey),recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_queryRequests)
                    }
                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queryRequests)
                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_answers, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_Answer)
                                    for(KMFLoopEntryKey in _answers.keySet()){
                        internal_visit(visitor,_answers.get(KMFLoopEntryKey),recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_answers)
                    }
                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_answers)
                                    }
                                                                                                                                                              visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_Query;
}
}
