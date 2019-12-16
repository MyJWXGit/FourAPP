package com.wd.home.fragment.common_fragment;

import android.content.Context;
import android.view.View;

import com.wd.common.base.BaseFragment;
import com.wd.home.R;
import com.wd.home.presenter.Fragment_Presenter;
import com.wd.home.presenter.HomePresenter;

/**
 * @name Health
 * @class name：com.wd.home.fragment.common_fragment
 * @class describe
 * @anthor 24673
 * @time 2019/12/16 9:51
 * @change
 * @chang time
 * @class describe
 */
public class Illness_Fragment extends BaseFragment<Fragment_Presenter> {
    @Override
    protected Fragment_Presenter providePresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.illness_fragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public Context context() {
        return null;
    }
}
