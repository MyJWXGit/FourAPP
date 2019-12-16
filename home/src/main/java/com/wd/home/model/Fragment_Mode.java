package com.wd.home.model;

import com.wd.common.utils.HttpUtils;
import com.wd.home.api.HttpApi;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.bean.DyugBean;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.bean.IllnessBean;
import com.wd.home.contract.Contract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @class describe
 * @anthor 24673
 * @time 2019/12/16 10:03
 * @change
 * @chang time
 * @class describe
 */
public class Fragment_Mode implements Contract.FModer {
    @Override
    public void onDepartment_F(IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onDepartment_F()
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DepartmentBean>() {
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
                    public void onNext(DepartmentBean departmentBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(departmentBean);
                        }
                    }
                });
    }

    @Override
    public void onCategory(int departmentId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onCategory(departmentId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryBean>() {
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
                    public void onNext(CategoryBean categoryBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(categoryBean);
                        }
                    }
                });
    }

    @Override
    public void onDyug(int id, IBallBask iBallBask) {
//HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onDyug(id)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DyugBean>() {
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
                    public void onNext(DyugBean dyugBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(dyugBean);
                        }
                    }
                });
    }

    @Override
    public void onCategoryList(IBallBask iBallBask) {
//HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onCategoryList()
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryListBean>() {
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
                    public void onNext(CategoryListBean categoryListBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(categoryListBean);
                        }
                    }
                });
    }

    @Override
    public void onDrugsKnowledgeList(int drugsCategoryId, int page, int count, IBallBask iBallBask) {
//HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onDrugsKnowledgeList(drugsCategoryId, page, count)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DrugsKnowledgeListBean>() {
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
                    public void onNext(DrugsKnowledgeListBean drugsKnowledgeListBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(drugsKnowledgeListBean);
                        }
                    }
                });
    }

    @Override
    public void onIllness(int id, IBallBask iBallBask) {
//HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onIllness(id)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IllnessBean>() {
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
                    public void onNext(IllnessBean illnessBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(illnessBean);
                        }
                    }
                });
    }
}
