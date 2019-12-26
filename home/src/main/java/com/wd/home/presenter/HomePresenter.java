package com.wd.home.presenter;

import android.content.Context;

import com.wd.common.api.Constant;
import com.wd.common.app.BaseApplication;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.common.utils.SpUtils;
import com.wd.home.APP;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.ConsultBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.bean.HomeSearchBean;
import com.wd.home.bean.Information_ListBean;
import com.wd.home.bean.InquiryRecordBean;
import com.wd.home.bean.Plate_ListBean;
import com.wd.home.bean.PopularBean;
import com.wd.home.bean.PuMessageBean;
import com.wd.home.bean.RecordingBean;
import com.wd.home.contract.Contract;
import com.wd.home.model.Home_Dode;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 19:07
 * @change
 * @chang time
 * @class describe
 */
public class HomePresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private Home_Dode home_dode;
    private static final String TAG = "HomePresenter";
    public Context context;

    //创建你的Mode层  进行全局变量，使用全局变量进行调用Mode层方法
    @Override
    protected void initModel() {
        home_dode = new Home_Dode();
    }

    @Override
    public void onBanner() {
        home_dode.onBanner(new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    BannerBean bean = (BannerBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onDepartment() {
        home_dode.onDepartment(new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    DepartmentBean bean = (DepartmentBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onPlateList() {
        home_dode.onPlateList(new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    Plate_ListBean bean = (Plate_ListBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onInformationList(int plateId, int page, int count) {
        home_dode.onInformationList(plateId, page, count, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    Information_ListBean bean = (Information_ListBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onFindInfo(int infoId) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        home_dode.onFindInfo(userId, sessionid, infoId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    FindInfoBean bean = (FindInfoBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onHomeSearch(String keyWord) {
        home_dode.onHomeSearch(keyWord, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    HomeSearchBean bean = (HomeSearchBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onPopular() {
        home_dode.onPopular(new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    PopularBean bean = (PopularBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onPuMessage(int inquiryId, String content, int type, int doctorId) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionId = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        home_dode.onPuMessage(userId, sessionId, inquiryId, content, 1, doctorId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    PuMessageBean bean = (PuMessageBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }


    @Override
    public void getRecording(int inquiryId, int page, int count) {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionId = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        home_dode.getRecording(userId, sessionId, inquiryId, page, count, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    RecordingBean bean = (RecordingBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

    @Override
    public void onEndInquiry() {

    }


    @Override
    public void onInquiryRecord() {
        int userId = (int) SpUtils.get(APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(APP.context, Constant.SESSIONID, "");
        home_dode.onInquiryRecord(userId, sessionid, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    InquiryRecordBean bean = (InquiryRecordBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {//失败的方法
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }

}
