package com.wd.my_message.view.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.R;
import com.wd.my_message.bean.QueryTaskListBean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/25 13:55
 * @change
 * @chang time
 * @class describe
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.Holder> {
    private List<QueryTaskListBean.ResultBean> list;
    private Context context;

    public TaskListAdapter(List<QueryTaskListBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mytask_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if(holder instanceof Holder){
            holder.mttaskitemText.setText(list.get(position).getTaskName());
            holder.mttaskitemHbi.setText("+"+list.get(position).getReward()+"H币");
            int whetherReceive = list.get(position).getWhetherReceive();
            if (whetherReceive==1){
                holder.mttaskitemLingquhbi.setVisibility(View.VISIBLE);
                holder.mttaskitemQuwancheng.setVisibility(View.GONE);
                holder.mttaskitemYiwancheng.setVisibility(View.GONE);
            }else if (whetherReceive==2){
                holder.mttaskitemYiwancheng.setVisibility(View.VISIBLE);
                holder.mttaskitemQuwancheng.setVisibility(View.GONE);
                holder.mttaskitemLingquhbi.setVisibility(View.GONE);
            }else if (whetherReceive==3){
                holder.mttaskitemQuwancheng.setVisibility(View.VISIBLE);
                holder.mttaskitemYiwancheng.setVisibility(View.GONE);
                holder.mttaskitemLingquhbi.setVisibility(View.GONE);
            }
            holder.mttaskitemQuwancheng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    areaView.onCurress(list.get(position).getId());
                    holder.mttaskitemLingquhbi.setVisibility(View.VISIBLE);
                    holder.mttaskitemQuwancheng.setVisibility(View.GONE);
                    holder.mttaskitemYiwancheng.setVisibility(View.GONE);
                }
            });
            holder.mttaskitemLingquhbi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    areaView.onCurre(list.get(position).getId());
                    holder.mttaskitemYiwancheng.setVisibility(View.VISIBLE);
                    holder.mttaskitemQuwancheng.setVisibility(View.GONE);
                    holder.mttaskitemLingquhbi.setVisibility(View.GONE);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final TextView mttaskitemText;
        private final TextView mttaskitemHbi;
        private final Button mttaskitemQuwancheng;
        private final Button mttaskitemYiwancheng;
        private final Button mttaskitemLingquhbi;

        public Holder(@NonNull View itemView) {
            super(itemView);
            mttaskitemText = itemView.findViewById(R.id.mttaskitem_text);
            mttaskitemHbi = itemView.findViewById(R.id.mttaskitem_hbi);
            mttaskitemQuwancheng = itemView.findViewById(R.id.mttaskitem_quwancheng);
            mttaskitemYiwancheng = itemView.findViewById(R.id.mttaskitem_yiwancheng);
            mttaskitemLingquhbi = itemView.findViewById(R.id.mttaskitem_lingquhbi);
        }
    }
    //jiekou接口回调
    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }
    AreaView areaView;
    public interface AreaView {

        void onCurress(int id);

        void onCurre(int id);
    }
}
