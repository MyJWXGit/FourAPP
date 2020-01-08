package com.wd.video.api;

import com.wd.video.bean.Video_EntryBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.bean.Video_SendBean;
import com.wd.video.bean.Video_CollectionBean;
import com.wd.video.bean.Video_PayBean;
import com.wd.video.bean.Video_Query_BarrageBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public interface Video_HttpApi {
     //查看视频类目
    @GET(API.VIDEO_ENTRY)
    Observable<Video_EntryBean> getVideo_Entry();
    //根据类目id查询视频
    @GET(API.VIDEO_QUERY)
    Observable<Video_QueryBean> getViewo_Query(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("categoryId") String categoryId, @Query("page") String page, @Query("count") String count);
    //收藏视频
    @POST(API.VIDEO_COLLECTION)
    Observable<Video_CollectionBean> getVideo_Collection(@Header("userId") String userId, @Header("sessionId") String sessionId,@Query("videoId")String videoId);
    //查询视频弹幕
    @GET(API.VIDEO_QUERY_BARRAGE)
    Observable<Video_Query_BarrageBean> getVideo_Query_Barrage(@Query("videoId")String videoId);
    //购买视频
    @POST(API.VIDEO_PAY)
    Observable<Video_PayBean> getVideo_Pay(@Header("userId") String userId, @Header("sessionId") String sessionId,@Query("videoId")String videoId,@Query("price")String price);
    //发送评论（弹幕）
    @POST(API.VIDEO_SEND)
    Observable<Video_SendBean> getVideo_Send(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("videoId")String videoId, @Query("content")String content);
}
