package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.common.base.BaseActivity;
import com.wd.home.R;
import com.wd.home.api.Constant;
import com.wd.home.bean.IllnessBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.Fragment_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrugActivity extends BaseActivity<Fragment_Presenter> implements Contract.IView {
    @BindView(R.id.line1)
    LinearLayout line1;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.component)
    TextView component;
    @BindView(R.id.taboo)
    TextView taboo;
    @BindView(R.id.effect)
    TextView effect;
    @BindView(R.id.usage)
    TextView usage;
    @BindView(R.id.shape)
    TextView shape;
    @BindView(R.id.packing)
    TextView packing;
    @BindView(R.id.sideEffects)
    TextView sideEffects;
    @BindView(R.id.storage)
    TextView storage;
    @BindView(R.id.minMatter)
    TextView minMatter;
    @BindView(R.id.approvalNumber)
    TextView approvalNumber;

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
        int drug_Id = intent.getIntExtra(Constant.drug_id, 0);
        String name = intent.getStringExtra("name");
        textName.setText(name);
        mPresenter.onIllness(drug_Id);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_drug;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof IllnessBean) {
            IllnessBean bean = (IllnessBean) obj;
            effect.setText(bean.getResult().getEffect());
            taboo.setText(bean.getResult().getTaboo());
            shape.setText(bean.getResult().getShape());
            packing.setText(bean.getResult().getPacking());
            component.setText(bean.getResult().getComponent());
            usage.setText(bean.getResult().getUsage());
            sideEffects.setText(bean.getResult().getSideEffects());
            storage.setText(bean.getResult().getStorage());
            minMatter.setText(bean.getResult().getMindMatter());
            approvalNumber.setText(bean.getResult().getApprovalNumber());
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
