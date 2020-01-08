package com.wd.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.home.bean.Information_ListBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.adapter
 * @class describe
 * @anthor 24673
 * @time 2019/12/14 15:14
 * @change
 * @chang time
 * @class describe
 */
public class Information_Adapter extends RecyclerView.Adapter {
    List<Information_ListBean.ResultBean> list;
    Context context;

    public Information_Adapter(List<Information_ListBean.ResultBean> result, Context context) {
        this.context = context;
        this.list = result;
    }

    @Override
    public int getItemViewType(int position) {
        String[] split = list.get(position).getThumbnail().split(";");
        if (split.length == 1) {
            return 0;
        } else if (split.length == 3) {
            return 1;
        }
        return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.home_info_one_image, parent, false);
                return new MyOne_imageViewHolder(view);
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.home_info_three_image, parent, false);
                return new MyThree_imageViewHolder(view);
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.home_info_title, parent, false);
                return new MyTitleHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Date date = new Date(list.get(position).getReleaseTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                MyOne_imageViewHolder holder = (MyOne_imageViewHolder) viewHolder;
                holder.text_name.setText(list.get(position).getSource());
                holder.text_title.setText(list.get(position).getTitle());
                holder.simple.setImageURI(list.get(position).getThumbnail());
                simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                holder.text_time.setText(simpleDateFormat.format(date));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemInfoId.onInfoId(list.get(position).getId());
                    }
                });
                break;
            case 1:
                MyThree_imageViewHolder holder1 = (MyThree_imageViewHolder) viewHolder;
                holder1.text_name.setText(list.get(position).getSource());
                holder1.text_title.setText(list.get(position).getTitle());

                String[] split = list.get(position).getThumbnail().split(";");
                holder1.simple1.setImageURI(split[0]);
                holder1.simple2.setImageURI(split[1]);
                holder1.simple3.setImageURI(split[2]);

                holder1.text_time.setText(simpleDateFormat.format(date));

                holder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemInfoId.onInfoId(list.get(position).getId());
                    }
                });
                break;
            case 2:
                MyTitleHolder holder2 = (MyTitleHolder) viewHolder;
                holder2.text_name.setText(this.list.get(position).getSource());
                holder2.text_title.setText(this.list.get(position).getTitle());

                simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                holder2.text_time.setText(simpleDateFormat.format(date));

                holder2.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemInfoId.onInfoId(list.get(position).getId());
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyOne_imageViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simple;
        private TextView text_title, text_name, text_time;

        public MyOne_imageViewHolder(@NonNull View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            text_title = itemView.findViewById(R.id.text_title);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
        }
    }

    public class MyThree_imageViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simple1, simple2, simple3;
        private TextView text_title, text_name, text_time;


        public MyThree_imageViewHolder(@NonNull View itemView) {
            super(itemView);
            text_time = itemView.findViewById(R.id.text_time);
            text_title = itemView.findViewById(R.id.text_title);
            text_name = itemView.findViewById(R.id.text_name);
            simple1 = itemView.findViewById(R.id.simple1);
            simple2 = itemView.findViewById(R.id.simple2);
            simple3 = itemView.findViewById(R.id.simple3);
        }
    }

    public class MyTitleHolder extends RecyclerView.ViewHolder {
        private TextView text_title, text_name, text_time;

        public MyTitleHolder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            text_name = itemView.findViewById(R.id.text_name);
            text_time = itemView.findViewById(R.id.text_time);
        }
    }

    public onItemInfoId onItemInfoId;

    public interface onItemInfoId {
        void onInfoId(int infoId);
    }

    public void setOnItemInfoId(Information_Adapter.onItemInfoId onItemInfoId) {
        this.onItemInfoId = onItemInfoId;
    }
}
