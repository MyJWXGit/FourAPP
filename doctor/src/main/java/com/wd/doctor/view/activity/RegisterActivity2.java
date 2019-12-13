package com.wd.doctor.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity2 extends AppCompatActivity {

    @BindView(R.id.regin_back)
    ImageView reginBack;
    @BindView(R.id.resginter_jian)
    EditText resginterJian;
    @BindView(R.id.resginter_edd)
    EditText resginterEdd;
    @BindView(R.id.register_ru)
    Button registerRu;
    private String youxiang;
    private String jianyan;
    private String pwd;
    private String pwd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        youxiang = intent.getStringExtra("youxiang");
        jianyan = intent.getStringExtra("jianyan");
        pwd = intent.getStringExtra("pwd");
        pwd2 = intent.getStringExtra("pwd2");

    }

    @OnClick({R.id.regin_back, R.id.register_ru})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regin_back:
                finish();
                break;
            case R.id.register_ru:
                String jianli = resginterJian.getText().toString().trim();
                String lingyu = resginterEdd.getText().toString().trim();
                Intent intent=new Intent(RegisterActivity2.this,RegisterActivity3.class);
                intent.putExtra("youxiang",youxiang);
                intent.putExtra("jianyan",jianyan);
                intent.putExtra("pwd",pwd);
                intent.putExtra("pwd2",pwd2);
                intent.putExtra("jianli",jianli);
                intent.putExtra("lingyu",lingyu);
                startActivity(intent);
                break;
        }
    }
}
