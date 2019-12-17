package com.wd.doctor.api;

import com.wd.doctor.bean.AppnBean;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.ImagePicBean;
import com.wd.doctor.bean.InquiryBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.bean.PatientsBean;
import com.wd.doctor.bean.PublishBean;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.StreamBean;
import com.wd.doctor.bean.VerifyBean;


import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
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
    @Headers({"Content-Type : application/json;charset=UTF-8"})
    //@FormUrlEncoded
   /* @POST("health/doctor/v1/applyJoin")
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
                                      );*/
    @POST("health/doctor/v1/applyJoin")
    Observable<RegisterBean> onZhuce(@Body Map<String,Object> body);
    //发送邮箱
    @FormUrlEncoded
    @POST("health/doctor/v1/sendEmailCode")
    Observable<SendBean> Send(@Field("email") String email);
    //检验验证码
    @FormUrlEncoded
    @POST("health/doctor/v1/checkCode")
    Observable<VerifyBean> Verif(@Field("email") String email,@Field("code") String code);
    //医生信息
    @GET("health/doctor/verify/v1/findDoctorById")
    Observable<MianBean> Mian(@Header("doctorId") int doctorId,@Header("sessionId") String sessionId);
    //
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<InquiryBean> Inquiry();
    //病友圈展示
    @GET("health/doctor/sickCircle/v1/findSickCircleList")
    Observable<PatientsBean> Patients(@Query("departmentId") int departmentId,@Query("page") int page,@Query("count") int count);
    //根据关键词查询病友圈
    @GET("health/doctor/sickCircle/v1/searchSickCircle")
    Observable<StreamBean> Stram(@Query("keyWord") String keyWord);
    //查询病友圈详情
    @GET("health/doctor/sickCircle/v1/findSickCircleInfo")
    Observable<DetailsBean> Detals(@Header("doctorId") int doctorId,@Header("sessionId") String sessionId,@Query("sickCircleId") int sickCircleId);
   //发表评论
    @FormUrlEncoded
    @POST("health/doctor/sickCircle/verify/v1/publishComment")
    Observable<PublishBean> Publish(@Header("doctorId") int doctorId,@Header("sessionId") String sessionId,@Query("sickCircleId") int sickCircleId,@Field("content") String content);
   //系统照片
    @GET("health/doctor/v1/findSystemImagePic")
   Observable<ImagePicBean> Imagep();
}
