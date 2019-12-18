package com.wd.health.mode;

import com.wd.common.utils.HttpUtils;
import com.wd.health.api.HttpApi;
import com.wd.health.bean.EmailBean;
import com.wd.health.bean.LoginBean;
import com.wd.health.bean.RegisterBean;
import com.wd.health.bean.WXLoginBean;
import com.wd.health.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @name Health
 * @class name：com.wd.main.mode
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 8:01
 * @change
 * @chang time
 * @class describe
 */
public class APPHome implements Contract.IModer {
    @Override
    public void onRegister(String email, String code, String pwd1, String pwd2, String invitationCode, Contract.IModer.IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onRegister(email, code, pwd1, pwd2, invitationCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(registerBean);
                        }
                    }
                });
    }

    @Override
    public void onLogin(String email, String pwd, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onLogin(email, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(loginBean);
                        }
                    }
                });
    }

    @Override
    public void onWXLogin(String code, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onWXLogin(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WXLoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(WXLoginBean wxLoginBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(wxLoginBean);
                        }
                    }
                });
    }

    @Override
    public void onEmail(String email, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onEmail(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EmailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(EmailBean emailBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(emailBean);
                        }
                    }
                });
    }
}
