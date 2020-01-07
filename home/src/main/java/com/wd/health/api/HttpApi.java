package com.wd.health.api;

import com.wd.health.bean.ConsultBean;
import com.wd.health.bean.FollowBean;
import com.wd.health.bean.HomeSearchBean;
import com.wd.health.bean.InquiryRecordBean;
import com.wd.health.bean.BannerBean;
import com.wd.health.bean.CancelFllowBean;
import com.wd.health.bean.CategoryBean;
import com.wd.health.bean.CategoryListBean;
import com.wd.health.bean.DepartmentBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.DoctorListBean;
import com.wd.health.bean.DrugsKnowledgeListBean;
import com.wd.health.bean.DyugBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluateListBean;
import com.wd.health.bean.FindInfoBean;
import com.wd.health.bean.IllnessBean;
import com.wd.health.bean.Information_ListBean;
import com.wd.health.bean.Plate_ListBean;
import com.wd.health.bean.PopularBean;
import com.wd.health.bean.PuMessageBean;
import com.wd.health.bean.RecordingBean;
import com.wd.health.bean.UserWalletBean;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    //查询医生明细信息
    @GET(API.DoctorInfo)
    Observable<DoctorInfoBean> onDoctorInfo(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") String doctorId);

    //关注医生
    @POST(API.followDoctor)
    Observable<FollowBean> onFollow(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") int doctorId);

    //取消关注医生
    @DELETE(API.cancelFollow)
    Observable<CancelFllowBean> onCancelFollow(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") int doctorId);

    //用户查看当前问诊
    @GET(API.CurrentInquiryRecord)
    Observable<InquiryRecordBean> onInquiryRecord(@Header("userId") int userId, @Header("sessionId") String sessionId);

    //我的钱包
    @GET(API.UserWallet)
    Observable<UserWalletBean> onUserWallet(@Header("userId") int userId, @Header("sessionId") String sessionId);

    //查询医生评价列表
    @GET(API.EvaluateList)
    Observable<EvaluateListBean> onEvaluateList(@Query("doctorId") int doctorId, @Query("page") int page, @Query("count") int size);

    //问诊-发送消息（文本消息）
    @FormUrlEncoded
    @POST(API.pushMessage)
    Observable<PuMessageBean> onPuMessage(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("inquiryId") int inquiryId, @Field("content") String content, @Field("type") int type, @Field("doctorId") int doctorId);

    //咨询医生
    @PUT(API.consultDoctor)
    Observable<ConsultBean> getConsult(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") int doctorId);

    //查询历史问诊聊天记录
    @GET(API.InquiryRecordList)
    Observable<RecordingBean> getRecording(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("inquiryId") int inquiryId, @Query("page") int page, @Query("count") int count);

    //结束问诊
    @PUT(API.endInquiry)
    Observable<EndInquiryBean> onEndInquiry(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("recordId") int recordId);
}
