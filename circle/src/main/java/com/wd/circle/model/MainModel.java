package com.wd.circle.model;


import android.util.Log;

import com.wd.circle.api.HttpApi;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.LoginBean;
import com.wd.circle.contract.Contract;
import com.wd.common.utils.HttpUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 9:12
 * @change
 * @chang time
 * @class describe
 */
public class MainModel implements Contract.IModer {

    @Override
    public void onLogin(String email, String pwd, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onLogin(email, pwd)
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
                        if (iBallBask!=null){
                            iBallBask.onHttpOK(loginBean);
                        }
                    }
                });
    }

    @Override
    public void onhome(IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onListBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Circle_list_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: "+e);
                    }

                    @Override
                    public void onNext(Circle_list_Bean circle_list_bean) {
                        if (iBallBask!=null){
                            iBallBask.onHttpOK(circle_list_bean);
                        }
                    }
                });
    }

    @Override
    public void onhomes(int departmentId, int page, int count, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onListsBean(departmentId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Circle_lists_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Circle_lists_Bean circle_lists_bean) {
                        if (circle_lists_bean!=null){
                            iBallBask.onHttpOK(circle_lists_bean);
                        }
                    }
                });
    }
}
