package com.wd.doctor.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.PatientsBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/12/14
 * author:金豪(Lenovo)
 * function:
 */
public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.PatientsViewHolder> {
     private List<PatientsBean.ResultBean> list;
     private Context context;

    public PatientsAdapter(List<PatientsBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.patientsadapter, null);
        return new PatientsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientsViewHolder holder, int position) {
        holder.pati_name.setText(list.get(position).getTitle());
        holder.pati_zhengz.setText(list.get(position).getDetail());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(list.get(position).getReleaseTime());
        holder.pati_time.setText(format);
        holder.patien_num.setText(list.get(position).getAmount()+"");
        int amount = list.get(position).getAmount();
        if (amount!=0){
            holder.hhhb.setVisibility(View.VISIBLE);
            holder.patien_num.setVisibility(View.VISIBLE);
        }else {
            holder.hhhb.setVisibility(View.GONE);
            holder.patien_num.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sickCircleId = list.get(position).getSickCircleId();
                CallBack.sunsadnfn(sickCircleId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PatientsViewHolder extends RecyclerView.ViewHolder {
        private TextView pati_name,pati_zhengz,pati_time,patien_num;
        private ImageView hhhb;
        public PatientsViewHolder(@NonNull View itemView) {
            super(itemView);
            pati_name=itemView.findViewById(R.id.pati_name);
            pati_zhengz=itemView.findViewById(R.id.pati_zhengz);
            pati_time=itemView.findViewById(R.id.pati_time);
            patien_num=itemView.findViewById(R.id.patien_num);
            hhhb=itemView.findViewById(R.id.hhhb);
        }
    }
    public interface CallBack{
        void sunsadnfn(int sickCircleId);
    }
    private CallBack CallBack;

    public void setCallBack(PatientsAdapter.CallBack callBack) {
        CallBack = callBack;
    }
}
