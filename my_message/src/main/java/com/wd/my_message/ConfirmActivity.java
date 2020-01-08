package com.wd.my_message;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.health.R;
import com.wd.health.R2;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ConfirmActivity extends AppCompatActivity {
    @BindView(com.wd.health.R2.id.back)
    RelativeLayout back;
    @BindView(com.wd.health.R2.id.name)
    EditText name;
    @BindView(com.wd.health.R2.id.num)
    EditText num;
    @BindView(com.wd.health.R2.id.end)
    TextView end;
    @BindView(com.wd.health.R2.id.sure)
    Button sure;
    @BindView(R2.id.mymessage)
    LinearLayout mymessage;
    private SharedPreferences sp1;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        ButterKnife.bind(this);
        //获取SP
        sp1 = getSharedPreferences("front", MODE_PRIVATE);
        sp = getSharedPreferences("back", MODE_PRIVATE);
        String num1 = sp1.getString("num", "");
        String name1 = sp1.getString("name", "");
        String expiryDate1 = sp.getString("expiryDate", "");
        //赋值
        name.setText(name1);
        num.setText(num1);
        end.setText(expiryDate1);


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmActivity.this.finish();
                sp.edit().clear().commit();
                sp1.edit().clear().commit();
            }
        });
        findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(ConfirmActivity.this,AddBankActivity.class));
            }
        });
    }
}
