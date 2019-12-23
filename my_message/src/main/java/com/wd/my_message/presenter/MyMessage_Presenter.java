package com.wd.my_message.presenter;

import com.wd.common.api.Constant;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.common.utils.SpUtils;
import com.wd.my_message.APP;
import com.wd.my_message.bean.ImageBean;
import com.wd.common.utils.HttpUtils;
import com.wd.common.utils.SpUtils;
import com.wd.my_message.APP;
import com.wd.my_message.api.HttpApi;
import com.wd.my_message.bean.AttentionDoctorListBean;
import com.wd.my_message.bean.ConsumptionRecordBean;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.bean.InquiryMessageBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.bean.UnAttentionDoctorBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.model.MyMessage_Mode;

import okhttp3.MultipartBody;

/**
 * @name Health
 * @class name：com.wd.my_message.presenter
 * @class describe
 * @anthor 24673
 * @time 2019/12/19 13:34
 * @change
 * @chang time
 * @class describe
 */
public class MyMessage_Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private MyMessage_Mode myMessage_mode;
    private static final String TAG = "MyMessage_Presenter";

    @Override
    protected void initModel() {
        myMessage_mode = new MyMessage_Mode();
    }

    @Override
    public void onUserIdCard(int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice) {

    }

    @Override
    public void onUserBankCard( String bankCardNumber, String bankName, String bankCardType) {

    }

    @Override
    public void onImage_PIC(MultipartBody.Part part) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionId = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onImage_PIC(userId, sessionId, part, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    ImageBean bean = (ImageBean) data;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onUserSickCollection(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, 0);
        myMessage_mode.onUserSickCollection(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    UserSickCollectionBean userSickCollectionBean = (UserSickCollectionBean) data;
                    if (userSickCollectionBean != null) {
                        getView().onSuccess(userSickCollectionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onUserVideo(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, 0);
        myMessage_mode.onUserVideo(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    VideoCollectionBean videoCollectionBean = (VideoCollectionBean) data;
                    if (videoCollectionBean != null) {
                        getView().onSuccess(videoCollectionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onUserCollection(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onUserCollection(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    UserColletionBean userColletionBean = (UserColletionBean) data;
                    if (userColletionBean != null) {
                        getView().onSuccess(userColletionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onSystemmessage(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onSystemmessage(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    SystemMessageBean systemMessageBean = (SystemMessageBean) data;
                    if (systemMessageBean != null) {
                        getView().onSuccess(systemMessageBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onGetinquiry(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onGetinquiry(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    InquiryMessageBean inquiryMessageBean = (InquiryMessageBean) data;
                    if (inquiryMessageBean != null) {
                        getView().onSuccess(inquiryMessageBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onGetcurrency(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onGetcurrency(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    HealthyCurrencyBean healthyCurrencyBean = (HealthyCurrencyBean) data;
                    if (healthyCurrencyBean != null) {
                        getView().onSuccess(healthyCurrencyBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onGetmyWallet() {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onGetmyWallet(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    MyWalletBean myWalletBean = (MyWalletBean) data;
                    if (myWalletBean != null) {
                        getView().onSuccess(myWalletBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onRecordsOfConsumption(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onRecordsOfConsumption(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    ConsumptionRecordBean consumptionRecordBean= (ConsumptionRecordBean) data;
                    if (consumptionRecordBean!=null)
                    {
                        getView().onSuccess(consumptionRecordBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onAttentionDoctorList(int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onAttentionDoctorList(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    AttentionDoctorListBean attentionDoctorListBean= (AttentionDoctorListBean) data;
                    if (attentionDoctorListBean!=null){
                        getView().onSuccess(attentionDoctorListBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onUnAttentionDoctor(int doctorId) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onUnAttentionDoctor(userId, sessionid, doctorId, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    UnAttentionDoctorBean unAttentionDoctorBean= (UnAttentionDoctorBean) data;
                    if (unAttentionDoctorBean!=null){
                        getView().onSuccess(unAttentionDoctorBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }
}
