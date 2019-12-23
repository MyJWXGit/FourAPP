package com.wd.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.home.R;
import com.wd.home.bean.DoctorInfoBean;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:贾伟曦
 *@Date: 2019/12/18
 *@Time:15:59
 *@Description:评论适配器
 **/
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DoctorInfoBean.ResultBean.CommentListBean> list;
    Context context;

    public CommentAdapter(List<DoctorInfoBean.ResultBean.CommentListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            Glide.with(context).load(list.get(position).getHeadPic()).apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(((MyHolder)holder).head);
            ((MyHolder)holder).name.setText(list.get(position).getNickName());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String time = sdf.format( Long.valueOf(list.get(position).getCommentTime()));
            ((MyHolder)holder).time.setText(time);
            ((MyHolder)holder).comment.setText(list.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView head;
        private TextView name,time,comment;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            head=itemView.findViewById(R.id.head);
            name=itemView.findViewById(R.id.name);
            time=itemView.findViewById(R.id.time);
            comment=itemView.findViewById(R.id.comment);
        }
    }
}
