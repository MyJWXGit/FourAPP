package com.wd.circle.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wd.circle.R;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.common.base.BaseActivity;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReleaseCirclesActivity extends BaseActivity<MainPresenter> implements Contract.IView {

    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    @BindView(R.id.release_sickCircle_iv_user_head_pic)
    ImageView releaseSickCircleIvUserHeadPic;
    @BindView(R.id.patient_iv_user_message)
    ImageView patientIvUserMessage;
    @BindView(R.id.release_circle_et_title)
    EditText releaseCircleEtTitle;
    @BindView(R.id.release_circle_tv_choose_department)
    TextView releaseCircleTvChooseDepartment;
    @BindView(R.id.release_circle_iv_choose_department)
    RelativeLayout releaseCircleIvChooseDepartment;
    @BindView(R.id.release_circle_tv_choose_disease)
    TextView releaseCircleTvChooseDisease;
    @BindView(R.id.release_circle_iv_choose_disease)
    RelativeLayout releaseCircleIvChooseDisease;
    @BindView(R.id.release_circle_et_detail)
    EditText releaseCircleEtDetail;
    @BindView(R.id.release_circle_et_treatmentHospital)
    EditText releaseCircleEtTreatmentHospital;
    @BindView(R.id.release_circle_tv_startTime)
    TextView releaseCircleTvStartTime;
    @BindView(R.id.release_circle_iv_startTime)
    RelativeLayout releaseCircleIvStartTime;
    @BindView(R.id.release_circle_tv_endTime)
    TextView releaseCircleTvEndTime;
    @BindView(R.id.release_circle_iv_endTime)
    RelativeLayout releaseCircleIvEndTime;
    @BindView(R.id.release_circle_et_treatmentProcess)
    EditText releaseCircleEtTreatmentProcess;
    @BindView(R.id.release_circle_iv_upload_Picture)
    ImageView releaseCircleIvUploadPicture;
    @BindView(R.id.release_circle_iv_delete_Picture)
    ImageView releaseCircleIvDeletePicture;
    @BindView(R.id.release_circle_btn_publish)
    Button releaseCircleBtnPublish;
    @BindView(R.id.release_circle_linear_sick_circle)
    LinearLayout releaseCircleLinearSickCircle;

    @Override
    protected int initLayout() {
        return R.layout.activity_release_circles;
    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //开始时间
        releaseCircleIvStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        releaseCircleTvStartTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        //结束时间
        releaseCircleIvEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        releaseCircleTvEndTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        String trim = releaseCircleEtTitle.getText().toString().trim();
        mPresenter.onHome();
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onError(Throwable e) {

    }

}
