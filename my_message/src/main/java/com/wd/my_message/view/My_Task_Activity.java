package com.wd.my_message.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.DoTaskBean;
import com.wd.my_message.bean.GetTaskBean;
import com.wd.my_message.bean.LianxuSignBean;
import com.wd.my_message.bean.QuerySignBean;
import com.wd.my_message.bean.QueryTaskListBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.task.TaskListAdapter;
import com.wd.my_message.view.task.TaskListesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class My_Task_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.bonus_sign_item_day)
    TextView bonusSignItemDay;
    @BindView(R2.id.bonus_sign_item_right)
    View bonusSignItemRight;
    @BindView(R2.id.bonus_sign_item_left2)
    View bonusSignItemLeft2;
    @BindView(R2.id.bonus_sign_item_day2)
    TextView bonusSignItemDay2;
    @BindView(R2.id.bonus_sign_item_right2)
    View bonusSignItemRight2;
    @BindView(R2.id.bonus_sign_item_left3)
    View bonusSignItemLeft3;
    @BindView(R2.id.bonus_sign_item_day3)
    TextView bonusSignItemDay3;
    @BindView(R2.id.bonus_sign_item_right3)
    View bonusSignItemRight3;
    @BindView(R2.id.bonus_sign_item_left4)
    View bonusSignItemLeft4;
    @BindView(R2.id.bonus_sign_item_day4)
    TextView bonusSignItemDay4;
    @BindView(R2.id.bonus_sign_item_right4)
    View bonusSignItemRight4;
    @BindView(R2.id.bonus_sign_item_left5)
    View bonusSignItemLeft5;
    @BindView(R2.id.bonus_sign_item_day5)
    TextView bonusSignItemDay5;
    @BindView(R2.id.bonus_sign_item_right5)
    View bonusSignItemRight5;
    @BindView(R2.id.bonus_sign_item_left6)
    View bonusSignItemLeft6;
    @BindView(R2.id.bonus_sign_item_day6)
    TextView bonusSignItemDay6;
    @BindView(R2.id.bonus_sign_item_right6)
    View bonusSignItemRight6;
    @BindView(R2.id.bonus_sign_item_left7)
    View bonusSignItemLeft7;
    @BindView(R2.id.bonus_sign_item_day7)
    TextView bonusSignItemDay7;
    @BindView(R2.id.task_linear_run)
    LinearLayout taskLinearRun;
    @BindView(R2.id.accessibility_re_list_view)
    RecyclerView accessibilityReListView;
    @BindView(R2.id.accessibility_re_list)
    RecyclerView accessibilityReList;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        mPresenter.onQueryTaskList();
        mPresenter.onLianxuSign();
        mPresenter.onQueryUserSign();
        //每日任务
        //bujuguanliqi 布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        accessibilityReListView.setLayoutManager(linearLayoutManager);
        //一次性任务
        //bujuguanliqi 布局管理器
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        accessibilityReList.setLayoutManager(linearLayoutManager1);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_my__task_;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof QueryTaskListBean){
            QueryTaskListBean queryTaskListBean= (QueryTaskListBean) data;
            if (queryTaskListBean.getStatus().equals("0000")){
                List<QueryTaskListBean.ResultBean> result = queryTaskListBean.getResult();
                List<QueryTaskListBean.ResultBean> resultBeans=new ArrayList<>();
                List<QueryTaskListBean.ResultBean> resultBean=new ArrayList<>();
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTaskType()==1){
                        resultBeans.add(result.get(i));
                    }else if (result.get(i).getTaskType()==2){
                        resultBean.add(result.get(i));
                    }
                }
                TaskListAdapter taskAdapter=new TaskListAdapter(resultBeans,this);
                accessibilityReListView.setLayoutManager(new LinearLayoutManager(this));
                accessibilityReListView.setAdapter(taskAdapter);
                taskAdapter.setAreaView(new TaskListAdapter.AreaView() {
                    @Override
                    public void onCurress(int id) {
                        //做任务
                        mPresenter.onDoTask(id);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                accessibilityReListView.postInvalidate();
                            }
                        }).start();
                    }

                    @Override
                    public void onCurre(int id) {
                        //领取H币
                        mPresenter.onGetTask(id);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                accessibilityReListView.postInvalidate();
                            }
                        }).start();
                    }
                });

                TaskListesAdapter tasAdapter=new TaskListesAdapter(this,resultBean);
                accessibilityReList.setLayoutManager(new LinearLayoutManager(this));
                accessibilityReList.setAdapter(tasAdapter);
                tasAdapter.setAreaView(new TaskListesAdapter.AreaView() {
                    @Override
                    public void onCurress(int id) {
                        //zuoren做任务
                        mPresenter.onDoTask(id);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                accessibilityReList.postInvalidate();
                            }
                        }).start();
                    }

                    @Override
                    public void onCurre(int id) {
                        //ling领取
                        mPresenter.onGetTask(id);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                accessibilityReList.postInvalidate();
                            }
                        }).start();
                    }
                });

            }else{
                Toast.makeText(this, queryTaskListBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (data instanceof DoTaskBean){
            DoTaskBean doTaskBean= (DoTaskBean) data;
            if (doTaskBean.getStatus().equals("0000")){
                Toast.makeText(this, doTaskBean.getMessage(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, doTaskBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (data instanceof GetTaskBean){
            GetTaskBean getTaskBean = (GetTaskBean) data;
            if (getTaskBean.getStatus().equals("0000")){
                Toast.makeText(this, getTaskBean.getMessage(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, getTaskBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (data instanceof QuerySignBean){
            QuerySignBean querySignBean= (QuerySignBean) data;
            if (querySignBean.getStatus().equals("0000")){
                Toast.makeText(this, querySignBean.getMessage(), Toast.LENGTH_SHORT).show();
                mPresenter.onLianxuSign();
            }else{
                Toast.makeText(this, querySignBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (data instanceof LianxuSignBean){
            LianxuSignBean lianxuSignBean= (LianxuSignBean) data;
            if (lianxuSignBean.getStatus().equals("0000")){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        bonusSignItemDay.postInvalidate();
                        bonusSignItemDay2.postInvalidate();
                        bonusSignItemDay3.postInvalidate();
                        bonusSignItemDay4.postInvalidate();
                        bonusSignItemDay5.postInvalidate();
                        bonusSignItemDay6.postInvalidate();
                        bonusSignItemDay7.postInvalidate();
                        bonusSignItemRight.postInvalidate();
                        bonusSignItemRight2.postInvalidate();
                        bonusSignItemRight3.postInvalidate();
                        bonusSignItemRight4.postInvalidate();
                        bonusSignItemRight5.postInvalidate();
                        bonusSignItemRight6.postInvalidate();
                        bonusSignItemLeft2.postInvalidate();
                        bonusSignItemLeft3.postInvalidate();
                        bonusSignItemLeft4.postInvalidate();
                        bonusSignItemLeft5.postInvalidate();
                        bonusSignItemLeft6.postInvalidate();
                        bonusSignItemLeft7.postInvalidate();
                    }
                }).start();
                if (lianxuSignBean.getResult() == 0) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);

                } else if (lianxuSignBean.getResult() == 1) {
                    bonusSignItemDay.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
                } else if (lianxuSignBean.getResult() == 2) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay2.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
                } else if (lianxuSignBean.getResult() == 3) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay3.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
                } else if (lianxuSignBean.getResult() == 4) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay4.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
                } else if (lianxuSignBean.getResult() == 5) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay5.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_gray);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
                } else if (lianxuSignBean.getResult() == 6) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay6.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemDay7.setBackgroundResource(R.drawable.border_sign_heckin);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_gray);
                } else if (lianxuSignBean.getResult() == 7) {
                    bonusSignItemDay.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay2.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay3.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay4.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay5.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay6.setBackgroundResource(R.drawable.border_sign_day_checkin);
                    bonusSignItemDay7.setBackgroundResource(R.mipmap.my_task_select);
                    bonusSignItemRight.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight5.setBackgroundResource(R.color.color_blue);
                    bonusSignItemRight6.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft2.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft3.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft4.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft5.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft6.setBackgroundResource(R.color.color_blue);
                    bonusSignItemLeft7.setBackgroundResource(R.color.color_blue);
                }
            }else{
                Toast.makeText(this, lianxuSignBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
