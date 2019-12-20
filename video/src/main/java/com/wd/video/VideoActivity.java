package com.wd.video;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.video.fragment.BeautyFragment;
import com.wd.video.fragment.FitnessFragment;
import com.wd.video.fragment.FransnanaFragment;
import com.wd.video.fragment.HealthFragment;
import com.wd.video.fragment.KnowledgeFragment;
import com.wd.video.fragment.LoseWeightFragment;

import java.util.ArrayList;



public class VideoActivity extends AppCompatActivity {

    private static final String TAG = "VideoActivity";
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;
    private ViewPager videoVp;
    private TabLayout videoTab;
    private CheckBox video_pull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_video);
        videoVp = findViewById(R.id.video_vp);
        videoTab = findViewById(R.id.video_tab);
        video_pull = findViewById(R.id.video_pull);
        video_pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.video_pull:

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
                        break;
                }
            }
        });
        strings = new ArrayList<>();
        fragments = new ArrayList<>();
        fragments.add(new BeautyFragment());
        fragments.add(new HealthFragment());
        fragments.add(new FitnessFragment());
        fragments.add(new LoseWeightFragment());
        fragments.add(new FransnanaFragment());
        fragments.add(new KnowledgeFragment());
        strings.add("儿科");
        strings.add("常识");
        strings.add("健身");
        strings.add("美容");
        strings.add("心理");
        strings.add("养生");
        videoVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        videoTab.setupWithViewPager(videoVp);

    }
}
