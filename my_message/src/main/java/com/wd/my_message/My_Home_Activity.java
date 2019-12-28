package com.wd.my_message;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.my_message.view.Attention_Doctor_Activity;
import com.wd.my_message.bean.QuerySignBean;
import com.wd.my_message.bean.SignBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.AutonymActivity;
import com.wd.my_message.view.Collection_Activity;
import com.wd.my_message.view.MessagesActivity;
import com.wd.my_message.view.My_Walk_Activity;
import com.wd.my_message.view.MyCircle_Patients_Activity;
import com.wd.my_message.view.My_Record_Activity;
import com.wd.my_message.view.My_Task_Activity;
import com.wd.my_message.view.My_Walk_Activity;
import com.wd.my_message.view.RecordActivity;
import com.wd.my_message.view.Suggest_message_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/health/activity")
public class My_Home_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.messages)
    ImageView messages;
    @BindView(R2.id.my_image_simple)
    SimpleDraweeView myImageSimple;
    @BindView(R2.id.my_text_login)
    TextView myTextLogin;
    @BindView(R2.id.my_button_sing_in)
    Button myButtonSingIn;
    @BindView(R2.id.linear_lay)
    LinearLayout linearLay;
    @BindView(R2.id.my_button_inquiry)
    RelativeLayout myButtonInquiry;
    @BindView(R2.id.my_button_history)
    RelativeLayout myButtonHistory;
    @BindView(R2.id.re_latiview)
    RelativeLayout reLatiview;
    @BindView(R2.id.my_button_record)
    LinearLayout myButtonRecord;
    @BindView(R2.id.my_button_wallet)
    LinearLayout myButtonWallet;
    @BindView(R2.id.my_button_collect)
    LinearLayout myButtonCollect;
    @BindView(R2.id.my_button_suggest)
    LinearLayout myButtonSuggest;
    @BindView(R2.id.my_button_video)
    LinearLayout myButtonVideo;
    @BindView(R2.id.my_button_patients_circle)
    LinearLayout myButtonPatientsCircle;
    @BindView(R2.id.my_button_attention)
    LinearLayout myButtonAttention;
    @BindView(R2.id.my_button_task)
    LinearLayout myButtonTask;
    @BindView(R2.id.my_button_set)
    LinearLayout myButtonSet;
    @BindView(R2.id.linear_my)
    LinearLayout linearMy;
    @BindView(R2.id.my_text_title)
    TextView myTextTitle;

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
        mPresenter.onQueryUserSign();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_my_home;
    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R2.id.head_details_back, R2.id.messages, R2.id.my_image_simple, R2.id.my_text_login, R2.id.my_button_sing_in, R2.id.linear_lay, R2.id.my_button_inquiry, R2.id.my_button_history, R2.id.re_latiview, R2.id.my_button_record, R2.id.my_button_wallet, R2.id.my_button_collect, R2.id.my_button_suggest, R2.id.my_button_video, R2.id.my_button_patients_circle, R2.id.my_button_attention, R2.id.my_button_task, R2.id.my_button_set, R2.id.linear_my, R2.id.my_text_title})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.head_details_back) {
            finish();
        } else if (id == R.id.my_image_simple) {
        } else if (id == R.id.my_text_login) {
        } else if (id == R.id.my_button_sing_in) {
            mPresenter.onSign();
        } else if (id == R.id.linear_lay) {
        } else if (id == R.id.my_button_inquiry) {
        } else if (id == R.id.my_button_history) {
        } else if (id == R.id.re_latiview) {
        } else if (id == R.id.my_button_record) {
            startActivity(new Intent(this, My_Record_Activity.class));
        } else if (id == R.id.my_button_wallet) {
            startActivity(new Intent(this, My_Walk_Activity.class));
        } else if (id == R.id.my_button_collect) {
            startActivity(new Intent(this, Collection_Activity.class));
        } else if (id == R.id.my_button_suggest) {
            startActivity(new Intent(this, Suggest_message_Activity.class));
        } else if (id == R.id.my_button_video) {
        } else if (id == R.id.my_button_patients_circle) {
            startActivity(new Intent(this, MyCircle_Patients_Activity.class));
        } else if (id == R.id.my_button_attention) {
            startActivity(new Intent(this, Attention_Doctor_Activity.class));
        } else if (id == R.id.my_button_task) {
            startActivity(new Intent(this, My_Task_Activity.class));
        } else if (id == R.id.my_button_set) {
            startActivity(new Intent(My_Home_Activity.this, SettingsActivity.class));
        } else if (id == R.id.linear_my) {
        } else if (id == R.id.my_text_title) {
        } else if (id == R.id.messages) {
            startActivity(new Intent(this, MessagesActivity.class));
        }
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof SignBean) {
            SignBean signBean = (SignBean) data;
            if (signBean.getStatus().equals("0000")) {
                Toast.makeText(this, signBean.getMessage(), Toast.LENGTH_SHORT).show();
                myButtonSingIn.setText("已签到");
                //查询当天是否签到
                mPresenter.onQueryUserSign();
            } else {
                Toast.makeText(this, signBean.getMessage(), Toast.LENGTH_SHORT).show();
                myButtonSingIn.setText("已签到");
            }
        } else if (data instanceof QuerySignBean) {
            QuerySignBean querySignBean = (QuerySignBean) data;
            if (querySignBean.getStatus().equals("0000")) {
                int result = querySignBean.getResult();
                if (result == 1) {
                    myButtonSingIn.setText("已签到");
                } else if (result == 2) {
                    myButtonSingIn.setText("签到");
                }
            }
        }

    }

    @Override
    public void onError(Throwable e) {

    }
}
