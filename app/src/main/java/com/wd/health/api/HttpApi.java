package com.wd.health.api;


import android.database.Observable;

import com.wd.health.bean.EmailBean;
import com.wd.health.bean.LoginBean;
import com.wd.health.bean.RegisterBean;
import com.wd.health.bean.WXLoginBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
public interface HttpApi {
    //注册
    @FormUrlEncoded
    @POST(API.REGISTER)
    rx.Observable<RegisterBean> onRegister(
            @Field("email") String email,
            @Field("code") String code,
            @Field("pwd1") String pwd1,
            @Field("pwd2") String pwd2,
            @Field("invitationCode") String invitationCode);

    //登录
    @FormUrlEncoded
    @POST(API.LOGIN)
    rx.Observable<LoginBean> onLogin(
            @Field("email") String email,
            @Field("pwd") String pwd);

    //微信登录
    @POST(API.WX_LOGIN)
    rx.Observable<WXLoginBean> onWXLogin(
            @Query("wxCode") String wxCode);

    //发送邮箱验证码
    @POST(API.Email_Code)
    rx.Observable<EmailBean> onEmail(
            @Query("email") String email);
}
