package com.wd.health.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.bean.HistoryBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.health.adapter
 * @class describe
 * @anthor 24673
 * @time 2019/12/30 14:29
 * @change
 * @chang time
 * @class describe
 */
public class History_Adapter extends RecyclerView.Adapter {
    Context context;
    List<HistoryBean.ResultBean> list;

    public History_Adapter(Context context, List<HistoryBean.ResultBean> result) {
        this.context = context;
        this.list = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_item_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.text_name.setText(list.get(position).getDoctorName());
        holder.text_type.setText(list.get(position).getJobTitle());
        holder.simple.setImageURI(list.get(position).getImagePic());

        long inquiryTime = list.get(position).getInquiryTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd  HH:mm");
        holder.text_time.setText(simpleDateFormat.format(inquiryTime));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text_name, text_type, text_time;
        private SimpleDraweeView simple;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            text_name = itemView.findViewById(R.id.text_name);
            text_type = itemView.findViewById(R.id.text_type);
            text_time = itemView.findViewById(R.id.text_time);
        }
    }
}
