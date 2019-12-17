package com.wd.doctor.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.R;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.PublishBean;
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
    @BindView(R.id.wdejida)
    EditText wdejida;
    @BindView(R.id.xinfgg)
    TextView xinfgg;
    @BindView(R.id.jieda)
    TextView jieda;
    @BindView(R.id.publish)
    Button publish;
    @BindView(R.id.butd)
    LinearLayout butd;
    @BindView(R.id.but)
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
        if (obj instanceof  DetailsBean){
            //详情
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
        }else if (obj instanceof  PublishBean){
            //评论
            PublishBean bean1= (PublishBean) obj;
            String status = bean1.getStatus();
            if (bean1!=null){
                Toast.makeText(this,bean1.getMessage(), Toast.LENGTH_SHORT).show();
                if ("0000".equals(bean1.getStatus())){


             /*   Intent intent=new Intent(WriteCommActivity.this, MainActivity.class);
            startActivity(intent);*/
                }
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

    @OnClick({R.id.details_backfh, R.id.publish, R.id.xiepingl, R.id.xuanz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_backfh:
                finish();
                break;
            case R.id.publish:
                String trim = wdejida.getText().toString().trim();
                if (TextUtils.isEmpty(trim)){
                    ToastUtils.showLong(this,"不能为空");
                }else {
                    jieda.setVisibility(View.INVISIBLE);
                    wdejida.setVisibility(View.INVISIBLE);
                    but.setVisibility(View.VISIBLE);
                    butd.setVisibility(View.INVISIBLE);


                    mPresenter.Publish(doctorId,sessionId,sickCircleId,trim);
                }

                break;
            case R.id.xiepingl:


                break;
            case R.id.xuanz:
                jieda.setVisibility(View.VISIBLE);
                wdejida.setVisibility(View.VISIBLE);
                but.setVisibility(View.INVISIBLE);
                butd.setVisibility(View.VISIBLE);
                break;
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
