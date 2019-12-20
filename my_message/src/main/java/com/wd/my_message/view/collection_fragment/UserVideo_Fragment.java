package com.wd.my_message.view.collection_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wd.common.base.BaseFragment;
import com.wd.my_message.R;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyFragmentMessage_Presenter;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 14:54
 * @change
 * @chang time
 * @class describe
 */
public class UserVideo_Fragment extends BaseFragment<MyFragmentMessage_Presenter> implements Contract.IView  {

    @Override
    protected MyFragmentMessage_Presenter providePresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.uservideo_fragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

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
