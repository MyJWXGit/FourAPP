package com.wd.video.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class Video_QueryAdapter extends RecyclerView.Adapter<Video_QueryAdapter.ViewHolder> {
    @NonNull
    @Override
    public Video_QueryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Video_QueryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
