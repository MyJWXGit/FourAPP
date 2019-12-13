package com.wd.circle.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.circle.R;
import com.wd.circle.api.Constant;
import com.wd.circle.bean.LoginBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.utils.RsaCoder;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements Contract.IView {


    @BindView(R.id.edit1)
    EditText edit1;
    @BindView(R.id.edit2)
    EditText edit2;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.regin_btn)
    Button reginBtn;

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
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = edit1.getText().toString().trim();
                String trim1 = edit2.getText().toString().trim();
                try {
                    String s = RsaCoder.encryptByPublicKey(trim1);
                    mPresenter.onLogin(trim,s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        LoginBean loginBean= (LoginBean) obj;
        if (loginBean.getStatus().equals("0000")){
            Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            SpUtils.put(this, Constant.Sp_userId,loginBean.getResult().getId());
            SpUtils.put(this,Constant.Sp_touxiang,loginBean.getResult().getHeadPic());
            SpUtils.put(this,Constant.Sp_sessionId,loginBean.getResult().getSessionId());
            startActivity(new Intent(MainActivity.this,Circle_Home_Activity.class));
        }else {
            Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(Throwable e) {

    }
}
