package com.wd.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.Logger;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.HomePresenter;
import com.wd.home.utils.RsaCoder;

public class MainActivity extends BaseActivity<HomePresenter> implements Contract.IView {
    private Button button;
    private EditText email_edit, pwd_edit;
    private static final String TAG = "MainActivity";

    //返回你的P层  直接使用mPresenter可以进行请求
    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    //初始化控件
    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        email_edit = findViewById(R.id.email);
        pwd_edit = findViewById(R.id.pwd);
    }

    //业务逻辑   进行请求
    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd1 = pwd_edit.getText().toString();
                String email = email_edit.getText().toString();
                //对密码加密
                try {
                    String pwd = RsaCoder.encryptByPublicKey(pwd1);
                    //直接调用  mPresenter可以进行请求
                    mPresenter.onLogin(email, pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //返回XML文件
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    //用不到
    @Override
    public Context context() {
        return null;
    }

    //请求成功的方法
    @Override
    public void onSuccess(Object obj) {
        Logger.d(TAG, obj.toString() + "");
    }

    //请求失败的方法
    @Override
    public void onError(Throwable e) {

    }
}
