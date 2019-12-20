package com.wd.my_message.model;

import com.wd.common.utils.HttpUtils;
import com.wd.my_message.api.HttpApi;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.bean.InquiryMessageBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;
import com.wd.my_message.contract.Contract;

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
    public void onUserSickCollection(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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
                        if (userSickCollectionBean!=null){
                            iModelCallBack.onSuccess(userSickCollectionBean);
                        }
                    }
                });
    }

    @Override
    public void onUserVideo(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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
                        if (videoCollectionBean!=null){
                            iModelCallBack.onSuccess(videoCollectionBean);
                        }
                    }
                });
    }

    @Override
    public void onUserCollection(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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
                        if (userColletionBean!=null){
                            iModelCallBack.onSuccess(userColletionBean);
                        }
                    }
                });
    }

    @Override
    public void onSystemmessage(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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
                        if (systemMessageBean!=null){
                            iModelCallBack.onSuccess(systemMessageBean);
                        }
                    }
                });
    }

    @Override
    public void onGetinquiry(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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
                        if (inquiryMessageBean!=null){
                            iModelCallBack.onSuccess(inquiryMessageBean);
                        }
                    }
                });
    }

    @Override
    public void onGetcurrency(int userId, String sessionId, int page, int count, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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
                        if (healthyCurrencyBean!=null){
                            iModelCallBack.onSuccess(healthyCurrencyBean);
                        }
                    }
                });
    }

    @Override
    public void onGetmyWallet(int userId, String sessionId, IModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .getmyWallet(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyWalletBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyWalletBean myWalletBean) {
                        if (myWalletBean!=null){
                            iModelCallBack.onSuccess(myWalletBean);
                        }
                    }
                });
    }
}
