package com.wd.my_message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.common.base.BasePresenter;
import com.wd.my_message.view.Collection_Activity;
import com.wd.my_message.view.MessagesActivity;
import com.wd.my_message.view.Suggest_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/my_message/activity")
public class My_Home_Activity extends BaseActivity {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
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
    @BindView(R2.id.messages)
    ImageView imagemessage;
    @Override
    protected BasePresenter providePresenter() {
        return null;
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
        return R.layout.activity_my_home;
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

    @OnClick({R2.id.head_details_back,R2.id.messages, R2.id.my_image_simple, R2.id.my_text_login, R2.id.my_button_sing_in, R2.id.linear_lay, R2.id.my_button_inquiry, R2.id.my_button_history, R2.id.re_latiview, R2.id.my_button_record, R2.id.my_button_wallet, R2.id.my_button_collect, R2.id.my_button_suggest, R2.id.my_button_video, R2.id.my_button_patients_circle, R2.id.my_button_attention, R2.id.my_button_task, R2.id.my_button_set, R2.id.linear_my, R2.id.my_text_title})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.head_details_back) {
            finish();
        } else if (id == R.id.my_image_simple) {
        } else if (id == R.id.my_text_login) {
        } else if (id == R.id.my_button_sing_in) {
        } else if (id == R.id.linear_lay) {
        } else if (id == R.id.my_button_inquiry) {
        } else if (id == R.id.my_button_history) {
        } else if (id == R.id.re_latiview) {
        } else if (id == R.id.my_button_record) {
        } else if (id == R.id.my_button_wallet) {
        } else if (id == R.id.my_button_collect) {
            startActivity(new Intent(this, Collection_Activity.class));
        } else if (id == R.id.my_button_suggest) {
            startActivity(new Intent(this, Suggest_Activity.class));
        } else if (id == R.id.my_button_video) {
        } else if (id == R.id.my_button_patients_circle) {
        } else if (id == R.id.my_button_attention) {
        } else if (id == R.id.my_button_task) {
        } else if (id == R.id.my_button_set) {
        } else if (id == R.id.linear_my) {
        } else if (id == R.id.my_text_title) {
        } else if (id == R.id.messages){
            startActivity(new Intent(this, MessagesActivity.class));
        }
    }
}
