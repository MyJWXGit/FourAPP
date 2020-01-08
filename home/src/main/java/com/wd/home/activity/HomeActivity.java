package com.wd.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.common.base.BaseActivity;
import com.wd.common.base.BasePresenter;
import com.wd.health.R;
import com.wd.home.adapter.Fragment_Adapter;
import com.wd.home.fragment.Fragment_home;
import com.wd.home.contract.Contract;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

@Route(path = "/home/activity")
public class HomeActivity extends BaseActivity implements Contract.IView, View.OnClickListener {
    private ViewPager home_viewpager;
    private List<Fragment> fragments = new ArrayList<>();
    private LinearLayout linear_my, linear_home, linear_cinema, linear_home_null, linear_my_null, linear_cinema_null, line1, line2, line3;
    private static final String TAG = "HomeActivity";

    @Override
    protected void initView() {
        home_viewpager = findViewById(R.id.home_viewpager);
        linear_my = findViewById(R.id.linear_my);
        linear_home = findViewById(R.id.linear_home);
        linear_cinema = findViewById(R.id.linear_cinema);
        linear_home_null = findViewById(R.id.linear_home_null);
        linear_my_null = findViewById(R.id.linear_my_null);
        linear_cinema_null = findViewById(R.id.linear_cinema_null);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);
    }

    @Override
    protected void initData() {
        Fragment fragment_circle = (Fragment) ARouter.getInstance().build("/fragment_circle/fragment").navigation();
        Fragment fragment_video = (Fragment) ARouter.getInstance().build("/fragment_video/fragment").navigation();
        fragments.add(new Fragment_home());
        fragments.add(fragment_circle);
        fragments.add(fragment_video);
        Fragment_Adapter fragment_adapter = new Fragment_Adapter(getSupportFragmentManager(), fragments);
        home_viewpager.setAdapter(fragment_adapter);
        home_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ClickList();
    }

    private void ClickList() {
        line1.setOnClickListener(this);
        line2.setOnClickListener(this);
        line3.setOnClickListener(this);

        home_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                linear_home.setSelected(true);
                checkTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.home_activity_home;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    private void checkTab(int position) {
        if (position == R.id.line1) {
            home_viewpager.setCurrentItem(0);
        } else if (position == R.id.line2) {
            home_viewpager.setCurrentItem(1);
        } else if (position == R.id.line3) {
            home_viewpager.setCurrentItem(2);
        } else if (position == 0) {
            linear_home.setVisibility(View.VISIBLE);
            linear_home_null.setVisibility(View.GONE);
            linear_cinema_null.setVisibility(View.VISIBLE);
            linear_my_null.setVisibility(View.VISIBLE);
            linear_cinema.setVisibility(View.GONE);
            linear_my.setVisibility(View.GONE);
        } else if (position == 1) {
            linear_cinema.setVisibility(View.VISIBLE);
            linear_cinema_null.setVisibility(View.GONE);
            linear_my_null.setVisibility(View.VISIBLE);
            linear_home_null.setVisibility(View.VISIBLE);
            linear_my.setVisibility(View.GONE);
            linear_home.setVisibility(View.GONE);
        } else if (position == 2) {
            linear_my.setVisibility(View.VISIBLE);
            linear_my_null.setVisibility(View.GONE);
            linear_home_null.setVisibility(View.VISIBLE);
            linear_cinema_null.setVisibility(View.VISIBLE);
            linear_home.setVisibility(View.GONE);
            linear_cinema.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        checkTab(view.getId());
    }
}