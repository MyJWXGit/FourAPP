package com.wd.video;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.video.adapter.VideoAdapter;
import com.wd.video.bean.Video_EntryBean;
import com.wd.video.contract.Contract;
import com.wd.video.presenter.Video_EntryPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "video/MainActivity")
public class MainActivity extends BaseActivity<Video_EntryPresenter> implements Contract.IView {

    @BindView(R2.id.tab)
    TabLayout tab;
    @BindView(R2.id.vp)
    ViewPager vp;
    private String id;


    @Override
    protected Video_EntryPresenter providePresenter() {
        return new Video_EntryPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        mPresenter.onVideo_Entry();
        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {

            private View view;
            private String type;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                type = tab.getText().toString();
                view = tab.getCustomView();
                if (view != null && view instanceof TextView) {
                    //改变tab选择状态下的字体大小
                    ((TextView) view).setTextSize(16);
                    //改变tab选择状态下的字体颜色
                    ((TextView) view).setTextColor(ContextCompat.getColor(MainActivity.this, R.color.tabxuan));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (view != null && view instanceof TextView) {
                    //改变tab未选择状态下的字体大小
                    ((TextView) view).setTextSize(16);
                    //改变tab未选择状态下的字体颜色
                    ((TextView) view).setTextColor(ContextCompat.getColor(MainActivity.this, R.color.tabbuxuan));

                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Context context() {
        return null;
    }


    @Override
    public void onSuccess(Object data) {
        Video_EntryBean video_entryBean = (Video_EntryBean) data;
        List<Video_EntryBean.ResultBean> result = video_entryBean.getResult();
        result = ((Video_EntryBean) data).getResult();
        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i).getName();
            id = ((Video_EntryBean) data).getResult().get(i).getId();
            tab.addTab(tab.newTab().setText(s));
        }
       /* VideoAdapter videoAdapter = new VideoAdapter(getSupportFragmentManager(),result,id);
        vp.setAdapter(videoAdapter);
        tab.setupWithViewPager(vp);*/

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
