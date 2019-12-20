package com.wd.video.fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.common.base.BaseFragment;
import com.wd.video.R;
import com.wd.video.adapter.VideoAdapter;
import com.wd.video.bean.Video_CollectionBean;
import com.wd.video.bean.Video_PayBean;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.bean.Video_Query_BarrageBean;
import com.wd.video.contract.Contract;
import com.wd.video.presenter.Video_QueryFPresenter;
import com.wd.video.utils.AcFunDanmakuParser;
import com.wd.video.utils.OnViewPagerListener;
import com.wd.video.utils.PagerLayoutManager;

import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.ui.widget.DanmakuView;


public class HealthFragment extends BaseFragment<Video_QueryFPresenter> implements Contract.IView {
    RecyclerView xrecyc_video_health;
    DanmakuView video_danmu2;
    private int i = 1;
    private Video_QueryBean video_queryBean;
    private String contents;
    private DanmakuContext mContext;
    private AcFunDanmakuParser mParser;
    private static final String TAG = "HealthFragment";
    private IjkVideoView mVideoView;
    private PagerLayoutManager mlayoutManager;

    @Override
    public void onSuccess(Object data) {
        if (data instanceof Video_QueryBean) {
            video_queryBean = (Video_QueryBean) data;
            List<Video_QueryBean.ResultBean> result = video_queryBean.getResult();
            VideoAdapter videoAdapter = new VideoAdapter(result, getActivity());
            xrecyc_video_health.setAdapter(videoAdapter);
            mlayoutManager = new PagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
            xrecyc_video_health.setLayoutManager(mlayoutManager);
            videoAdapter.setSetOnClick(new VideoAdapter.setOnClick() {
                @Override
                public void onClick(String oid) {
                    mPresenter.onVideo_Collection(oid);
                }
            });
            videoAdapter.setsetOnTouch(new VideoAdapter.setOnTouch() {
                @Override
                public void onClick(String osid) {
                    mPresenter.onVideo_Query_Barrage(osid);
                }
            });
            videoAdapter.setSetOnPriceTouch(new VideoAdapter.setOnPriceTouch() {
                @Override
                public void onPriceClick(String mp, String ooid) {
                    mPresenter.onVideo_Pay(ooid,mp);
                }
            });
            videoAdapter.setOnDian(new VideoAdapter.setOnDian() {
                @Override
                public void onPriceClick(int ci) {
                    if (ci%2==1){
                        video_danmu2.setVisibility(View.GONE);
                    }else if (ci%2==0){
                        video_danmu2.setVisibility(View.VISIBLE);
                    }
                }
            });

        }
        else if (data instanceof Video_Query_BarrageBean){
            Video_Query_BarrageBean video_query_barrageBean = (Video_Query_BarrageBean) data;
          String  message = video_query_barrageBean.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            List<Video_Query_BarrageBean.ResultBean> result = video_query_barrageBean.getResult();
            for (int j = 0; j < result.size(); j++) {
                contents = result.get(j).getContent();
                Log.d(TAG, "onSuccess: "+contents);
                sendTextMessage();
            }
            sendTextMessage();

        }
        else if (data instanceof Video_PayBean){
            Video_PayBean video_payBean = (Video_PayBean) data;
            String message1 = video_payBean.getMessage();
            Toast.makeText(getActivity(), message1, Toast.LENGTH_SHORT).show();
        }else if (data instanceof Video_CollectionBean){
            Video_CollectionBean video_collectionBean = (Video_CollectionBean) data;
            String message2 = video_collectionBean.getMessage();
            Toast.makeText(getActivity(), message2, Toast.LENGTH_SHORT).show();
        }
        mlayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete(View view) {
                playVideo(0,view);
            }

            @Override
            public void onPageRelease(boolean isNext, int position, View view) {
                int index = 0;
                if (isNext){
                    index = 0;
                }else {
                    index = 1;
                }
                releaseVideo(view);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom, View view) {
                playVideo(position,view);
            }
        });
    }

    /**
     * 播放视频
     */
    private void playVideo(int position, View view) {
        if (view != null) {
            mVideoView = view.findViewById(R.id.video_view);
            mVideoView.start();
        }
    }

    /**
     * 停止播放
     */
    private void releaseVideo(View view) {
        if (view != null) {
            IjkVideoView videoView = view.findViewById(R.id.video_view);
            videoView.stopPlayback();
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
    protected Video_QueryFPresenter providePresenter() {
        return new Video_QueryFPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.health_fragment;
    }

    @Override
    protected void initView(View view) {
        xrecyc_video_health = view.findViewById(R.id.xrecyc_video_health);
        video_danmu2 = view.findViewById(R.id.video_danmu2);
    }

    @Override
    protected void initData() {
        mPresenter.onVideo_Query("2","1","5");
        mContext = DanmakuContext.create();
        //设置最大显示行数

        HashMap<Integer, Integer> maxLinesPair = new HashMap<>();
        maxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 8); // 滚动弹幕最大显示5行
        // 设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<>();
        overlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_RL, true);
        overlappingEnablePair.put(BaseDanmaku.TYPE_FIX_TOP, true);
        mContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 10) //描边的厚度
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f) //弹幕的速度。注意！此值越小，速度越快！值越大，速度越慢。// by phil
                .setScaleTextSize(1.2f)  //缩放的值
                //.setCacheStuffer(new SpannedCacheStuffer(), mCacheStufferAdapter) // 图文混排使用SpannedCacheStuffer
                // .setCacheStuffer(new BackgroundCacheStuffer())  // 绘制背景使用BackgroundCacheStuffer
                .setMaximumLines(maxLinesPair)
                .preventOverlapping(overlappingEnablePair);

        mParser = new AcFunDanmakuParser();
        video_danmu2.prepare(mParser, mContext);
        video_danmu2.enableDanmakuDrawingCache(true);
        if (video_danmu2 != null) {
            video_danmu2.setCallback(new master.flame.danmaku.controller.DrawHandler.Callback() {
                @Override
                public void updateTimer(DanmakuTimer timer) {
                }

                @Override
                public void drawingFinished() {

                }

                @Override
                public void danmakuShown(BaseDanmaku danmaku) {
                    Log.d("弹幕文本", "danmakuShown text=" + danmaku.text);
                }

                @Override
                public void prepared() {
                    video_danmu2.start();
                }
            });
        }



    }
    private void sendTextMessage() {
        addDanmaku(true);
    }
    private void addDanmaku(boolean islive) {
        BaseDanmaku danmaku = mContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        if (danmaku == null || video_danmu2 == null) {
            return;
        }

        danmaku.text = contents;
        danmaku.padding = 5;
        danmaku.priority = 0;  // 可能会被各种过滤器过滤并隐藏显示
        danmaku.isLive = islive;
        danmaku.setTime(video_danmu2.getCurrentTime() + 1200);
        danmaku.textSize = 20f * (mParser.getDisplayer().getDensity() - 0.6f); //文本弹幕字体大小

        video_danmu2.addDanmaku(danmaku);
    }
    @Override
    public void onPause() {
        super.onPause();
        if (video_danmu2 != null && video_danmu2.isPrepared()) {
            video_danmu2.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (video_danmu2 != null && video_danmu2.isPrepared() && video_danmu2.isPaused()) {
            video_danmu2.resume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (video_danmu2 != null) {
            // dont forget release!
            video_danmu2.release();
            video_danmu2 = null;
        }
    }
}
