package com.wd.circle.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.circle.R;
import com.wd.circle.bean.Circle_lists_Bean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 16:58
 * @change
 * @chang time
 * @class describe
 */
public class Circle_Lists_Adapter extends RecyclerView.Adapter<Circle_Lists_Adapter.Holder> {
    private List<Circle_lists_Bean.ResultBean> list;
    private Context context;

    public Circle_Lists_Adapter(List<Circle_lists_Bean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.circle_lists_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv.setText(list.get(position).getTitle());
        String s = String.valueOf(list.get(position).getReleaseTime());
        String format = DateFormatUtil.format(s);
        holder.time.setText(format);
        holder.common.setText(list.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final TextView common;
        private final TextView tv;
        private final TextView time;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.circle_tv2);
            common = itemView.findViewById(R.id.circle_common);
            time = itemView.findViewById(R.id.circle_time);
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
}
