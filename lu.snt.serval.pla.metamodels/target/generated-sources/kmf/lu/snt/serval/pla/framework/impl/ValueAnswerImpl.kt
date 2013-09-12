package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class ValueAnswerImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.ValueAnswer { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
queryRequest = null
resultedTimeBluring = null
ResultedValueBluring = null
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

public override var dateTime : java.util.Date? = null
	 set(iP : java.util.Date?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != dateTime){
$dateTime = iP
}
	}//end of setter

public override var value : Double? = null
	 set(iP : Double?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != value){
$value = iP
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

override var resultedTimeBluring:lu.snt.serval.pla.framework.TimeBluring?=null
	 set(resultedTimeBluringP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_resultedTimeBluring(resultedTimeBluringP, true, true)
}
fun internal_resultedTimeBluring(resultedTimeBluringP : lu.snt.serval.pla.framework.TimeBluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($resultedTimeBluring!= resultedTimeBluringP){
$resultedTimeBluring = resultedTimeBluringP
}
}

override var ResultedValueBluring:lu.snt.serval.pla.framework.ValueBluring?=null
	 set(ResultedValueBluringP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_ResultedValueBluring(ResultedValueBluringP, true, true)
}
fun internal_ResultedValueBluring(ResultedValueBluringP : lu.snt.serval.pla.framework.ValueBluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($ResultedValueBluring!= ResultedValueBluringP){
$ResultedValueBluring = ResultedValueBluringP
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_dateTime -> {
this.dateTime = (value as? java.util.Date)
}
lu.snt.serval.kmf.util.Constants.Att_value -> {
this.value = (value.toString().toDouble())
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
lu.snt.serval.kmf.util.Constants.Ref_resultedTimeBluring -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.resultedTimeBluring = (value as? lu.snt.serval.pla.framework.TimeBluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.resultedTimeBluring = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.resultedTimeBluring = (value as? lu.snt.serval.pla.framework.TimeBluring)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_ResultedValueBluring -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.ResultedValueBluring = (value as? lu.snt.serval.pla.framework.ValueBluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.ResultedValueBluring = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.ResultedValueBluring = (value as? lu.snt.serval.pla.framework.ValueBluring)
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
lu.snt.serval.kmf.util.Constants.Ref_resultedTimeBluring -> {
val objFound = resultedTimeBluring
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_ResultedValueBluring -> {
val objFound = ResultedValueBluring
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
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_resultedTimeBluring, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_TimeBluring)
                                                    internal_visit(visitor,resultedTimeBluring,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_resultedTimeBluring)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_resultedTimeBluring)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_ResultedValueBluring, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_ValueBluring)
                                                    internal_visit(visitor,ResultedValueBluring,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_ResultedValueBluring)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_ResultedValueBluring)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(dateTime,lu.snt.serval.kmf.util.Constants.Att_dateTime,this)
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
            visitor.visit(value,lu.snt.serval.kmf.util.Constants.Att_value,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_ValueAnswer;
}
}
