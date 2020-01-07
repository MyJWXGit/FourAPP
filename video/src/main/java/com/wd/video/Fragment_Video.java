package com.wd.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import com.wd.health.R;
import com.wd.health.R2;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseFragment;
import com.wd.common.base.BasePresenter;
import com.wd.video.bean.Video_EntryBean;
import com.wd.video.contract.Contract;
import com.wd.video.fragment.BeautyFragment;
import com.wd.video.presenter.Video_EntryPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.video
 * @class describe
 * @anthor 24673
 * @time 2019/12/24 16:23
 * @change
 * @chang time
 * @class describe
 */
@Route(path = "/fragment_video/fragment")
public class Fragment_Video extends BaseFragment<Video_EntryPresenter> implements Contract.IView {
    private ViewPager videoVp;
    private TabLayout videoTab;
    private CheckBox video_pull;
    private List<Video_EntryBean.ResultBean> result;

    @Override
    protected Video_EntryPresenter providePresenter() {
        return new Video_EntryPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my_video;
    }

    @Override
    protected void initView(View view) {
        videoVp = view.findViewById(R.id.video_vp);
        videoTab = view.findViewById(R.id.video_tab);
        video_pull = view.findViewById(R.id.video_pull);
    }

    @Override
    protected void initData() {
        mPresenter.onVideo_Entry();
        video_pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.video_pull) {
                    if (video_pull.isChecked()) {
                        float translationY = view.getTranslationY();
                        ObjectAnimator animator = ObjectAnimator.ofFloat(videoTab, "translationY", translationY, -120f);
                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", translationY, -120f);
                        animator.setDuration(500);
                        animator1.setDuration(500);
                        animator.start();
                        animator1.start();
                    } else {
                        float translationY = view.getTranslationY();
                        ObjectAnimator animator = ObjectAnimator.ofFloat(videoTab, "translationY", translationY, 0f);
                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", translationY, 0f);
                        animator.setDuration(500);
                        animator1.setDuration(500);
                        animator.start();
                        animator1.start();
                    }
                }
            }
        });
    }

    @Override
    public void onSuccess(Object data) {
        Video_EntryBean video_entryBean = (Video_EntryBean) data;
        result = video_entryBean.getResult();
        List<String> strings1 = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            String name = result.get(i).getName();
            strings1.add(name);
        }
        videoTab.addTab(videoTab.newTab().setText(strings1.get(0)));
        videoTab.addTab(videoTab.newTab().setText(strings1.get(1)));
        videoTab.addTab(videoTab.newTab().setText(strings1.get(2)));
        videoTab.addTab(videoTab.newTab().setText(strings1.get(3)));
        videoTab.addTab(videoTab.newTab().setText(strings1.get(4)));
        videoTab.addTab(videoTab.newTab().setText(strings1.get(5)));
        videoVp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("tid", result.get(position).getId());
                BeautyFragment beautyFragment = new BeautyFragment();
                beautyFragment.setArguments(bundle);
                return beautyFragment;
            }

            @Override
            public int getCount() {
                return strings1.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings1.get(position);
            }
        });
        videoTab.setupWithViewPager(videoVp);
        videoVp.setOffscreenPageLimit(strings1.size());
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
