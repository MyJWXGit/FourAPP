package com.wd.circle.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.wd.circle.R;
import com.wd.circle.R2;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.utils.ObservableScrollView;
import com.wd.circle.view.adapter.Search_Circle_Adapter;
import com.wd.circle.view.frgament.HomeFragment;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Circle_Home_Activity extends BaseActivity<MainPresenter> implements Contract.IView, ObservableScrollView.ScrollViewListener {
    @BindView(R2.id.circle_touxiang)
    SimpleDraweeView circleTouxiang;
    @BindView(R2.id.circle_message)
    ImageView circleMessage;
    @BindView(R2.id.patient_relative_titlebar)
    RelativeLayout patientRelativeTitlebar;
    @BindView(R2.id.patient_tv_department_name)
    TextView patientTvDepartmentName;
    @BindView(R2.id.citcle_edit)
    EditText citcleEdit;
    @BindView(R2.id.patient_iv_user_news)
    ImageView patientIvUserNews;
    @BindView(R2.id.patient_relative_serach)
    RelativeLayout patientRelativeSerach;
    @BindView(R2.id.tab)
    TabLayout tab;
    @BindView(R2.id.patient_iv_search)
    ImageView patientIvSearch;
    @BindView(R2.id.bbb)
    RelativeLayout bbb;
    @BindView(R2.id.viewpage)
    ViewPager viewpage;
    @BindView(R2.id.circle_recy3)
    RecyclerView circleRecy3;
    @BindView(R2.id.patient_linear_layout)
    LinearLayout patientLinearLayout;
    @BindView(R2.id.patient_scorll_view)
    ObservableScrollView patientScorllView;
    private List<Circle_list_Bean.ResultBean> result;
    private Unbinder bind;
    private int id;
    private int height;

    @Override
    protected int initLayout() {
        return R.layout.activity_circle__home_;
    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        String o = (String) SpUtils.get(this, Constant.Sp_touxiang, "");
        circleTouxiang.setImageURI(o);
        mPresenter.onHome();
        initListener();
        patientScorllView.setScrollViewListener(this);
        citcleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String trim = citcleEdit.getText().toString().trim();
                if (trim != null) {
                    mPresenter.onSearch(trim);
                    circleRecy3.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        patientIvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Circle_Home_Activity.this, Seach_Circle_Activity.class));
            }
        });
    }

    private void initListener() {
        //获取控件的视图观察者,一遍通过视图观察者得到控件的宽高属性
        ViewTreeObserver viewTreeObserver = patientLinearLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                //此时就可以得到控件的高度
                height = patientLinearLayout.getHeight();
                //我们做的第一件事情就是移除监听,卸磨杀驴,减少内存的消耗
                patientLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
        if (t <= 10) {
            //设置标题隐藏
            patientRelativeTitlebar.setVisibility(View.VISIBLE);
            //设置搜索框显示
            patientRelativeSerach.setVisibility(View.GONE);
        } else if (t > 10 && t < height) {
            //设置搜索框隐藏
            patientRelativeSerach.setVisibility(View.VISIBLE);
            //标题显示
            patientRelativeTitlebar.setVisibility(View.GONE);
        }
    }

    @Override
    public Context context() {
        return null;
    }


    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_list_Bean) {
            Circle_list_Bean circle_list_bean = (Circle_list_Bean) obj;
            result = circle_list_bean.getResult();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                list.add(result.get(i).getDepartmentName());
                patientTvDepartmentName.setText(result.get(i).getDepartmentName());
            }
            viewpage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                @NonNull
                @Override
                public Fragment getItem(int position) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", result.get(position).getId());
                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);
                    return homeFragment;
                }

                @Override
                public int getCount() {
                    return list.size();
                }

                @Nullable
                @Override
                public CharSequence getPageTitle(int position) {
                    return list.get(position);
                }
            });
            tab.setupWithViewPager(viewpage);
            viewpage.setOffscreenPageLimit(list.size());
        } else if (obj instanceof SearchCircleBean) {
            SearchCircleBean searchCircleBean = (SearchCircleBean) obj;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            circleRecy3.setLayoutManager(linearLayoutManager);
            List<SearchCircleBean.ResultBean> result = searchCircleBean.getResult();
            Search_Circle_Adapter search_circle_adapter = new Search_Circle_Adapter(result, Circle_Home_Activity.this);
            circleRecy3.setAdapter(search_circle_adapter);
            search_circle_adapter.setSetOnItems(new Search_Circle_Adapter.SetOnItems() {
                @Override
                public void setOns(int i) {
                    int sickCircleId = result.get(i).getSickCircleId();
                    Intent intent = new Intent(Circle_Home_Activity.this, Circle_Details_Activity.class);
                    intent.putExtra("sickCircleId", sickCircleId);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
