package com.wd.my_message.view.message;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.InquiryMessageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/20 9:55
 * @change
 * @chang time
 * @class describe
 */
public class InquirtMessageAdapter extends RecyclerView.Adapter<InquirtMessageAdapter.Holder> {
    private List<InquiryMessageBean.ResultBean> list;
    private Context context;

    public InquirtMessageAdapter(List<InquiryMessageBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.inquiry_message_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getContent());
        Date date = new Date(list.get(position).getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        holder.name.setText(simpleDateFormat.format(date));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final TextView name,time;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.inquiry_message_item_name);
            time = itemView.findViewById(R.id.inquiry_message_item_time);
        }
    }
}
