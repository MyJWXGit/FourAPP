package com.wd.doctor.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.StreamBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/12/15
 * author:金豪(Lenovo)
 * function:
 */
public class StreamingAdapter extends RecyclerView.Adapter<StreamingAdapter.StreamingViewHolder> {
     private List<StreamBean.ResultBean> list;
     private Context context;

    public StreamingAdapter(List<StreamBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StreamingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.patientsadapter, null);
        return new StreamingViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull StreamingViewHolder holder, int position) {
        holder.pati_name.setText(list.get(position).getTitle());
        holder.pati_zhengz.setText(list.get(position).getDetail());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(list.get(position).getReleaseTime());
        holder.pati_time.setText(format);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StreamingViewHolder extends RecyclerView.ViewHolder {
        private TextView pati_name,pati_zhengz,pati_time;
         public StreamingViewHolder(@NonNull View itemView) {
             super(itemView);
             pati_name=itemView.findViewById(R.id.pati_name);
             pati_zhengz=itemView.findViewById(R.id.pati_zhengz);
             pati_time=itemView.findViewById(R.id.pati_time);
         }
     }
}
