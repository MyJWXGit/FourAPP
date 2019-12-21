package com.wd.my_message.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.my_message.R;
import com.wd.my_message.R2;
import com.wd.my_message.bean.ConsumptionRecordBean;
import com.wd.my_message.bean.MyWalletBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.walk.ConsumptionRecordAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class My_Walk_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.img_buttton)
    ImageView imgButtton;
    @BindView(R2.id.hbi)
    TextView hbi;
    @BindView(R2.id.my_relat)
    RelativeLayout myRelat;
    @BindView(R2.id.mywallet_tixian)
    Button mywalletTixian;
    @BindView(R2.id.mywallet_chongzhi)
    Button mywalletChongzhi;
    @BindView(R2.id.mywallet_recycler)
    RecyclerView mywalletRecycler;

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
        mPresenter.onGetmyWallet();
        //bujuguanliqi 布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mywalletRecycler.setLayoutManager(linearLayoutManager);
        mPresenter.onRecordsOfConsumption(1,20);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_my__walk_;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof MyWalletBean) {
            MyWalletBean myWalletBean = (MyWalletBean) data;
            if (myWalletBean.getStatus().equals("0000")) {
                hbi.setText(myWalletBean.getResult() + "");

            } else {
                Toast.makeText(this, myWalletBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (data instanceof ConsumptionRecordBean){
            ConsumptionRecordBean consumptionRecordBean= (ConsumptionRecordBean) data;
            if (consumptionRecordBean.getStatus().equals("0000")){
                Toast.makeText(this, consumptionRecordBean.getMessage(), Toast.LENGTH_SHORT).show();
                List<ConsumptionRecordBean.ResultBean> result = consumptionRecordBean.getResult();
                if (result!=null){
                    ConsumptionRecordAdapter consumptionRecordAdapter = new ConsumptionRecordAdapter(result,this);
                    mywalletRecycler.setAdapter(consumptionRecordAdapter);
                }
            }else{
                Toast.makeText(this, consumptionRecordBean.getMessage(), Toast.LENGTH_SHORT).show();
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

    @OnClick({R2.id.message_fanhui, R2.id.mywallet_tixian, R2.id.mywallet_chongzhi})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.message_fanhui) {
            finish();
        } else if (id == R.id.mywallet_tixian) {
        } else if (id == R.id.mywallet_chongzhi) {
        }
    }
}
