package com.wd.health.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wd.health.adapter.fragment.Info_Fragment;
import com.wd.health.bean.DepartmentBean;

import java.util.List;

/**
 * @name Message_APP
 * @class name：com.bw.tablayout
 * @class describe
 * @anthor 24673
 * @time 2019/11/20 11:42
 * @change
 * @chang time
 * @class describe
 */
public class ViewPager_Adapter extends FragmentPagerAdapter {
    private List<String> list;
    private List<DepartmentBean.ResultBean> id_list;

    public ViewPager_Adapter(FragmentManager supportFragmentManager, List<String> list, List<DepartmentBean.ResultBean> id_list) {
        super(supportFragmentManager);
        this.list = list;
        this.id_list = id_list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //创建fragment对象并返回
        Bundle bundle = new Bundle();
        bundle.putString("url", list.get(position));
        bundle.putInt("id", id_list.get(position).getId());//数组添加 str[position]
        //实例化Fragment
        Info_Fragment info_fragment = new Info_Fragment();
        info_fragment.setArguments(bundle);
        return info_fragment;
    }

    //返回选项卡的文本 ，，，添加选项卡
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
