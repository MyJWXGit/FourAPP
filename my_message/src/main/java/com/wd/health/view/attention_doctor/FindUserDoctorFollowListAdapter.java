package com.wd.health.view.attention_doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.bean.AttentionDoctorListBean;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/21 11:24
 * @change
 * @chang time
 * @class describe
 */
public class FindUserDoctorFollowListAdapter extends RecyclerView.Adapter<FindUserDoctorFollowListAdapter.Holder> {
    private List<AttentionDoctorListBean.ResultBean> result;
    private Context context;

    public FindUserDoctorFollowListAdapter(List<AttentionDoctorListBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_finduserdoctorfollowlist_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.attention_doctor_name.setText(result.get(position).getName());
        holder.attention_doctor_inauguralhospital.setText(result.get(position).getInauguralHospital());
        holder.attention_doctor_jobtitle.setText(result.get(position).getJobTitle());
        holder.attention_doctor_praise.setText(result.get(position).getPraise());
        holder.attention_doctor_praiseNum.setText(result.get(position).getPraiseNum()+"");
        Glide.with(context).load(result.get(position).getImagePic()).placeholder(R.drawable.default_head_5).into(holder.attention_doctor_imagePic);

        holder.quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnItemClicK.onSetOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final ImageView attention_doctor_imagePic;
        private final TextView attention_doctor_name;
        private final TextView attention_doctor_jobtitle;
        private final TextView attention_doctor_inauguralhospital;
        private final TextView attention_doctor_praise;
        private final TextView attention_doctor_praiseNum;
        private final Button quxiao;

        public Holder(@NonNull View itemView) {
            super(itemView);
            attention_doctor_imagePic = itemView.findViewById(R.id.attention_doctor_imagePic);
            attention_doctor_name = itemView.findViewById(R.id.attention_doctor_name);
            attention_doctor_jobtitle = itemView.findViewById(R.id.attention_doctor_jobtitle);
            attention_doctor_inauguralhospital = itemView.findViewById(R.id.attention_doctor_inauguralhospital);
            attention_doctor_praise = itemView.findViewById(R.id.attention_doctor_praise);
            attention_doctor_praiseNum = itemView.findViewById(R.id.attention_doctor_praiseNum);
            quxiao = itemView.findViewById(R.id.quxiao);
        }
    }
    public interface SetOnItemClicK{
        void onSetOnClick(int position);
    }
    private SetOnItemClicK setOnItemClicK;

    public void setSetOnItemClicK(SetOnItemClicK setOnItemClicK) {
        this.setOnItemClicK = setOnItemClicK;
    }
}
