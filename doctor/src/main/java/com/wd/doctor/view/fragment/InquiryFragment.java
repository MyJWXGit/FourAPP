package com.wd.doctor.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.common.base.BaseFragment;
import com.wd.doctor.R;
import com.wd.doctor.bean.PatientsBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.activity.DetailsActivity;
import com.wd.doctor.view.adapter.PatientsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * date:2019/12/14
 * author:金豪(Lenovo)
 * function:
 */
public class InquiryFragment extends BaseFragment<LoginPresenter> implements Contract.IView {

    int page = 1;

    private int doctorId;
    private String sessionId;
   private RecyclerView xlistView;
   private SmartRefreshLayout refreshLayout;
    private ArrayList<PatientsBean.ResultBean> mList;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.inqurter;
    }

    @Override
    protected void initView(View view) {
        xlistView=view.findViewById(R.id.xlist_view);
        refreshLayout=view.findViewById(R.id.refreshLayout);
        xlistView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Intent intent = getActivity().getIntent();
         doctorId = intent.getIntExtra("doctorId", 0);
         sessionId = intent.getStringExtra("sessionId");
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String departmentId = arguments.getString("departmentId");
        int i = Integer.parseInt(departmentId);
        mPresenter.Patients(i,page,10);
        refreshLayout.setEnableRefresh(true);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                mPresenter.Patients(i,page,10);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mList.clear();
                page = 1;
                mPresenter.Patients(i,page,10);
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        PatientsBean bean= (PatientsBean) obj;
        List<PatientsBean.ResultBean> result = bean.getResult();
        mList = new ArrayList<>();
        mList.addAll(result);
        PatientsAdapter adapter=new PatientsAdapter(bean.getResult(),getActivity());
        xlistView.setAdapter(adapter);
        adapter.setCallBack(new PatientsAdapter.CallBack() {
            @Override
            public void sunsadnfn(int sickCircleId) {
                int sickCircleId1 = sickCircleId;
                Intent intent=new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("doctorId",doctorId);
                intent.putExtra("sessionId",sessionId);
                intent.putExtra("sickCircleId",sickCircleId1);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
