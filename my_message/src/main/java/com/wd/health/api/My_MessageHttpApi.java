package com.wd.health.api;

import com.wd.health.bean.SetSignBean;
import com.wd.health.bean.AddArchivesBean;
import com.wd.health.bean.AttentionDoctorListBean;
import com.wd.health.bean.ConsumptionRecordBean;
import com.wd.health.bean.DeleteArchivesBean;
import com.wd.health.bean.DeleteCollectionBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.DoTaskBean;
import com.wd.health.bean.GetTaskBean;
import com.wd.health.bean.HealthyCurrencyBean;
import com.wd.health.bean.HistoryBean;
import com.wd.health.bean.ImageBean;
import com.wd.health.bean.InquiryMessageBean;
import com.wd.health.bean.InquiryRecordBean;
import com.wd.health.bean.LianxuSignBean;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.bean.QuerySignBean;
import com.wd.health.bean.QueryTaskListBean;
import com.wd.health.bean.SetPwdBean;
import com.wd.health.bean.SetSexBean;
import com.wd.health.bean.Set_NameBean;
import com.wd.health.bean.SignBean;
import com.wd.health.bean.SuggestBean;
import com.wd.health.bean.SystemMessageBean;
import com.wd.health.bean.UnAttentionDoctorBean;
import com.wd.health.bean.UpdateArchivesBean;
import com.wd.health.bean.UserArchivesBean;
import com.wd.health.bean.UserArchivesPictureBean;
import com.wd.health.bean.UserColletionBean;
import com.wd.health.bean.UserSickCollectionBean;
import com.wd.health.bean.User_InfoBean;
import com.wd.health.bean.VideoCollectionBean;


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
public interface My_MessageHttpApi {
    @GET(My_messageAPI.VideoCollectionList)
    Observable<VideoCollectionBean> onVideoBean(@Header("userId") int userId
            , @Header("sessionId") String sessionId
            , @Query("page") int page
            , @Query("count") int count);

    @GET(My_messageAPI.UserSickCollectionList)
    Observable<UserSickCollectionBean> onUserSickCollection(
            @Header("userId") int userId
            , @Header("sessionId") String sessionId
            , @Query("page") int page
            , @Query("count") int count
    );

    @GET(My_messageAPI.UserCollection)
    Observable<UserColletionBean> onUserCollection(
            @Header("userId") int userId
            , @Header("sessionId") String sessionId
            , @Query("page") int page
            , @Query("count") int count
    );

    @DELETE(My_messageAPI.DeleteCollection)
    Observable<DeleteCollectionBean> onDeleteCollection(
            @Header("userId") int userId
            , @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId
    );

    //消息
    @GET(My_messageAPI.MessageUserList)
    Observable<SystemMessageBean> getsystemmessage(@Header("userId") int userId,
                                                   @Header("sessionId") String sessionId,
                                                   @Query("page") int page,
                                                   @Query("count") int count);

    @GET(My_messageAPI.WenZhen)
    Observable<InquiryMessageBean> getinquiry(@Header("userId") int userId,
                                              @Header("sessionId") String sessionId,
                                              @Query("page") int page,
                                              @Query("count") int count);

    @GET(My_messageAPI.UserHMoneyMessage)
    Observable<HealthyCurrencyBean> getcurrency(@Header("userId") int userId,
                                                @Header("sessionId") String sessionId,
                                                @Query("page") int page,
                                                @Query("count") int count);

    @GET(My_messageAPI.MyMoneyBao)
    Observable<MyWalletBean> getmyWallet(@Header("userId") int userId,
                                         @Header("sessionId") String sessionId);

    @GET(My_messageAPI.RecordsOfConsumption)
    Observable<ConsumptionRecordBean> getconsumptionRecord(@Header("userId") int userId,
                                                           @Header("sessionId") String sessionId,
                                                           @Query("page") int page,
                                                           @Query("count") int count);

