package com.wd.video.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wd.video.bean.Video_EntryBean;
import com.wd.video.fragment.VideoFragment;

import java.util.List;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class VideoAdapter  extends FragmentPagerAdapter {
     List<Video_EntryBean.ResultBean> list;
     String EntryId;

    public VideoAdapter(@NonNull FragmentManager fm,  List<Video_EntryBean.ResultBean> list, String entryId) {
        super(fm);
        this.list = list;
        EntryId = entryId;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("EntryId",EntryId);
        VideoFragment videoFragment = new VideoFragment();
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) list.get(position);
    }
}
