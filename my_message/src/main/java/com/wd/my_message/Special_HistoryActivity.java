package com.wd.my_message;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.adapter.History_Adapter;
import com.wd.my_message.bean.HistoryBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Special_HistoryActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.recycler)
    RecyclerView recycler;

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
        mPresenter.onHistory(1, 5);
    }

    @Override
    protected int initLayout() {
        return R.layout.message_activity_special_history;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof HistoryBean) {
            HistoryBean bean = (HistoryBean) data;
            List<HistoryBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycler.setLayoutManager(linearLayoutManager);
            History_Adapter adapter = new History_Adapter(this, result);
            recycler.setAdapter(adapter);
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
