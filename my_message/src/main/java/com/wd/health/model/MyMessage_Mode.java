package com.wd.health.model;

import android.util.Log;

import com.wd.common.utils.HttpUtils;
import com.wd.health.api.My_MessageHttpApi;
import com.wd.health.bean.AddArchivesBean;
import com.wd.health.bean.AttentionDoctorListBean;
import com.wd.health.bean.ConsumptionRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.DeleteArchivesBean;
import com.wd.health.bean.DoTaskBean;
import com.wd.health.bean.GetTaskBean;
import com.wd.health.bean.HealthyCurrencyBean;
import com.wd.health.bean.HistoryBean;
import com.wd.health.bean.ImageBean;
import com.wd.health.bean.InquiryMessageBean;
import com.wd.health.bean.InquiryRecordBean;
import com.wd.health.bean.LianxuSignBean;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.bean.QuerySignBean;
import com.wd.health.bean.QueryTaskListBean;
import com.wd.health.bean.SetPwdBean;
import com.wd.health.bean.SetSexBean;
import com.wd.health.bean.SetSignBean;
import com.wd.health.bean.Set_NameBean;
import com.wd.health.bean.SignBean;
import com.wd.health.bean.SuggestBean;
import com.wd.health.bean.SystemMessageBean;
import com.wd.health.bean.UnAttentionDoctorBean;
import com.wd.health.bean.UpdateArchivesBean;
import com.wd.health.bean.UserArchivesBean;
import com.wd.health.bean.UserArchivesPictureBean;
import com.wd.health.bean.UserColletionBean;
import com.wd.health.bean.UserSickCollectionBean;
import com.wd.health.bean.User_InfoBean;
import com.wd.health.bean.VideoCollectionBean;
import com.wd.health.contract.Contract;

import java.util.Map;

import okhttp3.MultipartBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @name Health
 * @class name：com.wd.my_message.model
 * @class describe
 * @anthor 24673
 * @time 2019/12/19 9:52
 * @change
 * @chang time
 * @class describe
 */
public class MyMessage_Mode implements Contract.IModel {
    @Override
    public void onUserIdCard(int userId, String sessionId, int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice, IModelCallBack iModelCallBack) {

    }

    @Override
    public void onUserBankCard(int userId, String sessionId, String bankCardNumber, String bankName, String bankCardType, IModelCallBack iModelCallBack) {

    }


