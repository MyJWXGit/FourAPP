package com.wd.health.api;

/**
 * @name Health
 * @class name：com.wd.main.api
 * @class describe
 * @anthor 24673
 * @time 2019/12/17 22:10
 * @change
 * @chang time
 * @class describe
 */
public interface API {
    //注册
    String REGISTER = "health/user/v1/register";
    //登录
    String LOGIN = "health/user/v1/login";
    //微信登录
    String WX_LOGIN = "health/user/v1/weChatLogin";
    //发生邮箱验证码
    String Email_Code = "health/user/v1/sendOutEmailCode";
}
