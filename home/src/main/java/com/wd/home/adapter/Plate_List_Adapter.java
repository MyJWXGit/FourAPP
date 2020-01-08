package com.wd.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.R;
import com.wd.home.bean.Plate_ListBean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.adapter
 * @class describe
 * @anthor 24673
 * @time 2019/12/14 15:14
 * @change
 * @chang time
 * @class describe
 */
public class Plate_List_Adapter extends RecyclerView.Adapter {
    private List<Plate_ListBean.ResultBean> list;
    private Context context;

    public Plate_List_Adapter(List<Plate_ListBean.ResultBean> result, Context context) {
        this.context = context;
        this.list = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plate_title_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.textView.setText(list.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onId.onId(position);
                notifyDataSetChanged();
            }
        });
        if (position == getColor()) {
            holder.textView.setTextColor(Color.parseColor("#3084ea"));
        } else {
            holder.textView.setTextColor(Color.parseColor("#333333"));
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

    public onPosition onId;

    public interface onPosition {
        void onId(int position);
    }

    public void setOnId(onPosition onId) {
        this.onId = onId;
    }

    public int onColor;

    private int getColor() {
        return onColor;
    }

    public void setOnColor(int onColor) {
        this.onColor = onColor;
    }
}
