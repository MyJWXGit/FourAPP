package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;
import com.wd.home.R;
import com.wd.home.api.Constant;
import com.wd.home.bean.LoginBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.HomePresenter;
import com.wd.home.utils.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<HomePresenter> implements Contract.IView {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.button)
    Button button;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(Object obj) {
        LoginBean bean = (LoginBean) obj;
        if (bean.getStatus().equals("0000")) {
            SpUtils.put(this, Constant.USERID, bean.getResult().getId());
            SpUtils.put(this, Constant.SESSIONID, bean.getResult().getSessionId());
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        String pwd1 = pwd.getText().toString();
        String email1 = email.getText().toString();
        //对密码加密
        try {
            String pwd = RsaCoder.encryptByPublicKey(pwd1);
            //直接调用  mPresenter可以进行请求
            mPresenter.onLogin(email1, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
