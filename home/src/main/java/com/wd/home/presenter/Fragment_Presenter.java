package com.wd.home.presenter;

import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.bean.DyugBean;
import com.wd.home.bean.IllnessBean;
import com.wd.home.bean.Information_ListBean;
import com.wd.home.contract.Contract;
import com.wd.home.model.Fragment_Mode;

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
        home_dode.onDepartment_F(new Contract.FModer.IBallBask() {
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
        home_dode.onCategory(departmentId, new Contract.FModer.IBallBask() {
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
    public void onDyug(int id) {
        home_dode.onDyug(id, new Contract.FModer.IBallBask() {
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
        home_dode.onCategoryList(new Contract.FModer.IBallBask() {
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
        home_dode.onDrugsKnowledgeList(drugsCategoryId, page, count, new Contract.FModer.IBallBask() {
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
        home_dode.onIllness(id, new Contract.FModer.IBallBask() {
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
}
