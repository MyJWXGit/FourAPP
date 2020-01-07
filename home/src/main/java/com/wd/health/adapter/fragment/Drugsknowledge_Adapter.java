package com.wd.health.adapter.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.api.Constant;
import com.wd.health.R;
import com.wd.health.activity.DrugActivity;
import com.wd.health.bean.DrugsKnowledgeListBean;

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
public class Drugsknowledge_Adapter extends RecyclerView.Adapter {
    List<DrugsKnowledgeListBean.ResultBean> list;
    Context context;

    public Drugsknowledge_Adapter(List<DrugsKnowledgeListBean.ResultBean> result, Context context) {
        this.list = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drugsknowledge_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.text_name.setText(list.get(position).getName());
        holder.simple.setImageURI(list.get(position).getPicture());
        holder.line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DrugActivity.class);
                intent.putExtra(Constant.drug_id, list.get(position).getId());
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
        private TextView text_name;
        private SimpleDraweeView simple;
        private LinearLayout line1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            text_name = itemView.findViewById(R.id.text_name);
            line1 = itemView.findViewById(R.id.line1);
        }
    }
}
