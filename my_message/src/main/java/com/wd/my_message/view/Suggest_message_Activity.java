package com.wd.my_message.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.SuggestBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.view.suggest.FindMyAdoptedCommentListAdapter;
import com.wd.my_message.presenter.MyMessage_Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Suggest_message_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.fil_tus)
    ImageView filTus;
    @BindView(R2.id.yijiankong)
    RelativeLayout yijiankong;
    @BindView(R2.id.comment_list_recy)
    RecyclerView commentListRecy;

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
        mPresenter.onMySuggest(1, 15);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        commentListRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_suggest_message_;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof SuggestBean) {
            SuggestBean suggestBean = (SuggestBean) data;
            List<?> result = suggestBean.getResult();
            int size = result.size();
            if (size > 0) {
                FindMyAdoptedCommentListAdapter findMyAdoptedCommentListAdapter = new FindMyAdoptedCommentListAdapter(result, this);
                commentListRecy.setAdapter(findMyAdoptedCommentListAdapter);
            } else {
                yijiankong.setVisibility(View.VISIBLE);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
