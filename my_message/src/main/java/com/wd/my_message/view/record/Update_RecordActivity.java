package com.wd.my_message.view.record;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.bean.UpdateArchivesBean;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Update_RecordActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.vvv)
    View vvv;
    @BindView(R2.id.diseaseMain)
    EditText diseaseMain;
    @BindView(R2.id.line1)
    LinearLayout line1;
    @BindView(R2.id.diseaseNow)
    EditText diseaseNow;
    @BindView(R2.id.lin2)
    LinearLayout lin2;
    @BindView(R2.id.diseaseBefore)
    EditText diseaseBefore;
    @BindView(R2.id.lin3)
    LinearLayout lin3;
    @BindView(R2.id.treatmentHospitalRecent)
    EditText treatmentHospitalRecent;
    @BindView(R2.id.lin4)
    LinearLayout lin4;
    @BindView(R2.id.start)
    TextView start;
    @BindView(R2.id.edit_starttime)
    TextView editStarttime;
    @BindView(R2.id.img_startTime)
    ImageView imgStartTime;
    @BindView(R2.id.startTime)
    RelativeLayout startTime;
    @BindView(R2.id.lin5)
    LinearLayout lin5;
    @BindView(R2.id.end)
    TextView end;
    @BindView(R2.id.edit_endtime)
    TextView editEndtime;
    @BindView(R2.id.img_endTime)
    ImageView imgEndTime;
    @BindView(R2.id.endTime)
    RelativeLayout endTime;
    @BindView(R2.id.lin6)
    LinearLayout lin6;
    @BindView(R2.id.treatmentProcess)
    EditText treatmentProcess;
    @BindView(R2.id.lin7)
    LinearLayout lin7;
    @BindView(R2.id.info_img)
    SimpleDraweeView infoImg;
    @BindView(R2.id.addFiles)
    Button addFiles;
    @BindView(R2.id.lin8)
    LinearLayout lin8;
    private int id;
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    private String main;
    private String now;
    private String before;
    private String recent;
    private String process;
    private String startte;
    private String endte;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
    //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //接收值
        Intent intent = getIntent();
        //	档案id
        id = intent.getIntExtra("id", 0);
        //主要病状
        String diseaseMain1 = intent.getStringExtra("diseaseMain");
        //	现病史
        String diseaseNow1 = intent.getStringExtra("diseaseNow");
        //ji既往史
        String diseaseBefore1 = intent.getStringExtra("diseaseBefore");
        //zujin最近治疗医院
        String treatmentHospitalRecent1 = intent.getStringExtra("treatmentHospitalRecent");
        //	治疗过程
        String treatmentProcess1 = intent.getStringExtra("treatmentProcess");
        //开始时间格式：2019-4-1
        String treatmentStartTime1 = intent.getStringExtra("treatmentStartTime");
        //	结束时间格式：2019-4-1
        String treatmentEndTime1 = intent.getStringExtra("treatmentEndTime");
        //设置值
        diseaseMain.setText(diseaseMain1);
        diseaseNow.setText(diseaseNow1);
        diseaseBefore.setText(diseaseBefore1);
        treatmentHospitalRecent.setText(treatmentHospitalRecent1);
        editStarttime.setText(treatmentStartTime1);
        end.setText(treatmentEndTime1);

        //点击
        addFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //主要病症
                main = diseaseMain.getText().toString().trim();
                //现病史
                now = diseaseNow.getText().toString().trim();
                //既往史
                before = diseaseBefore.getText().toString().trim();
                //最近治疗医院
                recent = treatmentHospitalRecent.getText().toString().trim();
                //治疗过程
                process = treatmentProcess.getText().toString().trim();
                startte = editStarttime.getText().toString().trim();
                endte = end.getText().toString().trim();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("diseaseMain", main);
                map.put("diseaseNow", now);
                map.put("diseaseBefore", before);
                map.put("treatmentHospitalRecent", recent);
                map.put("treatmentProcess", process);
                map.put("treatmentStartTime", startte);
                map.put("treatmentEndTime", endte);
                mPresenter.onUpdateFile(map);
                finish();
            }
        });

        //开始时间
        imgStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Update_RecordActivity.this);
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
                        StringBuffer starttimes = new StringBuffer();
                        starttimes.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        editStarttime.setText(starttimes);
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
        imgEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Update_RecordActivity.this);
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
                        StringBuffer endtimes = new StringBuffer();
                        endtimes.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        end.setText(endtimes);
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
    }
    @OnClick(R2.id.message_fanhui)
    public void onViewClicked() {
        finish();
    }
    @Override
    protected int initLayout() {
        return R.layout.activity_update__record;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof UpdateArchivesBean){
            UpdateArchivesBean updateArchivesBean= (UpdateArchivesBean) data;
            if ( updateArchivesBean.getStatus().equals("0000")){
                Toast.makeText(this, updateArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
                Intent it = new Intent();
                it.putExtra("main",main);
                it.putExtra("now",now);
                it.putExtra("before",before);
                it.putExtra("recent",recent);
                it.putExtra("process",process);
                it.putExtra("starttimes",startte);
                it.putExtra("endtimes",endte);
                setResult(2000,it);
                finish();
            }else{
                // Toast.makeText(this, updateArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
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
