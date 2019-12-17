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
        //个人信息
        void Mian(int doctorId,String sessionId);
        //骨科
        void Inquer();
        //病友圈
        void Patients(int departmentId,int page,int count);
        //根据关键词查询病友圈
        void Streanm(String keyWord);
        //查询病友圈详情
        void Details(int doctorId, String sessionId, int sickCircleId);
        //发表评论
        void Publish(int doctorId, String sessionId, int sickCircleId, String content);
        //系统形象照
        void Imagep();
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
        //个人信息
        void Mian(int doctorId,String sessionId,IBallBask iBallBask);
        //根据关键词查询病友圈
        void Streanm(String keyWord,IBallBask iBallBask);
        //发表评论
        void Publish(int doctorId,String sessionId,int sickCircleId,String content,IBallBask iBallBask);
       //查询病友圈详情
        void Details(int doctorId, String sessionId, int sickCircleId, IModer.IBallBask iBallBask);
        void Inquer(IBallBask iBallBask);
        //系统形象照
        void Imagep(IBallBask iBallBask);
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }

    //Fragment  M层
    interface FModer {
        //病友圈
        void Patients(int departmentId, int page, int count, IModer.IBallBask iBallBask);
        //查询病友圈详情
        void Details(int doctorId, String sessionId, int sickCircleId, IModer.IBallBask iBallBask);
        interface IBallBask {
            void onHttpOK(Object obj);

            void onHttpNO(Throwable e);
        }
    }
}
