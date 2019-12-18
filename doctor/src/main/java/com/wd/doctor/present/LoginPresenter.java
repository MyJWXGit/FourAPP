package com.wd.doctor.present;



import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.ImagePicBean;
import com.wd.doctor.bean.InquiryBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.bean.PatientsBean;
import com.wd.doctor.bean.PublishBean;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.StreamBean;
import com.wd.doctor.bean.UploadingBean;
import com.wd.doctor.bean.VerifyBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.model.FragmentModel;
import com.wd.doctor.model.LoginModel;

import java.io.File;
import java.util.Map;


/**
 * date:2019/11/6
 * author:金豪(Lenovo)
 * function:
 */
public class LoginPresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter{

    private LoginModel model;
    private static final String TAG = "HomePresenter";
    private FragmentModel fModel;

    @Override
    protected void initModel() {
        model = new LoginModel();
        fModel = new FragmentModel();
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
    //个人信息
    @Override
    public void Mian(int doctorId, String sessionId) {
        model.Mian(doctorId, sessionId, new Contract.IModer.IBallBask() {
            @Override
            public void onHttpOK(Object obj) {
                //软引用
                if (isViewAttached()) {
                    //Bean包强转  拿到Status进行判断
                    MianBean bean = (MianBean) obj;
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
   //骨科....
    @Override
    public void Inquer() {
         model.Inquer(new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     InquiryBean bean = (InquiryBean) obj;
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
    //病友圈
    @Override
    public void Patients(int departmentId, int page, int count) {
         fModel.Patients(departmentId, page, count, new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     PatientsBean bean = (PatientsBean) obj;
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
   //根据关键词查询病友圈
    @Override
    public void Streanm(String keyWord) {
         model.Streanm(keyWord, new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     StreamBean bean = (StreamBean) obj;
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
    //查询病友圈详情
    @Override
    public void Details(int doctorId, String sessionId, int sickCircleId) {
            fModel.Details(doctorId, sessionId, sickCircleId, new Contract.IModer.IBallBask() {
                @Override
                public void onHttpOK(Object obj) {
                    //软引用
                    if (isViewAttached()) {
                        //Bean包强转  拿到Status进行判断
                        DetailsBean bean = (DetailsBean) obj;
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
    //发表评论
    @Override
    public void Publish(int doctorId, String sessionId, int sickCircleId, String content) {
       model.Publish(doctorId, sessionId, sickCircleId, content, new Contract.IModer.IBallBask() {
           @Override
           public void onHttpOK(Object obj) {
               //软引用
               if (isViewAttached()) {
                   //Bean包强转  拿到Status进行判断
                   PublishBean bean = (PublishBean) obj;
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
    //系统形象照
    @Override
    public void Imagep() {
         fModel.Imagep(new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     ImagePicBean bean = (ImagePicBean) obj;
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

    @Override
    public void onZhucec(Map<String, Object> paramsMap) {
        model.onZhucec(paramsMap, new Contract.IModer.IBallBask() {
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
     //上传系统照片
    @Override
    public void Uploading(int doctorId, String sessionId, String imagePic) {
         fModel.Uploading(doctorId, sessionId, imagePic, new Contract.IModer.IBallBask() {
             @Override
             public void onHttpOK(Object obj) {
                 //软引用
                 if (isViewAttached()) {
                     //Bean包强转  拿到Status进行判断
                     UploadingBean bean = (UploadingBean) obj;
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



