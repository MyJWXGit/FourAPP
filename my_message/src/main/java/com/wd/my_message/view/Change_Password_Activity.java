package com.wd.my_message.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.SettingsActivity;
import com.wd.my_message.Update_Message_Activity;
import com.wd.my_message.bean.SetPwdBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.utils.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Change_Password_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.biaoti)
    RelativeLayout biaoti;
    @BindView(R2.id.edit_yuan)
    EditText editYuan;
    @BindView(R2.id.edit_xin)
    EditText editXin;
    @BindView(R2.id.edit_queding)
    EditText editQueding;
    @BindView(R2.id.btn_ding)
    Button btnDing;
    private String s1;
    private String s2;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
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
        return R.layout.activity_change__password_;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof SetPwdBean){
            SetPwdBean setPwdBean = (SetPwdBean) data;
            String message = setPwdBean.getMessage();
            ToastUtils.show(Change_Password_Activity.this,message, Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R2.id.fanhui, R2.id.btn_ding})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.fanhui) {
            finish();
        } else if (id == R.id.btn_ding) {
            String trim = editYuan.getText().toString();
            String trim1 = editXin.getText().toString();
            String trim2 = editQueding.getText().toString();
            if (trim1.equals(trim2)) {
                try {
                    s1 = RsaCoder.encryptByPublicKey(trim1);
                    s2 = RsaCoder.encryptByPublicKey(trim);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (trim != null && s1 != null) {
                    mPresenter.onSet_Pwd(s2, s1);
                    Intent intent = new Intent(Change_Password_Activity.this, SettingsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }else {
                Toast.makeText(this, "请输入相同的密码", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
