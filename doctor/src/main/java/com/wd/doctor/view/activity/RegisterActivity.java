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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.SendBean;
import com.wd.doctor.bean.VerifyBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.encrypt.RsaCoder;
import com.wd.doctor.present.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<LoginPresenter> implements Contract.IView {

    @BindView(R2.id.register_zhang)
    EditText registerZhang;
    @BindView(R2.id.register_forget)
    Button registerForget;
    @BindView(R2.id.register_ma)
    EditText registerMa;
    @BindView(R2.id.register_mi)
    EditText registerMi;
    @BindView(R2.id.register_hiet)
    ImageView registerHiet;
    @BindView(R2.id.register_show)
    ImageView registerShow;
    @BindView(R2.id.register_ermi)
    EditText registerErmi;
    @BindView(R2.id.register_hiet1)
    ImageView registerHiet1;
    @BindView(R2.id.register_show1)
    ImageView registerShow1;
    @BindView(R2.id.register_xia)
    Button registerXia;
    boolean flag = false;
    private String youxiang;
    private String pwd;
    private String pwd2;

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
        return R.layout.activity_register;
    }

    @OnClick({R2.id.register_forget, R2.id.register_hiet, R2.id.register_show, R2.id.register_hiet1, R2.id.register_show1, R2.id.register_xia})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.register_forget) {
            String trim = registerZhang.getText().toString().trim();
            mPresenter.Send(trim);
        } else if (id == R.id.register_hiet) {
            if (!flag) {
                registerMi.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                registerHiet.setVisibility(View.GONE);
                registerShow.setVisibility(View.VISIBLE);
            }
        } else if (id == R.id.register_show) {
            if (!flag) {
                registerMi.setTransformationMethod(PasswordTransformationMethod.getInstance());
                registerHiet.setVisibility(View.VISIBLE);
                registerShow.setVisibility(View.GONE);
            }
        } else if (id == R.id.register_hiet1) {
            if (!flag) {
                registerErmi.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                registerHiet1.setVisibility(View.GONE);
                registerShow1.setVisibility(View.VISIBLE);
            }
        } else if (id == R.id.register_show1) {
            if (!flag) {
                registerErmi.setTransformationMethod(PasswordTransformationMethod.getInstance());
                registerHiet1.setVisibility(View.VISIBLE);
                registerShow1.setVisibility(View.GONE);
            }
        } else if (id == R.id.register_xia) {
            youxiang = registerZhang.getText().toString().trim();
            String jianyan = registerMa.getText().toString().trim();
            String pwd1 = registerMi.getText().toString().trim();

            pwd2 = registerErmi.getText().toString().trim();

            if (pwd1.equals(pwd2)) {
                try {
                    pwd = RsaCoder.encryptByPublicKey(pwd1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mPresenter.Verif(youxiang, jianyan);
                Intent intent = new Intent(RegisterActivity.this, RegisterActivity2.class);
                intent.putExtra("youxiang", youxiang);
                intent.putExtra("jianyan", jianyan);
                intent.putExtra("pwd", pwd);
                intent.putExtra("pwd2", pwd2);
                startActivity(intent);
            } else {
                ToastUtils.showLong(this, "密码不一致,请重新输入");
            }
            if (pwd.equals("") || pwd2.equals("")) {
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            }/*else if (pwd.equals(pwd2)){
                    mPresenter.Verif(youxiang,jianyan);
                    Intent intent=new Intent(RegisterActivity.this,RegisterActivity2.class);
                    intent.putExtra("youxiang", youxiang);
                    intent.putExtra("jianyan",jianyan);
                    intent.putExtra("pwd",pwd);
                    intent.putExtra("pwd2",pwd2);
                    startActivity(intent);
                }*/
        }
    }

    @Override
    public void onSuccess(Object obj) {
        SendBean bean = (SendBean) obj;

        if (bean != null) {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())) {

            }
        }
        //检验
        VerifyBean verifyBean = (VerifyBean) obj;
        if (verifyBean != null) {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())) {

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
