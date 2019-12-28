package com.wd.my_message.contract;

import com.wd.common.base.IBaseView;

import okhttp3.MultipartBody;

/**
 * @name Health
 * @class name：com.wd.my_message.contract
 * @class describe
 * @anthor 24673
 * @time 2019/12/19 9:49
 * @change
 * @chang time
 * @class describe
 */
public interface Contract {

    interface IView extends IBaseView {
        void onSuccess(Object data);

        void onError(Throwable e);
    }

    interface IModel {
        //绑定身份证
        void onUserIdCard(int userId, String sessionId, int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice, IModelCallBack iModelCallBack);

        //绑定（换绑）银行卡信息
        void onUserBankCard(int userId, String sessionId, String bankCardNumber, String bankName, String bankCardType, IModelCallBack iModelCallBack);

        //上传头像
        void onImage_PIC(int userId, String sessionId, MultipartBody.Part part, IModelCallBack iModelCallBack);

        //收藏 我的病友圈
        void onUserSickCollection(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //收藏 我的视频
        void onUserVideo(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //收藏 健康咨询资讯
        void onUserCollection(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //系统消息 查询用户系统通知列表
        void onSystemmessage(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //问诊消息
        void onGetinquiry(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //查询用户H币通知列表
        void onGetcurrency(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //wode我的钱包
        void onGetmyWallet(int userId, String sessionId, IModelCallBack iModelCallBack);

        //查询我的关注的医生列表
        void onAttentionDoctorList(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //取消关注医生
        void onUnAttentionDoctor(int userId, String sessionId, int doctorId, IModelCallBack iModelCallBack);

        //消费记录
        void onRecordsOfConsumption(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //签到
        void onSign(int userId, String sessionId, IModelCallBack iModelCallBack);

        //查询是否签到
        void onQueryUserSign(int userId, String sessionId, IModelCallBack iModelCallBack);

        //查询我的被采纳的信息
        void onMySuggest(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack);

        //用户查看当前问诊
        void onInquiryRecord(int userId, String sessionId, IModelCallBack iBallBask);

        //结束问诊
        void onEndInquiry(int userId, String sessionId, int recordId, IModelCallBack iBallBask);

        interface IModelCallBack {
            void onSuccess(Object data);

            void onError(Throwable e);
        }
    }

    interface IPresenter {
        //绑定身份证
        void onUserIdCard(int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice);

        //绑定（换绑）银行卡信息
        void onUserBankCard(String bankCardNumber, String bankName, String bankCardType);

        //上传头像
        void onImage_PIC(MultipartBody.Part part);

        //收藏 我的病友圈
        void onUserSickCollection(int page, int count);

        //收藏 我的视频
        void onUserVideo(int page, int count);

        //收藏 健康咨询资讯
        void onUserCollection(int page, int count);

        //系统消息 查询用户系统通知列表
        void onSystemmessage(int page, int count);

        //问诊消息
        void onGetinquiry(int page, int count);

        //查询用户H币通知列表
        void onGetcurrency(int page, int count);

        //wode我的钱包
        void onGetmyWallet();

        //消费记录
        void onRecordsOfConsumption(int page, int count);

        //查询我的关注的医生列表
        void onAttentionDoctorList(int page, int count);

        //取消关注医生
        void onUnAttentionDoctor(int doctorId);

        //签到
        void onSign();

        //查询是否签到
        void onQueryUserSign();

        //查询我的被采纳的信息
        void onMySuggest(int page, int count);

        //用户查看当前问诊
        void onInquiryRecord();

        //结束问诊
        void onEndInquiry(int recordId);
    }

    //Fragment   M
    interface FModel {
        //收藏 我的病友圈
        void onUserSickCollection(int userId, String sessionId, int page, int count, FModelCallBack fModelCallBack);

        //收藏 我的视频
        void onUserVideo(int userId, String sessionId, int page, int count, FModelCallBack fModelCallBack);

        //收藏 健康咨询资讯
        void onUserCollection(int userId, String sessionId, int page, int count, FModelCallBack fModelCallBack);

        //删除病友圈
        void onDeleteCollection(int userId, String sessionId, int sickCircleId, FModelCallBack fModelCallBack);

        interface FModelCallBack {
            void onSuccess(Object data);

            void onError(Throwable e);
        }
    }

    //Fragment P
    interface FPresenter {
        //收藏 我的病友圈
        void onUserSickCollection(int page, int count);

        //收藏 我的视频
        void onUserVideo(int page, int count);

        //收藏 健康咨询资讯
        void onUserCollection(int page, int count);

        //删除病友圈
        void onDeleteCollection(int sickCircleId);
    }
}
