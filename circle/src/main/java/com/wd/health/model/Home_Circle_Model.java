package com.wd.health.model;

import com.wd.health.api.HttpApi;
import com.wd.health.bean.Circle_lists_Bean;
import com.wd.health.bean.SearchCircleBean;
import com.wd.health.contract.Contract;
import com.wd.common.utils.HttpUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/18 15:04
 * @change
 * @chang time
 * @class describe
 */
public class Home_Circle_Model implements Contract.FModer {
    @Override
    public void onhomes(int departmentId, int page, int count, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onListsBean(departmentId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Circle_lists_Bean>() {
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
                    public void onNext(Circle_lists_Bean circle_lists_bean) {
                        if (circle_lists_bean != null) {
                            iBallBask.onHttpOK(circle_lists_bean);
                        }
                    }
                });
    }

    @Override
    public void onSearch(String keyWord, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onSearchBean(keyWord)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SearchCircleBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchCircleBean searchCircleBean) {
                        if (searchCircleBean != null) {
                            iBallBask.onHttpOK(searchCircleBean);
                        }
                    }
                });
    }
}
