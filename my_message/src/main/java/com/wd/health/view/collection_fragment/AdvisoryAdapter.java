package com.wd.health.view.collection_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.bean.UserColletionBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 15:57
 * @change
 * @chang time
 * @class describe
 */
public class AdvisoryAdapter extends RecyclerView.Adapter<AdvisoryAdapter.Holder> {
    private List<UserColletionBean.ResultBean> list;
    private Context context;

    public AdvisoryAdapter(List<UserColletionBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_adapter_advisorylist_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.advisorylist_name.setText(list.get(position).getTitle());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(list.get(position).getCreateTime());
        holder.advisorylist_releaseTime.setText(format);

        String[] split = list.get(position).getThumbnail().split(";");
        for (int j = 0; j <split.length ; j++) {
            Glide.with(context).load(split[j]).into(holder.advisorylist_img);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnItemClick.setOnItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final TextView advisorylist_name;
        private final ImageView advisorylist_img;
        private final TextView advisorylist_source;
        private final TextView advisorylist_releaseTime;
        public Holder(@NonNull View itemView) {
            super(itemView);
            advisorylist_name = itemView.findViewById(R.id.advisorylist_name);
            advisorylist_img = itemView.findViewById(R.id.advisorylist_img);
            advisorylist_source = itemView.findViewById(R.id.advisorylist_source);
            advisorylist_releaseTime = itemView.findViewById(R.id.advisorylist_releaseTime);
        }
    }
    public interface SetOnItemClick{
        void setOnItem(int position);
    }
    private SetOnItemClick setOnItemClick;

    public void setSetOnItemClick(SetOnItemClick setOnItemClick) {
        this.setOnItemClick = setOnItemClick;
    }
}
