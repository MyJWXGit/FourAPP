package com.wd.video.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.wd.common.base.BaseFragment;
import com.wd.common.utils.Logger;
import com.wd.video.R;
import com.wd.video.VideoActivity;
import com.wd.video.adapter.Video_QueryAdapter;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;
import com.wd.video.presenter.Video_QueryFPresenter;
import com.wd.video.utils.OnViewPagerListener;
import com.wd.video.utils.TikTokController;
import com.wd.video.utils.ViewPagerLayoutManager;

import java.util.List;

import butterknife.BindView;


public class Video_QueryFragment extends BaseFragment<Video_QueryFPresenter> implements Contract.IView {


    private static final String TAG = "Video_QueryFragment";
    @BindView(R.id.video_down)
    RecyclerView videoDown;
    private int mCurrentPosition;
    private IjkVideoView mIjkVideoView;
    private TikTokController mTikTokController;
    private String enid;
    private List<Video_QueryBean.ResultBean> result;

    @Override
    protected Video_QueryFPresenter providePresenter() {
        return new Video_QueryFPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_video__query;
    }

    @Override
    protected void initView(View view) {
        setStatusBarTransparent();
        mIjkVideoView = new IjkVideoView(getActivity());
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
    }

    @Override
    protected void initData() {
        SharedPreferences essid = getActivity().getSharedPreferences("essid", Context.MODE_PRIVATE);
        enid = essid.getString("eid", "");
        Logger.d(TAG,enid);
        mPresenter.onVideo_Query("1", "1", "100");
    }


    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getActivity().getWindow().getDecorView();
            decorView.setOnApplyWindowInsetsListener((v, insets) -> {
                WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                return defaultInsets.replaceSystemWindowInsets(
                        defaultInsets.getSystemWindowInsetLeft(),
                        0,
                        defaultInsets.getSystemWindowInsetRight(),
                        defaultInsets.getSystemWindowInsetBottom());
            });
            ViewCompat.requestApplyInsets(decorView);
            getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getActivity(), android.R.color.transparent));
        }
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof Video_QueryBean) {
            Video_QueryBean video_queryBean = (Video_QueryBean) data;
            result = video_queryBean.getResult();
            Logger.d(TAG,video_queryBean.getMessage());
            Video_QueryAdapter video_queryAdapter = new Video_QueryAdapter(result, getActivity());
            ViewPagerLayoutManager layoutManager = new ViewPagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
            videoDown.setLayoutManager(layoutManager);
            videoDown.setAdapter(video_queryAdapter);
            layoutManager.setOnViewPagerListener(new OnViewPagerListener() {
                @Override
                public void onInitComplete() {
                    //自动播放第一条
                    startPlay(0);
                }

                @Override
                public void onPageRelease(boolean isNext, int position) {
                    if (mCurrentPosition == position) {
                        mIjkVideoView.release();
                    }
                }

                @Override
                public void onPageSelected(int position, boolean isBottom) {
                    if (mCurrentPosition == position) return;
                    startPlay(position);
                    mCurrentPosition = position;
                }
            });
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
    private void startPlay(int position) {
        View itemView = videoDown.getChildAt(0);
        FrameLayout frameLayout = itemView.findViewById(R.id.container);
        Glide.with(getActivity())
                .load(R.mipmap.black)
                .placeholder(android.R.color.black)
                .into(mTikTokController.getThumb());
        ViewParent parent = mIjkVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(mIjkVideoView);
        }
        frameLayout.addView(mIjkVideoView);
        mIjkVideoView.setUrl(result.get(position).getOriginalUrl());
        mIjkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        mIjkVideoView.start();
    }
    @Override
    public void onPause() {
        super.onPause();
        mIjkVideoView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mIjkVideoView.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIjkVideoView.release();
    }
}
