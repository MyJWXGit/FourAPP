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
import com.wd.doctor.R2;
import com.wd.doctor.bean.ImagePicBean;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.activity.InquiryActivity;
import com.wd.doctor.view.activity.message.MessageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter> implements Contract.IView {

    @BindView(R2.id.main_bell)
    ImageView mainBell;
    @BindView(R2.id.text_main)
    TextView textMain;
    @BindView(R2.id.main_notice)
    RelativeLayout mainNotice;
    @BindView(R2.id.main_tip_box_inter)
    RelativeLayout mainTipBoxInter;
    @BindView(R2.id.main_tip_box_wardmate)
    RelativeLayout mainTipBoxWardmate;
    @BindView(R2.id.wdxx)
    TextView wdxx;
    @BindView(R2.id.main_my)
    ImageView mainMy;
    @BindView(R2.id.main_headportrait)
    SimpleDraweeView mainHeadportrait;
    @BindView(R2.id.main_name)
    TextView mainName;
    @BindView(R2.id.main_address)
    TextView mainAddress;
    @BindView(R2.id.main_doctor)
    TextView mainDoctor;
    @BindView(R2.id.main_subjects)
    TextView mainSubjects;
    @BindView(R2.id.main_tip_box_my)
    RelativeLayout mainTipBoxMy;
    @BindView(R2.id.main_interrogation)
    ImageView mainInterrogation;
    @BindView(R2.id.main_wardmate)
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
        ButterKnife.bind(this);
        Intent intent = getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");
        mPresenter.Mian(doctorId, sessionId);
        mPresenter.Imagep();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R2.layout.activity_main;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof MianBean){
            MianBean bean = (MianBean) obj;
            mainName.setText(bean.getResult().getDepartmentName());
            mainAddress.setText(bean.getResult().getInauguralHospital());
            mainDoctor.setText(bean.getResult().getJobTitle());
            mainSubjects.setText(bean.getResult().getGoodField());
            mainHeadportrait.setImageURI(bean.getResult().getImagePic());
        }/*else if (obj instanceof ImagePicBean){
            ImagePicBean bean1= (ImagePicBean) obj;
            mainHeadportrait.setImageURI(bean1.getResult().get(0).getImagePic());
        }*/




    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }


    @OnClick({R2.id.main_bell, R2.id.main_interrogation, R2.id.main_wardmate, R2.id.main_my, R2.id.main_headportrait})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.main_bell) {
        } else if (id == R.id.main_interrogation) {
        } else if (id == R.id.main_wardmate) {
            Intent intent = new Intent(MainActivity.this, InquiryActivity.class);
            intent.putExtra("doctorId", doctorId);
            intent.putExtra("sessionId", sessionId);
            startActivity(intent);
        } else if (id == R.id.main_my) {
            Intent intent=new Intent(MainActivity.this,MessageActivity.class);
            intent.putExtra("doctorId", doctorId);
            intent.putExtra("sessionId", sessionId);
            startActivity(intent);
        } else if (id == R.id.main_headportrait) {
        }
    }
}
