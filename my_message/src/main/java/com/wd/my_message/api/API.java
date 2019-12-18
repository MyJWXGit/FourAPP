package com.wd.my_message.api;

/**
 * @name Health
 * @class name：com.wd.my_message.api
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 21:02
 * @change
 * @chang time
 * @class describe
 */
public interface API {
    //用户签到
    String ADD_SIGN = "health/user/verify/v1/addSign";
    //用户查看当前问诊
    String CurrentInquiryRecord = "health/user/inquiry/verify/v1/findCurrentInquiryRecord";
    //查看历史问诊
    String HistoryInquiryRecord = "health/user/inquiry/verify/v1/findHistoryInquiryRecord";
    //我的钱包
    String UserWallet = "health/user/verify/v1/findUserWallet";
    //查询用户收藏病友圈列表  我的病友圈
    String UserSickCollectionList = "health/user/verify/v1/findUserSickCollectionList";
    //用户收藏健康课堂视频列表  我的视频
    String VideoCollectionList = "health/user/verify/v1/findVideoCollectionList";
    //查询我的被采纳的建议  被采纳建议
    String MyAdoptedCommentList = "health/user/verify/v1/findMyAdoptedCommentList";
    //查询用户资讯收藏列表  我的收藏
    String UserInfoCollectionList = "health/user/verify/v1/findUserInfoCollectionList";
    //查询用户关注医生列表  我的关注
    String UserDoctorFollowList = "health/user/verify/v1/findUserDoctorFollowList";

}
