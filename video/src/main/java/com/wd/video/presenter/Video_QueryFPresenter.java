package com.wd.video.presenter;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;
import com.wd.video.model.Video_QueryFModel;

/*
 *author:郭昊坤
 *date:2019/12/17
 *function:*/public class Video_QueryFPresenter extends BasePresenter<Contract.IView> implements Contract.FPresenter {

    private static final String TAG = "Video_QueryFPresenter";
    private Video_QueryFModel video_queryFModel;
    private String userId = "444";
    private String sessionId = "1575979881047444";

    @Override
    protected void initModel() {
        video_queryFModel = new Video_QueryFModel();
    }

    public void onVideo_Query(String categoryId, String page, String count) {
        video_queryFModel.onVideo_Query(userId, sessionId, categoryId, page, count, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    Video_QueryBean video_queryBean = (Video_QueryBean) data;
                    if (video_queryBean != null && video_queryBean.getStatus().equals("0000")) {
                        getView().onSuccess(video_queryBean);
                    } else {
                        getView().onError(new Exception("请求失败"));
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
    }
