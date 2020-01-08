package com.wd.my_message.view.collection_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.wd.health.R;
import com.wd.my_message.bean.UserSickCollectionBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/19 16:40
 * @change
 * @chang time
 * @class describe
 */
public class FindUserSickCollectionListAdapter extends RecyclerView.Adapter<FindUserSickCollectionListAdapter.Holder> {
    private List<UserSickCollectionBean.ResultBean> list;
    private Context context;

    public FindUserSickCollectionListAdapter(List<UserSickCollectionBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_findusersickcollectionlist_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.usersick_title.setText(list.get(position).getTitle());
        holder.usersick_disease.setText(list.get(position).getDisease());
        holder.usersick_collectionnum.setText("收藏  "+list.get(position).getCollectionNum());
        holder.usersick_commentnum.setText("           建议"+list.get(position).getCommentNum());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(list.get(position).getCreateTime());
        holder.usersick_createtime.setText(format);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnItemClick.setOnItemclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final TextView usersick_title;
        private final TextView usersick_disease;
        private final TextView usersick_collectionnum;
        private final TextView usersick_commentnum;
        private final TextView usersick_createtime;
        public Holder(@NonNull View itemView) {
            super(itemView);
            usersick_title = itemView.findViewById(R.id.usersick_title);
            usersick_disease = itemView.findViewById(R.id.usersick_disease);
            usersick_collectionnum = itemView.findViewById(R.id.usersick_collectionnum);
            usersick_commentnum = itemView.findViewById(R.id.usersick_commentnum);
            usersick_createtime = itemView.findViewById(R.id.usersick_createtime);
        }
    }
    public interface SetOnItemClick{
        void setOnItemclick(int position);
    }
    private SetOnItemClick setOnItemClick;

    public void setSetOnItemClick(SetOnItemClick setOnItemClick) {
        this.setOnItemClick = setOnItemClick;
    }
}
