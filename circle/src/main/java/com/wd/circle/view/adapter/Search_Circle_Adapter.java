package com.wd.circle.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.R;
import com.wd.circle.bean.SearchCircleBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/15 18:45
 * @change
 * @chang time
 * @class describe
 */
public class Search_Circle_Adapter extends RecyclerView.Adapter<Search_Circle_Adapter.Holder> {
    private List<SearchCircleBean.ResultBean> list;
    private Context context;

    public Search_Circle_Adapter(List<SearchCircleBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.circle_search_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv.setText(list.get(position).getTitle());
        String s = String.valueOf(list.get(position).getReleaseTime());
        String format = DateFormatUtil.format(s);
        holder.time.setText(format);
        holder.common.setText(list.get(position).getDetail());
        holder.item_shoucang.setText(list.get(position).getCollectionNum()+"");
        holder.item_jianyi.setText(list.get(position).getCommentNum()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnItems.setOns(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final TextView common,item_shoucang;
        private final TextView tv,item_jianyi;
        private final TextView time;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.circle_tv3);
            common = itemView.findViewById(R.id.circle_common3);
            time = itemView.findViewById(R.id.circle_time3);
            item_jianyi = itemView.findViewById(R.id.item_jianyi3);
            item_shoucang = itemView.findViewById(R.id.item_shoucang3);
        }
    }
    public static class DateFormatUtil{
        public static String format(String date){
            if (TextUtils.isEmpty(date))
                return null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日mm分ss秒");
            Long aLong = new Long(date);
            return simpleDateFormat.format(aLong);
        }
    }
    public interface SetOnItems{
        void setOns(int i);
    }
    private SetOnItems setOnItems;

    public void setSetOnItems(SetOnItems setOnItems) {
        this.setOnItems = setOnItems;
    }
}
