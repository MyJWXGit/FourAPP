package com.wd.video;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.Logger;
import com.wd.video.adapter.VideoAdapter;
import com.wd.video.bean.Video_EntryBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;
import com.wd.video.presenter.Video_EntryPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends BaseActivity<Video_EntryPresenter> implements Contract.IView {

    private static final String TAG = "VideoActivity";
    TabLayout videoTab;
    ViewPager videoVp;


    private List<Video_QueryBean.ResultBean> result;
    private String eid;
    private String name;

    @Override
    protected Video_EntryPresenter providePresenter() {
        return new Video_EntryPresenter();
    }

    @Override
    protected void initView() {
        videoVp = findViewById(R.id.video_vp);
        videoTab = findViewById(R.id.video_tab);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("抖音");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    protected int initLayout() {
        return R.layout.activity_my_video;
    }

    @Override
    public Context context() {
        return null;
    }


    @Override
    protected void initData() {
        mPresenter.onVideo_Entry();
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof Video_EntryBean) {
            Video_EntryBean video_entryBean = (Video_EntryBean) data;
            for (int i = 0; i < result.size(); i++) {
                name = (video_entryBean).getResult().get(i).getName();
                eid = (video_entryBean).getResult().get(i).getId();
                Logger.d(TAG, name);
                Logger.d(TAG, name);
                TabLayout.Tab tab = videoTab.newTab();
                if (tab != null) {
                    tab.setText(name);
                    videoTab.addTab(tab);
                }
            }
            VideoAdapter videoAdapter = new VideoAdapter(getSupportFragmentManager(), result, eid);
            videoVp.setAdapter(videoAdapter);
            videoTab.setupWithViewPager(videoVp);
            /*videoTab.setOnClickListener(new View.OnClickListener() {

                private SharedPreferences.Editor edit;

                @Override
                public void onClick(View view) {
                    SharedPreferences essid = getSharedPreferences("essid", Context.MODE_PRIVATE);
                    edit = essid.edit();
                    edit.putString("eid", eid);
                    edit.commit();
                }
            });*/
        }
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
