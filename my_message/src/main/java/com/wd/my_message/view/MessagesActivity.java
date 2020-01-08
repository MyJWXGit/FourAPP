package com.wd.my_message.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.view.message.CurrencyMessageActivity;
import com.wd.my_message.view.message.InquiryMessageActivity;
import com.wd.my_message.view.message.SystemMessageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessagesActivity extends AppCompatActivity {

    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.message_text)
    TextView messageText;
    @BindView(R2.id.message_but)
    Button messageBut;
    @BindView(R2.id.message_linear)
    LinearLayout messageLinear;
    @BindView(R2.id.xitongxiaoxi)
    LinearLayout xitongxiaoxi;
    @BindView(R2.id.wenzhenxiaoxi)
    LinearLayout wenzhenxiaoxi;
    @BindView(R2.id.ruzhangxinxi)
    LinearLayout ruzhangxinxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        ButterKnife.bind(this);
        messageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageLinear.setVisibility(View.GONE);
            }
        });
        //点击开启
        messageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageLinear.setVisibility(View.GONE);
            }
        });

    }
    @OnClick({R2.id.message_fanhui, R2.id.xitongxiaoxi, R2.id.wenzhenxiaoxi, R2.id.ruzhangxinxi})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.message_fanhui) {
            finish();
        } else if (id == R.id.xitongxiaoxi) {
            Intent intent = new Intent(MessagesActivity.this, SystemMessageActivity.class);
            startActivity(intent);
        } else if (id == R.id.wenzhenxiaoxi) {
            Intent intent1 = new Intent(MessagesActivity.this, InquiryMessageActivity.class);
            startActivity(intent1);
        } else if (id == R.id.ruzhangxinxi) {
            Intent intent2 = new Intent(MessagesActivity.this, CurrencyMessageActivity.class);
            startActivity(intent2);
        }
    }
}
