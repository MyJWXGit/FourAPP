package com.wd.doctor.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.bean.WenzhenBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/12/25
 * author:金豪(Lenovo)
 * function:
 */
public class WenzhanAdapter extends RecyclerView.Adapter<WenzhanAdapter.WenzhanViewHolder> {
    private List<WenzhenBean.ResultBean> list;
    private Context context;
    private final ViewBinderHelper binderHelper = new ViewBinderHelper();
    public WenzhanAdapter(List<WenzhenBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WenzhanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wenzhenadapter, null);
        return new WenzhanViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull WenzhanViewHolder holder, int position) {
        holder.name.setText(list.get(position).getNickName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(list.get(position).getInquiryTime());
        holder.time.setText(format);
        holder.img.setImageURI(list.get(position).getUserHeadPic());
        holder.frontLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userId = list.get(position).getUserId();
                OnckieButnk.Onckedfklf(userId);
            }
        });

      /*  binderHelper.bind(holder.swipeLayout, String.valueOf(resultBean));
        holder.bind(String.valueOf(resultBean));*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WenzhanViewHolder extends RecyclerView.ViewHolder {
        private SwipeRevealLayout swipeLayout;
        private SimpleDraweeView img;
        private View frontLayout;
        private View deleteLayout;
        private TextView name, time, neirong, tv_delete;
        private RelativeLayout layout_content;

        public WenzhanViewHolder(@NonNull View itemView) {
            super(itemView);
           /* frontLayout = itemView.findViewById(R.id.front_layout);
            deleteLayout = itemView.findViewById(R.id.delete_layout);*/
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            neirong = itemView.findViewById(R.id.neirong);
            layout_content = itemView.findViewById(R.id.layout_content);
            tv_delete = itemView.findViewById(R.id.tv_delete);
            deleteLayout = itemView.findViewById(R.id.delete_layout);
            frontLayout = itemView.findViewById(R.id.front_layout);
           // swipeLayout = itemView.findViewById(R.id.swipe_layout);
        }

       /* public void bind(final String data) {
            deleteLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
            tv_delete.setText(data);
            frontLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String displayText = "" + data + " clicked";
                   // Toast.makeText(mContext, displayText, Toast.LENGTH_SHORT).show();
                    Log.d("RecyclerAdapter", displayText);
                }
            });*/
    }
    public interface OnckieButnk{
        void Onckedfklf(int userId);
    }
    private OnckieButnk OnckieButnk;

    public void setOnckieButnk(WenzhanAdapter.OnckieButnk onckieButnk) {
        OnckieButnk = onckieButnk;
    }
}
