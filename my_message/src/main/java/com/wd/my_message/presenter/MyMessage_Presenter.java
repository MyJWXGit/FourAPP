package com.wd.my_message.presenter;

import com.wd.common.api.Constant;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.common.utils.SpUtils;
import com.wd.my_message.Message_APP;
import com.wd.my_message.bean.HistoryBean;
import com.wd.my_message.bean.SetPwdBean;
import com.wd.my_message.bean.SetSexBean;
import com.wd.my_message.bean.SetSignBean;
import com.wd.my_message.bean.Set_NameBean;
import com.wd.my_message.bean.User_InfoBean;
import com.wd.my_message.model.MyMessage_Mode;
import com.wd.my_message.bean.AddArchivesBean;
import com.wd.my_message.bean.AttentionDoctorListBean;
import com.wd.my_message.bean.ConsumptionRecordBean;
import com.wd.my_message.bean.EndInquiryBean;
import com.wd.my_message.bean.DeleteArchivesBean;
import com.wd.my_message.bean.DoTaskBean;
import com.wd.my_message.bean.GetTaskBean;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.bean.ImageBean;
import com.wd.my_message.bean.InquiryMessageBean;
import com.wd.my_message.bean.InquiryRecordBean;
import com.wd.my_message.bean.LianxuSignBean;
import com.wd.my_message.bean.MySickCircleCommentListBean;
import com.wd.my_message.bean.MySickCircleListBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.bean.QuerySignBean;
import com.wd.my_message.bean.QueryTaskListBean;
import com.wd.my_message.bean.SignBean;
import com.wd.my_message.bean.SuggestBean;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.bean.UnAttentionDoctorBean;
import com.wd.my_message.bean.UpdateArchivesBean;
import com.wd.my_message.bean.UserArchivesBean;
import com.wd.my_message.bean.UserArchivesPictureBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;
import com.wd.my_message.contract.Contract;

