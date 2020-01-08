package com.wd.my_message.view.message;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.SystemMessageBean;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.contract.Contract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemMessageActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.system_meassage_recycle)
    RecyclerView systemMeassageRecycle;
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
        mPresenter.onSystemmessage(1, 10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        systemMeassageRecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.message_activity_system_message;
    }

    @Override
    public void onSuccess(Object data) {
        SystemMessageBean systemMessageBean = (SystemMessageBean) data;
        if (systemMessageBean.getStatus().equals("0000")) {
            Toast.makeText(this, systemMessageBean.getMessage(), Toast.LENGTH_SHORT).show();
            List<SystemMessageBean.ResultBean> result = systemMessageBean.getResult();
            if (result != null) {
                messageIncludeRelat.setVisibility(View.GONE);
                systemMeassageRecycle.setVisibility(View.VISIBLE);
                //适配器
                SystemMessageAdapter systemMessageAdapter = new SystemMessageAdapter(result,this);
                systemMeassageRecycle.setAdapter(systemMessageAdapter);
            } else {
                messageIncludeRelat.setVisibility(View.VISIBLE);
                systemMeassageRecycle.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(this, systemMessageBean.getMessage(), Toast.LENGTH_SHORT).show();
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
}
