package com.wd.video.model;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.HttpUtils;
import com.wd.video.api.HttpApi;
import com.wd.video.bean.Video_CollectionBean;
import com.wd.video.bean.Video_PayBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.bean.Video_Query_BarrageBean;
import com.wd.video.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*
 *author:郭昊坤
 *date:2019/12/17
 *function:*/public class Video_QueryFModel implements Contract.FModel {
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
                        if (iModelCallBack != null) {
                            iModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Video_QueryBean video_queryBean) {
                        if (iModelCallBack != null) {
                            iModelCallBack.onSuccess(video_queryBean);
                        }
                    }
                });

    }

    @Override
    public void onVideo_Pay(String userId, String sessionId, String videoId, String price, FModelCallBack fModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .getVideo_Pay(userId, sessionId,videoId,price)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Video_PayBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (fModelCallBack != null) {
                            fModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Video_PayBean video_payBean) {
                        if (fModelCallBack != null) {
                            fModelCallBack.onSuccess(video_payBean);
                        }
                    }
                });

    }

    @Override
    public void onVideo_Query_Barrage(String videoId, FModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .getVideo_Query_Barrage(videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Video_Query_BarrageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallBack!=null){
                            iModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Video_Query_BarrageBean video_query_barrageBean) {
                        if (iModelCallBack!=null){
                            iModelCallBack.onSuccess(video_query_barrageBean);
                        }
                    }
                });
    }

    @Override
    public void onVideo_Collection(String userId, String sessionId, String videoId, FModelCallBack iModelCallBack) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .getVideo_Collection(userId, sessionId, videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Video_CollectionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallBack!=null){
                            iModelCallBack.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Video_CollectionBean video_collectionBean) {
                        if (iModelCallBack!=null){
                            iModelCallBack.onSuccess(video_collectionBean);
                        }
                    }
                });
    }
}
