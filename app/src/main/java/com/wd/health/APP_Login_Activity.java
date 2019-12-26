package com.wd.health;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.transition.Explode;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;
import com.wd.health.bean.LoginBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MainPresenter;
import com.wd.health.utils.RsaCoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
            int id = bean.getResult().getId();
            String sessionId = bean.getResult().getSessionId();
            String str = id + "" + sessionId + "movie";
            String s = MD5(str);
            Log.i("xxx", "onSuccess: " + str);
            Log.i("xxx", "onSuccess: " + s);
            ARouter.getInstance().build("/home/activity").navigation();
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
                startActivity(new Intent(this, RegisterActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
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

    /**
     * MD5加密
     *
     * @param sourceStr
     * @return
     */
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
