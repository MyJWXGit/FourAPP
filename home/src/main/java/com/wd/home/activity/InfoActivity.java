package com.wd.home.activity;

import androidx.viewpager.widget.ViewPager;

import android.content.Context;

import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.home.presenter.HomePresenter;
import com.wd.home.adapter.ViewPager_Adapter;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.contract.Contract;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends BaseActivity<HomePresenter> implements Contract.IView {
    private TabLayout tab_layout;
    private ViewPager view_pager;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        view_pager = findViewById(R.id.view_pager);
        tab_layout = findViewById(R.id.tab_layout);
    }

    @Override
    protected void initData() {
        mPresenter.onDepartment();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_info;
    }

    @Override
    public void onSuccess(Object obj) {
        List<String> strings = new ArrayList<>();
        if (obj instanceof DepartmentBean) {
            DepartmentBean bean = (DepartmentBean) obj;
            List<DepartmentBean.ResultBean> result = bean.getResult();
            for (int i = 0; i < result.size(); i++) {
                strings.add(result.get(i).getDepartmentName());
            }
            tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
            tab_layout.setupWithViewPager(view_pager);
            ViewPager_Adapter view_adapter = new ViewPager_Adapter(getSupportFragmentManager(), strings, result);
            view_pager.setAdapter(view_adapter);
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
