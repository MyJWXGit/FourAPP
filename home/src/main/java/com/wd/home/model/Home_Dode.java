package com.wd.home.model;


import com.wd.common.utils.HttpUtils;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.bean.HomeSearchBean;
import com.wd.home.bean.Information_ListBean;
import com.wd.home.bean.Plate_ListBean;
import com.wd.home.bean.PopularBean;
import com.wd.home.bean.PuMessageBean;
import com.wd.home.bean.RecordingBean;
import com.wd.home.api.HttpApi;
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
 * @time 2019/12/12 18:54
 * @change
 * @chang time
 * @class describe
 */
public class Home_Dode implements Contract.IModer {
    @Override
    public void onBanner(IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onBanner()
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
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
                    public void onNext(BannerBean bannerBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(bannerBean);
                        }
                    }
                });
    }

    @Override
    public void onDepartment(IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onDepartment()
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
    public void onPlateList(IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onPlate_list()
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Plate_ListBean>() {
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
                    public void onNext(Plate_ListBean plate_listBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(plate_listBean);
                        }
                    }
                });
    }

    @Override
    public void onInformationList(int plateId, int page, int count, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onInformation_list(plateId, page, count)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Information_ListBean>() {
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
                    public void onNext(Information_ListBean information_listBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(information_listBean);
                        }
                    }
                });
    }

    @Override
    public void onFindInfo(int userId, String sessionId, int infoId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onFindInfo(userId, sessionId, infoId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindInfoBean>() {
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
                    public void onNext(FindInfoBean findInfoBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(findInfoBean);
                        }
                    }
                });
    }

    @Override
    public void onHomeSearch(String keyWord, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onHomeSearch(keyWord)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeSearchBean>() {
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
                    public void onNext(HomeSearchBean homeSearchBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(homeSearchBean);
                        }
                    }
                });
    }

    @Override
    public void onPopular(IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onPopular()
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PopularBean>() {
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
                    public void onNext(PopularBean popularBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(popularBean);
                        }
                    }
                });
    }

    @Override
    public void onPuMessage(int userId, String sessionId, int inquiryId, String content, int type, int doctorId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .onPuMessage(userId, sessionId, inquiryId, content, type, doctorId)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PuMessageBean>() {
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
                    public void onNext(PuMessageBean popularBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(popularBean);
                        }
                    }
                });
    }


    @Override
    public void getRecording(int userId, String sessionId, int inquiryId, int page, int count, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
                //你要跑的接口方法
                .getRecording(userId, sessionId, inquiryId, page, count)
                //切换线程
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecordingBean>() {
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
                    public void onNext(RecordingBean recordingBean) {
                        if (iBallBask != null) {
                            iBallBask.onHttpOK(recordingBean);
                        }
                    }
                });
    }


    @Override
    public void onInquiryRecord(int userId, String sessionId, IBallBask iBallBask) {
        //HttpUtil是网络封装类                        HttpApi是写注解的接口
        HttpUtils.getHttpUtils().getRetrofit().create(HttpApi.class)
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