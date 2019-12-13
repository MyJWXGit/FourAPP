package com.wd.video.model;

import com.wd.common.utils.HttpUtils;
import com.wd.common.utils.HttpUtils666;
import com.wd.common.utils.Logger;
import com.wd.video.api.HttpApi;
import com.wd.video.bean.Video_EntryBean;
import com.wd.video.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class Video_EntryModel implements Contract.IModel {
    private static final String TAG = "Video_EntryModel";
    @Override
    //查询视频类目
    public void onVideo_Entry(IModelCallBack iModelCallBack) {
        HttpUtils666.getHttpUtils().getRetrofit().create(HttpApi.class)
                .getVideo_Entry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Video_EntryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallBack != null) {
                            iModelCallBack.onError(e);
                        }
                        Logger.d(TAG,e.getMessage());
                    }

                    @Override
                    public void onNext(Video_EntryBean video_entryBean) {
                        if (iModelCallBack != null) {
                            iModelCallBack.onSuccess(video_entryBean);
                        }
                    }
                });
    }
}
