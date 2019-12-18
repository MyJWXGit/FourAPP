package com.wd.circle.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.circle.R;
import com.wd.circle.bean.Circle_list_Bean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 14:53
 * @change
 * @chang time
 * @class describe
 */
public class Circle_List_Adapter extends RecyclerView.Adapter<Circle_List_Adapter.Holder> {
    private List<Circle_list_Bean.ResultBean> list;
    private Context context;
    public Circle_List_Adapter(List<Circle_list_Bean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.circle_list_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv1.setText(list.get(position).getDepartmentName()+"");

        holder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnItemClick.setOnItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final TextView tv1;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.circle_tv1);
        }
    }
    public interface SetOnItemClick{
        void setOnItem(int i);
    }
    private SetOnItemClick setOnItemClick;

    public void setSetOnItemClick(SetOnItemClick setOnItemClick) {
        this.setOnItemClick = setOnItemClick;
    }
}
