package com.wd.health.view.message;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.bean.InquiryMessageBean;
import com.wd.health.presenter.MyMessage_Presenter;
import com.wd.health.contract.Contract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InquiryMessageActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.inquiry_meassage_recycle)
    RecyclerView inquiryMeassageRecycle;
    @BindView(R2.id.message_include_img)
    SimpleDraweeView messageIncludeImg;
    @BindView(R2.id.message_include_text)
    TextView messageIncludeText;
    @BindView(R2.id.message_include_relat)
    RelativeLayout messageIncludeRelat;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        messageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mPresenter.onGetinquiry(1,15);
        //bujuguanliqi 布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        inquiryMeassageRecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_inquiry_message;
    }

    @Override
    public void onSuccess(Object data) {
        InquiryMessageBean inquiryMessageBean= (InquiryMessageBean) data;
        if (inquiryMessageBean.getStatus().equals("0000")){
            Toast.makeText(this, inquiryMessageBean.getMessage(), Toast.LENGTH_SHORT).show();
            List<InquiryMessageBean.ResultBean> result = inquiryMessageBean.getResult();
            if (result!=null){
                messageIncludeRelat.setVisibility(View.VISIBLE);
                inquiryMeassageRecycle.setVisibility(View.GONE);
              /*  messageIncludeRelat.setVisibility(View.GONE);
                inquiryMeassageRecycle.setVisibility(View.VISIBLE);
                //适配器
                InquirtMessageAdapter inquirtMessageAdapter = new InquirtMessageAdapter(this);
                inquirtMessageAdapter.setList(result);
                inquiryMeassageRecycle.setAdapter(inquirtMessageAdapter);*/
            }else{
                messageIncludeRelat.setVisibility(View.VISIBLE);
                inquiryMeassageRecycle.setVisibility(View.GONE);
            }

        }else{
            Toast.makeText(this, inquiryMessageBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

}
