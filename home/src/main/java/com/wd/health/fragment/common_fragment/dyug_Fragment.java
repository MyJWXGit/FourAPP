package com.wd.health.fragment.common_fragment;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseFragment;
import com.wd.health.R;
import com.wd.health.adapter.fragment.Department_Adapter;
import com.wd.health.contract.Contract;
import com.wd.health.adapter.fragment.Category_Adapter;
import com.wd.health.bean.CategoryBean;
import com.wd.health.bean.DepartmentBean;
import com.wd.health.presenter.Fragment_Presenter;

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
public class dyug_Fragment extends BaseFragment<Fragment_Presenter> implements Contract.IView {
    RecyclerView titleRecycler;
    RecyclerView infoRecycler;

    @Override
    protected Fragment_Presenter providePresenter() {
        return new Fragment_Presenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.dyug_fragment;
    }

    @Override
    protected void initView(View view) {
        titleRecycler = view.findViewById(R.id.title_recycler);
        infoRecycler = view.findViewById(R.id.info_recycler);
    }

    @Override
    protected void initData() {
        mPresenter.onDepartment();
        mPresenter.onCategory(7);
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof DepartmentBean) {
            DepartmentBean bean = (DepartmentBean) obj;
            List<DepartmentBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            Department_Adapter department_adapter = new Department_Adapter(result, getContext());
            titleRecycler.setLayoutManager(linearLayoutManager);
            titleRecycler.setAdapter(department_adapter);

            department_adapter.setOnId(new Department_Adapter.onId() {
                @Override
                public void onId(int id) {
                    mPresenter.onCategory(id);
                }
            });
        } else if (obj instanceof CategoryBean) {
            CategoryBean bean = (CategoryBean) obj;
            List<CategoryBean.ResultBean> result = bean.getResult();
            GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            infoRecycler.setLayoutManager(linearLayoutManager);
            Category_Adapter category_adapter = new Category_Adapter(result, getActivity());
            infoRecycler.setAdapter(category_adapter);
        }
    }

    @Override
    public void onError(Throwable e) {

    }
}
