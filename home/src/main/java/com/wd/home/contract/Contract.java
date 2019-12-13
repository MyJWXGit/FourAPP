package com.wd.home.contract;


import com.wd.common.base.IBaseView;

public interface Contract {
    //接口回调  IBaseView
    interface IView extends IBaseView {
        void onSuccess(Object obj);

        void onError(Throwable e);
    }

    //Activity  P层方法
    interface IPresenter {
        //注册
        void onRegister(String email, String code, String pwd1, String pwd2, String invitationCode);

        //登录
        void onLogin(String email, String pwd);
    }

    //Activity  M层
    interface IModer {
        //注册
        void onRegister(String email, String code, String pwd1, String pwd2, String invitationCode, IBallBask iBallBask);

        //登录
        void onLogin(String email, String pwd, IBallBask iBallBask);

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }

    //Fragment  P层方法
    interface FPresenter {

    }

    //Fragment  M层
    interface FModer {

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
