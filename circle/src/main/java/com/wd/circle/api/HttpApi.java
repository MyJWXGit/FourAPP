package com.wd.circle.api;

import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.LoginBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 9:15
 * @change
 * @chang time
 * @class describe
 */
public interface HttpApi {
    @FormUrlEncoded
    @POST(Api.LOGIN_URL)
    Observable<LoginBean> onLogin(
            @Field("email") String email,
            @Field("pwd") String pwd);
    @GET(Api.LIST_URL)
    Observable<Circle_list_Bean> onListBean();
    @GET(Api.LISTS_URL)
    Observable<Circle_lists_Bean> onListsBean(
            @Query("departmentId") int departmentId,
            @Query("page") int page,
            @Query("count")int count);
}
