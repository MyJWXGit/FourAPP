package com.wd.health.adapter.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.api.Constant;
import com.wd.health.R;
import com.wd.health.activity.DiseaseKnowledgeActivity;
import com.wd.health.bean.CategoryBean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.adapter.fragment
 * @class describe
 * @anthor 24673
 * @time 2019/12/16 11:51
 * @change
 * @chang time
 * @class describe
 */
public class Category_Adapter extends RecyclerView.Adapter {
    List<CategoryBean.ResultBean> list;
    Context context;

    public Category_Adapter(List<CategoryBean.ResultBean> result, Context context) {
        this.list = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_dyug, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.title_name.setText(list.get(position).getName());
        holder.title_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DiseaseKnowledgeActivity.class);
                intent.putExtra(Constant.Condition_id, list.get(position).getId());
                intent.putExtra("name", list.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_name = itemView.findViewById(R.id.title_name);
        }
    }
}
