package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.common.base.BasePresenter;
import com.wd.home.R;
import com.wd.home.R2;
import com.wd.home.adapter.utils_adapter.MyFragment_Adapter;
import com.wd.home.fragment.common_fragment.Illness_Fragment;
import com.wd.home.fragment.common_fragment.dyug_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonActivity extends BaseActivity {
    @BindView(R2.id.tab)
    TabLayout tab;
    @BindView(R2.id.view_pager)
    ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabs = new ArrayList<>();

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }

    @Override
    protected void initData() {
        tabs.add("常见病状");
        tabs.add("常见药品");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.setTabMode(TabLayout.MODE_FIXED);

        fragments.add(new dyug_Fragment());
        fragments.add(new Illness_Fragment());
        viewPager.setOffscreenPageLimit(2);
        tab.setupWithViewPager(viewPager);
        MyFragment_Adapter fragment_adapter = new MyFragment_Adapter(getSupportFragmentManager(), fragments, tabs);
        viewPager.setAdapter(fragment_adapter);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_common;
    }

    @Override
    public Context context() {
        return null;
    }
}
