package com.wd.home.api;

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
    //注册
    String REGISTER = "health/user/v1/register";
    //登录
    String LOGIN = "health/user/v1/login";
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
}
