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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;
import com.wd.health.bean.LoginBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.APP_MainPresenter;
import com.wd.my_message.utils.RsaCoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class APP_Login_Activity extends BaseActivity<APP_MainPresenter> implements Contract.IView {
    @BindView(R.id.i1)
    ImageView i1;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.line1)
    LinearLayout line1;
    @BindView(R.id.forget_pwd)
    TextView forgetPwd;
    @BindView(R.id.text_register)
    TextView textRegister;
    @BindView(R.id.wx)
    TextView wx;
    @BindView(R.id.login_wx)
    ImageButton loginWx;
    private LoginBean.ResultBean result;
    private String string;

    @Override
    protected APP_MainPresenter providePresenter() {
        return new APP_MainPresenter();
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
        return R.layout.app_activity_login_app;
    }

    @Override
    public void onSuccess(Object obj) {
        LoginBean bean = (LoginBean) obj;
        if (bean.getStatus().equals("0000")) {
            SpUtils.put(this, Constant.USERID, bean.getResult().getId());
            SpUtils.put(this, Constant.SESSIONID, bean.getResult().getSessionId());
            ARouter.getInstance().build("/home/activity").navigation();
            result = bean.getResult();
            String userName = result.getUserName();
            Log.d("SSSS", "userName: " + userName);
            String jiGuangPwd = result.getJiGuangPwd();
            SpUtils.put(My_APP.context, "BeanPic", bean.getResult().getHeadPic());
            SpUtils.put(My_APP.context, "BeanName", bean.getResult().getNickName());
            try {
                string = RsaCoder.decryptByPublicKey(jiGuangPwd);
                Log.d("aaaa", "onSuccess: " + string);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String s = MD5(string);
            Log.d("ssss", "s: " + s);
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
                if (!My_APP.api.isWXAppInstalled()) {
                    Toast.makeText(APP_Login_Activity.this, "您的设备未安装微信客户端", Toast.LENGTH_SHORT).show();
                } else {
                    final SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "wechat_sdk_demo_test";
                    String packageName = getPackageName();
                    Log.i("xxx", "onViewClicked: " + packageName);
                    My_APP.api.sendReq(req);
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