    @GET(My_messageAPI.AttentionDoctorList)
    Observable<AttentionDoctorListBean> onAttentionDoctorListBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("page") int page,
            @Query("count") int count
    );

    @DELETE(My_messageAPI.UnAttentionDoctor)
    Observable<UnAttentionDoctorBean> onUnAttentionDoctorBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("doctorId") int doctorId
    );

    @POST(My_messageAPI.Sign)
    Observable<SignBean> onSignBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );

    @GET(My_messageAPI.QueryUserSign)
    Observable<QuerySignBean> onQueryUserSignBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );

    @GET(My_messageAPI.LianxuSign)
    Observable<LianxuSignBean> onLianxuSignBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );

    @GET(My_messageAPI.MySuggest)
    Observable<SuggestBean> onSuggestBean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("page") int page,
            @Query("count") int count
    );

    @Multipart
    @POST(My_messageAPI.IMAGE_PIC)
    Observable<ImageBean> onImage_PIC(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Part MultipartBody.Part part
    );

    //用户查看当前问诊
    @GET(My_messageAPI.CurrentInquiryRecord)
    Observable<InquiryRecordBean> onInquiryRecord(@Header("userId") int userId, @Header("sessionId") String sessionId);

    //结束问诊
    @PUT(My_messageAPI.endInquiry)
    Observable<EndInquiryBean> onEndInquiry(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("recordId") int recordId);

    //查看自己的档案
    //http://172.17.8.100/health/user/verify/v1/findUserArchives
    @GET(My_messageAPI.MyFile)
    Observable<UserArchivesBean> getarchives(@Header("userId") int userId, @Header("sessionId") String sessionId);

    //删除档案
    //http://172.17.8.100/health/user/verify/v1/deleteUserArchives
    @DELETE(My_messageAPI.DeleteFile)
    Observable<DeleteArchivesBean> getdeleteUserArchives(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("archivesId") int archivesId);

    //用户修改档案
    //http://172.17.8.100/health/user/verify/v1/updateUserArchives
    @PUT(My_messageAPI.UpdateFile)
    Observable<UpdateArchivesBean> getupdateUserArchives(@Header("userId") int userId, @Header("sessionId") String sessionId, @Body Map<String, Object> map);

    //用户添加档案
    //http://172.17.8.100/health/user/verify/v1/addUserArchives
    @POST(My_messageAPI.InsertFile)
    Observable<AddArchivesBean> getaddUserArchives(@Header("userId") int userId, @Header("sessionId") String sessionId, @Body Map<String, Object> map);

    //用户档案上传图片
    //http://172.17.8.100/health/user/verify/v1/uploadArchivesPicture
    @Multipart
    @POST(My_messageAPI.UploadPiture)
    Observable<UserArchivesPictureBean> getpicture(@Header("userId") int userId, @Header("sessionId") String sessionId, @Part MultipartBody.Part picture);

    //做任务
    @POST(My_messageAPI.DoTask)
    Observable<DoTaskBean> onDoTaskBean(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("taskId") int taskId);

    //领取任务奖励
    @POST(My_messageAPI.GetTask)
    Observable<GetTaskBean> onGetTaskBean(@Header("userId") int userId,
                                          @Header("sessionId") String sessionId,
                                          @Query("taskId") int taskId);

    //查询用户任务列表
    @GET(My_messageAPI.QueryTaskList)
    Observable<QueryTaskListBean> onQueryTaskBean(@Header("userId") int userId,
                                                  @Header("sessionId") String sessionId);

    //我的病友圈
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleList?page=1&count=5
    @GET(My_messageAPI.MyCircle)
    Observable<MySickCircleListBean> getMySickCircleList(@Header("userId") int userId,
                                                         @Header("sessionId") String sessionId,
                                                         @Query("page") int page,
                                                         @Query("count") int count);

    //查询我的病友圈帖子的评论列表
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleCommentList?sickCircleId=1796&page=1&count=5
    @GET(My_messageAPI.MyCircleCommentent)
    Observable<MySickCircleCommentListBean> getMySickCircleCommentList(@Header("userId") int userId,
                                                                       @Header("sessionId") String sessionId,
                                                                       @Query("sickCircleId") int sickCircleId,
                                                                       @Query("page") int page,
                                                                       @Query("count") int count);

    //查看历史问诊
    @GET(My_messageAPI.HistoryInquiryRecord)
    Observable<HistoryBean> onHistory(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("page") int page, @Query("count") int count);

    @PUT(My_messageAPI.SetName)
    Observable<Set_NameBean> onSet_Name(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("nickName") String nickName
    );

    @GET(My_messageAPI.UserInfo)
    Observable<User_InfoBean> onUser_Info(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId
    );

    @PUT(My_messageAPI.SetSex)
    Observable<SetSexBean> onSet_Sex(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("sex") int sex
    );

    @PUT(My_messageAPI.SetPwd)
    Observable<SetPwdBean> onSet_Pwd(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("oldPwd") String oldPwd,
            @Query("newPwd") String newPwd
    );

    @PUT(My_messageAPI.SetSign)
    Observable<SetSignBean> onSet_Sign(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Query("age") int age,
            @Query("height") int height,
            @Query("weight") int weight
    );
}
