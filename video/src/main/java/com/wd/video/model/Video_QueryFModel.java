package com.wd.video.model;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.HttpUtils;
import com.wd.video.api.HttpApi;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*
 *author:郭昊坤
 *date:2019/12/17
 *function:*/public class Video_QueryFModel implements Contract.FModel {
    @Override
    public void onVideo_Query(String userId, String sessionId, String categoryId, String page, String count, FModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .getViewo_Query(userId, sessionId, categoryId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Video_QueryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallBack!=null) {
                            iModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Video_QueryBean video_queryBean) {
                        if (iModelCallBack!=null) {
                            iModelCallBack.onSuccess(video_queryBean);
                        }
                    }
                });

    }
}
