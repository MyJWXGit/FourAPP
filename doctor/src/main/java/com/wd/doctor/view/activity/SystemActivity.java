package com.wd.doctor.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.R;
import com.wd.doctor.bean.ImagePicBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.adapter.SystemAdapter;

public class SystemActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    private RecyclerView recyfdf;
    private LinearLayout butedk;
    private String imagePic;
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
        butedk=findViewById(R.id.butedk);
        recyfdf=findViewById(R.id.recyfdf);
        Intent intent = getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");
    }

    @Override
    protected void initData() {
       mPresenter.Imagep();
        recyfdf.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_system2;
    }

    @Override
    public void onSuccess(Object obj) {
        ImagePicBean bean= (ImagePicBean) obj;
        SystemAdapter adapter=new SystemAdapter(bean.getResult(),this);
        recyfdf.setAdapter(adapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyfdf);
        adapter.setOnImagePic(new SystemAdapter.onImagePic() {
            @Override
            public void setPic(int position) {
                imagePic = bean.getResult().get(position).getImagePic();
                //Toast.makeText(SystemActivity.this, "1223323123123", Toast.LENGTH_SHORT).show();
            }
        });
        butedk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imagePic!=null) {
                    mPresenter.Uploading(doctorId,sessionId,imagePic);
                    Intent intent = new Intent(SystemActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(SystemActivity.this, "你没有选择照片", Toast.LENGTH_SHORT).show();
                }
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
