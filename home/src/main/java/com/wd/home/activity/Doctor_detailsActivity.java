package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.home.R;
import com.wd.home.R2;
import com.wd.home.adapter.CommentAdapter;
import com.wd.home.adapter.MyGiftAdapter;
import com.wd.home.bean.CancelFllowBean;
import com.wd.home.bean.DoctorInfoBean;
import com.wd.home.bean.FollowBean;
import com.wd.home.bean.InquiryRecordBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.Fragment_Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Doctor_detailsActivity extends BaseActivity<Fragment_Presenter> implements Contract.IView {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.rela)
    RelativeLayout rela;
    @BindView(R2.id.head_img)
    ImageView headImg;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.work)
    TextView work;
    @BindView(R2.id.address)
    TextView address;
    @BindView(R2.id.good)
    TextView good;
    @BindView(R2.id.number)
    TextView number;
    @BindView(R2.id.gift)
    TextView gift;
    @BindView(R2.id.recrivegift)
    TextView recrivegift;
    @BindView(R2.id.recy)
    RecyclerView recy;
    @BindView(R2.id.nolike)
    ImageView nolike;
    @BindView(R2.id.like)
    ImageView like;
    @BindView(R2.id.jieshao)
    TextView jieshao;
    @BindView(R2.id.scaddress)
    TextView scaddress;
    @BindView(R2.id.commit_count)
    TextView commitCount;
    @BindView(R2.id.recy_commit)
    RecyclerView recyCommit;
    @BindView(R2.id.more)
    TextView more;
    @BindView(R2.id.price)
    TextView price;
    @BindView(R2.id.go_now)
    Button goNow;
    private String doctorId;

    @Override
    protected Fragment_Presenter providePresenter() {
        return new Fragment_Presenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        doctorId = intent.getStringExtra(Constant.doctorId);
        mPresenter.onDoctorInfo(doctorId);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_doctor_details;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof DoctorInfoBean) {
            DoctorInfoBean bean = (DoctorInfoBean) obj;
            DoctorInfoBean.ResultBean result = bean.getResult();
            if (result != null) {
                int followFlag = result.getFollowFlag();
                if (followFlag == 1) {
                    nolike.setVisibility(View.GONE);
                    like.setVisibility(View.VISIBLE);
                }
                int servicePrice = result.getServicePrice();
                price.setText(servicePrice + "H币/次");
                Glide.with(this).load(result.getImagePic()).into(headImg);
                name.setText(result.getDoctorName());
                work.setText(result.getJobTitle());
                address.setText(result.getInauguralHospital());
                good.setText("好评率 " + result.getPraise());
                number.setText("服务患者数 " + result.getPraiseNum());
                List<DoctorInfoBean.ResultBean.DoctorReceiveGiftListBean> list = result.getDoctorReceiveGiftList();
                if (!list.isEmpty()) {
                    recrivegift.setVisibility(View.GONE);
                    recy.setVisibility(View.VISIBLE);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Doctor_detailsActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    recy.setLayoutManager(linearLayoutManager);
                    MyGiftAdapter myGiftAdapter = new MyGiftAdapter(list, Doctor_detailsActivity.this);
                    recy.setAdapter(myGiftAdapter);
                } else {
                    recrivegift.setVisibility(View.VISIBLE);
                    recy.setVisibility(View.GONE);
                }
                jieshao.setText(result.getPersonalProfile());
                scaddress.setText(result.getGoodField());
                commitCount.setText("(" + result.getCommentNum() + "条评论)");
                if (result.getCommentNum() != 0) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Doctor_detailsActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyCommit.setLayoutManager(linearLayoutManager);
                    List<DoctorInfoBean.ResultBean.CommentListBean> commentList = result.getCommentList();
                    CommentAdapter commentAdapter = new CommentAdapter(commentList, Doctor_detailsActivity.this);
                    recyCommit.setAdapter(commentAdapter);
                    if (commentList.size() == 3 && result.getCommentNum() > 3) {
                        more.setVisibility(View.VISIBLE);
                        more.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(Doctor_detailsActivity.this, CommentActivity.class);
                                intent.putExtra(Constant.doctorId, doctorId);
                                startActivity(intent);
                            }
                        });
                    }
                }
            } else {
                Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else if (obj instanceof FollowBean) {
            FollowBean bean = (FollowBean) obj;
            String message = bean.getMessage();
            nolike.setVisibility(View.GONE);
            like.setVisibility(View.VISIBLE);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (obj instanceof CancelFllowBean) {
            CancelFllowBean bean = (CancelFllowBean) obj;
            String message = bean.getMessage();
            nolike.setVisibility(View.VISIBLE);
            like.setVisibility(View.GONE);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (obj instanceof InquiryRecordBean) {
            InquiryRecordBean bean = (InquiryRecordBean) obj;
            String message = bean.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(Throwable e) {

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

    @OnClick({R2.id.back, R2.id.nolike, R2.id.like, R2.id.go_now})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.nolike) {
            int i = Integer.parseInt(doctorId);
            mPresenter.onFollow(i);
        } else if (id == R.id.like) {
            int i = Integer.parseInt(doctorId);
            mPresenter.onCancelFollow(i);
        } else if (id == R.id.go_now) {
            mPresenter.onInquiryRecord();
        }
    }
}
