package com.wd.my_message;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.EndInquiryBean;
import com.wd.my_message.bean.InquiryRecordBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class My_Present_InquiryActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(com.wd.health.R2.id.simple)
    SimpleDraweeView simple;
    @BindView(com.wd.health.R2.id.text_name)
    TextView textName;
    @BindView(com.wd.health.R2.id.text_type)
    TextView textType;
    @BindView(com.wd.health.R2.id.text_department)
    TextView textDepartment;
    @BindView(com.wd.health.R2.id.text_time)
    TextView textTime;
    @BindView(com.wd.health.R2.id.line1)
    LinearLayout line1;
    @BindView(com.wd.health.R2.id.bt_go_no)
    Button btGoNo;
    @BindView(com.wd.health.R2.id.bt_stop)
    Button btStop;
    @BindView(com.wd.health.R2.id.image)
    ImageView image;
    @BindView(com.wd.health.R2.id.re_latiview)
    RelativeLayout reLatiview;
    private int recordId;

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
        mPresenter.onInquiryRecord();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_my_present_inquiry;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof InquiryRecordBean) {
            InquiryRecordBean bean = (InquiryRecordBean) data;
            InquiryRecordBean.ResultBean list = bean.getResult();
            if (list != null) {
                image.setVisibility(View.GONE);
                reLatiview.setVisibility(View.VISIBLE);
                String imagePic = list.getImagePic();
                String jobTitle = list.getJobTitle();
                String doctorName = list.getDoctorName();
                String department = list.getDepartment();
                long inquiryTime = list.getInquiryTime();
                simple.setImageURI(imagePic);
                textName.setText(doctorName);
                textType.setText(jobTitle);
                textDepartment.setText(department);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(inquiryTime);
                String format = simpleDateFormat.format(date);
                textTime.setText(format);
                recordId = list.getRecordId();
            } else {
                image.setVisibility(View.VISIBLE);
                reLatiview.setVisibility(View.GONE);
            }
        } else if (data instanceof EndInquiryBean) {
            EndInquiryBean bean = (EndInquiryBean) data;
            String message = bean.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if (bean.getStatus().equals("0000")) {
                image.setVisibility(View.VISIBLE);
                reLatiview.setVisibility(View.GONE);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({com.wd.health.R2.id.bt_go_no, R2.id.bt_stop})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.bt_go_no) {
        } else if (id == R.id.bt_stop) {
            mPresenter.onEndInquiry(recordId);
        }
    }
}
