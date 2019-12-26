package com.wd.my_message.model;

import com.wd.common.utils.HttpUtils;
import com.wd.my_message.api.My_MessageHttpApi;
import com.wd.my_message.bean.DeleteCollectionBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.bean.VideoCollectionBean;
import com.wd.my_message.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 15:21
 * @change
 * @chang time
 * @class describe
 */
public class MyFragmentMessage_Model implements Contract.FModel {
    @Override
    public void onUserSickCollection(int userId, String sessionId, int page, int count, FModelCallBack fModelCallBack) {
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
                        if (userSickCollectionBean!=null){
                            fModelCallBack.onSuccess(userSickCollectionBean);
                        }
                    }
                });
    }

    @Override
    public void onUserVideo(int userId, String sessionId, int page, int count, FModelCallBack fModelCallBack) {
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
                        if (videoCollectionBean!=null){
                            fModelCallBack.onSuccess(videoCollectionBean);
                        }
                    }
                });
    }

    @Override
    public void onUserCollection(int userId, String sessionId, int page, int count, FModelCallBack fModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onUserCollection(userId, sessionId, page, count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
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
                            fModelCallBack.onSuccess(userColletionBean);
                        }
                    }
                });
    }

    @Override
    public void onDeleteCollection(int userId, String sessionId, int sickCircleId, FModelCallBack fModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(My_MessageHttpApi.class)
                .onDeleteCollection(userId, sessionId, sickCircleId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeleteCollectionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DeleteCollectionBean deleteCollectionBean) {
                        if (deleteCollectionBean!=null){
                            fModelCallBack.onSuccess(deleteCollectionBean);
                        }
                    }
                });
    }
}
