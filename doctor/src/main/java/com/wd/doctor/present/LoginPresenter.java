package com.wd.doctor.present;



import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.VerifyBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.model.LoginModel;


/**
 * date:2019/11/6
 * author:金豪(Lenovo)
 * function:
 */
public class LoginPresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter{

    private LoginModel model;
    private static final String TAG = "HomePresenter";
    @Override
    protected void initModel() {
        model = new LoginModel();
    }
   //注册
    @Override
    public void onRegister(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField) {
         model.onRegister(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField, new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     RegisterBean bean = (RegisterBean) obj;
                     if (bean != null && bean.getStatus().equals("0000")) {
                         //getView是BasePresenter方法  使用getView进行调用P层
                         getView().onSuccess(bean);
                     } else {
                         getView().onError(new Exception("请求失败"));
                     }
                 }
             }

             @Override
             public void onHttpNO(Throwable e) {
                 if (isViewAttached()) {
                     Logger.d(TAG, e.getMessage() + "");
                 }
             }
         });
    }

    //发送邮箱
    @Override
    public void Send(String email) {
        model.Send(email, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    SendBean bean = (SendBean) obj;
                    if (bean != null && bean.getStatus().equals("0000")) {
                        //getView是BasePresenter方法  使用getView进行调用P层
                        getView().onSuccess(bean);
                    } else {
                        getView().onError(new Exception("请求失败"));
                    }
                }
            }

            @Override
            public void onHttpNO(Throwable e) {
                if (isViewAttached()) {
                    Logger.d(TAG, e.getMessage() + "");
                }
            }
        });
    }
    //检验验证码
    @Override
    public void Verif(String email, String code) {
         model.Verif(email, code, new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     VerifyBean bean = (VerifyBean) obj;
                     if (bean != null && bean.getStatus().equals("0000")) {
                         //getView是BasePresenter方法  使用getView进行调用P层
                         getView().onSuccess(bean);
                     } else {
                         getView().onError(new Exception("请求失败"));
                     }
                 }
             }

             @Override
             public void onHttpNO(Throwable e) {
                 if (isViewAttached()) {
                     Logger.d(TAG, e.getMessage() + "");
                 }
             }
         });
    }
   //登录
    @Override
    public void onLogin(String email, String pwd) {
          model.onLogin(email, pwd, new Contract.IModer.IBallBask() {
              @Override
              public void onHttpOK(Object obj) {
                  //软引用
                  if (isViewAttached()) {
                      //Bean包强转  拿到Status进行判断
                      LoginBean bean = (LoginBean) obj;
                      if (bean != null && bean.getStatus().equals("0000")) {
                          //getView是BasePresenter方法  使用getView进行调用P层
                          getView().onSuccess(bean);
                      } else {
                          getView().onError(new Exception("请求失败"));
                      }
                  }
              }

              @Override
              public void onHttpNO(Throwable e) {
                  if (isViewAttached()) {
                      Logger.d(TAG, e.getMessage() + "");
                  }
              }
          });
    }
}



