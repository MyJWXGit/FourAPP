package com.wd.home.api;

import com.wd.home.bean.BannerBean;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DoctorListBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.bean.DyugBean;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.bean.HomeSearchBean;
import com.wd.home.bean.IllnessBean;
import com.wd.home.bean.Information_ListBean;
import com.wd.home.bean.Plate_ListBean;
import com.wd.home.bean.PopularBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
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
    Observable<DyugBean> onDiseaseKnowledge(@Query("id") int id);

    //查询常见药品详情
    @GET(API.DrugsKnowledge)
    Observable<IllnessBean> onIllness(@Query("id") int id);

    //查询常见药品详情
    @GET(API.homePageSearch)
    Observable<HomeSearchBean> onHomeSearch(@Query("keyWord") String keyWord);

    //查询常见药品详情
    @GET(API.POPULARSEARCH)
    Observable<PopularBean> onPopular();

    //查询问诊医生列表
    @GET(API.DoctorList)
    Observable<DoctorListBean> onDoctorList(@Query("deptId") int deptId, @Query("condition") int condition, @Query("page") int page, @Query("count") int count);
}
