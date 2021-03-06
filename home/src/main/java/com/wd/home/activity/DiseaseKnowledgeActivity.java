package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.home.R;
import com.wd.home.R2;
import com.wd.home.bean.DyugBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.Fragment_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiseaseKnowledgeActivity extends BaseActivity<Fragment_Presenter> implements Contract.IView {
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.pathology)
    TextView pathology;
    @BindView(R2.id.symptom)
    TextView symptom;
    @BindView(R2.id.benefitTaboo)
    TextView benefitTaboo;
    @BindView(R2.id.chineseMedicineTreatment)
    TextView chineseMedicineTreatment;
    @BindView(R2.id.westernMedicineTreatment)
    TextView westernMedicineTreatment;

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
        int condition_id = intent.getIntExtra(Constant.Condition_id, 0);
        String name = intent.getStringExtra("name");
        textName.setText(name);
        mPresenter.onDiseaseKnowledge(condition_id);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_disease_knowledge;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof DyugBean) {
            DyugBean bean = (DyugBean) obj;
            DyugBean.ResultBean result = bean.getResult();
            pathology.setText(result.getPathology());
            symptom.setText(result.getSymptom());
            benefitTaboo.setText(result.getBenefitTaboo());
            chineseMedicineTreatment.setText(result.getChineseMedicineTreatment());
        }
    }

    @Override
    public void onError(Throwable e) {

    }
}
