package com.wd.circle.model;


import android.util.Log;

import com.wd.circle.api.HttpApi;
import com.wd.circle.bean.Circle_Comment_Bean;
import com.wd.circle.bean.Circle_Details_Bean;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.CommentBean;
import com.wd.circle.bean.DiseaseBean;
import com.wd.circle.bean.DoTaskBean;
import com.wd.circle.bean.LoginBean;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.bean.UserTaskListBean;
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
                        if (searchCircleBean!=null){
                            iBallBask.onHttpOK(searchCircleBean);
                        }
                    }
                });
    }

    @Override
    public void onDetails(int sickCircleId, String userId, String sessionId, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onDetailsBean(sickCircleId, userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Circle_Details_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Circle_Details_Bean circle_details_bean) {
                        if (circle_details_bean!=null){
                            iBallBask.onHttpOK(circle_details_bean);
                        }
                    }
                });
    }

    @Override
    public void onComment(int sickCircleId, String userId, String sessionId, String content, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onCommentBean(userId, sessionId, sickCircleId, content)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CommentBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CommentBean commentBean) {
                        if (commentBean!=null){
                            iBallBask.onHttpOK(commentBean);
                        }
                    }
                });
    }

    @Override
    public void onCircleComment(int sickCircleId, String userId, String sessionId, int count, int page, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onCircleCommentBean(userId, sessionId, sickCircleId, count, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Circle_Comment_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Circle_Comment_Bean circle_comment_bean) {
                        if (circle_comment_bean!=null){
                            iBallBask.onHttpOK(circle_comment_bean);
                        }
                    }
                });
    }

    @Override
    public void onDoTask(String userId, String sessionId, int taskId, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onDoTaskBean(userId, sessionId, taskId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DoTaskBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DoTaskBean doTaskBean) {
                        if (doTaskBean!=null){
                            iBallBask.onHttpOK(doTaskBean);
                        }
                    }
                });
    }

    @Override
    public void onUserTaskList(String userId, String sessionId, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onUserTaskListBean(userId, sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserTaskListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserTaskListBean userTaskListBean) {
                        if (userTaskListBean!=null){
                            iBallBask.onHttpOK(userTaskListBean);
                        }
                    }
                });
    }

    @Override
    public void onDisease(int departmentId, IBallBask iBallBask) {
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                .onDiseaseBean(departmentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiseaseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DiseaseBean diseaseBean) {
                        if (diseaseBean!=null){
                            iBallBask.onHttpOK(diseaseBean);
                        }
                    }
                });
    }


}
