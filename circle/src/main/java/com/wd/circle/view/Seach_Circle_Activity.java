package com.wd.circle.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.circle.R;
import com.wd.circle.R2;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.view.adapter.Search_Circle_Adapter;
import com.wd.common.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Seach_Circle_Activity extends BaseActivity<MainPresenter> implements Contract.IView {


    @BindView(R2.id.fanhui_text)
    ImageView fanhuiText;
    @BindView(R2.id.ed_mohucha)
    EditText edMohucha;
    @BindView(R2.id.but_bingquanshou)
    Button butBingquanshou;
    @BindView(R2.id.aaa)
    LinearLayout aaa;
    @BindView(R2.id.recy_modainying)
    RecyclerView recyModainying;
    @BindView(R2.id.include_img)
    SimpleDraweeView includeImg;
    @BindView(R2.id.include_text)
    TextView includeText;
    @BindView(R2.id.include_relate)
    RelativeLayout includeRelate;


    @Override
    protected int initLayout() {
        return R.layout.activity_seach__circle_;
    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyModainying.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void initData() {
        butBingquanshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = edMohucha.getText().toString().trim();
                if (trim!=null){
                    mPresenter.onSearch(trim);
                }
            }
        });
        fanhuiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public Context context() {
        return null;
    }
    @Override
    public void onSuccess(Object obj) {
        SearchCircleBean searchCircleBean= (SearchCircleBean) obj;
        List<SearchCircleBean.ResultBean> result = searchCircleBean.getResult();
        Search_Circle_Adapter search_circle_adapter=new Search_Circle_Adapter(result,Seach_Circle_Activity.this);
        recyModainying.setAdapter(search_circle_adapter);
        search_circle_adapter.setSetOnItems(new Search_Circle_Adapter.SetOnItems() {
            @Override
            public void setOns(int i) {
                int sickCircleId = result.get(i).getSickCircleId();
                Intent intent = new Intent(Seach_Circle_Activity.this,Circle_Details_Activity.class);
                intent.putExtra("sickCircleId",sickCircleId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onError(Throwable e) {

    }

}
