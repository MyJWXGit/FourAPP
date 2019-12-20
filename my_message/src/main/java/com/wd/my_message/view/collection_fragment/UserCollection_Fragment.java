package com.wd.my_message.view.collection_fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseFragment;
import com.wd.my_message.R;
import com.wd.my_message.R2;
import com.wd.my_message.bean.DeleteCollectionBean;
import com.wd.my_message.bean.UserColletionBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyFragmentMessage_Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 14:56
 * @change
 * @chang time
 * @class describe
 */
public class UserCollection_Fragment extends BaseFragment<MyFragmentMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.fil_tus)
    ImageView filTus;
    @BindView(R2.id.zixunkong)
    RelativeLayout zixunkong;
    @BindView(R2.id.advisory_recy)
    RecyclerView advisoryRecy;
    @BindView(R2.id.quxiao)
    ImageView quxiao;
    private int infoId;

    @Override
    protected MyFragmentMessage_Presenter providePresenter() {
        return new MyFragmentMessage_Presenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.usercolleciton_fragment;
    }

    @Override
    protected void initView(View view) {
        filTus = view.findViewById(R.id.fil_tus);
        zixunkong = view.findViewById(R.id.zixunkong);
        advisoryRecy = view.findViewById(R.id.advisory_recy);
        quxiao = view.findViewById(R.id.quxiao);
    }

    @Override
    protected void initData() {
        mPresenter.onUserCollection(1,15);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        advisoryRecy.setLayoutManager(linearLayoutManager);
//        quxiao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPresenter.onDeleteCollection(infoId);
//            }
//        });
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof UserColletionBean){
            UserColletionBean userColletionBean= (UserColletionBean) data;
            if (userColletionBean.getResult().size()>0){
                List<UserColletionBean.ResultBean> result = userColletionBean.getResult();
                AdvisoryAdapter advisoryAdapter=new AdvisoryAdapter(result,getActivity());
                advisoryRecy.setAdapter(advisoryAdapter);
                advisoryAdapter.setSetOnItemClick(new AdvisoryAdapter.SetOnItemClick() {
                    @Override
                    public void setOnItem(int position) {
                        infoId = result.get(position).getInfoId();
                    }
                });
            }else {
                zixunkong.setVisibility(View.VISIBLE);
            }
        }
//        else if (data instanceof DeleteCollectionBean){
//            DeleteCollectionBean deleteCollectionBean= (DeleteCollectionBean) data;
//            if (deleteCollectionBean.getStatus().equals("0000")){
//                Toast.makeText(getActivity(), deleteCollectionBean.getMessage(), Toast.LENGTH_SHORT).show();
//                mPresenter.onUserCollection(1,15);
//
//            }else {
//                Toast.makeText(getActivity(), deleteCollectionBean.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
