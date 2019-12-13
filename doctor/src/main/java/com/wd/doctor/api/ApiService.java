package com.wd.doctor.api;

import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.VerifyBean;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * date:2019/12/11
 * author:金豪(Lenovo)
 * function:
 */
public interface ApiService {
    //登录
    @FormUrlEncoded
    @POST("health/doctor/v1/login")
    Observable<LoginBean> login(@Field("email") String email, @Field("pwd") String pwd);
    //申请入驻
    @FormUrlEncoded
    @POST("health/doctor/v1/applyJoin")
    Observable<RegisterBean> Register(@Field("email") String email,
                                      @Field("code") String code,
                                      @Field("pwd1") String pwd1,
                                      @Field("pwd2") String pwd2,
                                      @Field("name") String name,
                                      @Field("inauguralHospital") String inauguralHospital,
                                      @Field("departmentName") String departmentName,
                                      @Field("jobTitle") String jobTitle,
                                      @Field("personalProfile") String personalProfile,
                                      @Field("goodField") String goodField
                                      );
    //发送邮箱
    @FormUrlEncoded
    @POST("health/doctor/v1/sendEmailCode")
    Observable<SendBean> Send(@Field("email") String email);
    //检验验证码
    @FormUrlEncoded
    @POST("health/doctor/v1/checkCode")
    Observable<VerifyBean> Verif(@Field("email") String email,@Field("code") String code);
}
