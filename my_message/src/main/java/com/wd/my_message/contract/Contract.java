package com.wd.my_message.contract;

import com.wd.common.base.IBaseView;

/**
 * @name Health
 * @class name：com.wd.my_message.contract
 * @class describe
 * @anthor 24673
 * @time 2019/12/19 9:49
 * @change
 * @chang time
 * @class describe
 */
public interface Contract {

    interface IView extends IBaseView {
        void onSuccess(Object data);

        void onError(Throwable e);
    }

    interface IModel {
        //绑定身份证
        void onUserIdCard(int userId, String sessionId, int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice, IModelCallBack iModelCallBack);

        //绑定（换绑）银行卡信息
        void onUserBankCard(int userId, String sessionId, String bankCardNumber, String bankName, String bankCardType, IModelCallBack iModelCallBack);

        interface IModelCallBack {
            void onSuccess(Object data);

            void onError(Throwable e);
        }
    }

    interface IPresenter {
        //绑定身份证
        void onUserIdCard(int userId, String sessionId, int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice);

        //绑定（换绑）银行卡信息
        void onUserBankCard(int userId, String sessionId, String bankCardNumber, String bankName, String bankCardType);

    }

    //Fragment   M
    interface FModel {
        interface FModelCallBack {
            void onSuccess(Object data);

            void onError(Throwable e);
        }
    }

    //Fragment P
    interface FPresenter {

    }
}
