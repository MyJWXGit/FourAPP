package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter> implements Contract.IView {

    @BindView(R.id.main_bell)
    ImageView mainBell;
    @BindView(R.id.text_main)
    TextView textMain;
    @BindView(R.id.main_notice)
    RelativeLayout mainNotice;
    @BindView(R.id.main_tip_box_inter)
    RelativeLayout mainTipBoxInter;
    @BindView(R.id.main_tip_box_wardmate)
    RelativeLayout mainTipBoxWardmate;
    @BindView(R.id.wdxx)
    TextView wdxx;
    @BindView(R.id.main_my)
    ImageView mainMy;
    @BindView(R.id.main_headportrait)
    SimpleDraweeView mainHeadportrait;
    @BindView(R.id.main_name)
    TextView mainName;
    @BindView(R.id.main_address)
    TextView mainAddress;
    @BindView(R.id.main_doctor)
    TextView mainDoctor;
    @BindView(R.id.main_subjects)
    TextView mainSubjects;
    @BindView(R.id.main_tip_box_my)
    RelativeLayout mainTipBoxMy;
    @BindView(R.id.main_interrogation)
    ImageView mainInterrogation;
    @BindView(R.id.main_wardmate)
    ImageView mainWardmate;
    private int doctorId;
    private String sessionId;

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
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");
        mPresenter.Mian(doctorId, sessionId);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object obj) {
        MianBean bean = (MianBean) obj;
        mainName.setText(bean.getResult().getDepartmentName());
        mainAddress.setText(bean.getResult().getInauguralHospital());
        mainDoctor.setText(bean.getResult().getJobTitle());
        mainSubjects.setText(bean.getResult().getGoodField());
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }


    @OnClick({R.id.main_bell, R.id.main_interrogation, R.id.main_wardmate, R.id.main_my, R.id.main_headportrait})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_bell:
                break;
            case R.id.main_interrogation:
                break;
            case R.id.main_wardmate:
                Intent intent=new Intent(MainActivity.this,InquiryActivity.class);
                intent.putExtra("doctorId",doctorId);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);

                break;
            case R.id.main_my:
                break;
            case R.id.main_headportrait:
                break;
        }
    }
}
