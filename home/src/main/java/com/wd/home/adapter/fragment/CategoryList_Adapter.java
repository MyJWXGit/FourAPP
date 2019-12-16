package com.wd.home.adapter.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.home.R;
import com.wd.home.bean.CategoryBean;
import com.wd.home.bean.CategoryListBean;

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
public class CategoryList_Adapter extends RecyclerView.Adapter {
    List<CategoryListBean.ResultBean> list;
    Context context;

    public CategoryList_Adapter(List<CategoryListBean.ResultBean> result, Context context) {
        this.list = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_department, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.title_name.setText(list.get(position).getName());
        holder.title_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onId.onId(list.get(position).getId());
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

    public onId onId;

    public interface onId {
        void onId(int id);
    }

    public void setOnId(onId onId) {
        this.onId = onId;
    }
}
