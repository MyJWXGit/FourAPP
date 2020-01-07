package com.wd.health.view.frgament;

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

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.bean.Circle_list_Bean;
import com.wd.health.bean.SearchCircleBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MainPresenter;
import com.wd.health.utils.ObservableScrollView;
import com.wd.health.view.Circle_Details_Activity;
import com.wd.health.view.Seach_Circle_Activity;
import com.wd.health.view.adapter.Search_Circle_Adapter;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseFragment;
import com.wd.common.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @name Health
 * @class name：com.wd.circle.view.frgament
 * @class describe
 * @anthor 24673
 * @time 2019/12/24 15:44
 * @change
 * @chang time
 * @class describe
 */
@Route(path = "/fragment_circle/fragment")
public class Fragmentn_circle extends BaseFragment<MainPresenter> implements Contract.IView, ObservableScrollView.ScrollViewListener {
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
    private Unbinder bind;
    private int height;
    private List<Circle_list_Bean.ResultBean> result;

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_list_Bean) {
            Circle_list_Bean circle_list_bean = (Circle_list_Bean) obj;
            result = circle_list_bean.getResult();
            result = circle_list_bean.getResult();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                list.add(result.get(i).getDepartmentName());
                patientTvDepartmentName.setText(result.get(i).getDepartmentName());
            }
            viewpage.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
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
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            circleRecy3.setLayoutManager(linearLayoutManager);
            List<SearchCircleBean.ResultBean> result = searchCircleBean.getResult();
            Search_Circle_Adapter search_circle_adapter = new Search_Circle_Adapter(result, getContext());
            circleRecy3.setAdapter(search_circle_adapter);
            search_circle_adapter.setSetOnItems(new Search_Circle_Adapter.SetOnItems() {
                @Override
                public void setOns(int i) {
                    int sickCircleId = result.get(i).getSickCircleId();
                    Intent intent = new Intent(getContext(), Circle_Details_Activity.class);
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
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_circle__home_;
    }

    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this, view);
    }

    @Override
    protected void initData() {
        String o = (String) SpUtils.get(getContext(), Constant.Sp_touxiang, "");
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
                startActivity(new Intent(getContext(), Seach_Circle_Activity.class));
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
    public Context context() {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
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

    @OnClick(R2.id.circle_touxiang)
    public void onViewClicked() {
        ARouter.getInstance().build("/health/activity").navigation();
    }
}
