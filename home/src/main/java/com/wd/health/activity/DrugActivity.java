package com.wd.health.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.contract.Contract;
import com.wd.health.bean.IllnessBean;
import com.wd.health.presenter.Fragment_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.wd.health.R2;
public class DrugActivity extends BaseActivity<Fragment_Presenter> implements Contract.IView {
    @BindView(R2.id.line1)
    LinearLayout line1;
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.component)
    TextView component;
    @BindView(R2.id.taboo)
    TextView taboo;
    @BindView(R2.id.effect)
    TextView effect;
    @BindView(R2.id.usage)
    TextView usage;
    @BindView(R2.id.shape)
    TextView shape;
    @BindView(R2.id.packing)
    TextView packing;
    @BindView(R2.id.sideEffects)
    TextView sideEffects;
    @BindView(R2.id.storage)
    TextView storage;
    @BindView(R2.id.minMatter)
    TextView minMatter;
    @BindView(R2.id.approvalNumber)
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
