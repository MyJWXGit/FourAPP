package com.wd.health.view.walk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.wd.health.R;
import com.wd.health.bean.ConsumptionRecordBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/21 10:23
 * @change
 * @chang time
 * @class describe
 */
public class ConsumptionRecordAdapter extends RecyclerView.Adapter<ConsumptionRecordAdapter.Holder> {
    private List<ConsumptionRecordBean.ResultBean> list;
    private Context context;

    public ConsumptionRecordAdapter(List<ConsumptionRecordBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.my_wallet_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Date date = new Date(list.get(position).getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        holder.wallet_item_time.setText(simpleDateFormat.format(date));
        int direction = list.get(position).getDirection();
        if (direction==1){
            holder.wallet_item_consumption.setVisibility(View.GONE);
            holder.wallet_item_consumption2.setVisibility(View.VISIBLE);
            holder.wallet_item_consumption2.setText("+"+list.get(position).getChangeNum());
        }else if(direction==2){
            holder.wallet_item_consumption.setVisibility(View.VISIBLE);
            holder.wallet_item_consumption2.setVisibility(View.GONE);
            holder.wallet_item_consumption.setText(list.get(position).getChangeNum()+"");
        }
        int type = list.get(position).getType();
        if (type==1){
            holder.wallet_item_TextView.setText(list.get(position).getRemark());
        }else if(type==2){
            holder.wallet_item_TextView.setText("病友圈首评");
        }else if(type==3){
            holder.wallet_item_TextView.setText("首发病友圈");
        }else if(type==4){
            holder.wallet_item_TextView.setText("完善档案");
        }else if(type==5){
            holder.wallet_item_TextView.setText("健康评测");
        }else if(type==6){
            holder.wallet_item_TextView.setText("悬赏消费");
        }else if(type==7){
            holder.wallet_item_TextView.setText("悬赏奖励");
        }else if(type==8){
            holder.wallet_item_TextView.setText("邀请奖励");
        }else if(type==9){
            holder.wallet_item_TextView.setText("问诊消费");
        }else if(type==10){
            holder.wallet_item_TextView.setText("问诊收入");
        }else if(type==11){
            holder.wallet_item_TextView.setText(list.get(position).getRemark());
        }else if(type==12){
            holder.wallet_item_TextView.setText("送礼物");
        }else if(type==13){
            holder.wallet_item_TextView.setText("绑定身份证");
        }else if(type==14){
            holder.wallet_item_TextView.setText("绑定银行卡");
        }else if(type==15){
            holder.wallet_item_TextView.setText("充值");
        }else if(type==16){
            holder.wallet_item_TextView.setText("提现");
        }else if(type==17){
            holder.wallet_item_TextView.setText(list.get(position).getRemark());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final TextView wallet_item_time;
        private final TextView wallet_item_consumption2;
        private final TextView wallet_item_consumption,wallet_item_TextView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            wallet_item_time = itemView.findViewById(R.id.wallet_item_time);
            wallet_item_consumption2 = itemView.findViewById(R.id.wallet_item_consumption2);
            wallet_item_consumption = itemView.findViewById(R.id.wallet_item_consumption);
            wallet_item_TextView = itemView.findViewById(R.id.wallet_item_TextView);
        }
    }
}
