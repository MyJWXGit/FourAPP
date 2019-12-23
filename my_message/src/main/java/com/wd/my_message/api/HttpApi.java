package com.wd.my_message.api;

import com.wd.my_message.bean.AttentionDoctorListBean;
import com.wd.my_message.bean.ConsumptionRecordBean;
import com.wd.my_message.bean.DeleteCollectionBean;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.bean.ImageBean;
import com.wd.my_message.bean.InquiryMessageBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.bean.UnAttentionDoctorBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;


import okhttp3.MultipartBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.POST;
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
                                         @Header("sessionId") String sessionId); //上传图片

    @Multipart
    @POST(API.IMAGE_PIC)
    Observable<ImageBean> onImage_PIC(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Part MultipartBody.Part part
    );


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
}
