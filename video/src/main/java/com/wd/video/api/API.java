package com.wd.video.api;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public interface API {
    //查看视频类目
    String VIDEO_ENTRY = "health/user/video/v1/findVideoCategoryList";
    //根据类目id查询视频
    String VIDEO_QUERY = "health/user/video/v1/findVideoVoList";
    //收藏视频
    String VIDEO_COLLECTION = "health/user/video/verify/v1/addUserVideoCollection";
    //查看视频弹幕
    String VIDEO_QUERY_BARRAGE = "health/user/video/v1/findVideoCommentList";
    //购买视频
    String VIDEO_PAY = "health/user/video/verify/v1/videoBuy";
    //发布评论（弹幕）
    String VIDEO_SEND = "health/user/video/verify/v1/addVideoComment";
}