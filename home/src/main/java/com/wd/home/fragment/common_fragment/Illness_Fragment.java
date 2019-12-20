package com.wd.home.fragment.common_fragment;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseFragment;
import com.wd.home.R;
import com.wd.home.adapter.fragment.CategoryList_Adapter;
import com.wd.home.adapter.fragment.Department_Adapter;
import com.wd.home.adapter.fragment.Drugsknowledge_Adapter;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsKnowledgeListBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.Fragment_Presenter;
import com.wd.home.presenter.HomePresenter;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.fragment.common_fragment
 * @class describe
 * @anthor 24673
 * @time 2019/12/16 9:51
 * @change
 * @chang time
 * @class describe
 */
public class Illness_Fragment extends BaseFragment<Fragment_Presenter> implements Contract.IView {
    private RecyclerView titleRecycler;
    private RecyclerView infoRecycler;

    @Override
    protected Fragment_Presenter providePresenter() {
        return new Fragment_Presenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.illness_fragment;
    }

    @Override
    protected void initView(View view) {
        titleRecycler = view.findViewById(R.id.title_recycler);
        infoRecycler = view.findViewById(R.id.info_recycler);
    }

    @Override
    protected void initData() {
        mPresenter.onCategoryList();
        mPresenter.onDrugsKnowledgeList(1, 1, 5);
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof CategoryListBean) {
            CategoryListBean bean = (CategoryListBean) obj;
            List<CategoryListBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            CategoryList_Adapter categoryList_adapter = new CategoryList_Adapter(result, getContext());
            titleRecycler.setLayoutManager(linearLayoutManager);
            titleRecycler.setAdapter(categoryList_adapter);

            categoryList_adapter.setOnId(new CategoryList_Adapter.onId() {
                @Override
                public void onId(int id) {
                    mPresenter.onDrugsKnowledgeList(id, 1, 5);
                }
            });
        } else if (obj instanceof DrugsKnowledgeListBean) {
            DrugsKnowledgeListBean bean = (DrugsKnowledgeListBean) obj;
            List<DrugsKnowledgeListBean.ResultBean> result = bean.getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            infoRecycler.setLayoutManager(gridLayoutManager);
            Drugsknowledge_Adapter drugsknowledge_adapter = new Drugsknowledge_Adapter(result, getContext());
            infoRecycler.setAdapter(drugsknowledge_adapter);
        }
    }

    @Override
    public void onError(Throwable e) {

    }
}
