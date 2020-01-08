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
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.Message_LoginBean;
import com.wd.my_message.bean.QuerySignBean;
import com.wd.my_message.bean.SignBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.Attention_Doctor_Activity;
import com.wd.my_message.view.Collection_Activity;
import com.wd.my_message.view.MessagesActivity;
import com.wd.my_message.view.Suggest_message_Activity;
import com.wd.my_message.view.My_Walk_Activity;
import com.wd.my_message.view.MyCircle_Patients_Activity;
import com.wd.my_message.view.My_Record_Activity;
import com.wd.my_message.view.My_Task_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/health/activity")
public class My_Home_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(com.wd.health.R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(com.wd.health.R2.id.messages)
    ImageView messages;
    @BindView(com.wd.health.R2.id.my_image_simple)
    SimpleDraweeView myImageSimple;
    @BindView(com.wd.health.R2.id.my_text_login)
    TextView myTextLogin;
    @BindView(com.wd.health.R2.id.my_button_sing_in)
    Button myButtonSingIn;
    @BindView(com.wd.health.R2.id.linear_lay)
    LinearLayout linearLay;
    @BindView(com.wd.health.R2.id.my_button_inquiry)
    RelativeLayout myButtonInquiry;
    @BindView(com.wd.health.R2.id.my_button_history)
    RelativeLayout myButtonHistory;
    @BindView(com.wd.health.R2.id.re_latiview)
    RelativeLayout reLatiview;
    @BindView(com.wd.health.R2.id.my_button_record)
    LinearLayout myButtonRecord;
    @BindView(com.wd.health.R2.id.my_button_wallet)
    LinearLayout myButtonWallet;
    @BindView(com.wd.health.R2.id.my_button_collect)
    LinearLayout myButtonCollect;
    @BindView(com.wd.health.R2.id.my_button_suggest)
    LinearLayout myButtonSuggest;
    @BindView(com.wd.health.R2.id.my_button_video)
    LinearLayout myButtonVideo;
    @BindView(com.wd.health.R2.id.my_button_patients_circle)
    LinearLayout myButtonPatientsCircle;
    @BindView(com.wd.health.R2.id.my_button_attention)
    LinearLayout myButtonAttention;
    @BindView(com.wd.health.R2.id.my_button_task)
    LinearLayout myButtonTask;
    @BindView(com.wd.health.R2.id.my_button_set)
    LinearLayout myButtonSet;
    @BindView(com.wd.health.R2.id.linear_my)
    LinearLayout linearMy;
    @BindView(com.wd.health.R2.id.my_text_title)
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
        mPresenter.onMessage();
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

    @OnClick({com.wd.health.R2.id.head_details_back, com.wd.health.R2.id.messages, com.wd.health.R2.id.my_image_simple, com.wd.health.R2.id.my_text_login, com.wd.health.R2.id.my_button_sing_in, com.wd.health.R2.id.linear_lay, com.wd.health.R2.id.my_button_inquiry, com.wd.health.R2.id.my_button_history, com.wd.health.R2.id.re_latiview, com.wd.health.R2.id.my_button_record, com.wd.health.R2.id.my_button_wallet, com.wd.health.R2.id.my_button_collect, com.wd.health.R2.id.my_button_suggest, com.wd.health.R2.id.my_button_video, com.wd.health.R2.id.my_button_patients_circle, com.wd.health.R2.id.my_button_attention, com.wd.health.R2.id.my_button_task, com.wd.health.R2.id.my_button_set, com.wd.health.R2.id.linear_my, R2.id.my_text_title})
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
            startActivity(new Intent(My_Home_Activity.this, My_Present_InquiryActivity.class));
        } else if (id == R.id.my_button_history) {
            startActivity(new Intent(My_Home_Activity.this, Special_HistoryActivity.class));
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
        if (data instanceof Message_LoginBean) {
            Message_LoginBean bean = (Message_LoginBean) data;
            String headPic = bean.getResult().getHeadPic();
            String userName = bean.getResult().getUserName();
            myImageSimple.setImageURI(headPic);
            myTextLogin.setText(userName);
        } else if (data instanceof SignBean) {
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
