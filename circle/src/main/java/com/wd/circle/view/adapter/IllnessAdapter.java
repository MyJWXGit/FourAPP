package com.wd.circle.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.circle.bean.DiseaseBean;
import com.wd.health.R;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/17 16:36
 * @change
 * @chang time
 * @class describe
 */
public class IllnessAdapter extends RecyclerView.Adapter<IllnessAdapter.Holder> {
    private List<DiseaseBean.ResultBean> list;
    private Context context;

    public IllnessAdapter(List<DiseaseBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_illness_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.illness_name.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnItemClicks.setOnItems(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final TextView illness_name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            illness_name = itemView.findViewById(R.id.illness_name);
        }
    }
    public interface SetOnItemClicks{
        void setOnItems(int i);
    }
    private SetOnItemClicks setOnItemClicks;

    public void setSetOnItemClicks(SetOnItemClicks setOnItemClicks) {
        this.setOnItemClicks = setOnItemClicks;
    }
}
