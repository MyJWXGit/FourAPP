package com.wd.health.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.presenter.MyMessage_Presenter;
import com.wd.health.contract.Contract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCircle_Patients_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.mysickcircle_rlv)
    RecyclerView mysickcircleRlv;
    @BindView(R2.id.message_include_img)
    SimpleDraweeView messageIncludeImg;
    @BindView(R2.id.message_include_text)
    TextView messageIncludeText;
    @BindView(R2.id.mysickcircle_button)
    Button mysickcircleButton;
    @BindView(R2.id.message_include_relat)
    RelativeLayout messageIncludeRelat;

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
        messageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected int initLayout() {
        return R.layout.message_activity_my_circle__patients_;
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
