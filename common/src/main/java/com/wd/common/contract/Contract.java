package com.wd.common.contract;


import com.wd.common.base.IBaseView;

public interface Contract {
    //接口回调  IBaseView
    interface IView extends IBaseView {
        void onSuccess(Object obj);

        void onError(Throwable e);
    }

    //Activity  P层方法
    interface IPresenter extends IBaseView {
        void getDate(String trim, String s);
    }

    //Activity  M层
    interface IModer {
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }


    //Fragment  P层方法
    interface FPresenter extends IBaseView {

    }

    //Fragment  M层
    interface FModer {

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
