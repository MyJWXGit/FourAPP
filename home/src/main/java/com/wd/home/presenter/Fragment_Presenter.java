package com.wd.home.presenter;

import com.wd.common.api.Constant;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.common.utils.SpUtils;
import com.wd.home.bean.ConsultBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.bean.DyugBean;
import com.wd.home.bean.EvaluateListBean;
import com.wd.home.bean.FollowBean;
import com.wd.home.Home_APP;
import com.wd.home.bean.CancelFllowBean;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.DoctorInfoBean;
import com.wd.home.bean.DoctorListBean;
import com.wd.home.bean.EndInquiryBean;
import com.wd.home.bean.IllnessBean;
import com.wd.home.bean.UserWalletBean;
import com.wd.home.model.Fragment_Mode;
import com.wd.home.bean.InquiryRecordBean;
import com.wd.home.contract.Contract;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @class describe
 * @anthor 24673
 * @time 2019/12/16 10:02
 * @change
 * @chang time
 * @class describe
 */
public class Fragment_Presenter extends BasePresenter<Contract.IView> implements Contract.FPresenter {

    private Fragment_Mode home_dode;
    private static final String TAG = "Fragment_Presenter";

    @Override
    protected void initModel() {
        home_dode = new Fragment_Mode();
    }

    @Override
    public void onDepartment() {
        home_dode.onDepartment_F(new com.wd.home.contract.Contract.FModer.IBallBask() {
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
    public void onCategory(int departmentId) {
        home_dode.onCategory(departmentId, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    CategoryBean bean = (CategoryBean) obj;
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
    public void onDiseaseKnowledge(int id) {
        home_dode.onDiseaseKnowledge(id, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    DyugBean bean = (DyugBean) obj;
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
    public void onCategoryList() {
        home_dode.onCategoryList(new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    CategoryListBean bean = (CategoryListBean) obj;
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
    public void onDrugsKnowledgeList(int drugsCategoryId, int page, int count) {
        home_dode.onDrugsKnowledgeList(drugsCategoryId, page, count, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    DrugsKnowledgeListBean bean = (DrugsKnowledgeListBean) obj;
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
    public void onIllness(int id) {
        home_dode.onIllness(id, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    IllnessBean bean = (IllnessBean) obj;
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
    public void onDoctorList(int deptId, int condition, int page, int count) {
        home_dode.onDoctorList(deptId, condition, page, count, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    DoctorListBean bean = (DoctorListBean) obj;
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
    public void onDoctorInfo(String doctorId) {
        int userId = (int) SpUtils.get(Home_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Home_APP.context, Constant.SESSIONID, "");
        home_dode.onDoctorInfo(userId, sessionid, doctorId, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    DoctorInfoBean bean = (DoctorInfoBean) obj;
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
    public void onFollow(int doctorId) {
        int userId = (int) SpUtils.get(Home_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Home_APP.context, Constant.SESSIONID, "");
        home_dode.onFollow(userId, sessionid, doctorId, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    FollowBean bean = (FollowBean) obj;
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
    public void onCancelFollow(int doctorId) {
        int userId = (int) SpUtils.get(Home_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Home_APP.context, Constant.SESSIONID, "");
        home_dode.onCancelFollow(userId, sessionid, doctorId, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    CancelFllowBean bean = (CancelFllowBean) obj;
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
    public void onUserWallet() {
        int userId = (int) SpUtils.get(Home_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Home_APP.context, Constant.SESSIONID, "");
        home_dode.onUserWallet(userId, sessionid, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    UserWalletBean bean = (UserWalletBean) obj;
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
    public void onEvaluateList(int doctorId, int page, int count) {
        home_dode.onEvaluateList(doctorId, page, count, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    EvaluateListBean bean = (EvaluateListBean) obj;
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
    public void onEndInquiry(int recordId) {
        int userId = (int) SpUtils.get(Home_APP.context, Constant.USERID, 0);
        String sessionId = (String) SpUtils.get(Home_APP.context, Constant.SESSIONID, "");
        home_dode.onEndInquiry(userId, sessionId, recordId, new com.wd.home.contract.Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    EndInquiryBean bean = (EndInquiryBean) obj;
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
    public void onInquiryRecord() {
        int userId = (int) SpUtils.get(Home_APP.context, Constant.USERID, 0);
        String sessionid = (String) SpUtils.get(Home_APP.context, Constant.SESSIONID, "");
        home_dode.onInquiryRecord(userId, sessionid, new Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {//成功的方法
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    com.wd.home.bean.InquiryRecordBean bean = (InquiryRecordBean) obj;
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
