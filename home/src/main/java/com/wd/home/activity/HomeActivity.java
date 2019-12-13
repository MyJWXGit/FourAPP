package com.wd.home.activity;

import android.content.Context;
import android.os.Bundle;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.common.base.BaseActivity;
import com.wd.home.R;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity<HomePresenter> implements Contract.IView {

    @BindView(R.id.xRecycler)
    XRecyclerView xRecycler;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
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
        return R.layout.activity_home;
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
