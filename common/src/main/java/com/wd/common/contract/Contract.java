package com.wd.common.contract;


import com.wd.common.base.IBaseView;

public interface Contract {

    interface IView extends IBaseView {
        void onSuccess(Object obj);

        void onError(Throwable e);
    }


    interface IPresenter {

    }


    interface IModer {
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }

    interface FModer {

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
