package com.wd.doctor.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.wd.doctor.R;

public class GuideActivity extends AppCompatActivity {
    int count = 5;
    private TextView textnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        textnum=findViewById(R.id.textnum);
        textnum.setText(count+"s");

        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message,1000);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    count--;
                    textnum.setText(count+"s");
                    if (count > 0){
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message,1000);
                    }else{
                        Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
        }

    };
}
