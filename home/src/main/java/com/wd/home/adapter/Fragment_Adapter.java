package com.wd.home.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：86157<p>
 * <p>创建时间：2019/9/28<p>
 * <p>更改时间：2019/9/28<p>
 */
public class Fragment_Adapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public Fragment_Adapter(FragmentManager supportFragmentManager, List<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

}
