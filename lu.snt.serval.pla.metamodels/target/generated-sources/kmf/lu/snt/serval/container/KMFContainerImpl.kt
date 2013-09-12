





package lu.snt.serval.kmf.container

trait KMFContainerImpl : org.kevoree.modeling.api.KMFContainer {

    internal open var internal_eContainer : org.kevoree.modeling.api.KMFContainer?
    internal open var internal_unsetCmd : RemoveFromContainerCommand?

    override fun eContainer() : org.kevoree.modeling.api.KMFContainer? { return internal_eContainer }
    internal open var internal_containmentRefName : String?
    internal open var internal_readOnlyElem : Boolean
    internal open var internal_recursive_readOnlyElem : Boolean

    override fun setRecursiveReadOnly(){
        if(internal_recursive_readOnlyElem == true){return}
        setInternalRecursiveReadOnly()
        val recVisitor = object : org.kevoree.modeling.api.util.ModelVisitor(){
            override fun visit(elem : org.kevoree.modeling.api.KMFContainer, refNameInParent : String, parent : org.kevoree.modeling.api.KMFContainer){
                if(elem.isRecursiveReadOnly()){
                    noChildrenVisit()
                }else {
                    (elem as KMFContainerImpl).setInternalRecursiveReadOnly()
                    elem.setInternalReadOnly()
                }
            }
        }
        visit(recVisitor,true,true,true)
        setInternalReadOnly()
    }

    override fun setInternalReadOnly(){
        internal_readOnlyElem = true
    }

    fun setInternalRecursiveReadOnly(){
        internal_recursive_readOnlyElem = true
    }

    override fun getRefInParent() : String? {
        return internal_containmentRefName
    }

    override fun isReadOnly() : Boolean {
        return internal_readOnlyElem
    }

    override fun isRecursiveReadOnly() : Boolean {
        return internal_recursive_readOnlyElem
    }

    fun internalGetKey() : String?

    fun setEContainer( container : org.kevoree.modeling.api.KMFContainer?, unsetCmd : RemoveFromContainerCommand?, refNameInParent : String? ) {

        path_cache = null

        if(internal_readOnlyElem){return}

        val tempUnsetCmd = internal_unsetCmd
        internal_unsetCmd = null
        if(tempUnsetCmd != null){
            tempUnsetCmd.run()
        }
        internal_eContainer = container
        internal_unsetCmd = unsetCmd

        internal_containmentRefName = refNameInParent

    }

    override fun selectByQuery(query : String) : List<Any> {
        throw Exception("Not activated, please add selector option in KMF generation plugin")
    }

    override fun addModelElementListener(lst : org.kevoree.modeling.api.events.ModelElementListener){
        throw Exception("Not activated, please add events option in KMF generation plugin")
    }
    override fun removeModelElementListener(lst : org.kevoree.modeling.api.events.ModelElementListener ){
        throw Exception("Not activated, please add events option in KMF generation plugin")
    }
    override fun removeAllModelElementListeners(){
        throw Exception("Not activated, please add events option in KMF generation plugin")
    }
    override fun addModelTreeListener(lst : org.kevoree.modeling.api.events.ModelElementListener){
        throw Exception("Not activated, please add events option in KMF generation plugin")
    }
    override fun removeModelTreeListener(lst : org.kevoree.modeling.api.events.ModelElementListener){
        throw Exception("Not activated, please add events option in KMF generation plugin")
    }
    override fun removeAllModelTreeListeners(){
        throw Exception("Not activated, please add events option in KMF generation plugin")
    }

    override fun visit(visitor : org.kevoree.modeling.api.util.ModelVisitor, recursive : Boolean, containedReference : Boolean,nonContainedReference : Boolean){}
    override fun visitAttributes(visitor : org.kevoree.modeling.api.util.ModelAttributeVisitor){}

