package com.wd.doctor.contract;


import com.wd.common.base.IBaseView;
import com.wd.doctor.bean.LoginBean;


/**
 * date:2019/11/6
 * author:金豪(Lenovo)
 * function:
 */
public interface Contract {
    //接口回调  IBaseView
    interface IView extends IBaseView {
        void onSuccess(Object obj);

        void onError(Throwable e);
    }

    //Activity  P层方法
    interface IPresenter {
        //注册
        void onRegister(String email, String code, String pwd1, String pwd2, String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField);
       //发送邮箱
        void Send(String email);
        //检验验证码
        void Verif(String email, String code);
        //登录
        void onLogin(String email, String pwd);
    }

    //Activity  M层
    interface IModer {
        //注册
        void onRegister(String email, String code, String pwd1, String pwd2,String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField, IBallBask iBallBask);
        //发送邮箱
        void Send(String email,IBallBask iBallBask);
        //检验验证码
        void Verif(String email,String code,IBallBask iBallBask);
        //登录
        void onLogin(String email, String pwd, IBallBask iBallBask);

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }

    //Fragment  M层
    interface FModer {

        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
