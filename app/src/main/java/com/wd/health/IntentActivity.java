package com.wd.health;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.common.base.BaseActivity;
import com.wd.health.presenter.APP_MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntentActivity extends BaseActivity<APP_MainPresenter> {

    @BindView(R.id.image_guide)
    ImageView imageGuide;
    @BindView(R.id.text_time)
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
                        Intent intent = new Intent(IntentActivity.this, APP_Login_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                    break;
            }
        }
    };

    @Override
    protected APP_MainPresenter providePresenter() {
        return new APP_MainPresenter();
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
        return R.layout.activity_intent;
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
