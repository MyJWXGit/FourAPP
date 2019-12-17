package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.RegisterBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity3 extends BaseActivity<LoginPresenter> implements Contract.IView {

    @BindView(R2.id.regiser_name)
    EditText regiserName;
    @BindView(R2.id.regiser_hospital)
    EditText regiserHospital;
    @BindView(R2.id.regiser_administrative)
    EditText regiserAdministrative;
    @BindView(R2.id.regiser_occupation)
    EditText regiserOccupation;
    @BindView(R2.id.register_xia)
    Button registerXia;
    private String youxiang;
    private String jianyan;
    private String pwd;
    private String pwd2;
    private String jianli;
    private String lingyu;

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
        Intent intent = getIntent();
        youxiang = intent.getStringExtra("youxiang");
        jianyan = intent.getStringExtra("jianyan");
        pwd = intent.getStringExtra("pwd");
        pwd2 = intent.getStringExtra("pwd2");
        jianli = intent.getStringExtra("jianli");
        lingyu = intent.getStringExtra("lingyu");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_register3;
    }

    @OnClick(R2.id.register_xia)
    public void onViewClicked() {
        String name = regiserName.getText().toString().trim();
        String yiyuan = regiserHospital.getText().toString().trim();
        String keshi = regiserAdministrative.getText().toString().trim();
        String zhichen = regiserOccupation.getText().toString().trim();
        mPresenter.onRegister(youxiang,jianyan,pwd,pwd,name,yiyuan,keshi,zhichen,jianli,jianyan);
        if (name.equals("")||yiyuan.equals("")||keshi.equals("")||zhichen.equals("")){
            ToastUtils.showLong(this,"不能为空");
        }else {
            Intent intent=new Intent(RegisterActivity3.this,SucceedActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onSuccess(Object obj) {
        RegisterBean bean= (RegisterBean) obj;
        if (bean!=null){
            ToastUtils.showLong(this,bean.getMessage());
            if ("0000".equals(bean.getStatus())){

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
