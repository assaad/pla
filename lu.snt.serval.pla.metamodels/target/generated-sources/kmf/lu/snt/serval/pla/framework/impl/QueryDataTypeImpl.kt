package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class QueryDataTypeImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.QueryDataType { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
queriedDataType = null
requestedTimeBluring = null
requestedValueBluring = null
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

public override var location : String? = null
	 set(iP : String?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != location){
$location = iP
}
	}//end of setter

public override var name : String? = null
	 set(iP : String?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != name){
$name = iP
}
	}//end of setter

public override var dateTime : java.util.Date? = null
	 set(iP : java.util.Date?){
if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
if(iP != dateTime){
$dateTime = iP
}
	}//end of setter

override var queriedDataType:lu.snt.serval.pla.framework.DataType?=null
	 set(queriedDataTypeP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_queriedDataType(queriedDataTypeP, true, true)
}
fun internal_queriedDataType(queriedDataTypeP : lu.snt.serval.pla.framework.DataType?, setOpposite : Boolean, fireEvents : Boolean ) {
if($queriedDataType!= queriedDataTypeP){
$queriedDataType = queriedDataTypeP
}
}

override var requestedTimeBluring:lu.snt.serval.pla.framework.TimeBluring?=null
	 set(requestedTimeBluringP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_requestedTimeBluring(requestedTimeBluringP, true, true)
}
fun internal_requestedTimeBluring(requestedTimeBluringP : lu.snt.serval.pla.framework.TimeBluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($requestedTimeBluring!= requestedTimeBluringP){
$requestedTimeBluring = requestedTimeBluringP
}
}

override var requestedValueBluring:lu.snt.serval.pla.framework.ValueBluring?=null
	 set(requestedValueBluringP){if(isReadOnly()){throw Exception(lu.snt.serval.kmf.util.Constants.READ_ONLY_EXCEPTION)}
internal_requestedValueBluring(requestedValueBluringP, true, true)
}
fun internal_requestedValueBluring(requestedValueBluringP : lu.snt.serval.pla.framework.ValueBluring?, setOpposite : Boolean, fireEvents : Boolean ) {
if($requestedValueBluring!= requestedValueBluringP){
$requestedValueBluring = requestedValueBluringP
}
}

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_location -> {
this.location = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_name -> {
this.name = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_dateTime -> {
this.dateTime = (value as? java.util.Date)
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
lu.snt.serval.kmf.util.Constants.Ref_requestedTimeBluring -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.requestedTimeBluring = (value as? lu.snt.serval.pla.framework.TimeBluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.requestedTimeBluring = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.requestedTimeBluring = (value as? lu.snt.serval.pla.framework.TimeBluring)
}
org.kevoree.modeling.api.util.ActionType.RENEW_INDEX -> {
}
else -> {throw Exception(lu.snt.serval.kmf.util.Constants.UNKNOWN_MUTATION_TYPE_EXCEPTION + mutationType)}
}
}
lu.snt.serval.kmf.util.Constants.Ref_requestedValueBluring -> {
when(mutationType) {
org.kevoree.modeling.api.util.ActionType.SET -> {
      this.requestedValueBluring = (value as? lu.snt.serval.pla.framework.ValueBluring)
}
org.kevoree.modeling.api.util.ActionType.REMOVE -> {
      this.requestedValueBluring = null
}
org.kevoree.modeling.api.util.ActionType.ADD -> {
      this.requestedValueBluring = (value as? lu.snt.serval.pla.framework.ValueBluring)
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
lu.snt.serval.kmf.util.Constants.Ref_requestedTimeBluring -> {
val objFound = requestedTimeBluring
if(objFound!=null && (objFound as lu.snt.serval.kmf.container.KMFContainerImpl).internalGetKey() == idP){
return objFound
}else{return null}
}
lu.snt.serval.kmf.util.Constants.Ref_requestedValueBluring -> {
val objFound = requestedValueBluring
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
                                                                            visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queriedDataType, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_DataType)
                                                    internal_visit(visitor,queriedDataType,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_queriedDataType)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_queriedDataType)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_requestedTimeBluring, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_TimeBluring)
                                                    internal_visit(visitor,requestedTimeBluring,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_requestedTimeBluring)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_requestedTimeBluring)
                                                                                                        visitor.beginVisitRef(lu.snt.serval.kmf.util.Constants.Ref_requestedValueBluring, lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_ValueBluring)
                                                    internal_visit(visitor,requestedValueBluring,recursive,containedReference,nonContainedReference,lu.snt.serval.kmf.util.Constants.Ref_requestedValueBluring)
                                                visitor.endVisitRef(lu.snt.serval.kmf.util.Constants.Ref_requestedValueBluring)
                                                          }
                      visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(dateTime,lu.snt.serval.kmf.util.Constants.Att_dateTime,this)
            visitor.visit(location,lu.snt.serval.kmf.util.Constants.Att_location,this)
            visitor.visit(name,lu.snt.serval.kmf.util.Constants.Att_name,this)
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryDataType;
}
}
