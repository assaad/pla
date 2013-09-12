package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class QueryCloakerImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.QueryCloaker { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
queriedDataType = null
privacyPr = null
privacyRule = null
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

override var queriedDataType:lu.snt.serval.pla.framework.QueryDataType?=null
	 set(queriedDataTypeP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_queriedDataType(queriedDataTypeP, true, true)
}
fun internal_queriedDataType(queriedDataTypeP : lu.snt.serval.pla.framework.QueryDataType?, setOpposite : Boolean, fireEvents : Boolean ) {
if($queriedDataType!= queriedDataTypeP){
$queriedDataType = queriedDataTypeP
}
}

override var privacyPr:lu.snt.serval.pla.framework.AnswerPrivacyProfile?=null
	 set(privacyPrP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_privacyPr(privacyPrP, true, true)
}
fun internal_privacyPr(privacyPrP : lu.snt.serval.pla.framework.AnswerPrivacyProfile?, setOpposite : Boolean, fireEvents : Boolean ) {
if($privacyPr!= privacyPrP){
$privacyPr = privacyPrP
}
}

override var privacyRule:lu.snt.serval.pla.framework.PrivacyACRule?=null
	 set(privacyRuleP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_privacyRule(privacyRuleP, true, true)
}
fun internal_privacyRule(privacyRuleP : lu.snt.serval.pla.framework.PrivacyACRule?, setOpposite : Boolean, fireEvents : Boolean ) {
if($privacyRule!= privacyRuleP){
$privacyRule = privacyRuleP
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Ref_queriedDataType -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.queriedDataType = (value as? lu.snt.serval.pla.framework.QueryDataType)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.queriedDataType = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.queriedDataType = (value as? lu.snt.serval.pla.framework.QueryDataType)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_privacyPr -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.privacyPr = (value as? lu.snt.serval.pla.framework.AnswerPrivacyProfile)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.privacyPr = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.privacyPr = (value as? lu.snt.serval.pla.framework.AnswerPrivacyProfile)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_privacyRule -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.privacyRule = (value as? lu.snt.serval.pla.framework.PrivacyACRule)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.privacyRule = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.privacyRule = (value as? lu.snt.serval.pla.framework.PrivacyACRule)
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
lu.snt.serval.kmf.util.Constants.Ref_queriedDataType -> {
val objFound = queriedDataType
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_privacyPr -> {
val objFound = privacyPr
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_privacyRule -> {
val objFound = privacyRule
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
                                                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queriedDataType, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryDataType)
                                                    internal_visit(visitor,queriedDataType,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_queriedDataType)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queriedDataType)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_privacyPr, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_AnswerPrivacyProfile)
                                                    internal_visit(visitor,privacyPr,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_privacyPr)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_privacyPr)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_privacyRule, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyACRule)
                                                    internal_visit(visitor,privacyRule,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_privacyRule)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_privacyRule)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryCloaker;
}
}
