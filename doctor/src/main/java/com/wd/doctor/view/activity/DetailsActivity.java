package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    @BindView(R2.id.details_backfh)
    ImageView detailsBackfh;
    @BindView(R2.id.details_back)
    TextView detailsBack;
    @BindView(R2.id.details_name)
    TextView detailsName;
    @BindView(R2.id.details_disease)
    TextView detailsDisease;
    @BindView(R2.id.details_departmentName)
    TextView detailsDepartmentName;
    @BindView(R2.id.details_detail)
    TextView detailsDetail;
    @BindView(R2.id.design_treatmentHospital)
    TextView designTreatmentHospital;
    @BindView(R2.id.design_treatmentStartTime)
    TextView designTreatmentStartTime;
    @BindView(R2.id.design_treatmentProcess)
    TextView designTreatmentProcess;
    @BindView(R2.id.design_picture)
    SimpleDraweeView designPicture;
    @BindView(R2.id.xiepingl)
    Button xiepingl;
    @BindView(R2.id.xuanz)
    Button xuanz;
    @BindView(R2.id.wdejida)
    EditText wdejida;
    @BindView(R2.id.xinfgg)
    TextView xinfgg;
    @BindView(R2.id.jieda)
    TextView jieda;
    @BindView(R2.id.publish)
    Button publish;
    @BindView(R2.id.butd)
    LinearLayout butd;
    @BindView(R2.id.but)
    LinearLayout but;
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

    @OnClick({R2.id.details_backfh, R2.id.publish, R2.id.xiepingl, R2.id.xuanz})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.details_backfh) {
            finish();
        } else if (id == R.id.publish) {
            jieda.setVisibility(View.INVISIBLE);
            wdejida.setVisibility(View.INVISIBLE);
            but.setVisibility(View.VISIBLE);
            butd.setVisibility(View.INVISIBLE);
        } else if (id == R.id.xiepingl) {
        } else if (id == R.id.xuanz) {
            jieda.setVisibility(View.VISIBLE);
            wdejida.setVisibility(View.VISIBLE);
            but.setVisibility(View.INVISIBLE);
            butd.setVisibility(View.VISIBLE);
        }
    }

/*    @OnClick({R.id.details_backfh, R.id.xiepingl, R.id.xuanz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_backfh:
                finish();
                break;
            case R.id.xiepingl:
                break;
            case R.id.xuanz:
                 jieda.setVisibility(View.VISIBLE);
                 wdejida.setVisibility(View.VISIBLE);
                break;
        }
    }*/

    /*@OnClick(R.id.details_backfh)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R.id.xuanz)
    public void onViewClicked() {
    }*/
}
