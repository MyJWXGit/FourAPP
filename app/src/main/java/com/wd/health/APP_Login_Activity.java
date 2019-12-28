package com.wd.health;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;
import com.wd.health.bean.LoginBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MainPresenter;
import com.wd.health.utils.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class APP_Login_Activity extends BaseActivity<MainPresenter> implements Contract.IView {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.login_wx)
    ImageButton loginWx;
    @BindView(R.id.text_register)
    TextView textRegister;
    @BindView(R.id.forget_pwd)
    TextView forgetPwd;

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
        Intent intent = getIntent();
        String code = intent.getStringExtra(Constant.WX_CODE);
        mPresenter.onWXLogin(code);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_app__login_;
    }

    @Override
    public void onSuccess(Object obj) {
        LoginBean bean = (LoginBean) obj;
        if (bean.getStatus().equals("0000")) {
            SpUtils.put(this, Constant.USERID, bean.getResult().getId());
            SpUtils.put(this, Constant.SESSIONID, bean.getResult().getSessionId());
            ARouter.getInstance().build("/my_message/activity").navigation();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R.id.button, R.id.forget_pwd, R.id.text_register, R.id.login_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
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
                break;
            case R.id.forget_pwd:
                Toast.makeText(this, "忘记密码,请重新注册吧", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_register:
                Intent intent = new Intent(APP_Login_Activity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_wx:
                // send oauth request
                if (!APP.api.isWXAppInstalled()) {
                    Toast.makeText(APP_Login_Activity.this, "您的设备未安装微信客户端", Toast.LENGTH_SHORT).show();
                } else {
                    final SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "wechat_sdk_demo_test";
                    String packageName = getPackageName();
                    Log.i("xxx", "onViewClicked: " + packageName);
                    APP.api.sendReq(req);
                }
                break;
        }
    }
}
