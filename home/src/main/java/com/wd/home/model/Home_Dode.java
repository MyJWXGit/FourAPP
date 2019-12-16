package com.wd.home.model;


import com.wd.common.utils.HttpUtils;
import com.wd.home.api.HttpApi;
import com.wd.home.bean.LoginBean;
import com.wd.home.bean.RegisterBean;
import com.wd.home.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * @name Health
 * @class name：com.wd.home.model
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 18:54
 * @change
 * @chang time
 * @class describe
 */
public class Home_Dode implements Contract.IModer {
    @Override
    public void onRegister(String email, String code, String pwd1, String pwd2, String invitationCode, IBallBask iBallBask) {
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

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {

                    }
                });
    }

    @Override
    public void onLogin(String email, String pwd, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onLogin(email, pwd)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                    }
                });
    }
}
