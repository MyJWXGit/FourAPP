package com.wd.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.home.adapter.RecordingAdapter;
import com.wd.home.bean.InquiryRecordBean;
import com.wd.home.bean.PuMessageBean;
import com.wd.home.bean.RecordingBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.HomePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.MessageContent;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.event.NotificationClickEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.api.BasicCallback;

import static cn.jpush.im.android.api.model.Conversation.createSingleConversation;

public class SendMessageActivity extends BaseActivity<HomePresenter> implements Contract.IView {


    @BindView(R2.id.im_recycler)
    RecyclerView imRecycler;
    @BindView(R2.id.im_edit)
    EditText imEdit;
    @BindView(R2.id.im_fs_tv)
    TextView imFsTv;
    private RecordingAdapter recordingAdapter;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mPresenter.onInquiryRecord();
        mPresenter.getRecording(3853, 1, 10);
        imFsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = imEdit.getText().toString();
                if (s != null) {
                    mPresenter.onPuMessage(3853, s, 1, 156);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SendMessageActivity.this);
                    linearLayoutManager.setReverseLayout(true);//布局反向
                    linearLayoutManager.setStackFromEnd(true);//数据反向
                    //创建跨应用会话
                    Conversation con = createSingleConversation("HLo7T517701300447", "c7f6a1d56cb8da740fd18bfa");
                    MessageContent content = new TextContent(s);
                    //创建一条消息
                    Message sendMessage = con.createSendMessage(content);
                    //发送消息
                    JMessageClient.sendMessage(sendMessage);
                    imRecycler.setLayoutManager(linearLayoutManager);
                    imEdit.setText(null);
                } else {
                    Toast.makeText(SendMessageActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                }
            }
        });
        JMessageClient.registerEventReceiver(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.home_activity_send_message;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof InquiryRecordBean) {
            InquiryRecordBean currentBean = (InquiryRecordBean) obj;
            InquiryRecordBean.ResultBean result = currentBean.getResult();
            if (result != null) {
                JMessageClient.login("HLo7T517701300447", "202cb962ac59075b964b07152d234b70", new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {
                        Toast.makeText(SendMessageActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else if (obj instanceof RecordingBean) {
            RecordingBean bean = (RecordingBean) obj;
            List<RecordingBean.ResultBean> result = bean.getResult();
            if (result != null) {
                imRecycler.setSelected(false);
                recordingAdapter = new RecordingAdapter(this, result);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SendMessageActivity.this);
                linearLayoutManager.setReverseLayout(true);//布局反向
                linearLayoutManager.setStackFromEnd(true);//数据反向

                imRecycler.setLayoutManager(linearLayoutManager);
                imRecycler.setAdapter(recordingAdapter);
                recordingAdapter.setId(new RecordingAdapter.getposition() {
                    @Override
                    public void getposition(int position) {
                        imRecycler.scrollToPosition(position);
                    }
                });
            }
        } else if (obj instanceof PuMessageBean) {
            PuMessageBean bean = (PuMessageBean) obj;
            if (bean.getStatus().equals("0000")) {
                if (recordingAdapter != null) {
                    mPresenter.getRecording(3853, 1, 10);
                    recordingAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    public void onEventMainThread(MessageEvent event) {
        Message msg = event.getMessage();
        switch (msg.getContentType()) {
            case text:
                // 处理文字消息
                TextContent textContent = (TextContent) msg.getContent();
                textContent.getText();
                mPresenter.onInquiryRecord();
                break;
        }
    }

    public void onEvent(NotificationClickEvent event) {
        mPresenter.onInquiryRecord();
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
