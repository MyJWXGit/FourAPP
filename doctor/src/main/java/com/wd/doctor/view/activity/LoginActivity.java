package com.wd.doctor.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
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
                break;
        }
    }
}
