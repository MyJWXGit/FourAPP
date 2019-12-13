package com.wd.circle.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.circle.R;
import com.wd.circle.api.Constant;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.view.adapter.Circle_List_Adapter;
import com.wd.circle.view.adapter.Circle_Lists_Adapter;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Circle_Home_Activity extends BaseActivity<MainPresenter> implements Contract.IView {


    @BindView(R.id.circle_touxiang)
    SimpleDraweeView circleTouxiang;
    @BindView(R.id.circle_message)
    SimpleDraweeView circleMessage;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.circle_recy1)
    RecyclerView circleRecy1;
    @BindView(R.id.circle_recy2)
    RecyclerView circleRecy2;

    @Override
    protected int initLayout() {
        return R.layout.activity_circle__home_;
    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        String o = (String) SpUtils.get(this, Constant.Sp_touxiang, "");
        circleTouxiang.setImageURI(o);
        circleMessage.setImageResource(R.mipmap.common_nav_message_black_s);
        circleRecy2.setLayoutManager(new LinearLayoutManager(this));
        mPresenter.onHome();
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_list_Bean){
            Circle_list_Bean circle_list_bean= (Circle_list_Bean) obj;
            List<Circle_list_Bean.ResultBean> result = circle_list_bean.getResult();
            Log.d("sss",circle_list_bean+"");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            circleRecy1.setLayoutManager(linearLayoutManager);
            Circle_List_Adapter circle_list_adapter=new Circle_List_Adapter(result,Circle_Home_Activity.this);
            circleRecy1.setAdapter(circle_list_adapter);

            circle_list_adapter.setSetOnItemClick(new Circle_List_Adapter.SetOnItemClick() {
                @Override
                public void setOnItem(int i) {
                    int id = result.get(i).getId();
                    mPresenter.onHomes(id,1,7);
                }
            });
        }else if (obj instanceof Circle_lists_Bean){
            Circle_lists_Bean bean = (Circle_lists_Bean) obj;
            List<Circle_lists_Bean.ResultBean> result = bean.getResult();
            Circle_Lists_Adapter circle_lists_adapter = new Circle_Lists_Adapter(result,Circle_Home_Activity.this);
            circleRecy2.setAdapter(circle_lists_adapter);
        }

    }

    @Override
    public void onError(Throwable e) {

    }
}
