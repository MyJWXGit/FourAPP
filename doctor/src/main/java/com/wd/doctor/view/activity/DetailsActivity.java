package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    @BindView(R.id.details_backfh)
    ImageView detailsBackfh;
    @BindView(R.id.details_back)
    TextView detailsBack;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_disease)
    TextView detailsDisease;
    @BindView(R.id.details_departmentName)
    TextView detailsDepartmentName;
    @BindView(R.id.details_detail)
    TextView detailsDetail;
    @BindView(R.id.design_treatmentHospital)
    TextView designTreatmentHospital;
    @BindView(R.id.design_treatmentStartTime)
    TextView designTreatmentStartTime;
    @BindView(R.id.design_treatmentProcess)
    TextView designTreatmentProcess;
    @BindView(R.id.design_picture)
    SimpleDraweeView designPicture;
    @BindView(R.id.xiepingl)
    Button xiepingl;
    @BindView(R.id.xuanz)
    Button xuanz;
    private int doctorId;
    private String sessionId;
    private int sickCircleId;


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
        sickCircleId = intent.getIntExtra("sickCircleId", 0);
        sessionId = intent.getStringExtra("sessionId");

    }

    @Override
    protected void initData() {
        mPresenter.Details(doctorId, sessionId, sickCircleId);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void onSuccess(Object obj) {
        DetailsBean bean = (DetailsBean) obj;
        detailsBack.setText(bean.getResult().getTitle());
        detailsName.setText(bean.getResult().getAuthorName());
        detailsDisease.setText(bean.getResult().getDisease());
        detailsDepartmentName.setText(bean.getResult().getDepartmentName());
        detailsDetail.setText(bean.getResult().getDetail());
        designTreatmentHospital.setText(bean.getResult().getTreatmentHospital());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(bean.getResult().getTreatmentStartTime());
        designTreatmentStartTime.setText(format);
        designTreatmentProcess.setText(bean.getResult().getTreatmentProcess());
        designPicture.setImageURI(bean.getResult().getPicture());
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R.id.details_backfh, R.id.xiepingl, R.id.xuanz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_backfh:
                finish();
                break;
            case R.id.xiepingl:
                break;
            case R.id.xuanz:
                break;
        }
    }

    /*@OnClick(R.id.details_backfh)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R.id.xuanz)
    public void onViewClicked() {
    }*/
}
