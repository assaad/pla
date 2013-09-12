package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class AnswerPrivacyProfileImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.AnswerPrivacyProfile { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
queryRequest = null
dataType = null
timeBluring = null
valueBluring = null
relatedPrivacyProfile = null
relatedPrivacyRule = null
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

public override var cloakingAlgorithm : String? = null
	 set(iP : String?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != cloakingAlgorithm){
$cloakingAlgorithm = iP
}
	}//end of setter

override var queryRequest:lu.snt.serval.pla.framework.QueryRequest?=null
	 set(queryRequestP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_queryRequest(queryRequestP, true, true)
}
fun internal_queryRequest(queryRequestP : lu.snt.serval.pla.framework.QueryRequest?, setOpposite : Boolean, fireEvents : Boolean ) {
if($queryRequest!= queryRequestP){
$queryRequest = queryRequestP
}
}

override var dataType:lu.snt.serval.pla.framework.DataType?=null
	 set(dataTypeP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_dataType(dataTypeP, true, true)
}
fun internal_dataType(dataTypeP : lu.snt.serval.pla.framework.DataType?, setOpposite : Boolean, fireEvents : Boolean ) {
if($dataType!= dataTypeP){
$dataType = dataTypeP
}
}

override var timeBluring:lu.snt.serval.pla.framework.TimeBluring?=null
	 set(timeBluringP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_timeBluring(timeBluringP, true, true)
}
fun internal_timeBluring(timeBluringP : lu.snt.serval.pla.framework.TimeBluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($timeBluring!= timeBluringP){
$timeBluring = timeBluringP
}
}

override var valueBluring:lu.snt.serval.pla.framework.ValueBluring?=null
	 set(valueBluringP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_valueBluring(valueBluringP, true, true)
}
fun internal_valueBluring(valueBluringP : lu.snt.serval.pla.framework.ValueBluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($valueBluring!= valueBluringP){
$valueBluring = valueBluringP
}
}

override var relatedPrivacyProfile:lu.snt.serval.pla.framework.PrivacyProfile?=null
	 set(relatedPrivacyProfileP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_relatedPrivacyProfile(relatedPrivacyProfileP, true, true)
}
fun internal_relatedPrivacyProfile(relatedPrivacyProfileP : lu.snt.serval.pla.framework.PrivacyProfile?, setOpposite : Boolean, fireEvents : Boolean ) {
if($relatedPrivacyProfile!= relatedPrivacyProfileP){
$relatedPrivacyProfile = relatedPrivacyProfileP
}
}

override var relatedPrivacyRule:lu.snt.serval.pla.framework.PrivacyACRule?=null
	 set(relatedPrivacyRuleP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_relatedPrivacyRule(relatedPrivacyRuleP, true, true)
}
fun internal_relatedPrivacyRule(relatedPrivacyRuleP : lu.snt.serval.pla.framework.PrivacyACRule?, setOpposite : Boolean, fireEvents : Boolean ) {
if($relatedPrivacyRule!= relatedPrivacyRuleP){
$relatedPrivacyRule = relatedPrivacyRuleP
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_cloakingAlgorithm -> {
this.cloakingAlgorithm = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Ref_queryRequest -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.queryRequest = (value as? lu.snt.serval.pla.framework.QueryRequest)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.queryRequest = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.queryRequest = (value as? lu.snt.serval.pla.framework.QueryRequest)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_dataType -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.dataType = (value as? lu.snt.serval.pla.framework.DataType)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.dataType = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.dataType = (value as? lu.snt.serval.pla.framework.DataType)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_timeBluring -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.timeBluring = (value as? lu.snt.serval.pla.framework.TimeBluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.timeBluring = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.timeBluring = (value as? lu.snt.serval.pla.framework.TimeBluring)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_valueBluring -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.valueBluring = (value as? lu.snt.serval.pla.framework.ValueBluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.valueBluring = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.valueBluring = (value as? lu.snt.serval.pla.framework.ValueBluring)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyProfile -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.relatedPrivacyProfile = (value as? lu.snt.serval.pla.framework.PrivacyProfile)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.relatedPrivacyProfile = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.relatedPrivacyProfile = (value as? lu.snt.serval.pla.framework.PrivacyProfile)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyRule -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.relatedPrivacyRule = (value as? lu.snt.serval.pla.framework.PrivacyACRule)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.relatedPrivacyRule = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.relatedPrivacyRule = (value as? lu.snt.serval.pla.framework.PrivacyACRule)
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
lu.snt.serval.kmf.util.Constants.Ref_queryRequest -> {
val objFound = queryRequest
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_dataType -> {
val objFound = dataType
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_timeBluring -> {
val objFound = timeBluring
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_valueBluring -> {
val objFound = valueBluring
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyProfile -> {
val objFound = relatedPrivacyProfile
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyRule -> {
val objFound = relatedPrivacyRule
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
                                                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queryRequest, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryRequest)
                                                    internal_visit(visitor,queryRequest,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_queryRequest)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queryRequest)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_dataType, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_DataType)
                                                    internal_visit(visitor,dataType,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_dataType)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_dataType)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_timeBluring, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_TimeBluring)
                                                    internal_visit(visitor,timeBluring,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_timeBluring)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_timeBluring)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_valueBluring, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_ValueBluring)
                                                    internal_visit(visitor,valueBluring,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_valueBluring)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_valueBluring)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyProfile, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyProfile)
                                                    internal_visit(visitor,relatedPrivacyProfile,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyProfile)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyProfile)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyRule, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyACRule)
                                                    internal_visit(visitor,relatedPrivacyRule,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyRule)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_relatedPrivacyRule)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
            visitor.visit(cloakingAlgorithm,lu.snt.serval.kmf.util.Constants.Att_cloakingAlgorithm,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_AnswerPrivacyProfile;
}
}
