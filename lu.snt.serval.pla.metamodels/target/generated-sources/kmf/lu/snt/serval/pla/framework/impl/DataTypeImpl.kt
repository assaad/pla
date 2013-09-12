package lu.snt.serval.pla.framework.impl

/**
 * Created by Kevoree Model Generator(KMF).
 * @developers: Gregory Nain, Fouquet Francois
 * Date: 12 sept. 13 Time: 16:11
 * Meta-Model:NS_URI=http://framework
 */
class DataTypeImpl : lu.snt.serval.kmf.container.KMFContainerImpl, lu.snt.serval.pla.framework.DataType { 
override internal var internal_eContainer : org.kevoree.modeling.api.KMFContainer? = null
override internal var internal_containmentRefName : String? = null
override internal var internal_unsetCmd : lu.snt.serval.kmf.container.RemoveFromContainerCommand? = null
override internal var internal_readOnlyElem : Boolean = false
override internal var internal_recursive_readOnlyElem : Boolean = false
override var path_cache : String? = lu.snt.serval.kmf.util.Constants.STRING_DEFAULTVAL
override fun delete(){
}
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

override fun reflexiveMutator(mutationType : Int, refName : String, value : Any?, setOpposite : Boolean, fireEvents : Boolean) {
when(refName) {
lu.snt.serval.kmf.util.Constants.Att_location -> {
this.location = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_name -> {
this.name = (value as? String)
}
lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID -> {
this.generated_KMF_ID = (value as? String)
}
    else -> { throw Exception("Can reflexively "+mutationType+" for "+refName + " on "+ this) }
}
}
override fun internalGetKey() : String? {
return  generated_KMF_ID
}
override fun findByID(relationName:String,idP : String) : org.kevoree.modeling.api.KMFContainer? {when(relationName) {
else -> {return null}
}
}





override fun visit(visitor : org.kevoree.modeling.api.util.ModelVisitor, recursive : Boolean, containedReference : Boolean,nonContainedReference : Boolean){
            visitor.beginVisitElem(this)
                                                                          visitor.endVisitElem(this)
}

override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){
            visitor.visit(location,lu.snt.serval.kmf.util.Constants.Att_location,this)
            visitor.visit(generated_KMF_ID,lu.snt.serval.kmf.util.Constants.Att_generated_KMF_ID,this)
            visitor.visit(name,lu.snt.serval.kmf.util.Constants.Att_name,this)
    }
override fun metaClassName() : String {
return lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_DataType;
}
}
