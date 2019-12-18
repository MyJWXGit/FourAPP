package com.wd.doctor.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.ImagePicBean;

import java.util.List;

/**
 * date:2019/12/17
 * author:金豪(Lenovo)
 * function:
 */
public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.SystemViewHolder> {
    private List<ImagePicBean.ResultBean> list;
    private Context context;

    public SystemAdapter(List<ImagePicBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SystemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.system, null);
        return new SystemViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SystemViewHolder holder, int position) {
       holder.imfgf.setImageURI(list.get(position).getImagePic());
      //Glide.with(context).load(list.get(position).getImagePic()).into(holder.imfgf);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImagePic.setPic(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SystemViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView imfgf;
        public SystemViewHolder(@NonNull View itemView) {
            super(itemView);
            imfgf=itemView.findViewById(R.id.imfgf);
        }
    }
    public interface onImagePic{
        //void setPic(String ImagePic);
        void setPic(int position);
    }
    private onImagePic onImagePic;

    public void setOnImagePic(SystemAdapter.onImagePic onImagePic) {
        this.onImagePic = onImagePic;
    }
}
