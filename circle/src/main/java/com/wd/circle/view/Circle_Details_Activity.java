package com.wd.circle.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.circle.R;
import com.wd.circle.R2;
import com.wd.circle.api.Constant;
import com.wd.circle.bean.Circle_Comment_Bean;
import com.wd.circle.bean.Circle_Details_Bean;
import com.wd.circle.bean.CommentBean;
import com.wd.circle.bean.DoTaskBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.utils.DateUtils;
import com.wd.circle.view.adapter.RecycleView_Comment_Adapter;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Circle_Details_Activity extends BaseActivity<MainPresenter> implements Contract.IView {


    @BindView(R2.id.patient_iv_user_head_pic)
    SimpleDraweeView patientIvUserHeadPic;
    @BindView(R2.id.patient_activity_tv_title)
    TextView patientActivityTvTitle;
    @BindView(R2.id.patient_iv_user_message)
    ImageView patientIvUserMessage;
    @BindView(R2.id.patient_relative_titlebar)
    RelativeLayout patientRelativeTitlebar;
    @BindView(R2.id.patient_activity_tv_adoptNickName)
    TextView patientActivityTvAdoptNickName;
    @BindView(R2.id.patient_activity_tv_disease)
    TextView patientActivityTvDisease;
    @BindView(R2.id.patient_activity_tv_department)
    TextView patientActivityTvDepartment;
    @BindView(R2.id.patient_activity_tv_detail)
    TextView patientActivityTvDetail;
    @BindView(R2.id.patient_activity_tv_treatment_time)
    TextView patientActivityTvTreatmentTime;
    @BindView(R2.id.patient_activity_tv_treatmentProcess)
    TextView patientActivityTvTreatmentProcess;
    @BindView(R2.id.patient_activity_iv_picture)
    ImageView patientActivityIvPicture;
    @BindView(R2.id.patient_activity_tv_commentNum)
    TextView patientActivityTvCommentNum;
    @BindView(R2.id.patient_activity_iv_content)
    ImageView patientActivityIvContent;
    @BindView(R2.id.patient_activity_tv_collectionNum)
    TextView patientActivityTvCollectionNum;
    @BindView(R2.id.recycler_sick_circle_comment_list)
    RecyclerView recyclerSickCircleCommentList;
    @BindView(R2.id.patient_activity_iv_cancel)
    ImageView patientActivityIvCancel;
    @BindView(R2.id.patient_activity_et_content)
    EditText patientActivityEtContent;
    @BindView(R2.id.patient_activity_iv_send_content)
    ImageView patientActivityIvSendContent;
    @BindView(R2.id.patient_activity_relative_content)
    RelativeLayout patientActivityRelativeContent;
    @BindView(R2.id.patient_activity_iv_intent_release_sickCircle)
    ImageView patientActivityIvIntentReleaseSickCircle;
    @BindView(R2.id.patient_activity_relative_release_sickCircle)
    RelativeLayout patientActivityRelativeReleaseSickCircle;
    private int userId;
    private String sessionId;

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        String o = (String) SpUtils.get(this, Constant.Sp_touxiang, "");
        userId = (int) SpUtils.get(this, Constant.Sp_userId, 0);
        sessionId = (String) SpUtils.get(this, Constant.Sp_sessionId, "");
        patientIvUserHeadPic.setImageURI(o);
        Intent intent = getIntent();
        int sickCircleId = intent.getIntExtra("sickCircleId", 0);
        mPresenter.onDetails(sickCircleId, userId + "", sessionId);

        patientActivityIvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onCircleComment(sickCircleId, userId +"", sessionId,15,1);
                patientActivityRelativeContent.setVisibility(View.VISIBLE);
                patientActivityRelativeReleaseSickCircle.setVisibility(View.GONE);
            }
        });
        patientActivityIvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientActivityRelativeContent.setVisibility(View.GONE);
                patientActivityRelativeReleaseSickCircle.setVisibility(View.VISIBLE);
                InputMethodManager imm =(InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(patientActivityEtContent.getWindowToken(), 0);
            }
        });
        //评论
        patientActivityIvSendContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String et_content = patientActivityEtContent.getText().toString().trim();
                if (TextUtils.isEmpty(et_content)) {
                    Toast.makeText(Circle_Details_Activity.this, "输入的内容不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i("TAG", "onClick: " + "sickCircleId:" + sickCircleId);
                mPresenter.onComment(sickCircleId, userId +"", sessionId, et_content);
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_circle__details_;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_Details_Bean) {
            Circle_Details_Bean circle_details_bean = (Circle_Details_Bean) obj;
            Circle_Details_Bean.ResultBean result = circle_details_bean.getResult();
            Log.e("MyMessage", result.getDepartment());
            patientActivityTvTitle.setText(result.getTitle() + "");
            patientActivityTvAdoptNickName.setText(result.getAdoptNickName() + "");
            patientActivityTvDisease.setText(result.getDisease() + "");
            patientActivityTvDepartment.setText(result.getDepartment() + "");
            patientActivityTvDetail.setText(result.getDetail() + "");
            patientActivityTvTreatmentProcess.setText(result.getTreatmentProcess() + "");
            long treatmentStartTime = result.getTreatmentStartTime();
            long treatmentEndTime = result.getTreatmentEndTime();
            String endTimes = DateUtils.times(treatmentEndTime);
            String startTimes = DateUtils.times(treatmentStartTime);
            patientActivityTvTreatmentTime.setText(startTimes + "----" + endTimes);
            Glide.with(this).load(result.getPicture())
                    .placeholder(R.mipmap.none_comment)
                    .error(R.mipmap.none_comment)
                    .into(patientActivityIvPicture);
            patientActivityTvCommentNum.setText(result.getCommentNum() + "");
            patientActivityTvCollectionNum.setText(result.getCollectionNum() + "");
        } else if (obj instanceof Circle_Comment_Bean) {
            Circle_Comment_Bean circle_comment_bean = (Circle_Comment_Bean) obj;
            if (circle_comment_bean.getStatus().equals("0000")) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerSickCircleCommentList.setLayoutManager(linearLayoutManager);
                RecycleView_Comment_Adapter recycleView_comment_adapter = new RecycleView_Comment_Adapter(circle_comment_bean.getResult(), this);
                recyclerSickCircleCommentList.setAdapter(recycleView_comment_adapter);
            }
        } else if (obj instanceof CommentBean) {
            CommentBean commentBean = (CommentBean) obj;
            if (commentBean.getStatus().equals("0000")) {
                Toast.makeText(this, commentBean.getMessage(), Toast.LENGTH_SHORT).show();
                patientActivityEtContent.setText("");
                patientActivityEtContent.setHint("在此留下高见吧!!!");
                mPresenter.onDoTask(userId+"",sessionId,1002);
            } else {
                Toast.makeText(this, commentBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else if (obj instanceof DoTaskBean){
            DoTaskBean doTaskBean= (DoTaskBean) obj;
            Toast.makeText(this, ""+doTaskBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

}
