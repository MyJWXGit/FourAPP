package com.wd.health.view.collection_fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.R;
import com.wd.health.bean.VideoCollectionBean;

import java.text.SimpleDateFormat;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/*
 *author:郭昊坤
 *date:2019/12/25
 *function:*/public class Collection_VideoAdapter extends RecyclerView.Adapter{
     private List<VideoCollectionBean.ResultBean> resultBean;
     private Context context;

    public Collection_VideoAdapter(List<VideoCollectionBean.ResultBean> resultBean, Context context) {
        this.resultBean = resultBean;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_collection_video_layout, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).video_video.setUp(resultBean.get(position).getOriginalUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,resultBean.get(position).getTitle());
            ((ViewHolder) holder).video_num.setText(resultBean.get(position).getBuyNum());
            String s = String.valueOf(resultBean.get(position).getCreateTime());
            String format = Collection_VideoAdapter.DateFormatUtil.format(s);
            ((ViewHolder) holder).video_time.setText(format);
        }
    }

    @Override
    public int getItemCount() {
        return resultBean.size();
    }
    class  ViewHolder extends RecyclerView.ViewHolder{

        private final JCVideoPlayer video_video;
        private final TextView video_num;
        private final TextView video_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            video_video = itemView.findViewById(R.id.video_video);
            video_num = itemView.findViewById(R.id.video_num);
            video_time = itemView.findViewById(R.id.video_time);
        }
    }
    public static class DateFormatUtil{
        public static String format(String date){
            if (TextUtils.isEmpty(date))
                return null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            Long time = new Long(date);
            return format.format(time);
        }
    }
}
