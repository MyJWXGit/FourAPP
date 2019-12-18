package com.wd.doctor.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.wd.doctor.R;
import com.wd.doctor.view.fragment.PictureFragmentone;
import com.wd.doctor.view.fragment.PictureFragmenttwo;

import java.util.ArrayList;
import java.util.List;

public class PictureActivity extends AppCompatActivity {
    private ViewPager viewpagg;
    private RadioGroup ragoup;
    private List<Fragment> list;
    private PictureFragmentone pictureFragmentone;
    private PictureFragmenttwo pictureFragmenttwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        viewpagg=findViewById(R.id.viewpagg);
        ragoup=findViewById(R.id.ragoup);
        pictureFragmentone=new PictureFragmentone();
        pictureFragmenttwo=new PictureFragmenttwo();
        list=new ArrayList<>();
        list.add(pictureFragmentone);
        list.add(pictureFragmenttwo);
     viewpagg.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
         @NonNull
         @Override
         public Fragment getItem(int position) {
             return list.get(position);
         }

         @Override
         public int getCount() {
             return list.size();
         }
     });
 /*    ragoup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup radioGroup, int i) {
             switch (i){
                 case R.id.
             }
         }
     });*/
    }
}
