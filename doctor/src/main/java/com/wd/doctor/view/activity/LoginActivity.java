package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.Logger;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.encrypt.RsaCoder;
import com.wd.doctor.model.RegexUtil;
import com.wd.doctor.present.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    private static final String TAG = "MainActivity";
    @BindView(R2.id.login_edity)
    EditText loginEdity;
    @BindView(R2.id.suo)
    ImageView suo;
    @BindView(R2.id.login_pwd)
    EditText loginPwd;
    @BindView(R2.id.hit)
    ImageView hit;
    @BindView(R2.id.show)
    ImageView show;
    @BindView(R2.id.login_wangji)
    TextView loginWangji;
    @BindView(R2.id.long_register)
    TextView longRegister;
    @BindView(R2.id.login_deng)
    Button loginDeng;
    boolean flag = false;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
       // loginEdity.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.doctor_activity_login;
    }

    @OnClick({R2.id.suo, R2.id.hit, R2.id.show, R2.id.login_wangji, R2.id.long_register, R2.id.login_deng})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.suo) {
        } else if (id == R.id.hit) {
            if (!flag) {
                loginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                hit.setVisibility(View.GONE);
                show.setVisibility(View.VISIBLE);
            }
        } else if (id == R.id.show) {
            if (!flag) {
                loginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hit.setVisibility(View.VISIBLE);
                show.setVisibility(View.GONE);
            }
        } else if (id == R.id.login_wangji) {
        } else if (id == R.id.long_register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (id == R.id.login_deng) {
            String empty = loginEdity.getText().toString().trim();
            String trim = loginPwd.getText().toString().trim();
            try {
                s = RsaCoder.encryptByPublicKey(trim);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean email = RegexUtil.checkEmail(empty);
            if (email) {

            } else {
                Toast.makeText(LoginActivity.this, "请输入正确邮箱", Toast.LENGTH_SHORT).show();
            }
            mPresenter.onLogin(empty, s);
        }
    }

    @Override
    public void onSuccess(Object obj) {
        Logger.d(TAG, obj.toString() + "");
        LoginBean bean= (LoginBean) obj;
        if (bean!=null){
            Toast.makeText(this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())){
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("doctorId",bean.getResult().getId());
                intent.putExtra("sessionId",bean.getResult().getSessionId());
                startActivity(intent);

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
}
