package com.wd.health.view.collection_fragment;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseFragment;
import com.wd.health.R;
import com.wd.health.bean.VideoCollectionBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MyFragmentMessage_Presenter;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 14:54
 * @change
 * @chang time
 * @class describe
 */
public class UserVideo_Fragment extends BaseFragment<MyFragmentMessage_Presenter> implements Contract.IView {
    RecyclerView CollectionVideo;

    @Override
    protected MyFragmentMessage_Presenter providePresenter() {
        return new MyFragmentMessage_Presenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.message_uservideo_fragment;
    }

    @Override
    protected void initView(View view) {
        CollectionVideo = view.findViewById(R.id.Collection_Video);
    }

    @Override
    protected void initData() {
        mPresenter.onUserVideo(1, 100);
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof VideoCollectionBean) {
            VideoCollectionBean videoCollectionBean = (VideoCollectionBean) data;
            List<VideoCollectionBean.ResultBean> result = videoCollectionBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
           Collection_VideoAdapter collection_videoAdapter = new Collection_VideoAdapter(result, getActivity());
         /*   CollectionVideo.setLayoutManager(linearLayoutManager);
            CollectionVideo.setAdapter(collection_videoAdapter);*/
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