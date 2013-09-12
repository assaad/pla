


package lu.snt.serval.kmf.util;
object Constants {

    public val UNKNOWN_MUTATION_TYPE_EXCEPTION : String = "Unknown mutation type: "
    public val READ_ONLY_EXCEPTION : String = "This model is ReadOnly. Elements are not modifiable."
    public val LIST_PARAMETER_OF_SET_IS_NULL_EXCEPTION : String = "The list in parameter of the setter cannot be null. Use removeAll to empty a collection."
    public val ELEMENT_HAS_NO_KEY_IN_COLLECTION : String = "Cannot set the collection, because at least one element of it has no key!"
    public val EMPTY_KEY : String = "Key empty : please set the attribute key before adding the object."

    public val KMFQL_CONTAINED : String = "contained"

    public val STRING_DEFAULTVAL : String = ""
    public val INT_DEFAULTVAL : Int = 0
    public val BOOLEAN_DEFAULTVAL : Boolean = false
    public val CHAR_DEFAULTVAL : Char = 'a'
    public val SHORT_DEFAULTVAL : Short = 0
    public val LONG_DEFAULTVAL : Long = 0
    public val DOUBLE_DEFAULTVAL : Double = 0.0
    public val FLOAT_DEFAULTVAL : Float = 0.0
    public val BYTE_DEFAULTVAL : Byte = 0

    public val CN_QueryRequest : String = "QueryRequest"
    public val CN_Answer : String = "Answer"
    public val Ref_valueBluring : String = "valueBluring"
    public val lu_snt_serval_pla_framework_IntervalBluring : String = "lu.snt.serval.pla.framework.IntervalBluring"
    public val CN_PrivacyACRule : String = "PrivacyACRule"
    public val lu_snt_serval_pla_framework_NoiseBluring : String = "lu.snt.serval.pla.framework.NoiseBluring"
    public val CN_QueryCloaker : String = "QueryCloaker"
    public val lu_snt_serval_pla_framework_ValueBluring : String = "lu.snt.serval.pla.framework.ValueBluring"
    public val Ref_queriedDataType : String = "queriedDataType"
    public val lu_snt_serval_pla_framework_AnswerDataType : String = "lu.snt.serval.pla.framework.AnswerDataType"
    public val Ref_requestedTimeBluring : String = "requestedTimeBluring"
    public val CN_TimeBluring : String = "TimeBluring"
    public val CN_AnswerPrivacyProfile : String = "AnswerPrivacyProfile"
    public val lu_snt_serval_pla_framework_IntervalAnswer : String = "lu.snt.serval.pla.framework.IntervalAnswer"
    public val Att_variance : String = "variance"
    public val CN_PrivacyProfile : String = "PrivacyProfile"
    public val Att_location : String = "location"
    public val Att_cloakingAlgorithm : String = "cloakingAlgorithm"
    public val CN_NoiseBluring : String = "NoiseBluring"
    public val Att_duration : String = "duration"
    public val Ref_answers : String = "answers"
    public val CN_QueryPrivacyProfile : String = "QueryPrivacyProfile"
    public val Ref_userProfile : String = "userProfile"
    public val CN_IntervalBluring : String = "IntervalBluring"
    public val Att_id : String = "id"
    public val Att_generated_KMF_ID : String = "generated_KMF_ID"
    public val lu_snt_serval_pla_framework_QueryRequest : String = "lu.snt.serval.pla.framework.QueryRequest"
    public val CN_UserProfile : String = "UserProfile"
    public val Ref_privacyRules : String = "privacyRules"
    public val CN_AnswerDataType : String = "AnswerDataType"
    public val CN_Query : String = "Query"
    public val CN_TimeAveraging : String = "TimeAveraging"
    public val lu_snt_serval_pla_framework_PrivacyACRule : String = "lu.snt.serval.pla.framework.PrivacyACRule"
    public val Ref_timeBluring : String = "timeBluring"
    public val Att_value : String = "value"
    public val lu_snt_serval_pla_framework_AnswerPrivacyProfile : String = "lu.snt.serval.pla.framework.AnswerPrivacyProfile"
    public val Ref_privacyRule : String = "privacyRule"
    public val Att_max : String = "max"
    public val Att_dateTime : String = "dateTime"
    public val lu_snt_serval_pla_framework_QueryDataType : String = "lu.snt.serval.pla.framework.QueryDataType"
    public val lu_snt_serval_pla_framework_DataType : String = "lu.snt.serval.pla.framework.DataType"
    public val Ref_requestedValueBluring : String = "requestedValueBluring"
    public val lu_snt_serval_pla_framework_QueryPrivacyProfile : String = "lu.snt.serval.pla.framework.QueryPrivacyProfile"
    public val lu_snt_serval_pla_framework_TimeAveraging : String = "lu.snt.serval.pla.framework.TimeAveraging"
    public val Ref_relatedPrivacyProfile : String = "relatedPrivacyProfile"
    public val Att_TypeOfNoise : String = "TypeOfNoise"
    public val Att_IntervalLength : String = "IntervalLength"
    public val CN_IntervalAnswer : String = "IntervalAnswer"
    public val Ref_privacyPr : String = "privacyPr"
    public val Ref_dataType : String = "dataType"
    public val CN_QueryDataType : String = "QueryDataType"
    public val lu_snt_serval_pla_framework_TimeBluring : String = "lu.snt.serval.pla.framework.TimeBluring"
    public val lu_snt_serval_pla_framework_Answer : String = "lu.snt.serval.pla.framework.Answer"
    public val lu_snt_serval_pla_framework_QueryCloaker : String = "lu.snt.serval.pla.framework.QueryCloaker"
    public val Att_min : String = "min"
    public val lu_snt_serval_pla_framework_PrivacyProfile : String = "lu.snt.serval.pla.framework.PrivacyProfile"
    public val CN_ValueBluring : String = "ValueBluring"
    public val Att_name : String = "name"
    public val Ref_relatedPrivacyRule : String = "relatedPrivacyRule"
    public val Ref_queryRequests : String = "queryRequests"
    public val CN_DataType : String = "DataType"
    public val lu_snt_serval_pla_framework_Query : String = "lu.snt.serval.pla.framework.Query"
    public val lu_snt_serval_pla_framework_ValueAnswer : String = "lu.snt.serval.pla.framework.ValueAnswer"
    public val Ref_queryRequest : String = "queryRequest"
    public val CN_ValueAnswer : String = "ValueAnswer"
    public val CN_Bluring : String = "Bluring"
    public val Ref_EReference0 : String = "EReference0"
    public val lu_snt_serval_pla_framework_Bluring : String = "lu.snt.serval.pla.framework.Bluring"
    public val Ref_resultedTimeBluring : String = "resultedTimeBluring"
    public val lu_snt_serval_pla_framework_UserProfile : String = "lu.snt.serval.pla.framework.UserProfile"
    public val Ref_ResultedValueBluring : String = "ResultedValueBluring"

}

