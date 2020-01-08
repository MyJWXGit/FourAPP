package com.wd.my_message.view.suggest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.wd.health.R;

import java.util.List;

/**
 * @author 2019/11/14
 * @author 20:29
 *
 */
public class FindMyAdoptedCommentListAdapter extends RecyclerView.Adapter {
      private List<?> result;
      private Context context;

    public FindMyAdoptedCommentListAdapter(List<?> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_findmyadoptedcommentlist_item, null);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {




    }

    @Override
    public int getItemCount() {
        return result.size();
    }




    public class Viewholder1 extends RecyclerView.ViewHolder {



        public Viewholder1(@NonNull View itemView) {
            super(itemView);

        }
    }
}
