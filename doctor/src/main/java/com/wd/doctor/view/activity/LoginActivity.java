package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.Logger;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.App;
import com.wd.doctor.R;
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
    @BindView(R.id.login_edity)
    EditText loginEdity;
    @BindView(R.id.suo)
    ImageView suo;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.hit)
    ImageView hit;
    @BindView(R.id.show)
    ImageView show;
    @BindView(R.id.login_wangji)
    TextView loginWangji;
    @BindView(R.id.long_register)
    TextView longRegister;
    @BindView(R.id.login_deng)
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

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.suo, R.id.hit, R.id.show, R.id.login_wangji, R.id.long_register, R.id.login_deng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.suo:
                break;
            case R.id.hit:
                if (!flag) {
                    loginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    hit.setVisibility(View.GONE);
                    show.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.show:
                if (!flag) {
                    loginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    hit.setVisibility(View.VISIBLE);
                    show.setVisibility(View.GONE);
                }
                break;
            case R.id.login_wangji:
                break;
            case R.id.long_register:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_deng:



                String empty = loginEdity.getText().toString().trim();
                String trim = loginPwd.getText().toString().trim();
                try {
                    s = RsaCoder.encryptByPublicKey(trim);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean email = RegexUtil.checkEmail(empty);
                if (email){

                }else {
                    Toast.makeText(LoginActivity.this, "请输入正确邮箱", Toast.LENGTH_SHORT).show();
                }
                mPresenter.onLogin(empty,s);

                break;
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
