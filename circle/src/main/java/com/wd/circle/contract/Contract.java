package com.wd.circle.contract;


import com.wd.common.base.IBaseView;

import java.util.Map;

import okhttp3.MultipartBody;

public interface Contract {
    //接口回调  IBaseView
    interface IView extends IBaseView {
        void onSuccess(Object obj);

        void onError(Throwable e);
    }

    //Activity  P层方法
    interface IPresenter extends IBaseView {
        void onLogin(String email, String pwd);
        void onHome();
        void onHomes(int departmentId,int page,int count);
        void onSearch(String keyWord);
        void onDetails(int sickCircleId,String userId,String sessionId);
        void onComment(int sickCircleId,String userId,String sessionId, String content);
        void onCircleComment(int sickCircleId,String userId,String sessionId,int count,int page);
        void onDoTask(String userId,String sessionId,int taskId);
        void onUserTaskList(String userId,String sessionId);
        void onDisease(int departmentId);
        void onReplease(String userId, String sessionId, Map<String, Object> map);
        void onPicture(String userId, String sessionId, int sickCircleId, MultipartBody.Part part);
    }


    //Activity  M层
    interface IModer {
        void onLogin(String email, String pwd, IBallBask iBallBask);
        void onhome(IBallBask iBallBask);
        void onhomes(int departmentId,int page,int count,IBallBask iBallBask);
        void onSearch(String keyWord,IBallBask iBallBask);
        void onDetails(int sickCircleId,String userId,String sessionId,IBallBask iBallBask);
        void onComment(int sickCircleId,String userId,String sessionId, String content,IBallBask iBallBask);
        void onCircleComment(int sickCircleId,String userId,String sessionId,int count,int page,IBallBask iBallBask);
        void onDoTask(String userId,String sessionId,int taskId,IBallBask iBallBask);
        void onUserTaskList(String userId,String sessionId,IBallBask iBallBask);
        void onDisease(int departmentId,IBallBask iBallBask);
        void onReplease(String userId, String sessionId, Map<String, Object> map,IBallBask iBallBask);
        void onPicture(String userId, String sessionId, int sickCircleId, MultipartBody.Part part,IBallBask iBallBask);
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }


    //Fragment  P层方法
    interface FPresenter extends IBaseView {
        void onHomes(int departmentId,int page,int count);
        void onSearch(String keyWord);
    }

    //Fragment  M层
    interface FModer {
        void onhomes(int departmentId,int page,int count,IBallBask iBallBask);
        void onSearch(String keyWord,IBallBask iBallBask);
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
