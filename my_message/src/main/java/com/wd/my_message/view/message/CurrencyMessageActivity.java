package com.wd.my_message.view.message;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.my_message.R;
import com.wd.my_message.R2;
import com.wd.my_message.bean.HealthyCurrencyBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.message.CurrencyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CurrencyMessageActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.currency_meassage_recycle)
    RecyclerView currencyMeassageRecycle;
    @BindView(R2.id.message_include_img)
    SimpleDraweeView messageIncludeImg;
    @BindView(R2.id.message_include_text)
    TextView messageIncludeText;
    @BindView(R2.id.message_include_relat)
    RelativeLayout messageIncludeRelat;
    private List<HealthyCurrencyBean.ResultBean> result;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        currencyMeassageRecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_currency_message;
    }

    @Override
    public void onSuccess(Object data) {
        HealthyCurrencyBean healthyCurrencyBean= (HealthyCurrencyBean) data;
        if (healthyCurrencyBean.getStatus().equals("0000")){
            result = healthyCurrencyBean.getResult();
            if (result!=null) {
                messageIncludeRelat.setVisibility(View.GONE);
                currencyMeassageRecycle.setVisibility(View.VISIBLE);
                CurrencyAdapter currencyAdapter = new CurrencyAdapter(result, this);
                currencyMeassageRecycle.setAdapter(currencyAdapter);
            }else{
                messageIncludeRelat.setVisibility(View.VISIBLE);
                currencyMeassageRecycle.setVisibility(View.GONE);
            }
        }else{
            Toast.makeText(this, healthyCurrencyBean.getMessage(), Toast.LENGTH_SHORT).show();

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
