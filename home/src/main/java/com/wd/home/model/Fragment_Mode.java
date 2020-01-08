package com.wd.home.model;

import com.wd.common.utils.HttpUtils;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.ConsultBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.bean.DyugBean;
import com.wd.home.bean.EvaluateListBean;
import com.wd.home.bean.FollowBean;
import com.wd.home.bean.IllnessBean;
import com.wd.home.bean.CancelFllowBean;
import com.wd.home.bean.DoctorInfoBean;
import com.wd.home.bean.DoctorListBean;
import com.wd.home.bean.UserWalletBean;
import com.wd.home.api.Home_HttpApi;
import com.wd.home.bean.EndInquiryBean;
import com.wd.home.bean.InquiryRecordBean;
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
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
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
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
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
    public void onDiseaseKnowledge(int id, IBallBask iBallBask) {
//HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onDiseaseKnowledge(id)
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
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
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
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
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
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
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

    @Override
    public void onDoctorList(int deptId, int condition, int page, int count, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onDoctorList(deptId, condition, page, count)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DoctorListBean>() {
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
                    public void onNext(DoctorListBean doctorListBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(doctorListBean);
                        }
                    }
                });
    }

    @Override
    public void onDoctorInfo(int userId, String sessionId, String doctorId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onDoctorInfo(userId, sessionId, doctorId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DoctorInfoBean>() {
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
                    public void onNext(DoctorInfoBean doctorInfoBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(doctorInfoBean);
                        }
                    }
                });
    }

    @Override
    public void onFollow(int userId, String sessionId, int doctorId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onFollow(userId, sessionId, doctorId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FollowBean>() {
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
                    public void onNext(FollowBean followBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(followBean);
                        }
                    }
                });
    }

    @Override
    public void onCancelFollow(int userId, String sessionId, int doctorId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onCancelFollow(userId, sessionId, doctorId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CancelFllowBean>() {
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
                    public void onNext(CancelFllowBean cancelFllowBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(cancelFllowBean);
                        }
                    }
                });
    }

    @Override
    public void onUserWallet(int userId, String sessionId, IBallBask iBallBask) {
//HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onUserWallet(userId, sessionId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserWalletBean>() {
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
                    public void onNext(UserWalletBean userWalletBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(userWalletBean);
                        }
                    }
                });
    }

    @Override
    public void onEvaluateList(int doctorId, int page, int count, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onEvaluateList(doctorId, page, count)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EvaluateListBean>() {
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
                    public void onNext(EvaluateListBean evaluateListBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(evaluateListBean);
                        }
                    }
                });
    }

    @Override
    public void getConsult(int userId, String sessionId, int doctorId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .getConsult(userId, sessionId, doctorId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConsultBean>() {
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
                    public void onNext(ConsultBean consultBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(consultBean);
                        }
                    }
                });
    }

    @Override
    public void onEndInquiry(int userId, String sessionId, int recordId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onEndInquiry(userId, sessionId, recordId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<com.wd.home.bean.EndInquiryBean>() {
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
                    public void onNext(EndInquiryBean endInquiryBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(endInquiryBean);
                        }
                    }
                });
    }

    @Override
    public void onInquiryRecord(int userId, String sessionId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(Home_HttpApi.class)
                //你要跑的接口方法
                .onInquiryRecord(userId, sessionId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<com.wd.home.bean.InquiryRecordBean>() {
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
                    public void onNext(InquiryRecordBean inquiryRecordBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(inquiryRecordBean);
                        }
                    }
                });
    }
}
