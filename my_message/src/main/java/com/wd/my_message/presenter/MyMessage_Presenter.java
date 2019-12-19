package com.wd.my_message.presenter;

import com.wd.common.base.BasePresenter;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.model.MyMessage_Mode;

/**
 * @name Health
 * @class name：com.wd.my_message.presenter
 * @class describe
 * @anthor 24673
 * @time 2019/12/19 13:34
 * @change
 * @chang time
 * @class describe
 */
public class MyMessage_Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private MyMessage_Mode myMessage_mode;

    @Override
    protected void initModel() {
        myMessage_mode = new MyMessage_Mode();
    }

    @Override
    public void onUserIdCard(int userId, String sessionId, int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice) {

    }

    @Override
    public void onUserBankCard(int userId, String sessionId, String bankCardNumber, String bankName, String bankCardType) {

    }
}
