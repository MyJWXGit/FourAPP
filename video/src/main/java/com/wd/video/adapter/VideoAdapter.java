package com.wd.video.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wd.video.bean.Video_EntryBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.fragment.Video_QueryFragment;

import java.util.List;

/*
 *author:郭昊坤
 *date:2019/12/17
 *function:*/public class VideoAdapter extends FragmentPagerAdapter {
    List<Video_EntryBean.ResultBean> list;
    String entyid;

    public VideoAdapter(FragmentManager fm, List<Video_EntryBean.ResultBean> list, String entyid) {
        super(fm);
        this.list = list;
        this.entyid = entyid;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("yingyuanid", entyid);
        Video_QueryFragment video_queryFragment = new Video_QueryFragment();
        video_queryFragment.setArguments(bundle);
        return video_queryFragment;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
