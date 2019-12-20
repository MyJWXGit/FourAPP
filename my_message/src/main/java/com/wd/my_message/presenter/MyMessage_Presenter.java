package com.wd.my_message.presenter;

import com.wd.common.api.Constant;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.common.utils.SpUtils;
import com.wd.my_message.APP;
import com.wd.my_message.bean.ImageBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.model.MyMessage_Mode;

import okhttp3.MultipartBody;

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
    private static final String TAG = "MyMessage_Presenter";

    @Override
    protected void initModel() {
        myMessage_mode = new MyMessage_Mode();
    }

    @Override
    public void onUserIdCard(int userIdBoby, String name, String sex, String nation, String birthday, String address, String idNumber, String issueOffice) {

    }

    @Override
    public void onUserBankCard(String bankCardNumber, String bankName, String bankCardType) {

    }

    @Override
    public void onImage_PIC(MultipartBody.Part part) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionId = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        myMessage_mode.onImage_PIC(userId, sessionId, part, new Contract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Object data) {
                if (isViewAttached()) {
                    ImageBean bean = (ImageBean) data;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        getView().onSuccess(bean);
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
}
