package com.wd.home.presenter;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.home.bean.LoginBean;
import com.wd.home.bean.RegisterBean;
import com.wd.home.contract.Contract;
import com.wd.home.model.Home_Dode;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 19:07
 * @change
 * @chang time
 * @class describe
 */
public class HomePresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private Home_Dode home_dode;
    private static final String TAG = "HomePresenter";

    //创建你的Mode层  进行全局变量，使用全局变量进行调用Mode层方法
    @Override
    protected void initModel() {
        home_dode = new Home_Dode();
    }

    @Override
    public void onRegister(String email, String code, String pwd1, String pwd2, String invitationCode) {
        home_dode.onRegister(email, code, pwd1, pwd2, invitationCode, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    RegisterBean bean = (RegisterBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法

                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onLogin(String email, String pwd) {
        home_dode.onLogin(email, pwd, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    LoginBean bean = (LoginBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }


}
