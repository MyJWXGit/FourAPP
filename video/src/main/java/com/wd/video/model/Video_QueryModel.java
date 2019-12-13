package com.wd.video.model;

import com.wd.common.utils.HttpUtils;
import com.wd.video.api.HttpApi;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class Video_QueryModel implements Contract.FModel {
    @Override
    public void onVideo_Query(String userId, String sessionId, String categoryId, String page, String count, FModelCallBack fModelCallBack) {
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
                        if (fModelCallBack!=null) {
                            fModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Video_QueryBean video_queryBean) {
                        if (fModelCallBack!=null) {
                            fModelCallBack.onSuccess(video_queryBean);
                        }
                    }
                });
    }
}
