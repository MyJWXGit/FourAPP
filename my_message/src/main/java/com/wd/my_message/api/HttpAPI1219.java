package com.wd.my_message.api;

import com.wd.my_message.bean.ImageBean;

import okhttp3.MultipartBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @name Health
 * @class name：com.wd.my_message.api
 * @class describe
 * @anthor 24673
 * @time 2019/12/19 15:25
 * @change
 * @chang time
 * @class describe
 */
public interface HttpAPI1219 {
    //上传图片
    @Multipart
    @POST(API.IMAGE_PIC)
    Observable<ImageBean> onImage_PIC(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Part MultipartBody.Part part
    );
}
