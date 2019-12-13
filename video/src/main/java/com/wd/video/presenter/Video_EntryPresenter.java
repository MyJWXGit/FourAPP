package com.wd.video.presenter;

import android.content.Context;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.video.bean.Video_EntryBean;
import com.wd.video.contract.Contract;
import com.wd.video.model.Video_EntryModel;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class Video_EntryPresenter extends BasePresenter<Contract.IView> implements com.wd.video.contract.Contract.IPresenter {

    private static final String TAG = "Video_EntryPresenter";
    private Video_EntryModel video_entryModel;

    @Override
    protected void initModel() {
        video_entryModel = new Video_EntryModel();
    }

    @Override
    public void onVideo_Entry() {
        video_entryModel.onVideo_Entry(new com.wd.video.contract.Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    Video_EntryBean video_entryBean = (Video_EntryBean) data;
                    if (video_entryBean!=null&&video_entryBean.getStatus().equals("0000")){
                        getView().onSuccess(video_entryBean);
                    }else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    Logger.d(TAG,e.getMessage()+"");
                }
            }
        });
    }
}
