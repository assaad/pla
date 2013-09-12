





package lu.snt.serval.pla.framework;

trait FrameworkFactory : org.kevoree.modeling.api.KMFFactory {

    fun getVersion() : String

    fun createQuery() : Query
    fun createUserProfile() : UserProfile
    fun createQueryDataType() : QueryDataType
    fun createQueryPrivacyProfile() : QueryPrivacyProfile
    fun createQueryCloaker() : QueryCloaker
    fun createPrivacyProfile() : PrivacyProfile
    fun createDataType() : DataType
    fun createPrivacyACRule() : PrivacyACRule
    fun createAnswerPrivacyProfile() : AnswerPrivacyProfile
    fun createIntervalAnswer() : IntervalAnswer
    fun createValueAnswer() : ValueAnswer
    fun createIntervalBluring() : IntervalBluring
    fun createNoiseBluring() : NoiseBluring
    fun createTimeAveraging() : TimeAveraging


}