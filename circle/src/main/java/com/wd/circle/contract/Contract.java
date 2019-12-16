package com.wd.circle.contract;


import com.wd.common.base.IBaseView;

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
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }


    //Fragment  P层方法
    interface FPresenter extends IBaseView {
        void onLogin(String ms);
    }

    //Fragment  M层
    interface FModer {

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
