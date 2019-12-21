package com.wd.doctor.view.activity.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.MianBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.activity.PictureActivity;
import com.wd.doctor.view.activity.SystemActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity<LoginPresenter> implements Contract.IView {

    @BindView(R2.id.details_back)
    ImageView detailsBack;
    @BindView(R2.id.lingdan)
    ImageView lingdan;
    @BindView(R2.id.message_img)
    SimpleDraweeView messageImg;
    @BindView(R2.id.message_xiangq)
    TextView messageXiangq;
    @BindView(R2.id.message_history)
    LinearLayout messageHistory;
    @BindView(R2.id.message_wallet)
    LinearLayout messageWallet;
    @BindView(R2.id.message_suggest)
    LinearLayout messageSuggest;
    @BindView(R2.id.message_seif)
    LinearLayout messageSeif;
    private int doctorId;
    private String sessionId;
    private MianBean bean;

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
        sessionId = intent.getStringExtra("sessionId");
        mPresenter.Mian(doctorId, sessionId);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_message;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof MianBean) {
            bean = (MianBean) obj;
            messageImg.setImageURI(bean.getResult().getImagePic());
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R2.id.details_back, R2.id.lingdan, R2.id.message_xiangq, R2.id.message_history, R2.id.message_wallet, R2.id.message_suggest, R2.id.message_seif})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.details_back) {
            finish();
        } else if (id == R.id.lingdan) {
        } else if (id == R.id.message_xiangq) {
            Intent intent = new Intent(MessageActivity.this, PersonageActivity.class);
            intent.putExtra("doctorId", doctorId);
            intent.putExtra("sessionId", sessionId);
            startActivity(intent);
        } else if (id == R.id.message_history) {
        } else if (id == R.id.message_wallet) {
        } else if (id == R.id.message_suggest) {
        } else if (id == R.id.message_seif) {
        }
    }


    @OnClick(R2.id.message_img)
    public void onViewClicked() {
        View inflate = getLayoutInflater().inflate(R.layout.popwdenf, null);
        PopupWindow popupWindow=new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(messageSuggest,0,-80);
        View genghuan = inflate.findViewById(R.id.genghuan);
        View quxiao = inflate.findViewById(R.id.quxiao);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate.setVisibility(View.INVISIBLE);
            }
        });
        genghuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MessageActivity.this, PictureActivity.class);
                intent.putExtra("doctorId", doctorId);
                intent.putExtra("sessionId", sessionId);
                startActivity(intent);

            }
        });
    }

}
