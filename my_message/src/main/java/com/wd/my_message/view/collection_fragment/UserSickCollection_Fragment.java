package com.wd.my_message.view.collection_fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseFragment;
import com.wd.health.R;
import com.wd.my_message.bean.DeleteCollectionBean;
import com.wd.my_message.bean.UserSickCollectionBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyFragmentMessage_Presenter;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 14:55
 * @change
 * @chang time
 * @class describe
 */
public class UserSickCollection_Fragment extends BaseFragment<MyFragmentMessage_Presenter> implements Contract.IView {
    private RelativeLayout bingyoukong;
    private RecyclerView circle_recy;
    private ImageView quxiao;
    private int sickCircleId;

    @Override
    protected MyFragmentMessage_Presenter providePresenter() {
        return new MyFragmentMessage_Presenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.usersickcollection_fragment;
    }

    @Override
    protected void initView(View view) {
        bingyoukong = view.findViewById(R.id.bingyoukong);
        circle_recy = view.findViewById(R.id.circle_recy);
        quxiao = view.findViewById(R.id.quxiao);
    }

    @Override
    protected void initData() {
        mPresenter.onUserSickCollection(1,15);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        circle_recy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof UserSickCollectionBean){
            UserSickCollectionBean userSickCollectionBean= (UserSickCollectionBean) data;
            if (userSickCollectionBean.getResult().size()>0) {
                List<UserSickCollectionBean.ResultBean> result = userSickCollectionBean.getResult();
                FindUserSickCollectionListAdapter findUserSickCollectionListAdapter = new FindUserSickCollectionListAdapter(result, getContext());
                circle_recy.setAdapter(findUserSickCollectionListAdapter);
                findUserSickCollectionListAdapter.setSetOnItemClick(new FindUserSickCollectionListAdapter.SetOnItemClick() {
                    @Override
                    public void setOnItemclick(int position) {
                        sickCircleId = result.get(position).getSickCircleId();
                        quxiao.setVisibility(View.VISIBLE);
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.onDeleteCollection(sickCircleId);
                    }
                });
            }else {
                bingyoukong.setVisibility(View.VISIBLE);
            }
        }else if (data instanceof DeleteCollectionBean){
            DeleteCollectionBean deleteCollectionBean= (DeleteCollectionBean) data;
            if (deleteCollectionBean.getStatus().equals("0000")){
                Toast.makeText(getContext(), deleteCollectionBean.getMessage(), Toast.LENGTH_SHORT).show();
                mPresenter.onUserSickCollection(1,10);
            }else {
                Toast.makeText(getContext(), deleteCollectionBean.getMessage(), Toast.LENGTH_SHORT).show();
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
