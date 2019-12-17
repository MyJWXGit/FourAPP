package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.common.base.BaseActivity;
import com.wd.common.base.BasePresenter;
import com.wd.home.R;
import com.wd.home.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R2.id.image_guide)
    ImageView imageGuide;
    @BindView(R2.id.text_time)
    TextView textTime;
    private int i = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (i > 0) {
                        i--;
                        textTime.setText("" + i);
                        handler.sendEmptyMessageDelayed(0, 1000);
                    } else {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    break;
            }
        }
    };

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
