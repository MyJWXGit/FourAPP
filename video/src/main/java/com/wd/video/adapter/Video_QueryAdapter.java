package com.wd.video.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.video.R;
import com.wd.video.bean.Video_QueryBean;

import java.util.List;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class Video_QueryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     private List<Video_QueryBean.ResultBean> resultBeans;
     private Context context;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";

    public Video_QueryAdapter(List<Video_QueryBean.ResultBean> resultBeans, Context context) {
        this.resultBeans = resultBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            Glide.with(context).load(R.mipmap.black)
                    .placeholder(android.R.color.white)
                    .into(((ViewHolder) holder).mTikTokView);
        }

    }


    @Override
    public int getItemCount() {
        return resultBeans.size();
    }
   public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mTikTokView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTikTokView = itemView.findViewById(R.id.thumb);
        }

    }
}
