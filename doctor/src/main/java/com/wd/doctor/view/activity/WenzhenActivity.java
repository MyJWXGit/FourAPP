package com.wd.doctor.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.bean.WenzhenBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.adapter.WenzhanAdapter;

public class WenzhenActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
     private ImageView details_back;
     private RecyclerView wenzhen_recy;
    private int doctorId;
    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        wenzhen_recy=findViewById(R.id.wenzhen_recy);
        details_back=findViewById(R.id.details_back);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");
        mPresenter.Wenzhen(doctorId, sessionId);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        wenzhen_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_wenzhen;
    }

    @Override
    public void onSuccess(Object obj) {
        WenzhenBean bean= (WenzhenBean) obj;
        WenzhanAdapter adapter=new WenzhanAdapter(bean.getResult(),this);
        wenzhen_recy.setAdapter(adapter);
        adapter.setOnckieButnk(new WenzhanAdapter.OnckieButnk() {
            @Override
            public void Onckedfklf(int userId) {
                Toast.makeText(WenzhenActivity.this, "11111", Toast.LENGTH_SHORT).show();
              Intent intent=new Intent(WenzhenActivity.this,ParticulatsActivity.class);
              intent.putExtra("doctorId",doctorId);
              intent.putExtra("sessionId",sessionId);
              intent.putExtra("userId",userId);
              startActivity(intent);
            }
        });
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
