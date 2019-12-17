package com.wd.doctor.view.activity.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonageActivity extends BaseActivity<LoginPresenter> implements Contract.IView {

    @BindView(R2.id.details_back)
    ImageView detailsBack;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.personage_name)
    TextView personageName;
    @BindView(R2.id.hospital)
    TextView hospital;
    @BindView(R2.id.personage_hospital)
    TextView personageHospital;
    @BindView(R2.id.keshi)
    TextView keshi;
    @BindView(R2.id.personage_keshi)
    TextView personageKeshi;
    @BindView(R2.id.zhicheng)
    TextView zhicheng;
    @BindView(R2.id.personage_zhicheng)
    TextView personageZhicheng;
    @BindView(R2.id.persongge_jieshao)
    TextView personggeJieshao;
    @BindView(R2.id.persongge_lingyu)
    TextView personggeLingyu;
    private int doctorId;
    private String sessionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_personage);
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
        Intent intent = getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");
        mPresenter.Mian(doctorId,sessionId);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_personage;
    }

    @OnClick(R2.id.details_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onSuccess(Object obj) {
        MianBean bean = (MianBean) obj;
        personageName.setText(bean.getResult().getName());
        personageKeshi.setText(bean.getResult().getDepartmentName());
        personggeJieshao.setText(bean.getResult().getJobTitle());
        personageHospital.setText(bean.getResult().getInauguralHospital());
       // personggeJieshao.setText(bean.getResult().get);
        personggeLingyu.setText(bean.getResult().getGoodField());
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
