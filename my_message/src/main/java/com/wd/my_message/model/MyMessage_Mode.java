package com.wd.my_message.model;

import com.wd.common.utils.HttpUtils;
import com.wd.my_message.api.My_MessageHttpApi;
import com.wd.my_message.bean.AttentionDoctorListBean;
import com.wd.my_message.bean.ConsumptionRecordBean;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.bean.ImageBean;
import com.wd.my_message.bean.InquiryMessageBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.bean.QuerySignBean;
import com.wd.my_message.bean.SignBean;
import com.wd.my_message.bean.SuggestBean;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.bean.UnAttentionDoctorBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;
import com.wd.my_message.contract.Contract;

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
}