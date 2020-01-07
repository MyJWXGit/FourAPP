package com.wd.health.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.presenter.MyMessage_Presenter;
import com.wd.health.view.collection_fragment.PageAdapter;
import com.wd.health.view.collection_fragment.UserSickCollection_Fragment;
import com.wd.health.view.collection_fragment.UserVideo_Fragment;
import com.wd.health.contract.Contract;
import com.wd.health.view.collection_fragment.UserCollection_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Collection_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.favorite_tab)
    TabLayout favoriteTab;
    @BindView(R2.id.favorite_vp)
    ViewPager favoriteVp;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        List<Fragment> fragments=new ArrayList<>();

        fragments.add(new UserCollection_Fragment());
        fragments.add(new UserVideo_Fragment());
        fragments.add(new UserSickCollection_Fragment());


        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(),fragments);
        favoriteVp.setAdapter(pageAdapter);
        favoriteTab.setupWithViewPager(favoriteVp);
        favoriteTab.getTabAt(0).setText("健康咨询");
        favoriteTab.getTabAt(1).setText("健康视频");
        favoriteTab.getTabAt(2).setText("病友圈");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.message_activity_my_collection;
    }

    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

}
