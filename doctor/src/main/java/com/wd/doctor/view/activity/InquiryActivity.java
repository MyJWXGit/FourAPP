package com.wd.doctor.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.bean.InquiryBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.activity.myview.StreamingActivity;
import com.wd.doctor.view.adapter.InquiryAdapter;

import java.util.ArrayList;
import java.util.List;

public class InquiryActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    private ArrayList<String> tab = new ArrayList<>();
    private ImageView details_back,sou;
    private TabLayout tab_lay;
    private ViewPager view_pager;
    private int did;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        details_back=findViewById(R.id.details_back);
        tab_lay=findViewById(R.id.tab_lay);
        view_pager=findViewById(R.id.view_pager);
        sou=findViewById(R.id.sou);

    }

    @Override
    protected void initData() {
     mPresenter.Inquer();
     details_back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });
     sou.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(InquiryActivity.this, StreamingActivity.class);
             startActivity(intent);
         }
     });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_inquiry;
    }

    @Override
    public void onSuccess(Object obj) {
        InquiryBean bean = (InquiryBean) obj;

        List<InquiryBean.ResultBean> result = bean.getResult();
      /*  for (int i = 0; i < result.size(); i++) {
            String s = result.get(i).getDepartmentName();
            TabLayout.Tab tab = tab_lay.newTab();
            if (tab != null) {
                tab.setText(s);
                tab_lay.addTab(tab);
            }
        }*/
        for (int i = 0; i < result.size(); i++) {
            InquiryBean.ResultBean resultBean = result.get(i);
            tab.add(resultBean.getDepartmentName());
        }
        InquiryAdapter inquiryAdapter=new InquiryAdapter(getSupportFragmentManager(),tab,result);
        tab_lay.setupWithViewPager(view_pager);
        view_pager.setAdapter(inquiryAdapter);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
