







package lu.snt.serval.pla.framework.impl;

import lu.snt.serval.pla.framework.FrameworkFactory;
import lu.snt.serval.pla.framework.Query;
import lu.snt.serval.pla.framework.UserProfile;
import lu.snt.serval.pla.framework.QueryDataType;
import lu.snt.serval.pla.framework.QueryPrivacyProfile;
import lu.snt.serval.pla.framework.QueryCloaker;
import lu.snt.serval.pla.framework.PrivacyProfile;
import lu.snt.serval.pla.framework.DataType;
import lu.snt.serval.pla.framework.PrivacyACRule;
import lu.snt.serval.pla.framework.AnswerPrivacyProfile;
import lu.snt.serval.pla.framework.IntervalAnswer;
import lu.snt.serval.pla.framework.ValueAnswer;
import lu.snt.serval.pla.framework.IntervalBluring;
import lu.snt.serval.pla.framework.NoiseBluring;
import lu.snt.serval.pla.framework.TimeAveraging;

open class DefaultFrameworkFactory : FrameworkFactory {

override fun getVersion() : String { return "1.0-SNAPSHOT" }

override fun createQuery() : Query { return QueryImpl() }
override fun createUserProfile() : UserProfile { return UserProfileImpl() }
override fun createQueryDataType() : QueryDataType { return QueryDataTypeImpl() }
override fun createQueryPrivacyProfile() : QueryPrivacyProfile { return QueryPrivacyProfileImpl() }
override fun createQueryCloaker() : QueryCloaker { return QueryCloakerImpl() }
override fun createPrivacyProfile() : PrivacyProfile { return PrivacyProfileImpl() }
override fun createDataType() : DataType { return DataTypeImpl() }
override fun createPrivacyACRule() : PrivacyACRule { return PrivacyACRuleImpl() }
override fun createAnswerPrivacyProfile() : AnswerPrivacyProfile { return AnswerPrivacyProfileImpl() }
override fun createIntervalAnswer() : IntervalAnswer { return IntervalAnswerImpl() }
override fun createValueAnswer() : ValueAnswer { return ValueAnswerImpl() }
override fun createIntervalBluring() : IntervalBluring { return IntervalBluringImpl() }
override fun createNoiseBluring() : NoiseBluring { return NoiseBluringImpl() }
override fun createTimeAveraging() : TimeAveraging { return TimeAveragingImpl() }

override fun create(metaClassName : String) : org.kevoree.modeling.api.KMFContainer? {
      when(metaClassName){
            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_Query -> { return createQuery() }
            lu.snt.serval.kmf.util.Constants.CN_Query -> { return createQuery() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_UserProfile -> { return createUserProfile() }
            lu.snt.serval.kmf.util.Constants.CN_UserProfile -> { return createUserProfile() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryDataType -> { return createQueryDataType() }
            lu.snt.serval.kmf.util.Constants.CN_QueryDataType -> { return createQueryDataType() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryPrivacyProfile -> { return createQueryPrivacyProfile() }
            lu.snt.serval.kmf.util.Constants.CN_QueryPrivacyProfile -> { return createQueryPrivacyProfile() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_QueryCloaker -> { return createQueryCloaker() }
            lu.snt.serval.kmf.util.Constants.CN_QueryCloaker -> { return createQueryCloaker() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyProfile -> { return createPrivacyProfile() }
            lu.snt.serval.kmf.util.Constants.CN_PrivacyProfile -> { return createPrivacyProfile() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_DataType -> { return createDataType() }
            lu.snt.serval.kmf.util.Constants.CN_DataType -> { return createDataType() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_PrivacyACRule -> { return createPrivacyACRule() }
            lu.snt.serval.kmf.util.Constants.CN_PrivacyACRule -> { return createPrivacyACRule() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_AnswerPrivacyProfile -> { return createAnswerPrivacyProfile() }
            lu.snt.serval.kmf.util.Constants.CN_AnswerPrivacyProfile -> { return createAnswerPrivacyProfile() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_IntervalAnswer -> { return createIntervalAnswer() }
            lu.snt.serval.kmf.util.Constants.CN_IntervalAnswer -> { return createIntervalAnswer() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_ValueAnswer -> { return createValueAnswer() }
            lu.snt.serval.kmf.util.Constants.CN_ValueAnswer -> { return createValueAnswer() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_IntervalBluring -> { return createIntervalBluring() }
            lu.snt.serval.kmf.util.Constants.CN_IntervalBluring -> { return createIntervalBluring() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_NoiseBluring -> { return createNoiseBluring() }
            lu.snt.serval.kmf.util.Constants.CN_NoiseBluring -> { return createNoiseBluring() }

            lu.snt.serval.kmf.util.Constants.lu_snt_serval_pla_framework_TimeAveraging -> { return createTimeAveraging() }
            lu.snt.serval.kmf.util.Constants.CN_TimeAveraging -> { return createTimeAveraging() }

            else -> {return null;}
       }
}


}