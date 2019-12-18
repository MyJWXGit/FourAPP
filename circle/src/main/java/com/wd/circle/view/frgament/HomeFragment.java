package com.wd.circle.view.frgament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.circle.R;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.Home_CirclePresenter;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.view.Circle_Details_Activity;
import com.wd.circle.view.Circle_Home_Activity;
import com.wd.circle.view.adapter.Circle_Lists_Adapter;
import com.wd.common.base.BaseFragment;
import com.wd.common.utils.Logger;

import java.util.List;

import butterknife.BindView;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/18 14:29
 * @change
 * @chang time
 * @class describe
 */
public class HomeFragment extends BaseFragment<Home_CirclePresenter> implements Contract.IView {

    RecyclerView circleRecy2;

    @Override
    protected int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected Home_CirclePresenter providePresenter() {
        return new Home_CirclePresenter();
    }

    @Override
    protected void initView(View view) {
        circleRecy2 = view.findViewById(R.id.circle_recy2);
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        mPresenter.onHomes(id, 1, 18);
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_lists_Bean) {
            Circle_lists_Bean circle_lists_bean = (Circle_lists_Bean) obj;
            List<Circle_lists_Bean.ResultBean> result = circle_lists_bean.getResult();
            Circle_Lists_Adapter circle_lists_adapter = new Circle_Lists_Adapter(result, getActivity());
            circleRecy2.setLayoutManager(new LinearLayoutManager(getContext()));
            circleRecy2.setAdapter(circle_lists_adapter);
            circle_lists_adapter.setSetOnItems(new Circle_Lists_Adapter.SetOnItems() {
                @Override
                public void setOns(int i) {
                    int sickCircleId = result.get(i).getSickCircleId();
                    Intent intent = new Intent(getContext(), Circle_Details_Activity.class);
                    intent.putExtra("sickCircleId", sickCircleId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onError(Throwable e) {

    }

}
