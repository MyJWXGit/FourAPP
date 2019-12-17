package com.wd.circle.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.circle.R;
import com.wd.circle.api.Constant;
import com.wd.circle.bean.Circle_Comment_Bean;
import com.wd.circle.bean.Circle_Details_Bean;
import com.wd.circle.bean.CommentBean;
import com.wd.circle.bean.DoTaskBean;
import com.wd.circle.bean.UserTaskListBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.utils.DateUtils;
import com.wd.circle.view.adapter.RecycleView_Comment_Adapter;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Circle_Details_Activity extends BaseActivity<MainPresenter> implements Contract.IView {


    @BindView(R.id.patient_iv_user_head_pic)
    SimpleDraweeView patientIvUserHeadPic;
    @BindView(R.id.patient_activity_tv_title)
    TextView patientActivityTvTitle;
    @BindView(R.id.patient_iv_user_message)
    ImageView patientIvUserMessage;
    @BindView(R.id.patient_relative_titlebar)
    RelativeLayout patientRelativeTitlebar;
    @BindView(R.id.patient_activity_tv_adoptNickName)
    TextView patientActivityTvAdoptNickName;
    @BindView(R.id.patient_activity_tv_disease)
    TextView patientActivityTvDisease;
    @BindView(R.id.patient_activity_tv_department)
    TextView patientActivityTvDepartment;
    @BindView(R.id.patient_activity_tv_detail)
    TextView patientActivityTvDetail;
    @BindView(R.id.patient_activity_tv_treatment_time)
    TextView patientActivityTvTreatmentTime;
    @BindView(R.id.patient_activity_tv_treatmentProcess)
    TextView patientActivityTvTreatmentProcess;
    @BindView(R.id.patient_activity_iv_picture)
    ImageView patientActivityIvPicture;
    @BindView(R.id.patient_activity_tv_commentNum)
    TextView patientActivityTvCommentNum;
    @BindView(R.id.patient_activity_iv_content)
    ImageView patientActivityIvContent;
    @BindView(R.id.patient_activity_tv_collectionNum)
    TextView patientActivityTvCollectionNum;
    @BindView(R.id.recycler_sick_circle_comment_list)
    RecyclerView recyclerSickCircleCommentList;
    @BindView(R.id.patient_activity_iv_cancel)
    ImageView patientActivityIvCancel;
    @BindView(R.id.patient_activity_et_content)
    EditText patientActivityEtContent;
    @BindView(R.id.patient_activity_iv_send_content)
    ImageView patientActivityIvSendContent;
    @BindView(R.id.patient_activity_relative_content)
    RelativeLayout patientActivityRelativeContent;
    @BindView(R.id.patient_activity_iv_intent_release_sickCircle)
    ImageView patientActivityIvIntentReleaseSickCircle;
    @BindView(R.id.patient_activity_relative_release_sickCircle)
    RelativeLayout patientActivityRelativeReleaseSickCircle;
    @BindView(R.id.img_HeadPic)
    SimpleDraweeView imgHeadPic;
    @BindView(R.id.name_NickName)
    TextView nameNickName;
    @BindView(R.id.time_adoptTime)
    TextView timeAdoptTime;
    @BindView(R.id.text_adoptComment)
    TextView textAdoptComment;
    @BindView(R.id.adoptFlag)
    LinearLayout adoptFlag;
    private int userId;
    private String sessionId;
    private int sickCircleId;

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
        sickCircleId = intent.getIntExtra("sickCircleId", 0);
        mPresenter.onDetails(sickCircleId, userId + "", sessionId);
        mPresenter.onUserTaskList(userId + "", sessionId);
        patientActivityIvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onCircleComment(sickCircleId, userId + "", sessionId, 15, 1);
                patientActivityRelativeContent.setVisibility(View.VISIBLE);
                patientActivityRelativeReleaseSickCircle.setVisibility(View.GONE);
            }
        });
        patientActivityIvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientActivityRelativeContent.setVisibility(View.GONE);
                patientActivityRelativeReleaseSickCircle.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getSystemService(
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
                mPresenter.onComment(sickCircleId, userId + "", sessionId, et_content);
            }
        });
        //跳转发布病友圈
        patientActivityIvIntentReleaseSickCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Circle_Details_Activity.this, ReleaseCirclesActivity.class);
                startActivity(intent1);
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
            imgHeadPic.setImageURI(result.getAdoptHeadPic());
            nameNickName.setText(result.getAdoptNickName()+"");
            textAdoptComment.setText(result.getAdoptComment()+"");
            Date date1 = new Date(result.getAdoptTime());
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            timeAdoptTime.setText(simpleDateFormat1.format(date1));
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
                mPresenter.onDoTask(userId + "", sessionId, 1002);
            } else {
                Toast.makeText(this, commentBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else if (obj instanceof DoTaskBean) {
            DoTaskBean doTaskBean = (DoTaskBean) obj;
            if (doTaskBean.getStatus().equals("0000")) {
                Toast.makeText(this, "每日首评完成,快去领取奖励吧", Toast.LENGTH_SHORT).show();
                mPresenter.onCircleComment(sickCircleId, userId + "", sessionId, 1, 15);
            } else {
                mPresenter.onCircleComment(sickCircleId, userId + "", sessionId, 1, 15);
            }
        } else if (obj instanceof UserTaskListBean) {
            UserTaskListBean userTaskListBean = (UserTaskListBean) obj;
            List<UserTaskListBean.ResultBean> result = userTaskListBean.getResult();

        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
