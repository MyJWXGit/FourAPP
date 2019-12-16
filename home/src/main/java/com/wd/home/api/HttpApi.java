package com.wd.home.api;

import com.wd.home.bean.BannerBean;
import com.wd.home.bean.LoginBean;
import com.wd.home.bean.RegisterBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @name Health
 * @class name：com.wd.home.api
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 19:01
 * @change
 * @chang time
 * @class describe
 */
public interface HttpApi {
    //注册
    @FormUrlEncoded
    @POST(API.REGISTER)
    Observable<RegisterBean> onRegister(
            @Field("email") String email,
            @Field("code") String code,
            @Field("pwd1") String pwd1,
            @Field("pwd2") String pwd2,
            @Field("invitationCode") String invitationCode);

    //注册
    @FormUrlEncoded
    @POST(API.LOGIN)
    Observable<LoginBean> onLogin(
            @Field("email") String email,
            @Field("pwd") String pwd);

    //首页banner板块数据展示
    @GET(API.BANNER)
    Observable<BannerBean> onBanner();

}
