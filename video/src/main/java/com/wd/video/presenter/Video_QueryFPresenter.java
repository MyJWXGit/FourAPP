package com.wd.video.presenter;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.video.bean.Video_CollectionBean;
import com.wd.video.bean.Video_PayBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.bean.Video_Query_BarrageBean;
import com.wd.video.bean.Video_SendBean;
import com.wd.video.contract.Contract;
import com.wd.video.model.Video_QueryFModel;

/*
 *author:郭昊坤
 *date:2019/12/17
 *function:*/public class Video_QueryFPresenter extends BasePresenter<Contract.IView> implements Contract.FPresenter {

    private static final String TAG = "Video_QueryFPresenter";
    private Video_QueryFModel video_queryFModel;
    private String userId = "444";
    private String sessionId = "1577150365428444";

    @Override
    protected void initModel() {
        video_queryFModel = new Video_QueryFModel();
    }

    public void onVideo_Query(String categoryId, String page, String count) {
        video_queryFModel.onVideo_Query(userId, sessionId, categoryId, page, count, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                Video_QueryBean video_queryBean = (Video_QueryBean) data;
                if (video_queryBean != null && video_queryBean.getStatus().equals("0000")) {
                    getView().onSuccess(video_queryBean);
                } else {
                    getView().onError(new Exception("请求失败"));
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

    @Override
    public void onVideo_Collection(String videoId) {
        video_queryFModel.onVideo_Collection(userId, sessionId, videoId, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    Video_CollectionBean video_collectionBean = (Video_CollectionBean) data;
                    getView().onSuccess(video_collectionBean);
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

    @Override
    public void onVideo_Query_Barrage(String videoId) {
        video_queryFModel.onVideo_Query_Barrage(videoId, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    Video_Query_BarrageBean video_query_barrageBean = (Video_Query_BarrageBean) data;
                    if (video_query_barrageBean != null && video_query_barrageBean.getStatus().equals("0000")) {
                        getView().onSuccess(video_query_barrageBean);
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

    @Override
    public void onVideo_Pay(String videoId, String price) {
        video_queryFModel.onVideo_Pay(userId, sessionId, videoId, price, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    Video_PayBean video_payBean = (Video_PayBean) data;
                    getView().onSuccess(video_payBean);
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

    @Override
    public void onVideo_Send(String videoId, String content) {
        video_queryFModel.onVideo_Send(userId, sessionId, videoId, content, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    Video_SendBean video_sendBean = (Video_SendBean) data;
                    getView().onSuccess(video_sendBean);
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
