package com.wd.video.api;

import com.wd.video.bean.Video_EntryBean;
import com.wd.video.bean.Video_QueryBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public interface HttpApi {
     //查看视频类目
    @GET(API.VIDEO_ENTRY)
    Observable<Video_EntryBean> getVideo_Entry();
    //根据类目id查询视频
    @GET(API.VIDEO_QUERY)
    Observable<Video_QueryBean> getViewo_Query(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("categoryId")String categoryId,@Query("page")String page,@Query("count")String count);
}
