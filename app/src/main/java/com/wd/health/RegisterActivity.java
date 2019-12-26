package com.wd.health;

import android.content.Context;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.wd.common.base.BaseActivity;
import com.wd.health.bean.EmailBean;
import com.wd.health.bean.RegisterBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MainPresenter;
import com.wd.health.utils.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<MainPresenter> implements Contract.IView {

    @BindView(R.id.registered_icon_logo)
    ImageView registeredIconLogo;
    @BindView(R.id.iv_mail_n)
    ImageView ivMailN;
    @BindView(R.id.registered_et_youxiang)
    EditText registeredEtYouxiang;
    @BindView(R.id.registered_cb_code)
    Button registeredCbCode;
    @BindView(R.id.icon_verification)
    ImageView iconVerification;
    @BindView(R.id.registered_et_code)
    EditText registeredEtCode;
    @BindView(R.id.icon_lock_one)
    ImageView iconLockOne;
    @BindView(R.id.registered_et_pwd)
    EditText registeredEtPwd;
    @BindView(R.id.registered_icon_yanone)
    ImageView registeredIconYanone;
    @BindView(R.id.icon_lock_two)
    ImageView iconLockTwo;
    @BindView(R.id.registered_et_pwdtwo)
    EditText registeredEtPwdtwo;
    @BindView(R.id.registered_icon_yantwo)
    ImageView registeredIconYantwo;
    @BindView(R.id.icon_invitatiion)
    ImageView iconInvitatiion;
    @BindView(R.id.registered_et_yaoqing)
    EditText registeredEtYaoqing;
    @BindView(R.id.registered_bt_zhuce)
    Button registeredBtZhuce;

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int initLayout() {
        Transition transition = new TransitionSet().addTransition(new Explode());
        getWindow().setEnterTransition(transition.setDuration(2000));
        getWindow().setExitTransition(new Explode().setDuration(2000));
        return R.layout.activity_register;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof EmailBean) {
            EmailBean bean = (EmailBean) obj;
            String message = bean.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (obj instanceof RegisterBean) {
            RegisterBean bean = (RegisterBean) obj;
            if (bean.getStatus().equals("0000")) {
                finish();
            } else {
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }


    @OnClick({R.id.registered_bt_zhuce, R.id.registered_cb_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.registered_bt_zhuce:
                String email = registeredEtYouxiang.getText().toString();
                String code = registeredEtCode.getText().toString();
                String pwd_one = registeredEtPwd.getText().toString();
                String pwd_two = registeredEtPwdtwo.getText().toString();
                String pwd1 = null;
                String pwd2 = null;
                try {
                    pwd1 = RsaCoder.encryptByPublicKey(pwd_one);
                    pwd2 = RsaCoder.encryptByPublicKey(pwd_two);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mPresenter.onRegister(email, code, pwd1, pwd2, "");
                break;
            case R.id.registered_cb_code:
                String email_code = registeredEtYouxiang.getText().toString();
                mPresenter.onEmail(email_code);
                break;

        }
    }
}
