package com.wd.my_message.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.AttentionDoctorListBean;
import com.wd.my_message.bean.UnAttentionDoctorBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.attention_doctor.FindUserDoctorFollowListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Attention_Doctor_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.fil_tus)
    ImageView filTus;
    @BindView(R2.id.guanzhukong)
    RelativeLayout guanzhukong;
    @BindView(R2.id.attention_recy)
    RecyclerView attentionRecy;
    private FindUserDoctorFollowListAdapter findUserDoctorFollowListAdapter;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mPresenter.onAttentionDoctorList(1,15);
        //布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        attentionRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_attention__doctor_;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof AttentionDoctorListBean){
            AttentionDoctorListBean attentionDoctorListBean= (AttentionDoctorListBean) data;
            List<AttentionDoctorListBean.ResultBean> result = attentionDoctorListBean.getResult();
            if (result.size()>0){
                findUserDoctorFollowListAdapter = new FindUserDoctorFollowListAdapter(result, this);
                attentionRecy.setAdapter(findUserDoctorFollowListAdapter);

                //滑动取消关注
                findUserDoctorFollowListAdapter.setSetOnItemClicK(new FindUserDoctorFollowListAdapter.SetOnItemClicK() {
                    @Override
                    public void onSetOnClick(int position) {
                        int doctorId = result.get(position).getDoctorId();
                        mPresenter.onUnAttentionDoctor(doctorId);
                    }
                });
            }else {
                guanzhukong.setVisibility(View.VISIBLE);
            }
        }else if (data instanceof UnAttentionDoctorBean){
            UnAttentionDoctorBean unAttentionDoctorBean= (UnAttentionDoctorBean) data;
            if (unAttentionDoctorBean.getStatus().equals("0000")){
                Toast.makeText(this, unAttentionDoctorBean.getMessage(), Toast.LENGTH_SHORT).show();
                //滑动取消关注
                mPresenter.onAttentionDoctorList(1,15);
            }else {
                Toast.makeText(this, unAttentionDoctorBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
