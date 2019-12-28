package com.wd.my_message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.wd.common.base.BaseActivity;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;

public class Special_HistoryActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_history);
    }

    @Override
    protected MyMessage_Presenter providePresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return 0;
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
