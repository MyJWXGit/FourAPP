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
    }


    //Activity  M层
    interface IModer {
        void onLogin(String email, String pwd, IBallBask iBallBask);
        void onhome(IBallBask iBallBask);
        void onhomes(int departmentId,int page,int count,IBallBask iBallBask);
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