    @Override
    public void onImage_PIC(int userId, String sessionId, MultipartBody.Part part, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onImage_PIC(userId, sessionId, part)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallBack != null) {
                            iModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        if (iModelCallBack != null) {
                            iModelCallBack.onSuccess(imageBean);
                        }
                    }
                });
    }

    @Override
    public void onUserSickCollection(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onUserSickCollection(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserSickCollectionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserSickCollectionBean userSickCollectionBean) {
                        if (userSickCollectionBean != null) {
                            iModelCallBack.onSuccess(userSickCollectionBean);
                        }
                    }
                });
    }

    @Override
    public void onUserVideo(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onVideoBean(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoCollectionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(VideoCollectionBean videoCollectionBean) {
                        if (videoCollectionBean != null) {
                            iModelCallBack.onSuccess(videoCollectionBean);
                        }
                    }
                });
    }

    @Override
    public void onUserCollection(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onUserCollection(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserColletionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserColletionBean userColletionBean) {
                        if (userColletionBean != null) {
                            iModelCallBack.onSuccess(userColletionBean);
                        }
                    }
                });
    }

    @Override
    public void onSystemmessage(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getsystemmessage(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SystemMessageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SystemMessageBean systemMessageBean) {
                        if (systemMessageBean != null) {
                            iModelCallBack.onSuccess(systemMessageBean);
                        }
                    }
                });
    }

    @Override
    public void onGetinquiry(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getinquiry(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InquiryMessageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(InquiryMessageBean inquiryMessageBean) {
                        if (inquiryMessageBean != null) {
                            iModelCallBack.onSuccess(inquiryMessageBean);
                        }
                    }
                });
    }

    @Override
    public void onGetcurrency(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getcurrency(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HealthyCurrencyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HealthyCurrencyBean healthyCurrencyBean) {
                        if (healthyCurrencyBean != null) {
                            iModelCallBack.onSuccess(healthyCurrencyBean);
                        }
                    }
                });
    }

    @Override
    public void onGetmyWallet(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getmyWallet(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyWalletBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallBack != null) {
                            iModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(MyWalletBean myWalletBean) {
                        if (myWalletBean != null) {
                            iModelCallBack.onSuccess(myWalletBean);
                        }
                    }
                });
    }


    @Override
    public void onAttentionDoctorList(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onAttentionDoctorListBean(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AttentionDoctorListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AttentionDoctorListBean attentionDoctorListBean) {
                        if (attentionDoctorListBean != null) {
                            iModelCallBack.onSuccess(attentionDoctorListBean);
                        }
                    }
                });
    }

    @Override
    public void onUnAttentionDoctor(int userId, String sessionId, int doctorId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onUnAttentionDoctorBean(userId, sessionId, doctorId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UnAttentionDoctorBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UnAttentionDoctorBean unAttentionDoctorBean) {
                        if (unAttentionDoctorBean != null) {
                            iModelCallBack.onSuccess(unAttentionDoctorBean);
                        }
                    }
                });
    }

    @Override
    public void onRecordsOfConsumption(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getconsumptionRecord(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ConsumptionRecordBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ConsumptionRecordBean consumptionRecordBean) {
                        if (consumptionRecordBean != null) {
                            iModelCallBack.onSuccess(consumptionRecordBean);
                        }
                    }
                });
    }

    @Override
    public void onSign(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onSignBean(userId, sessionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SignBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SignBean signBean) {
                        if (signBean != null) {
                            iModelCallBack.onSuccess(signBean);
                        }
                    }
                });
    }

    @Override
    public void onQueryUserSign(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onQueryUserSignBean(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QuerySignBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(QuerySignBean querySignBean) {
                        if (querySignBean != null) {
                            iModelCallBack.onSuccess(querySignBean);
                        }
                    }
                });
    }

    @Override
    public void onLianxuSign(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onLianxuSignBean(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LianxuSignBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LianxuSignBean lianxuSignBean) {
                        if (lianxuSignBean != null) {
                            iModelCallBack.onSuccess(lianxuSignBean);
                        }
                    }
                });
    }

    @Override
    public void onMySuggest(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onSuggestBean(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SuggestBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SuggestBean suggestBean) {
                        if (suggestBean != null) {
                            iModelCallBack.onSuccess(suggestBean);
                        }
                    }
                });
    }

    @Override
    public void onInquiryRecord(int userId, String sessionId, IModelCallBack iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                //你要跑的接口方法
                .onInquiryRecord(userId, sessionId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InquiryRecordBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onError(e);
                        }
                    }

                    @Override
                    public void onNext(InquiryRecordBean inquiryRecordBean) {
                        if (iBallBask != null) {
                            iBallBask.onSuccess(inquiryRecordBean);
                        }
                    }
                });
    }

    @Override
    public void onEndInquiry(int userId, String sessionId, int recordId, IModelCallBack iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                //你要跑的接口方法
                .onEndInquiry(userId, sessionId, recordId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EndInquiryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onError(e);
                        }
                    }

                    @Override
                    public void onNext(EndInquiryBean endInquiryBean) {
                        if (iBallBask != null) {
                            iBallBask.onSuccess(endInquiryBean);
                        }
                    }
                });
    }

    @Override
    public void onMyFile(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getarchives(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserArchivesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserArchivesBean userArchivesBean) {
                        if (userArchivesBean != null) {
                            iModelCallBack.onSuccess(userArchivesBean);
                        }
                    }
                });
    }

    @Override
    public void onDeleteFile(int userId, String sessionId, int archivesId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getdeleteUserArchives(userId, sessionId, archivesId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DeleteArchivesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DeleteArchivesBean deleteArchivesBean) {
                        if (deleteArchivesBean != null) {
                            iModelCallBack.onSuccess(deleteArchivesBean);
                        }
                    }
                });
    }

    @Override
    public void onUpdateFile(int userId, String sessionId, Map<String, Object> map, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getupdateUserArchives(userId, sessionId, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpdateArchivesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdateArchivesBean updateArchivesBean) {
                        if (updateArchivesBean != null) {
                            iModelCallBack.onSuccess(updateArchivesBean);
                        }
                    }
                });
    }

    @Override
    public void onInsertFile(int userId, String sessionId, Map<String, Object> map, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getaddUserArchives(userId, sessionId, map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddArchivesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AddArchivesBean addArchivesBean) {
                        if (addArchivesBean != null) {
                            iModelCallBack.onSuccess(addArchivesBean);
                        }
                    }
                });
    }

    @Override
    public void onUploadPiture(int userId, String sessionId, MultipartBody.Part picture, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getpicture(userId, sessionId, picture)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserArchivesPictureBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserArchivesPictureBean userArchivesPictureBean) {
                        if (userArchivesPictureBean != null) {
                            iModelCallBack.onSuccess(userArchivesPictureBean);
                        }
                    }
                });
    }

    @Override
    public void onDoTask(int userId, String sessionId, int taskId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onDoTaskBean(userId, sessionId, taskId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DoTaskBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DoTaskBean doTaskBean) {
                        if (doTaskBean != null) {
                            iModelCallBack.onSuccess(doTaskBean);
                        }
                    }
                });
    }

    @Override
    public void onGetTask(int userId, String sessionId, int taskId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onGetTaskBean(userId, sessionId, taskId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTaskBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GetTaskBean getTaskBean) {
                        if (getTaskBean != null) {
                            iModelCallBack.onSuccess(getTaskBean);
                        }
                    }
                });
    }

    @Override
    public void onQueryTaskList(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onQueryTaskBean(userId, sessionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<QueryTaskListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(QueryTaskListBean queryTaskListBean) {
                        if (queryTaskListBean != null) {
                            iModelCallBack.onSuccess(queryTaskListBean);
                        }
                    }
                });
    }

    @Override
    public void onMyCircle(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getMySickCircleList(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MySickCircleListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MySickCircleListBean mySickCircleListBean) {
                        if (mySickCircleListBean != null) {
                            iModelCallBack.onSuccess(mySickCircleListBean);
                        }
                    }
                });
    }

    @Override
    public void onMyCircleComment(int userId, String sessionId, int sickCircleId, int page, int count, IModelCallBack iModelCallBac) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .getMySickCircleCommentList(userId, sessionId, sickCircleId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MySickCircleCommentListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MySickCircleCommentListBean mySickCircleCommentListBean) {
                        if (mySickCircleCommentListBean != null) {
                            iModelCallBac.onSuccess(mySickCircleCommentListBean);
                        }
                    }
                });
    }

    @Override
    public void onHistory(int userId, String sessionId, int page, int count, IModelCallBack iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                //你要跑的接口方法
                .onHistory(userId, sessionId, page, count)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HistoryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onError(e);
                        }
                    }

                    @Override
                    public void onNext(HistoryBean historyBean) {
                        if (iBallBask != null) {
                            iBallBask.onSuccess(historyBean);
                        }
                    }
                });
    }

    public void onSet_Name(int userId, String sessionId, String nickName, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onSet_Name(userId, sessionId, nickName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Set_NameBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: " + e);
                    }

                    @Override
                    public void onNext(Set_NameBean set_nameBean) {
                        if (set_nameBean != null) {
                            iModelCallBack.onSuccess(set_nameBean);
                        }
                    }
                });
    }


    public void onUser_Info(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onUser_Info(userId, sessionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User_InfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: " + e);
                    }

                    @Override
                    public void onNext(User_InfoBean user_infoBean) {
                        if (user_infoBean != null) {
                            iModelCallBack.onSuccess(user_infoBean);
                        }
                    }
                });
    }


    public void onSet_Sex(int userId, String sessionId, int sex, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onSet_Sex(userId, sessionId, sex)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SetSexBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: " + e);
                    }

                    @Override
                    public void onNext(SetSexBean setSexBean) {
                        if (setSexBean != null) {
                            iModelCallBack.onSuccess(setSexBean);
                        }
                    }
                });
    }


    public void onSet_Pwd(int userId, String sessionId, String oldPwd, String newPwd, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onSet_Pwd(userId, sessionId, oldPwd, newPwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SetPwdBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: " + e);
                    }

                    @Override
                    public void onNext(SetPwdBean setPwdBean) {
                        if (setPwdBean != null) {
                            iModelCallBack.onSuccess(setPwdBean);
                        }
                    }
                });
    }


    public void onSet_Sign(int userId, String sessionId, int age, int height, int weight, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onSet_Sign(userId, sessionId, age, height, weight)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SetSignBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: " + e);
                    }

                    @Override
                    public void onNext(SetSignBean setSignBean) {
                        if (setSignBean != null) {
                            iModelCallBack.onSuccess(setSignBean);
                        }
                    }
                });
    }

}