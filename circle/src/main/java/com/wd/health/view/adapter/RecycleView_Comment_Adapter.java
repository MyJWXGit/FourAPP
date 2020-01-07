package com.wd.health.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.wd.health.R;
import com.wd.health.bean.Circle_Comment_Bean;
import com.wd.health.utils.DateUtils;

import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/16 9:39
 * @change
 * @chang time
 * @class describe
 */
public class RecycleView_Comment_Adapter extends RecyclerView.Adapter<RecycleView_Comment_Adapter.Holder> {
private List<Circle_Comment_Bean.ResultBean> list;
private Context context;

    public RecycleView_Comment_Adapter(List<Circle_Comment_Bean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.circle_adapter_sick_circle_comment_list_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.adapter_comment_list_tv_nickName.setText(list.get(position).getNickName()+"");
        holder.adapter_comment_list_tv_content.setText(list.get(position).getContent()+"");
        long commentTime = list.get(position).getCommentTime();
        String times = DateUtils.times(commentTime);
        holder.adapter_comment_list_tv_commentTime.setText(times+"");
        Glide.with(context).load(list.get(position).getHeadPic())
                .transform(new CircleCrop())
                .placeholder(R.mipmap.common_button_collection_large_n)
                .error(R.mipmap.common_button_collection_large_n)
                .into(holder.adapter_comment_list_iv_headPic);

        holder.adapter_comment_list_tv_supportNum.setText(list.get(position).getSupportNum()+"");
        holder.adapter_comment_list_tv_opposeNum.setText(list.get(position).getOpposeNum()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final ImageView adapter_comment_list_iv_headPic;
        private final TextView adapter_comment_list_tv_nickName;
        private final TextView adapter_comment_list_tv_content;
        private final TextView adapter_comment_list_tv_commentTime;
        private final TextView adapter_comment_list_tv_supportNum;
        private final TextView adapter_comment_list_tv_opposeNum;
        public Holder(@NonNull View itemView) {
            super(itemView);
            adapter_comment_list_iv_headPic = itemView.findViewById(R.id.adapter_comment_list_iv_headPic);
            adapter_comment_list_tv_nickName = itemView.findViewById(R.id.adapter_comment_list_tv_nickName);
            adapter_comment_list_tv_commentTime = itemView.findViewById(R.id.adapter_comment_list_tv_commentTime);
            adapter_comment_list_tv_content = itemView.findViewById(R.id.adapter_comment_list_tv_content);
            adapter_comment_list_tv_supportNum = itemView.findViewById(R.id.adapter_comment_list_tv_supportNum);
            adapter_comment_list_tv_opposeNum = itemView.findViewById(R.id.adapter_comment_list_tv_opposeNum);
        }
    }
}
