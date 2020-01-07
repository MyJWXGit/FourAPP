package com.wd.health.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.common.base.BasePresenter;
import com.wd.health.R;
import com.wd.health.adapter.utils_adapter.MyFragment_Adapter;
import com.wd.health.fragment.common_fragment.Illness_Fragment;
import com.wd.health.fragment.common_fragment.dyug_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.wd.health.R2;
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

        Intent intent = getIntent();
        int one = intent.getIntExtra("1", 0);
        int two = intent.getIntExtra("2", 0);
        if (one == 1) {
            viewPager.setCurrentItem(0);
        } else if (two == 2) {
            viewPager.setCurrentItem(1);
        }
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
