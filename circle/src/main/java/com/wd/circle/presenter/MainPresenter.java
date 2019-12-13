package com.wd.circle.presenter;

import android.content.Context;
import android.widget.Toast;

import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.LoginBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.model.MainModel;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.ToastUtils;


/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 9:00
 * @change
 * @chang time
 * @class describe
 */
public class MainPresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
    }

    @Override
    public Context context() {
        return null;
    }


    @Override
    public void onLogin(String email, String pwd) {
        mainModel.onLogin(email, pwd, new com.wd.circle.contract.Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()) {
                    LoginBean loginBean = (LoginBean) obj;
                    if (loginBean != null && loginBean.getStatus().equals("0000")) {
                        getView().onSuccess(loginBean);
                    } else {
                        Toast.makeText(context(), "请求失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    getView().onError(e);
                }
            }
        });
    }

    @Override
    public void onHome() {
        mainModel.onhome(new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                if (isViewAttached()){
                    Circle_list_Bean circle_list_bean= (Circle_list_Bean) obj;
                    if (circle_list_bean!=null){
                        getView().onSuccess(circle_list_bean);
                    }else {
                        ToastUtils.show(context(),circle_list_bean.getMessage(),2000);
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
    public void onHomes(int departmentId, int page, int count) {
        mainModel.onhomes(departmentId, page, count, new Contract.IModer.IBallBask() {
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
}