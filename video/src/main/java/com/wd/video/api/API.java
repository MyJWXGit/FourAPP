package com.wd.video.api;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public interface API {
    //查看视频类目
    String VIDEO_ENTRY = "health/user/video/v1/findVideoCategoryList";
    //根据类目id查询视频
    String VIDEO_QUERY = "health/user/video/v1/findVideoVoList";
}