    fun internal_visit(visitor : org.kevoree.modeling.api.util.ModelVisitor,internalElem : org.kevoree.modeling.api.KMFContainer?,recursive:Boolean,containedReference : Boolean,nonContainedReference : Boolean, refName : String){
        if(internalElem != null){
            if(nonContainedReference && recursive){
                var elemPath = internalElem.path()!!
                if(visitor.alreadyVisited != null && visitor.alreadyVisited!!.containsKey(elemPath)){return}
                if(visitor.alreadyVisited == null){
                    visitor.alreadyVisited = java.util.HashMap<String,org.kevoree.modeling.api.KMFContainer>()
                }
                visitor.alreadyVisited!!.put(elemPath,internalElem)
            }
            visitor.visit(internalElem,refName,this)
            if(!visitor.visitStopped){
                if(recursive && visitor.visitChildren){
                    internalElem.visit(visitor,recursive,containedReference,nonContainedReference)
                }
                visitor.visitChildren = true
            }
        }
    }

    var path_cache : String?

    override fun path(): String? {
        if(path_cache!=null){return path_cache}
        val container = eContainer()
        if(container != null) {
            val parentPath = container.path()
            if(parentPath == null){
                return null
            } else {
                path_cache = if(parentPath == ""){""}else{parentPath + "/"} + internal_containmentRefName + "[" + internalGetKey() + "]"
            }
        } else {
            path_cache =  ""
        }
        return path_cache;
    }

    override fun modelEquals(similarObj: org.kevoree.modeling.api.KMFContainer?): Boolean {
        if(similarObj == null){return false}
        if(this == similarObj){return true}//same Object
        if(similarObj.metaClassName()!=metaClassName()){return false}
        val values = java.util.HashMap<String,String?>()
        val attVisitor = object : org.kevoree.modeling.api.util.ModelAttributeVisitor {
            public override fun visit(value: Any?, name: String, parent: org.kevoree.modeling.api.KMFContainer){
                if(values.containsKey(name)){
                    if(values.get(name) == value?.toString()){
                        values.remove(name)
                    }
                } else {
                    values.put(name,value?.toString())
                }
            }
        }
        this.visitAttributes(attVisitor)
        similarObj.visitAttributes(attVisitor)
        if(!values.isEmpty()){return false}
        val payload = "";
        val refVisitor = object : org.kevoree.modeling.api.util.ModelVisitor() {
            public override fun visit(elem: org.kevoree.modeling.api.KMFContainer, refNameInParent: String, parent: org.kevoree.modeling.api.KMFContainer) {
                val concatedKey = refNameInParent+"_"+elem.path()
                if(values.containsKey(concatedKey)){
                    values.remove(concatedKey)
                } else {
                    values.put(concatedKey,payload)
                }
            }
        }
        this.visit(refVisitor,false,false,true)
        similarObj.visit(refVisitor,false,false,true)
        if(!values.isEmpty()){return false}
        return true
    }

    override fun deepModelEquals(similarObj: org.kevoree.modeling.api.KMFContainer?): Boolean {
        if(!modelEquals(similarObj)){return false}
        var similarRoot : org.kevoree.modeling.api.KMFContainer = similarObj!!
        while(similarRoot.eContainer() != null){
            similarRoot = similarRoot.eContainer()!!;
        }
        var resultTest = true
        val finalRoot = similarRoot
        val objVisitor = object : org.kevoree.modeling.api.util.ModelVisitor() {
            public override fun visit(elem: org.kevoree.modeling.api.KMFContainer, refNameInParent: String, parent: org.kevoree.modeling.api.KMFContainer) {
                  var similarSubObj = finalRoot.findByPath(elem.path()!!)
                  if(!elem.modelEquals(similarSubObj)){
                      resultTest = false
                      stopVisit()
                  }
            }
        }
        visit(objVisitor,true,true,false)
        return resultTest
    }


    override fun findByPath<A>(query: String, clazz: Class<A>): A? {
        try {
            val res = findByPath(query)
            if(res != null){
                return res as A
            } else {
                return null
            }
        }catch(e: Exception){
            return null
        }
    }

