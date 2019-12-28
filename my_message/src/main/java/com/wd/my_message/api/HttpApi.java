package com.wd.my_message.api;

import com.wd.my_message.bean.AddArchivesBean;
import com.wd.my_message.bean.AttentionDoctorListBean;
import com.wd.my_message.bean.ConsumptionRecordBean;
import com.wd.my_message.bean.DeleteArchivesBean;
import com.wd.my_message.bean.DeleteCollectionBean;
import com.wd.my_message.bean.DoTaskBean;
import com.wd.my_message.bean.GetTaskBean;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.bean.ImageBean;
import com.wd.my_message.bean.InquiryMessageBean;
import com.wd.my_message.bean.LianxuSignBean;
import com.wd.my_message.bean.MySickCircleCommentListBean;
import com.wd.my_message.bean.MySickCircleListBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.bean.QuerySignBean;
import com.wd.my_message.bean.QueryTaskListBean;
import com.wd.my_message.bean.SignBean;
import com.wd.my_message.bean.SuggestBean;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.bean.UnAttentionDoctorBean;
import com.wd.my_message.bean.UpdateArchivesBean;
import com.wd.my_message.bean.UserArchivesBean;
import com.wd.my_message.bean.UserArchivesPictureBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;


import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.POST;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 13:56
 * @change
 * @chang time
 * @class describe
 */
public interface HttpApi {
    @GET(API.VideoCollectionList)
    Observable<VideoCollectionBean> onVideoBean(@Header("userId") int userId
            , @Header("sessionId") String sessionId
            , @Query("page") int page
            , @Query("count") int count);

    @GET(API.UserSickCollectionList)
    Observable<UserSickCollectionBean> onUserSickCollection(
            @Header("userId") int userId
            , @Header("sessionId") String sessionId
            , @Query("page") int page
            , @Query("count") int count
    );

    @GET(API.UserCollection)
    Observable<UserColletionBean> onUserCollection(
            @Header("userId") int userId
            , @Header("sessionId") String sessionId
            , @Query("page") int page
            , @Query("count") int count
    );

    @DELETE(API.DeleteCollection)
    Observable<DeleteCollectionBean> onDeleteCollection(
            @Header("userId") int userId
            , @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId
    );

    //消息
    @GET(API.MessageUserList)
    Observable<SystemMessageBean> getsystemmessage(@Header("userId") int userId,
                                                   @Header("sessionId") String sessionId,
                                                   @Query("page") int page,
                                                   @Query("count") int count);

    @GET(API.WenZhen)
    Observable<InquiryMessageBean> getinquiry(@Header("userId") int userId,
                                              @Header("sessionId") String sessionId,
                                              @Query("page") int page,
                                              @Query("count") int count);

    @GET(API.UserHMoneyMessage)
    Observable<HealthyCurrencyBean> getcurrency(@Header("userId") int userId,
                                                @Header("sessionId") String sessionId,
                                                @Query("page") int page,
                                                @Query("count") int count);

    @GET(API.MyMoneyBao)
    Observable<MyWalletBean> getmyWallet(@Header("userId") int userId,
                                         @Header("sessionId") String sessionId);

    @GET(API.RecordsOfConsumption)
    Observable<ConsumptionRecordBean> getconsumptionRecord(@Header("userId") int userId,
                                                           @Header("sessionId") String sessionId,
                                                           @Query("page") int page,
                                                           @Query("count") int count);
    @GET(API.AttentionDoctorList)
    Observable<AttentionDoctorListBean> onAttentionDoctorListBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("page") int page,
            @Query("count") int count
    );
    @DELETE(API.UnAttentionDoctor)
    Observable<UnAttentionDoctorBean> onUnAttentionDoctorBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("doctorId") int doctorId
    );
    //签到
    @POST(API.Sign)
    Observable<SignBean> onSignBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );
    //查询用户是否签到
    @GET(API.QueryUserSign)
    Observable<QuerySignBean> onQueryUserSignBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );
    @GET(API.LianxuSign)
    Observable<LianxuSignBean> onLianxuSignBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );
    @GET(API.MySuggest)
    Observable<SuggestBean> onSuggestBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("page") int page,
            @Query("count") int count
    );
    @Multipart
    @POST(API.IMAGE_PIC)
    Observable<ImageBean> onImage_PIC(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Part MultipartBody.Part part
    );

    //查看自己的档案
    //http://172.17.8.100/health/user/verify/v1/findUserArchives
    @GET(API.MyFile)
    Observable<UserArchivesBean> getarchives(@Header("userId") int userId, @Header("sessionId") String sessionId);
    //删除档案
    //http://172.17.8.100/health/user/verify/v1/deleteUserArchives
    @DELETE(API.DeleteFile)
    Observable<DeleteArchivesBean> getdeleteUserArchives(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("archivesId") int archivesId);
    //用户修改档案
    //http://172.17.8.100/health/user/verify/v1/updateUserArchives
    @PUT(API.UpdateFile)
    Observable<UpdateArchivesBean> getupdateUserArchives(@Header("userId") int userId, @Header("sessionId") String sessionId, @Body Map<String,Object> map);
    //用户添加档案
    //http://172.17.8.100/health/user/verify/v1/addUserArchives
    @POST(API.InsertFile)
    Observable<AddArchivesBean> getaddUserArchives(@Header("userId") int userId, @Header("sessionId") String sessionId, @Body Map<String,Object> map);
    //用户档案上传图片
    //http://172.17.8.100/health/user/verify/v1/uploadArchivesPicture
    @Multipart
    @POST(API.UploadPiture)
    Observable<UserArchivesPictureBean> getpicture(@Header("userId") int userId, @Header("sessionId") String sessionId, @PartMap Map<String,MultipartBody.Part> picture);
    //做任务
    @POST(API.DoTask)
    Observable<DoTaskBean> onDoTaskBean(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("taskId") int taskId);
    //领取任务奖励
    @POST(API.GetTask)
    Observable<GetTaskBean> onGetTaskBean(@Header("userId") int userId,
                                          @Header("sessionId") String sessionId,
                                          @Query("taskId") int taskId);
    //查询用户任务列表
    @GET(API.QueryTaskList)
    Observable<QueryTaskListBean> onQueryTaskBean(@Header("userId") int userId,
                                                   @Header("sessionId") String sessionId);
    //我的病友圈
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleList?page=1&count=5
    @GET(API.MyCircle)
    Observable<MySickCircleListBean> getMySickCircleList(@Header("userId") int userId,
                                                         @Header("sessionId") String sessionId,
                                                         @Query("page") int page,
                                                         @Query("count") int count);
    //查询我的病友圈帖子的评论列表
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleCommentList?sickCircleId=1796&page=1&count=5
    @GET(API.MyCircleCommentent)
    Observable<MySickCircleCommentListBean> getMySickCircleCommentList(@Header("userId") int userId,
                                                                       @Header("sessionId") String sessionId,
                                                                       @Query("sickCircleId") int sickCircleId,
                                                                       @Query("page") int page,
                                                                       @Query("count") int count);
}
