package com.wd.health.view.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.wd.health.R;
import com.wd.health.bean.HealthyCurrencyBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/20 13:36
 * @change
 * @chang time
 * @class describe
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.Holder> {
    private List<HealthyCurrencyBean.ResultBean> list;
    private Context context;

    public CurrencyAdapter(List<HealthyCurrencyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.system_message_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getContent());
        Date date = new Date(list.get(position).getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        holder.time.setText(simpleDateFormat.format(date));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final TextView name,time;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.system_message_item_name);
            time = itemView.findViewById(R.id.system_message_item_time);
        }
    }
}
