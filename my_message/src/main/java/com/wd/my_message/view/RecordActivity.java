package com.wd.my_message.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.my_message.R;
import com.wd.my_message.R2;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.back)
    ImageView back;
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
    @BindView(R2.id.start_image)
    ImageView startImage;
    @BindView(R2.id.startTime)
    RelativeLayout startTime;
    @BindView(R2.id.lin5)
    LinearLayout lin5;
    @BindView(R2.id.end)
    TextView end;
    @BindView(R2.id.edit_endtime)
    TextView editEndtime;
    @BindView(R2.id.end_image)
    ImageView endImage;
    @BindView(R2.id.endTime)
    RelativeLayout endTime;
    @BindView(R2.id.lin6)
    LinearLayout lin6;
    @BindView(R2.id.treatmentProcess)
    EditText treatmentProcess;
    @BindView(R2.id.lin7)
    LinearLayout lin7;
    @BindView(R2.id.bo_image_list)
    RecyclerView boImageList;
    @BindView(R2.id.add_image)
    ImageView addImage;
    @BindView(R2.id.addFiles)
    Button addFiles;
    @BindView(R2.id.lin8)
    LinearLayout lin8;

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

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_record;
    }

    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

}