import java.util.Map;

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
    public void onUserBankCard(String bankCardNumber, String bankName, String bankCardType) {

    }

    @Override
    public void onImage_PIC(MultipartBody.Part part) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionId = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, 0);
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, 0);
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
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
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
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
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onRecordsOfConsumption(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onRecordsOfConsumption(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    ConsumptionRecordBean consumptionRecordBean = (ConsumptionRecordBean) data;
                    if (consumptionRecordBean != null) {
                        getView().onSuccess(consumptionRecordBean);
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
    public void onAttentionDoctorList(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onAttentionDoctorList(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    AttentionDoctorListBean attentionDoctorListBean = (AttentionDoctorListBean) data;
                    if (attentionDoctorListBean != null) {
                        getView().onSuccess(attentionDoctorListBean);
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
    public void onUnAttentionDoctor(int doctorId) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onUnAttentionDoctor(userId, sessionid, doctorId, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    UnAttentionDoctorBean unAttentionDoctorBean = (UnAttentionDoctorBean) data;
                    if (unAttentionDoctorBean != null) {
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

    @Override
    public void onSign() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onSign(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    SignBean signBean = (SignBean) data;
                    if (signBean != null) {
                        getView().onSuccess(signBean);
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
    public void onQueryUserSign() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onQueryUserSign(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    QuerySignBean querySignBean = (QuerySignBean) data;
                    if (querySignBean != null) {
                        getView().onSuccess(querySignBean);
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
    public void onLianxuSign() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onLianxuSign(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    LianxuSignBean lianxuSignBean = (LianxuSignBean) data;
                    if (lianxuSignBean != null) {
                        getView().onSuccess(lianxuSignBean);
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
    public void onMySuggest(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onMySuggest(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    SuggestBean suggestBean = (SuggestBean) data;
                    if (suggestBean != null) {
                        getView().onSuccess(suggestBean);
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
    public void onInquiryRecord() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onInquiryRecord(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    InquiryRecordBean inquiryRecordBean = (InquiryRecordBean) data;
                    if (inquiryRecordBean != null) {
                        getView().onSuccess(inquiryRecordBean);
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
    public void onEndInquiry(int recordId) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onEndInquiry(userId, sessionid, recordId, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    EndInquiryBean endInquiryBean = (EndInquiryBean) data;
                    if (endInquiryBean != null) {
                        getView().onSuccess(endInquiryBean);
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
    public void onMyFile() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onMyFile(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    UserArchivesBean userArchivesBean = (UserArchivesBean) data;
                    if (userArchivesBean != null) {
                        getView().onSuccess(userArchivesBean);
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
    public void onDeleteFile(int archivesId) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onDeleteFile(userId, sessionid, archivesId, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    DeleteArchivesBean deleteArchivesBean = (DeleteArchivesBean) data;
                    if (deleteArchivesBean != null) {
                        getView().onSuccess(deleteArchivesBean);
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
    public void onUpdateFile(Map<String, Object> map) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onUpdateFile(userId, sessionid, map, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    UpdateArchivesBean updateArchivesBean = (UpdateArchivesBean) data;
                    if (updateArchivesBean != null) {
                        getView().onSuccess(updateArchivesBean);
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
    public void onInsertFile(Map<String, Object> map) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onInsertFile(userId, sessionid, map, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    AddArchivesBean addArchivesBean = (AddArchivesBean) data;
                    if (addArchivesBean != null) {
                        getView().onSuccess(addArchivesBean);
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
    public void onUploadPiture(MultipartBody.Part picture) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onUploadPiture(userId, sessionid, picture, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    UserArchivesPictureBean userArchivesPictureBean = (UserArchivesPictureBean) data;
                    if (userArchivesPictureBean != null) {
                        getView().onSuccess(userArchivesPictureBean);
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
    public void onDoTask(int taskId) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onDoTask(userId, sessionid, taskId, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    DoTaskBean doTaskBean = (DoTaskBean) data;
                    if (doTaskBean != null) {
                        getView().onSuccess(doTaskBean);
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
    public void onGetTask(int taskId) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onGetTask(userId, sessionid, taskId, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    GetTaskBean getTaskBean = (GetTaskBean) data;
                    if (getTaskBean != null) {
                        getView().onSuccess(getTaskBean);
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
    public void onQueryTaskList() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onQueryTaskList(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    QueryTaskListBean queryTaskListBean = (QueryTaskListBean) data;
                    if (queryTaskListBean != null) {
                        getView().onSuccess(queryTaskListBean);
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
    public void onMyCircle(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onMyCircle(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    MySickCircleListBean mySickCircleListBean = (MySickCircleListBean) data;
                    if (mySickCircleListBean != null) {
                        getView().onSuccess(mySickCircleListBean);
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
    public void onMyCircleComment(int sickCircleId, int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onMyCircleComment(userId, sessionid, sickCircleId, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    MySickCircleCommentListBean mySickCircleCommentListBean = (MySickCircleCommentListBean) data;
                    if (mySickCircleCommentListBean != null) {
                        getView().onSuccess(mySickCircleCommentListBean);
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
    public void onHistory(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onHistory(userId, sessionid, page, count, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    HistoryBean historyBean = (HistoryBean) data;
                    if (historyBean != null) {
                        getView().onSuccess(historyBean);
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

    public void onSet_Name(String nickName) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onSet_Name(userId, sessionid, nickName, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    Set_NameBean set_nameBean = (Set_NameBean) data;
                    if (set_nameBean != null) {
                        getView().onSuccess(set_nameBean);
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


    public void onUser_Info() {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onUser_Info(userId, sessionid, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    User_InfoBean user_infoBean = (User_InfoBean) data;
                    if (user_infoBean != null) {
                        getView().onSuccess(user_infoBean);
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


    public void onSet_Sex(int sex) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onSet_Sex(userId, sessionid, sex, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    SetSexBean setSexBean = (SetSexBean) data;
                    if (setSexBean != null) {
                        getView().onSuccess(setSexBean);
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


    public void onSet_Pwd(String oldPwd, String newPwd) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onSet_Pwd(userId, sessionid, oldPwd, newPwd, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    SetPwdBean setPwdBean = (SetPwdBean) data;
                    if (setPwdBean != null) {
                        getView().onSuccess(setPwdBean);
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


    public void onSet_Sign(int age, int height, int weight) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myMessage_mode.onSet_Sign(userId, sessionid, age, height, weight, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    SetSignBean setSignBean = (SetSignBean) data;
                    if (setSignBean != null) {
                        getView().onSuccess(setSignBean);
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
