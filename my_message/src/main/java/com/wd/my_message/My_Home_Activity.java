package com.wd.my_message;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.common.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}
