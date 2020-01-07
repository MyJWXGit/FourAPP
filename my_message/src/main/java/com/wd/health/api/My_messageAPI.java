package com.wd.health.api;

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
public interface My_messageAPI {
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
    //用户收藏资讯  健康咨询资讯
    String UserCollection = "health/user/verify/v1/findUserInfoCollectionList";
    //查询我的被采纳的建议  被采纳建议
    String MyAdoptedCommentList = "health/user/verify/v1/findMyAdoptedCommentList";
    //查询用户资讯收藏列表  我的收藏
    String UserInfoCollectionList = "health/user/verify/v1/findUserInfoCollectionList";
    //查询用户关注医生列表  我的关注
    String UserDoctorFollowList = "health/user/verify/v1/findUserDoctorFollowList";
    //上传头像
    String IMAGE_PIC = "health/user/verify/v1/modifyHeadPic";
    //取消收藏病友圈
    String DeleteCollection = "health/user/verify/v1/cancelSickCollection";
    //系统消息 查询用户系统通知列表
    String MessageUserList = "health/user/verify/v1/findSystemNoticeList";
    //问诊消息
    String WenZhen = "health/user/verify/v1/findInquiryNoticeList";
    //查询用户H币通知列表
    String UserHMoneyMessage = "health/user/verify/v1/findHealthyCurrencyNoticeList";
    //wode我的钱包
    String MyMoneyBao = "health/user/verify/v1/findUserWallet";
    //消费记录
    String RecordsOfConsumption = "health/user/verify/v1/findUserConsumptionRecordList";
    //查询关注医生列表
    String AttentionDoctorList = "health/user/verify/v1/findUserDoctorFollowList";
    //关注医生
    String AttentionDoctor = "health/user/inquiry/verify/v1/followDoctor";
    //取消关注医生
    String UnAttentionDoctor = "health/user/inquiry/verify/v1/cancelFollow";
    //签到
    String Sign = "health/user/verify/v1/addSign";
    //查询用户是否签到
    String QueryUserSign = "health/user/verify/v1/whetherSignToday";
    //查询用户是否签到
    String LianxuSign="health/user/verify/v1/findUserSign";
    //查询我的被采纳的意见
    String MySuggest = "health/user/verify/v1/findMyAdoptedCommentList";
    //结束问诊
    String endInquiry = "health/user/inquiry/verify/v1/endInquiry";
    String MyFile="health/user/verify/v1/findUserArchives";
    String DeleteFile="health/user/verify/v1/deleteUserArchives";
    String UpdateFile="health/user/verify/v1/updateUserArchives";
    String InsertFile="health/user/verify/v1/addUserArchives";
    String UploadPiture="health/user/verify/v1/uploadArchivesPicture";
    //做任务
    String DoTask="health/user/verify/v1/doTask";
    //领取任务奖励
    String GetTask="health/user/verify/v1/receiveReward";
    //查询用户任务列表
    String QueryTaskList="health/user/verify/v1/findUserTaskList";
    //我的病友圈
    String MyCircle="health/user/sickCircle/verify/v1/findMySickCircleList";
    //查询我的病友圈帖子的评论列表
    String MyCircleCommentent="health/user/sickCircle/verify/v1/findMySickCircleCommentList";
    //修改昵称
    String SetName="health/user/verify/v1/modifyNickName";
    //根据ID查询用户信息
    String UserInfo="health/user/verify/v1/getUserInfoById";
    //修改性别
    String SetSex="health/user/verify/v1/updateUserSex";
    //修改密码
    String SetPwd="health/user/verify/v1/updateUserPwd";
    //完善用户信息
    String SetSign="health/user/verify/v1/perfectUserInfo";
}
