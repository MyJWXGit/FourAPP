package com.wd.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.home.R;
import com.wd.home.activity.CommentActivity;
import com.wd.home.bean.EvaluateListBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.adapter
 * @class describe
 * @anthor 24673
 * @time 2019/12/22 19:54
 * @change
 * @chang time
 * @class describe
 */
public class EvaluateList_Adapter extends RecyclerView.Adapter {
    List<EvaluateListBean.ResultBean> result;
    Context context;

    public EvaluateList_Adapter(List<EvaluateListBean.ResultBean> result, Context context) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.evaluate_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.simpleDraweeView.setImageURI(result.get(position).getHeadPic());
        holder.text_comment.setText(result.get(position).getContent());
        holder.text_name.setText(result.get(position).getNickName());
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String format = sdf.format(result.get(position).getCommentTime());
        holder.text_time.setText(format + "小时前");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView;
        private TextView text_name, text_time, text_comment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simple);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
            text_comment = itemView.findViewById(R.id.text_comment);
        }
    }
}
