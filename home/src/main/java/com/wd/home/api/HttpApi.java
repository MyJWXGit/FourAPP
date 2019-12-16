package com.wd.home.api;

import com.wd.home.bean.BannerBean;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.bean.DyugBean;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.bean.IllnessBean;
import com.wd.home.bean.Information_ListBean;
import com.wd.home.bean.LoginBean;
import com.wd.home.bean.Plate_ListBean;
import com.wd.home.bean.RegisterBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
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

    //查询科室列表
    @GET(API.FIND_DEPARTMENT)
    Observable<DepartmentBean> onDepartment();

    //健康资讯分类类目查询
    @GET(API.FIND_INFORMATION_PLATE_LIST)
    Observable<Plate_ListBean> onPlate_list();

    //根据资讯板块查询资讯列表
    @GET(API.FIND_INFORMATION_LIST)
    Observable<Information_ListBean> onInformation_list(@Query("plateId") int plateId, @Query("page") int page, @Query("count") int count);

    //资讯详情
    @GET(API.FIND_INFO)
    Observable<FindInfoBean> onFindInfo(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("infoId") int infoId);

    //查询科室列表
    @GET(API.FIND_DEPARTMENT_F)
    Observable<DepartmentBean> onDepartment_F();

    //根据科室查询对应病症
    @GET(API.Category)
    Observable<CategoryBean> onCategory(@Query("departmentId") int departmentId);

    //药品科目分类列表查询
    @GET(API.CategoryList)
    Observable<CategoryListBean> onCategoryList();

    //根据药品类目查询常见药品
    @GET(API.DrugsKnowledgeList)
    Observable<DrugsKnowledgeListBean> onDrugsKnowledgeList(@Query("drugsCategoryId") int drugsCategoryId, @Query("page") int page, @Query("count") int count);

    //查询常见病症详情
    @GET(API.DiseaseKnowledge)
    Observable<DyugBean> onDyug(@Query("id") int id);

    //查询常见药品详情
    @GET(API.DrugsKnowledge)
    Observable<IllnessBean> onIllness(@Query("id") int id);
}
