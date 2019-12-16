package com.wd.doctor.view.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wd.doctor.bean.InquiryBean;
import com.wd.doctor.view.fragment.InquiryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/12/14
 * author:金豪(Lenovo)
 * function:
 */
public class InquiryAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tab;
    private List<InquiryBean.ResultBean> list;
    public InquiryAdapter(@NonNull FragmentManager fm, ArrayList<String> tab, List<InquiryBean.ResultBean> list) {
        super(fm);
        this.tab = tab;
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("departmentId",list.get(position).getId()+"");
        InquiryFragment inquiryAdapter=new InquiryFragment();
        inquiryAdapter.setArguments(bundle);
        return inquiryAdapter;
    }

    @Override
    public int getCount() {
        return tab.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
