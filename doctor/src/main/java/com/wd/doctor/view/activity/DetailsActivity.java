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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.App;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.DetailsBean;
import com.wd.doctor.bean.PublishBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.utils.HideIMEUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    @BindView(R2.id.xiang_back)
    ImageView xiangBack;
    @BindView(R2.id.xiang_title)
    TextView xiangTitle;
    @BindView(R2.id.xiang_name)
    TextView xiangName;
    @BindView(R2.id.xiang_bing)
    TextView xiangBing;
    @BindView(R2.id.xiang_keshi)
    TextView xiangKeshi;
    @BindView(R2.id.xiang_xq)
    TextView xiangXq;
    @BindView(R2.id.xiang_yiyuan)
    TextView xiangYiyuan;
    @BindView(R2.id.xiang_time)
    TextView xiangTime;
    @BindView(R2.id.xiang_jl)
    TextView xiangJl;
    @BindView(R2.id.xiang_img)
    ImageView xiangImg;
    @BindView(R2.id.xiang_hb)
    TextView xiangHb;
    @BindView(R2.id.xiang_jd)
    TextView xiangJd;
    @BindView(R2.id.xiang_end_time)
    TextView xiangEndTime;
    @BindView(R2.id.et_text)
    EditText etText;
    @BindView(R2.id.img_enjoy)
    ImageView imgEnjoy;
    @BindView(R2.id.img_send)
    ImageView imgSend;
    @BindView(R2.id.linear_et)
    LinearLayout linearEt;
    @BindView(R2.id.relative_edit)
    RelativeLayout relativeEdit;
    @BindView(R2.id.linear_jd)
    LinearLayout linearJd;
    @BindView(R2.id.linear_show)
    LinearLayout linearShow;
    @BindView(R2.id.tv_my_jd)
    TextView tvMyJd;
    @BindView(R2.id.linear_cancel_jd)
    LinearLayout linearCancelJd;
    @BindView(R2.id.line_view)
    View lineView;
    private String sessionId;
    private int whetherContent;
    private int doctorId;
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

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sickCircleId = intent.getIntExtra("sickCircleId", 0);
        sessionId = intent.getStringExtra("sessionId");
        mPresenter.Details(doctorId, sessionId, sickCircleId);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof  DetailsBean){
            DetailsBean data= (DetailsBean) obj;
            if (data.getResult() != null) {
                whetherContent = data.getResult().getWhetherContent();
                if (whetherContent == 1) {
                    linearCancelJd.setVisibility(View.VISIBLE);
                    linearJd.setVisibility(View.GONE);
                    lineView.setVisibility(View.GONE);
                } else if (whetherContent == 2) {
                    linearCancelJd.setVisibility(View.GONE);
                    linearJd.setVisibility(View.VISIBLE);
                    lineView.setVisibility(View.VISIBLE);
                }
                //标题
                String title = data.getResult().getTitle();
                xiangTitle.setText(title);
                //名字
                String authorName = data.getResult().getAuthorName();
                xiangName.setText(authorName);
                //病症
                String disease = data.getResult().getDisease();
                xiangBing.setText(disease);
                //科室
                String departmentName = data.getResult().getDepartmentName();
                xiangKeshi.setText(departmentName);
                //详情
                String detail = data.getResult().getDetail();
                xiangXq.setText(detail);
                //经历
                String treatmentProcess = data.getResult().getTreatmentProcess();
                xiangJl.setText(treatmentProcess);
                //医院
                String treatmentHospital = data.getResult().getTreatmentHospital();
                xiangYiyuan.setText(treatmentHospital);
                //解答
                String content = data.getResult().getContent();
                tvMyJd.setText(content);
                //开始时间
                long treatmentStartTime = data.getResult().getTreatmentStartTime();
                Date date = new Date(treatmentStartTime);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
                xiangTime.setText(simpleDateFormat.format(date));
                //结束时间
                long treatmentEndTime = data.getResult().getTreatmentEndTime();
                Date date1 = new Date(treatmentEndTime);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM.dd");
                xiangEndTime.setText(simpleDateFormat1.format(date1));

                //相关图片
                String picture = data.getResult().getPicture();
                Glide.with(this).load(picture).into(xiangImg);
                //悬赏奖励数
                int amount = data.getResult().getAmount();
                xiangHb.setText(amount + "H币");
            } else {
                Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (obj instanceof  PublishBean) {
            PublishBean data= (PublishBean) obj;
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            if (data.getMessage().equals("发表成功")) {
                relativeEdit.setVisibility(View.GONE);
                HideIMEUtil.wrap(this);

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
    @OnClick({R2.id.xiang_back, R2.id.xiang_hb, R2.id.xiang_jd, R2.id.img_enjoy, R2.id.img_send, R2.id.linear_show})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiang_back:
                finish();
                break;
            case R.id.xiang_hb:
                break;
            case R.id.xiang_jd:
                linearJd.setVisibility(View.GONE);
                relativeEdit.setVisibility(View.VISIBLE);
                break;
            case R.id.img_enjoy:
                break;
            case R.id.img_send:
                String ed_tive = etText.getText().toString().trim();
                mPresenter.Publish(doctorId, sessionId, sickCircleId, ed_tive);
                break;
            case R.id.linear_show:
                if (whetherContent == 1) {
                    linearCancelJd.setVisibility(View.VISIBLE);
                    linearJd.setVisibility(View.GONE);
                    lineView.setVisibility(View.GONE);
                } else if (whetherContent == 2) {
                    linearCancelJd.setVisibility(View.GONE);
                    linearJd.setVisibility(View.VISIBLE);
                    lineView.setVisibility(View.VISIBLE);
                }
                relativeEdit.setVisibility(View.GONE);
                HideIMEUtil.wrap(this);
                //取消editText焦点
                //linearShow.setFocusableInTouchMode(true);
                break;
        }
    }
   /* @BindView(R2.id.details_backfh)
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


             *//*   Intent intent=new Intent(WriteCommActivity.this, MainActivity.class);
            startActivity(intent);*//*
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

    @OnClick({R2.id.details_backfh, R2.id.publish, R2.id.xiepingl, R2.id.xuanz})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R2.id.details_backfh) {
            finish();
        } else if (id == R2.id.publish) {
            jieda.setVisibility(View.INVISIBLE);
            wdejida.setVisibility(View.INVISIBLE);
            but.setVisibility(View.VISIBLE);
            butd.setVisibility(View.INVISIBLE);
        } else if (id == R2.id.xiepingl) {
        } else if (id == R2.id.xuanz) {
            jieda.setVisibility(View.VISIBLE);
            wdejida.setVisibility(View.VISIBLE);
            but.setVisibility(View.INVISIBLE);
            butd.setVisibility(View.VISIBLE);
        }

    }

*//*    @OnClick({R2.id.details_backfh, R2.id.xiepingl, R2.id.xuanz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R2.id.details_backfh:
                finish();
                break;
            case R2.id.xiepingl:
                break;
            case R2.id.xuanz:
                 jieda.setVisibility(View.VISIBLE);
                 wdejida.setVisibility(View.VISIBLE);
                break;
        }
    }*//*

    *//*@OnClick(R2.id.details_backfh)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R2.id.xuanz)
    public void onViewClicked() {
    }*/
}
