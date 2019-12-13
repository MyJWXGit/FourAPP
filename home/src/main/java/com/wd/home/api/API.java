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
}
