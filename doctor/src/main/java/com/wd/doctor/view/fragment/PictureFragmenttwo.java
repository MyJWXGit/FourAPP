package com.wd.doctor.view.fragment;

import android.content.Context;
import android.view.View;

import com.wd.common.base.BaseFragment;
import com.wd.common.base.BasePresenter;
import com.wd.doctor.R;
import com.wd.doctor.present.LoginPresenter;

/**
 * date:2019/12/18
 * author:金豪(Lenovo)
 * function:
 */
public class PictureFragmenttwo extends BaseFragment<LoginPresenter> {
    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.picturefragmenttwo;
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
