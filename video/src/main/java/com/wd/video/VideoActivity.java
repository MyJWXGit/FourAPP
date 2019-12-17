package com.wd.video;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.video.adapter.VideoAdapter;
import com.wd.video.adapter.Video_QueryAdapter;
import com.wd.video.bean.Video_EntryBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;
import com.wd.video.presenter.Video_EntryPresenter;
import com.wd.video.utils.OnViewPagerListener;
import com.wd.video.utils.TikTokController;
import com.wd.video.utils.ViewPagerLayoutManager;

import java.util.List;

public class VideoActivity extends BaseActivity<Video_EntryPresenter> implements Contract.IView {

    private RecyclerView videoUp;
    private RecyclerView videoDown;
    private int mCurrentPosition;
    private IjkVideoView mIjkVideoView;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";
    private List<Video_QueryBean.ResultBean> result;
    private TikTokController mTikTokController;


    @Override
    protected Video_EntryPresenter providePresenter() {
        return new Video_EntryPresenter();
    }

    @Override
    protected void initView() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("抖音");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setStatusBarTransparent();
        videoUp = findViewById(R.id.video_up);
        videoDown = findViewById(R.id.video_down);
        mIjkVideoView = new IjkVideoView(VideoActivity.this);
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);

    }


    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Context context() {
        return null;
    }


    @Override
    protected void initData() {
        /*
        *  mIjkVideoView = new IjkVideoView(MainActivity.this);
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
        mTikTokController = new TikTokController(MainActivity.this);
        mIjkVideoView.setVideoController(mTikTokController);
        *
        * */

        mIjkVideoView = new IjkVideoView(VideoActivity.this);
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
        mTikTokController = new TikTokController(VideoActivity.this);
        mIjkVideoView.setVideoController(mTikTokController);
        mPresenter.onVideo_Entry();



    }

    /**
     * 把状态栏设成透明
     */
    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = VideoActivity.this.getWindow().getDecorView();
            decorView.setOnApplyWindowInsetsListener((v, insets) -> {
                WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                return defaultInsets.replaceSystemWindowInsets(
                        defaultInsets.getSystemWindowInsetLeft(),
                        0,
                        defaultInsets.getSystemWindowInsetRight(),
                        defaultInsets.getSystemWindowInsetBottom());
            });
            ViewCompat.requestApplyInsets(decorView);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
        }
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof Video_EntryBean) {
            Video_EntryBean video_entryBean = (Video_EntryBean) data;
            List<Video_EntryBean.ResultBean> result = video_entryBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(VideoActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            videoUp.setLayoutManager(linearLayoutManager);
            VideoAdapter videoAdapter = new VideoAdapter(result, VideoActivity.this);
            videoUp.setAdapter(videoAdapter);
            videoAdapter.setSetOnClick(new VideoAdapter.setOnClick() {
                @Override
                public void onClick(String entryid) {
                    mPresenter.onVideo_Query(entryid, "1", "100");
                    ToastUtils.show(VideoActivity.this, entryid, Toast.LENGTH_LONG);
                }
            });
        } else if (data instanceof Video_QueryBean) {
            Video_QueryBean video_queryBean = (Video_QueryBean) data;
            result = video_queryBean.getResult();
            Video_QueryAdapter video_queryAdapter = new Video_QueryAdapter(result, VideoActivity.this);
            ViewPagerLayoutManager layoutManager = new ViewPagerLayoutManager(VideoActivity.this, OrientationHelper.VERTICAL);
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

    private void startPlay(int position) {
        View itemView = videoDown.getChildAt(0);
        FrameLayout frameLayout = itemView.findViewById(R.id.container);
        Glide.with(this)
                .load(path)
                .placeholder(android.R.color.black)
                .into(mTikTokController.getThumb());
        ViewParent parent = mIjkVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(mIjkVideoView);
        }
        frameLayout.addView(mIjkVideoView);
//        mIjkVideoView.
        mIjkVideoView.setUrl(result.get(position).getOriginalUrl());
        mIjkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        mIjkVideoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIjkVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIjkVideoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIjkVideoView.release();
    }
}
