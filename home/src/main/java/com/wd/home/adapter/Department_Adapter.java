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
import com.wd.home.bean.DepartmentBean;

import java.util.List;

import butterknife.BindView;

/**
 * @name Health
 * @class name：com.wd.home.adapter
 * @class describe
 * @anthor 24673
 * @time 2019/12/13 16:55
 * @change
 * @chang time
 * @class describe
 */
public class Department_Adapter extends RecyclerView.Adapter {
    private List<DepartmentBean.ResultBean> list;
    private Context context;

    public Department_Adapter(List<DepartmentBean.ResultBean> result, Context context) {
        this.context = context;
        this.list = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.department_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.department_view.setImageURI(list.get(position).getPic());
        holder.text_name.setText(list.get(position).getDepartmentName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onID.onID(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView department_view;
        private TextView text_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.text_name);
            department_view = itemView.findViewById(R.id.department_view);
        }
    }

    public onID onID;

    public interface onID {
        void onID(int id);
    }

    public void setOnID(Department_Adapter.onID onID) {
        this.onID = onID;
    }
}
