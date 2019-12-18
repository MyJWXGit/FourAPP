package com.wd.health.presenter;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.health.bean.EmailBean;
import com.wd.health.bean.LoginBean;
import com.wd.health.bean.RegisterBean;
import com.wd.health.bean.WXLoginBean;
import com.wd.health.contract.Contract;
import com.wd.health.mode.APPHome;

/**
 * @name Health
 * @class name：com.wd.main.presenter
 * @class describe
 * @anthor 24673
 * @time 2019/12/17 22:08
 * @change
 * @chang time
 * @class describe
 */
public class MainPresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private APPHome APPHome;
    private static final String TAG = "MainPresenter";

    @Override
    protected void initModel() {
        APPHome = new APPHome();
    }

    @Override
    public void onRegister(String email, String code, String pwd1, String pwd2, String invitationCode) {
        APPHome.onRegister(email, code, pwd1, pwd2, invitationCode, new Contract.IModer.IBallBask() {
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
        APPHome.onLogin(email, pwd, new Contract.IModer.IBallBask() {
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

    @Override
    public void onWXLogin(String code) {
        APPHome.onWXLogin(code, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    WXLoginBean bean = (WXLoginBean) obj;
//                    if (bean != null && bean.getStatus().equals("0000")) {
//                        //getView是BasePresenter方法  使用getView进行调用P层
//                        getView().onSuccess(bean);
//                    } else {
//                        getView().onError(new Exception("请求失败"));
//                    }
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
    public void onEmail(String email) {
        APPHome.onEmail(email, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    EmailBean bean = (EmailBean) obj;
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
