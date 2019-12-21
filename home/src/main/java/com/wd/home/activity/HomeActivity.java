package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.home.R;
import com.wd.home.R2;
import com.wd.home.adapter.Department_Adapter;
import com.wd.home.adapter.Information_Adapter;
import com.wd.home.adapter.Plate_List_Adapter;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.Information_ListBean;
import com.wd.home.bean.Plate_ListBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.HomePresenter;

import java.util.AbstractList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/home/activity")
public class HomeActivity extends BaseActivity<HomePresenter> implements Contract.IView {
    @BindView(R2.id.edit_query)
    EditText editQuery;
    @BindView(R2.id.xBanner)
    XBanner xBanner;
    @BindView(R2.id.recycler)
    RecyclerView recycler;
    @BindView(R2.id.title_recycler)
    RecyclerView titleRecycler;
    @BindView(R2.id.advisory_recycler)
    RecyclerView advisoryRecycler;
    @BindView(R2.id.common_Illness)
    LinearLayout commonIllness;
    @BindView(R2.id.common_drug)
    LinearLayout commonDrug;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        mPresenter.onBanner();
        mPresenter.onDepartment();
        mPresenter.onPlateList();
        mPresenter.onInformationList(3, 1, 5);
        advisoryRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof BannerBean) {
            BannerBean bean = (BannerBean) obj;
            List<BannerBean.ResultBean> result = bean.getResult();
            AbstractList<SimpleBannerInfo> info = new AbstractList<SimpleBannerInfo>() {
                @Override
                public SimpleBannerInfo get(int index) {
                    return null;
                }

                @Override
                public int size() {
                    return result.size();
                }
            };
            xBanner.setBannerData(R.layout.image_fresco, info);
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    String imageUrl = result.get(position).getImageUrl();
                    SimpleDraweeView simpleDraweeView = view.findViewById(R.id.simple);
                    DraweeController controller = Fresco.newDraweeControllerBuilder()
                            .setUri(imageUrl)
                            .setAutoPlayAnimations(true).build();
                    simpleDraweeView.setController(controller);
                }
            });
        } else if (obj instanceof DepartmentBean) {
            DepartmentBean bean = (DepartmentBean) obj;
            List<DepartmentBean.ResultBean> result = bean.getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            Department_Adapter department_adapter = new Department_Adapter(result, this);
            recycler.setLayoutManager(gridLayoutManager);
            recycler.setAdapter(department_adapter);
        } else if (obj instanceof Plate_ListBean) {
            Plate_ListBean bean = (Plate_ListBean) obj;
            List<Plate_ListBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            titleRecycler.setLayoutManager(linearLayoutManager);
            Plate_List_Adapter list_adapter = new Plate_List_Adapter(result, this);
            titleRecycler.setAdapter(list_adapter);


            list_adapter.setOnId(new Plate_List_Adapter.onPosition() {
                @Override
                public void onId(int position) {
                    mPresenter.onInformationList(result.get(position).getId(), 1, 5);
                    list_adapter.setOnColor(position);
                    list_adapter.notifyDataSetChanged();
                }
            });
        } else if (obj instanceof Information_ListBean) {
            Information_ListBean bean = (Information_ListBean) obj;
            List<Information_ListBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            advisoryRecycler.setLayoutManager(linearLayoutManager);
            Information_Adapter information_adapter = new Information_Adapter(result, this);
            advisoryRecycler.setAdapter(information_adapter);

            information_adapter.setOnItemInfoId(new Information_Adapter.onItemInfoId() {
                @Override
                public void onInfoId(int infoId) {
                    Intent intent = new Intent(HomeActivity.this, FindInfoActivity.class);
                    intent.putExtra(Constant.INFOID, infoId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.common_Illness, R2.id.common_drug, R2.id.edit_query})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        int id = view.getId();
        if (id == R.id.common_Illness) {
            intent = new Intent(HomeActivity.this, CommonActivity.class);
            intent.putExtra("1", 1);
            startActivity(intent);
        } else if (id == R.id.common_drug) {
            intent = new Intent(HomeActivity.this, CommonActivity.class);
            intent.putExtra("2", 2);
            startActivity(intent);
        } else if (id == R.id.edit_query) {
            intent = new Intent(HomeActivity.this, Edit_SearchActivity.class);
            startActivity(intent);
        }
    }
}
