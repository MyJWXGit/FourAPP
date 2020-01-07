package com.wd.health.activity;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.EvaluateList_Adapter;
import com.wd.health.contract.Contract;
import com.wd.health.bean.EvaluateListBean;
import com.wd.health.presenter.Fragment_Presenter;

import java.util.List;

import com.wd.health.R2;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentActivity extends BaseActivity<Fragment_Presenter> implements Contract.IView {
    @BindView(R2.id.recycler)
    RecyclerView recycler;

    @Override
    protected Fragment_Presenter providePresenter() {
        return new Fragment_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String doctorId = intent.getStringExtra(Constant.doctorId);
        int id = Integer.parseInt(doctorId);
        mPresenter.onEvaluateList(id, 1, 5);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_comment;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof EvaluateListBean) {
            EvaluateListBean bean = (EvaluateListBean) obj;
            List<EvaluateListBean.ResultBean> result = bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            EvaluateList_Adapter adapter = new EvaluateList_Adapter(result, this);
            recycler.setLayoutManager(linearLayoutManager);
            recycler.setAdapter(adapter);
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
