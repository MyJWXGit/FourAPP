package com.wd.video.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.video.R;
import com.wd.video.bean.Video_EntryBean;

import java.util.List;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Video_EntryBean.ResultBean> list;
    private Context context;

    public VideoAdapter(List<Video_EntryBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_entry_layout, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).recy_up_text.setText(list.get(position).getName());
            ((ViewHolder) holder).recy_up_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = list.get(position).getId();
                    setOnClick.onClick(id);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView recy_up_text;
        private final LinearLayout linear_video;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recy_up_text = itemView.findViewById(R.id.recy_up_text);
            linear_video = itemView.findViewById(R.id.linear_video);
        }
    }
    public interface setOnClick{
        void onClick(String entryid);
    }
    private setOnClick setOnClick;

    public void setSetOnClick(VideoAdapter.setOnClick setOnClick) {
        this.setOnClick = setOnClick;
    }
}
