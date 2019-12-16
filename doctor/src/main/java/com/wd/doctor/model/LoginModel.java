package com.wd.doctor.model;



import com.wd.common.utils.HttpUtils;
import com.wd.doctor.api.ApiService;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.InquiryBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.bean.PatientsBean;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.StreamBean;
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
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

    @Override
    public void Mian(int doctorId, String sessionId, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Mian(doctorId,sessionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MianBean>() {
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
                    public void onNext(MianBean mianBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(mianBean);
                        }
                    }
                });
    }
    //根据关键词查询病友圈
    @Override
    public void Streanm(String keyWord, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Stram(keyWord)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<StreamBean>() {
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
                    public void onNext(StreamBean streamBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(streamBean);
                        }
                    }
                });
    }
     //查询病友圈详情
    @Override
    public void Details(int doctorId, String sessionId, int sickCircleId, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Detals(doctorId,sessionId,sickCircleId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DetailsBean>() {
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
                    public void onNext(DetailsBean detailsBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(detailsBean);
                        }
                    }
                });
    }


    @Override
    public void Inquer(IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(ApiService.class)
                .Inquiry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InquiryBean>() {
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
                    public void onNext(InquiryBean inquiryBean) {
                        //成功的方法
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(inquiryBean);
                        }
                    }
                });
    }
}
