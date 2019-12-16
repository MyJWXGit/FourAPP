package com.wd.doctor.view.activity.myview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.bean.StreamBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.adapter.StreamingAdapter;

public class StreamingActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    private MyStreaming_View myStreaming;
    private MyEditView edit_view;
    private RecyclerView stdr_recy;
 /*   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
        edit_view = findViewById(R.id.edit_view);
        myStreaming = findViewById(R.id.myStreaming);
        stdr_recy = findViewById(R.id.stdr_recy);

    }*/

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        edit_view = findViewById(R.id.edit_view);
        myStreaming = findViewById(R.id.myStreaming);
        stdr_recy = findViewById(R.id.stdr_recy);
        stdr_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
      /*  edit_view.setOnTextAddListener(new MyEditView.onTextAddListener() {
            @Override
            public void onSucceed(final String msg) {
                myStreaming.addText(msg);
            }
        });*/
      edit_view.setOnTextAddListener(new MyEditView.onTextAddListener() {
          @Override
          public void onSucceed(String msg) {
              myStreaming.addText(msg);
          }

          @Override
          public void Edtext(String sd) {
              mPresenter.Streanm(sd);
          }
      });

        myStreaming.setOnTextSetClickListener(new MyStreaming_View.onTextSetClickListener() {
            @Override
            public void onSucceed(final String msg) {
                Toast.makeText(StreamingActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_streaming;
    }

    @Override
    public void onSuccess(Object obj) {
        StreamBean bean= (StreamBean) obj;
        StreamingAdapter adapter=new StreamingAdapter(bean.getResult(),this);
        stdr_recy.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }
}
