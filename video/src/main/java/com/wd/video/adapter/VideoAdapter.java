package com.wd.video.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.dou361.ijkplayer.widget.IjkVideoView;
import com.wd.health.R;
import com.wd.video.bean.Video_QueryBean;
import com.wd.video.contract.Contract;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tv.danmaku.ijk.media.exo.IjkExoMediaPlayer;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.Holder> {
    private List<Video_QueryBean.ResultBean> list;
    private Context context;
    private String id;
    private int count =  0;
    private int counts =  0;
    private int whetherCollection;
    private String price;
    private IjkVideoView video_view;
    private int whetherBuy;


    public VideoAdapter(List<Video_QueryBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.video_adapter, parent, false);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        id = list.get(position).getId();
        whetherBuy = list.get(position).getWhetherBuy();
        whetherCollection = list.get(position).getWhetherCollection();
        price = list.get(position).getPrice();
        String originalUrl = list.get(position).getOriginalUrl();
        String[] split = originalUrl.split(",");
        holder.video_view
                .setVideoPath(split[0]);

        if (whetherCollection==1){
            holder.cb_collecte.setBackgroundResource(R.drawable.video_common_button_collection_small_s);
        }else if (whetherCollection==2){
            holder.cb_collecte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setOnClick.onClick(id);
                    holder.cb_collecte.setBackgroundResource(R.drawable.video_common_button_collection_small_s);
                }
            });
        }
        if (whetherBuy==1){
            holder.qian.setBackgroundResource(R.drawable.common_icon_comment_small_n);
            holder.qian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.video_edit.setVisibility(View.VISIBLE);
                    holder.video_send.setVisibility(View.VISIBLE);
                    holder.video_send.setOnClickListener(new View.OnClickListener() {

                        private String string;

                        @Override
                        public void onClick(View view) {
                            string = holder.video_edit.getText().toString();
                            Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                            setOnPingLun.onPingLunClick(id,string);
                        }
                    });
                }
            });
        }else if (whetherBuy==2){
            holder.qian.setBackgroundResource(R.drawable.common_icon_toll_n);
            holder.qian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setOnPriceTouch.onPriceClick(price,id);
                }
            });
        }

        holder.cb_barrage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counts++;
                setOnDian.onPriceClick(counts);
                if (counts%2==1){
                    holder.cb_barrage.setBackgroundResource(R.drawable.video_common_icon_close_live_commenting_n);
                }else if (counts%2==0){
                    holder.cb_barrage.setBackgroundResource(R.drawable.video_common_icon_open_live_commenting_n);
                }
            }
        });

        holder.video_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                count++;
                if (count%2==1){
                    holder.video_view.start();
                    holder.video_pause.setVisibility(View.INVISIBLE);
                    setOnTouch.onClick(id);
                }else if (count%2==0) {
                    holder.video_view.pause();
                    holder.video_pause.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });


        holder.video_title.setText(list.get(position).getTitle());
        holder.video_content.setText(list.get(position).getAbstracts());
        holder.video_want.setText(list.get(position).getBuyNum()+"人想看");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public IjkVideoView video_view;
        public ImageView video_pause;
        public TextView video_content;
        public TextView video_title;
        public TextView video_want;
        public ImageView cb_collecte;
        public CheckBox qian;
        public CheckBox cb_barrage;
        public Button video_send;
        public EditText video_edit;

        public Holder(@NonNull View itemView) {
            super(itemView);
            video_view = itemView.findViewById(R.id.video_view);
            video_pause = itemView.findViewById(R.id.video_pause);
            video_content = itemView.findViewById(R.id.video_content);
            video_title = itemView.findViewById(R.id.video_title);
            video_want = itemView.findViewById(R.id.video_want);
            cb_collecte = itemView.findViewById(R.id.cb_collecte);
            qian = itemView.findViewById(R.id.qian);
            cb_barrage = itemView.findViewById(R.id.cb_barrage);
            video_edit = itemView.findViewById(R.id.video_edit);
            video_send = itemView.findViewById(R.id.video_send);

        }
    }
    public VideLun videLun;
    public interface VideLun{
        void getData(int contens);
    }

    public void setVideLun(VideLun videLun) {
        this.videLun = videLun;
    }
    public interface setOnClick{
        void onClick(String oid);
    }
    private setOnClick setOnClick;

    public void setSetOnClick(VideoAdapter.setOnClick setOnClick) {
        this.setOnClick = setOnClick;
    }
    public interface setOnTouch{
        void onClick(String osid);
    }
    private setOnTouch setOnTouch;

    public void setsetOnTouch(VideoAdapter.setOnTouch setOnTouch) {
        this.setOnTouch = setOnTouch;
    }
    public interface setOnPriceTouch{
        void onPriceClick(String mp,String ooid);
    }
    private setOnPriceTouch setOnPriceTouch;

    public void setSetOnPriceTouch(VideoAdapter.setOnPriceTouch setOnPriceTouch) {
        this.setOnPriceTouch = setOnPriceTouch;
    }
    public interface setOnDian{
        void onPriceClick(int ci);
    }
    private setOnDian setOnDian;

    public void setOnDian(VideoAdapter.setOnDian setOnDian) {
        this.setOnDian = setOnDian;
    }
    public interface setOnPingLun{
        void onPingLunClick(String vid,String pl);
    }
    private setOnPingLun setOnPingLun;

    public void setSetOnPingLun(VideoAdapter.setOnPingLun setOnPingLun) {
        this.setOnPingLun = setOnPingLun;
    }
}
