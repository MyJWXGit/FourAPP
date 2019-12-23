package com.wd.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.home.R;
import com.wd.home.bean.DoctorInfoBean;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 *@auther:贾伟曦
 *@Date: 2019/12/18
 *@Time:15:09
 *@Description:礼物适配器
 **/
public class MyGiftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DoctorInfoBean.ResultBean.DoctorReceiveGiftListBean> list;
    Context context;

    public MyGiftAdapter(List<DoctorInfoBean.ResultBean.DoctorReceiveGiftListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_gift, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder) {
            Glide.with(context).load(list.get(position).getGiftPic()).into(((MyHolder) holder).img);
            ((MyHolder) holder).count.setText(list.get(position).getReceiveNum() + "");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView count;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.giftPic);
            count = itemView.findViewById(R.id.count);
        }
    }
}
