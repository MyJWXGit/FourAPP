package com.wd.circle.api;

import com.wd.circle.bean.Adoption_Comment_Bean;
import com.wd.circle.bean.Circle_Comment_Bean;
import com.wd.circle.bean.Circle_Details_Bean;
import com.wd.circle.bean.Circle_Post_Bean;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.CommentBean;
import com.wd.circle.bean.DiseaseBean;
import com.wd.circle.bean.DoTaskBean;
import com.wd.circle.bean.LoginBean;
import com.wd.circle.bean.My_CirclePost_Bean;
import com.wd.circle.bean.PictureBean;
import com.wd.circle.bean.Post_Image_Bean;
import com.wd.circle.bean.Put_Circle_Bean;
import com.wd.circle.bean.Put_Viewpoint_Bean;
import com.wd.circle.bean.Query_MyCircle_Post_Bean;
import com.wd.circle.bean.RepleaseCircleBean;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.bean.UserTaskListBean;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
 * @time 2019/12/13 9:15
 * @change
 * @chang time
 * @class describe
 */
public interface HttpApi {
    @FormUrlEncoded
    @POST(Api.LOGIN_URL)
    Observable<LoginBean> onLogin(
            @Field("email") String email,
            @Field("pwd") String pwd);

    @GET(Api.LIST_URL)
    Observable<Circle_list_Bean> onListBean();

    @GET(Api.LISTS_URL)
    Observable<Circle_lists_Bean> onListsBean(
            @Query("departmentId") int departmentId,
            @Query("page") int page,
            @Query("count") int count);

    @GET(Api.SEARCH_URL)
    Observable<SearchCircleBean> onSearchBean(
            @Query("keyWord") String keyWord
    );

    @GET(Api.DETAILS_URL)
    Observable<Circle_Details_Bean> onDetailsBean(
            @Query("sickCircleId") int sickCircleId,
            @Header("userId") String userId,
            @Header("sessionId") String sessionId
    );

    //病友圈发表评论
    @POST(Api.COMMENT_URL)
    Observable<CommentBean> onCommentBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId,
            @Query("content") String content
    );

    //病友圈评论列表
    @GET(Api.DETAILS_COMMENT_URL)
    Observable<Circle_Comment_Bean> onCircleCommentBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId,
            @Query("count") int count,
            @Query("page") int page
    );

    //采纳病友圈优秀的评论
    @PUT(Api.ADOPTION_COMMENT_URL)
    Observable<Adoption_Comment_Bean> onAdoptionCommentBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId,
            @Query("commentId") int commentId
    );

    //发表观点
    @PUT(Api.PUT_VIEWPOINT_URL)
    Observable<Put_Viewpoint_Bean> onPutViewpointBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("opinion") int opinion,
            @Query("commentId") int commentId
    );

    //查看病友的病友圈发帖列表
    @GET(Api.CIRCLE_POST_URL)
    Observable<Circle_Post_Bean> onCirclePostBean(
            @Query("patientUserId") int patientUserId,
            @Query("count") int count,
            @Query("page") int page
    );

    //查看我的病友圈发帖列表
    @GET(Api.MY_POST_URL)
    Observable<My_CirclePost_Bean> myCirclePostBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("count") int count,
            @Query("page") int page
    );

    //查看我的病友圈帖子的评论列表
    @GET(Api.QUERY_MYCIRCLE_POST_URL)
    Observable<Query_MyCircle_Post_Bean> onQueryMyCirclePostBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId,
            @Query("count") int count,
            @Query("page") int page
    );

    //上传头像
    @Multipart
    @FormUrlEncoded
    @POST(Api.POST_IMAGE_URL)
    Observable<Post_Image_Bean> onPostImageBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Field("sickCircleId") int sickCircleId,
            @Part MultipartBody.Part map
    );

    //做任务
    @POST(Api.DO_TASK_URL)
    Observable<DoTaskBean> onDoTaskBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("taskId") int taskId
    );

    //查询用户任务列表
    @GET(Api.USER_TASK_LIST_URL)
    Observable<UserTaskListBean> onUserTaskListBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId
    );

    //发布病友圈
    @POST(Api.REPLEASE_CIRCLE_URL)
    Observable<RepleaseCircleBean> onRepleaseCircleBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Body Map<String, Object> map
    );

    //对应病症
    @GET(Api.DISEASE_URL)
    Observable<DiseaseBean> onDiseaseBean(
            @Query("departmentId") int departmentId
    );

    //上传图片
    @Multipart
    @POST(Api.PICTURE_URL)
    Observable<PictureBean> onPictureBean(
            @Header("userId") String userId,
            @Header("sessionId") String sessionId,
            @Query("sickCircleId") int sickCircleId,
            @Part List<MultipartBody.Part> part
    );
}