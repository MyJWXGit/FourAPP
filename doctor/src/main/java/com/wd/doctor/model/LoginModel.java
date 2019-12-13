package com.wd.doctor.model;



import com.wd.common.utils.HttpUtils;
import com.wd.doctor.api.ApiService;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.VerifyBean;
import com.wd.doctor.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * date:2019/11/6
 * author:金豪(Lenovo)
 * function:
 */
public class LoginModel implements Contract.IModer {


//注册
    @Override
    public void onRegister(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Register(email,code,pwd1,pwd2,name,inauguralHospital,departmentName,jobTitle,personalProfile,goodField)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //失败的方法
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
    public void Send(String email,IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Send(email)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SendBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //失败的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(SendBean sendBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(sendBean);
                        }
                    }
                });
    }
    //检验验证码
    @Override
    public void Verif(String email, String code, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Verif(email,code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VerifyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //失败的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpNO(e);
                        }
                    }

                    @Override
                    public void onNext(VerifyBean verifyBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(verifyBean);
                        }

                    }
                });
    }

    @Override
    public void onLogin(String email, String pwd, IBallBask iBallBask) {
           HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                   .login(email,pwd)
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribeOn(Schedulers.io())
                   .subscribe(new Observer<LoginBean>() {
                       @Override
                       public void onCompleted() {

                       }

                       @Override
                       public void onError(Throwable e) {
                           //失败的方法
                           if (iBallBask != null) {
                               iBallBask.onHttpNO(e);
                           }
                       }

                       @Override
                       public void onNext(LoginBean loginBean) {
                           //成功的方法
                           if (iBallBask != null) {
                               iBallBask.onHttpOK(loginBean);
                           }
                       }
                   });
    }
}