    override fun findByPath(query: String): org.kevoree.modeling.api.KMFContainer? {
        val firstSepIndex = query.indexOf('[')
        var queryID = ""
        var extraReadChar = 2
        val relationName = query.substring(0, query.indexOf('['))
        if(query.indexOf('{') == firstSepIndex + 1){
            queryID = query.substring(query.indexOf('{') + 1, query.indexOf('}'))
            extraReadChar = extraReadChar + 2
        } else {
            var indexFirstClose = query.indexOf(']')
            while( indexFirstClose + 1 < query.length && query.charAt(indexFirstClose + 1) != '/'){
                indexFirstClose = query.indexOf(']',indexFirstClose + 1)
            }
            queryID = query.substring(query.indexOf('[') + 1, indexFirstClose)
        }
        var subquery = query.substring(relationName.size + queryID.size + extraReadChar, query.size)
        if (subquery.indexOf('/') != -1){
            subquery = subquery.substring(subquery.indexOf('/') + 1, subquery.size)
        }
        val objFound = findByID(relationName,queryID)
        if(subquery != "" && objFound != null){
             return objFound.findByPath(subquery)
        } else {
             return objFound
        }
    }


    override fun createTraces(similarObj : org.kevoree.modeling.api.KMFContainer?, isInter : Boolean, isMerge : Boolean, onlyReferences : Boolean, onlyAttributes : Boolean) : List<org.kevoree.modeling.api.trace.ModelTrace> {
        val traces = java.util.ArrayList<org.kevoree.modeling.api.trace.ModelTrace>()
        val values = java.util.HashMap<String,String?>()
        if(onlyAttributes){
            val attVisitorFill = object : org.kevoree.modeling.api.util.ModelAttributeVisitor {
                public override fun visit(value: Any?, name: String, parent: org.kevoree.modeling.api.KMFContainer){
                    values.put(name,value?.toString())
                }
            }
            this.visitAttributes(attVisitorFill)
            val attVisitor = object : org.kevoree.modeling.api.util.ModelAttributeVisitor {
                public override fun visit(value: Any?, name: String, parent: org.kevoree.modeling.api.KMFContainer){
                        var attVal2 : String?
                        if(value != null){
                            attVal2 = value.toString()
                        } else {
                            attVal2 = null
                        }
                        if(values.get(name) == attVal2){
                            if(isInter) {
                                traces.add(org.kevoree.modeling.api.trace.ModelSetTrace(path()!!,name,null,attVal2,null))
                            }
                        } else {
                            if(!isInter) {
                                traces.add(org.kevoree.modeling.api.trace.ModelSetTrace(path()!!,name,null,attVal2,null))
                            }
                        }
                        values.remove(name)
                }
            }
            if(similarObj!=null){similarObj.visitAttributes(attVisitor)}
            if(!isInter && !isMerge && values.size!= 0){
                for(hashLoopRes in values.keySet()){
                    traces.add(org.kevoree.modeling.api.trace.ModelSetTrace(path()!!,hashLoopRes,null,null,null))
                }
            }
        }
        if(onlyReferences){
            val payload = "";
            val refVisitorFill = object : org.kevoree.modeling.api.util.ModelVisitor() {
                public override fun visit(elem: org.kevoree.modeling.api.KMFContainer, refNameInParent: String, parent: org.kevoree.modeling.api.KMFContainer) {
                    val concatedKey = refNameInParent+"_"+elem.path()
                    values.put(concatedKey,payload)
                }
            }
            this.visit(refVisitorFill,false,false,true)
            val refVisitor = object : org.kevoree.modeling.api.util.ModelVisitor() {
                public override fun visit(elem: org.kevoree.modeling.api.KMFContainer, refNameInParent: String, parent: org.kevoree.modeling.api.KMFContainer) {
                    val concatedKey = refNameInParent+"_"+elem.path()
                    if(values.get(concatedKey) != null){
                        if(isInter){
                            traces.add(org.kevoree.modeling.api.trace.ModelAddTrace(path()!!,refNameInParent,elem.path()!!,null))
                        }
                    } else {
                       if(!isInter){
                            traces.add(org.kevoree.modeling.api.trace.ModelAddTrace(path()!!,refNameInParent,elem.path()!!,null))
                       }
                    }
                    values.remove(concatedKey)
                }
            }
            if(similarObj!=null){similarObj.visit(refVisitor,false,false,true)}
            if(!isInter && !isMerge && values.size!= 0){
                for(hashLoopRes in values.keySet()){
                    val splittedVal = hashLoopRes.split("_");
                    traces.add(org.kevoree.modeling.api.trace.ModelRemoveTrace(path()!!,splittedVal.get(0),splittedVal.get(1)))
                }
            }
        }
        return traces
    }


}
