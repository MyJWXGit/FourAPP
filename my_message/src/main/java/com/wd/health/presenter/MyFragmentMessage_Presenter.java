package com.wd.health.presenter;

import com.wd.common.api.Constant;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.SpUtils;
import com.wd.health.Message_APP;
import com.wd.health.model.MyFragmentMessage_Model;
import com.wd.health.bean.DeleteCollectionBean;
import com.wd.health.bean.UserColletionBean;
import com.wd.health.bean.UserSickCollectionBean;
import com.wd.health.bean.VideoCollectionBean;
import com.wd.health.contract.Contract;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 15:11
 * @change
 * @chang time
 * @class describe
 */
public class MyFragmentMessage_Presenter extends BasePresenter<Contract.IView> implements Contract.FPresenter {

    private MyFragmentMessage_Model myFragmentMessage_model;

    @Override
    protected void initModel() {
        myFragmentMessage_model = new MyFragmentMessage_Model();
    }

    @Override
    public void onUserSickCollection(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myFragmentMessage_model.onUserSickCollection(userId, sessionid, page, count, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    UserSickCollectionBean userSickCollectionBean= (UserSickCollectionBean) data;
                    if (userSickCollectionBean!=null){
                        getView().onSuccess(userSickCollectionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onUserVideo(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myFragmentMessage_model.onUserVideo(userId, sessionid, page, count, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    VideoCollectionBean videoCollectionBean= (VideoCollectionBean) data;
                    if (videoCollectionBean!=null){
                        getView().onSuccess(videoCollectionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onUserCollection(int page, int count) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myFragmentMessage_model.onUserCollection(userId, sessionid, page, count, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    UserColletionBean userColletionBean= (UserColletionBean) data;
                    if (userColletionBean!=null){
                        getView().onSuccess(userColletionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onDeleteCollection(int sickCircleId) {
        int userId = (int) SpUtils.get(Message_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Message_APP.context, Constant.SESSIONID, "");
        myFragmentMessage_model.onDeleteCollection(userId, sessionid, sickCircleId, new Contract.FModel.FModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()){
                    DeleteCollectionBean deleteCollectionBean= (DeleteCollectionBean) data;
                    if (deleteCollectionBean!=null){
                        getView().onSuccess(deleteCollectionBean);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }
}
