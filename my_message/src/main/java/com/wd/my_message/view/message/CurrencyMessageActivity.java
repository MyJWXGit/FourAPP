package com.wd.my_message.view.message;

import android.content.Context;

import com.wd.common.base.BaseActivity;
import com.wd.my_message.R;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;


public class CurrencyMessageActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_currency_message;
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
