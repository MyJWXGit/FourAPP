package com.wd.circle.presenter;

import android.content.Context;

import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.model.Home_Circle_Model;
import com.wd.common.base.BasePresenter;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/18 15:03
 * @change
 * @chang time
 * @class describe
 */
public class Home_CirclePresenter extends BasePresenter<Contract.IView> implements Contract.FPresenter {

    private Home_Circle_Model home_circle_model;

    @Override
    public void onHomes(int departmentId, int page, int count) {
        home_circle_model.onhomes(departmentId, page, count, new Contract.FModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()){
                    Circle_lists_Bean circle_lists_bean= (Circle_lists_Bean) obj;
                    if (circle_lists_bean!=null){
                        getView().onSuccess(circle_lists_bean);
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()){
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onSearch(String keyWord) {
    home_circle_model.onSearch(keyWord, new Contract.FModer.IBallBask() {
        @Override
        public void onHttpOK(Object obj) {
            if (isViewAttached()){
                SearchCircleBean searchCircleBean= (SearchCircleBean) obj;
                if (searchCircleBean!=null){
                    getView().onSuccess(searchCircleBean);
                }
            }
        }

        @Override
        public void onHttpNO(Throwable e) {
            if (isViewAttached()){
                getView().onError(e);
            }
        }
    });
    }

    @Override
    protected void initModel() {
        home_circle_model = new Home_Circle_Model();
    }

    @Override
    public Context context() {
        return null;
    }
}
