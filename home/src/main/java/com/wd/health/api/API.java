package com.wd.health.api;

import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @name Health
 * @class name：com.wd.home.api
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 18:57
 * @change
 * @chang time
 * @class describe
 */
public interface API {
    //首页banner板块数据展示
    String BANNER = "health/share/v1/bannersShow";
    //查询科室列表
    String FIND_DEPARTMENT = "health/share/knowledgeBase/v1/findDepartment";
    //健康资讯分类类目查询
    String FIND_INFORMATION_PLATE_LIST = "health/share/information/v1/findInformationPlateList";
    //根据资讯板块查询资讯列表
    String FIND_INFORMATION_LIST = "health/share/information/v1/findInformationList";
    //资讯详情
    String FIND_INFO = "health/share/information/v1/findInformation";
    //查询科室列表
    String FIND_DEPARTMENT_F = "health/share/knowledgeBase/v1/findDepartment";
    //根据科室查询对应病症
    String Category = "health/share/knowledgeBase/v1/findDiseaseCategory";
    //根据科室查询对应病症
    String CategoryList = "health/share/knowledgeBase/v1/findDrugsCategoryList";
    //根据药品类目查询常见药品
    String DrugsKnowledgeList = "health/share/knowledgeBase/v1/findDrugsKnowledgeList";
    //查询常见病症 详情
    String DiseaseKnowledge = "health/share/knowledgeBase/v1/findDiseaseKnowledge";
    //查询常见药品详情
    String DrugsKnowledge = "health/share/knowledgeBase/v1/findDrugsKnowledge";
    //首页搜索
    String homePageSearch = "health/share/v1/homePageSearch";
    //热门搜索
    String POPULARSEARCH = "health/share/v1/popularSearch";
    //查询问诊医生列表
    String DoctorList = "health/user/inquiry/v1/findDoctorList";
    //查询医生明细信息
    String DoctorInfo = "health/user/inquiry/v1/findDoctorInfo";
    //关注医生
    String followDoctor = "health/user/inquiry/verify/v1/followDoctor";
    //取消关注医生
    String cancelFollow = "health/user/inquiry/verify/v1/cancelFollow";
    //用户查看当前问诊
    String CurrentInquiryRecord = "health/user/inquiry/verify/v1/findCurrentInquiryRecord";
    //我的钱包
    String UserWallet = "health/user/verify/v1/findUserWallet";
    //查询医生评价列表
    String EvaluateList = "health/user/inquiry/v1/findDoctorEvaluateList";
    //问诊-发送消息（文本消息）
    String pushMessage = "health/user/inquiry/verify/v1/pushMessage";
    //咨询医生
    String consultDoctor = "health/user/inquiry/verify/v1/consultDoctor";
    //查询历史问诊聊天记录
    String InquiryRecordList = "health/user/inquiry/verify/v1/findInquiryRecordList";
    //结束问诊
    String endInquiry = "health/user/inquiry/verify/v1/endInquiry";
}