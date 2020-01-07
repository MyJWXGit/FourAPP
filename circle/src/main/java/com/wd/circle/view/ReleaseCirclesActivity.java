package com.wd.circle.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.circle.R;
import com.wd.circle.api.Constant;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.DiseaseBean;
import com.wd.circle.bean.DoTaskBean;
import com.wd.circle.bean.PictureBean;
import com.wd.circle.bean.RepleaseCircleBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.utils.ImageUtil;
import com.wd.circle.view.adapter.ConsultationTwoAdapter;
import com.wd.circle.view.adapter.IllnessAdapter;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ReleaseCirclesActivity extends BaseActivity<MainPresenter> implements Contract.IView {

    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    @BindView(R.id.release_sickCircle_iv_user_head_pic)
    ImageView releaseSickCircleIvUserHeadPic;
    @BindView(R.id.patient_iv_user_message)
    ImageView patientIvUserMessage;
    @BindView(R.id.release_circle_et_title)
    EditText releaseCircleEtTitle;
    @BindView(R.id.release_circle_tv_choose_department)
    TextView releaseCircleTvChooseDepartment;
    @BindView(R.id.release_circle_iv_choose_department)
    RelativeLayout releaseCircleIvChooseDepartment;
    @BindView(R.id.release_circle_tv_choose_disease)
    TextView releaseCircleTvChooseDisease;
    @BindView(R.id.release_circle_iv_choose_disease)
    RelativeLayout releaseCircleIvChooseDisease;
    @BindView(R.id.release_circle_et_detail)
    EditText releaseCircleEtDetail;
    @BindView(R.id.release_circle_et_treatmentHospital)
    EditText releaseCircleEtTreatmentHospital;
    @BindView(R.id.release_circle_tv_startTime)
    TextView releaseCircleTvStartTime;
    @BindView(R.id.release_circle_iv_startTime)
    RelativeLayout releaseCircleIvStartTime;
    @BindView(R.id.release_circle_tv_endTime)
    TextView releaseCircleTvEndTime;
    @BindView(R.id.release_circle_iv_endTime)
    RelativeLayout releaseCircleIvEndTime;
    @BindView(R.id.release_circle_et_treatmentProcess)
    EditText releaseCircleEtTreatmentProcess;
    @BindView(R.id.release_circle_iv_upload_Picture)
    ImageView releaseCircleIvUploadPicture;
    @BindView(R.id.release_circle_iv_delete_Picture)
    ImageView releaseCircleIvDeletePicture;
    @BindView(R.id.release_circle_btn_publish)
    Button releaseCircleBtnPublish;
    @BindView(R.id.release_circle_linear_sick_circle)
    LinearLayout releaseCircleLinearSickCircle;
    @BindView(R.id.button_hbi3)
    Button buttonHbi3;
    @BindView(R.id.aaa)
    TextView aaa;
    @BindView(R.id.xuanshangedu_linear)
    LinearLayout xuanshangeduLinear;
    @BindView(R.id.swit)
    Switch swit;
    //    private ShapeLoadingDialog shapeLoadingDialog;
    private int userId;
    private String sessionId;
    private RecyclerView popup_recycler_department;
    private PopupWindow popupWindow;
    private int id;
    private RecyclerView popup_recycler_disease;
    private MultipartBody.Part picture;
    private PopupWindow popWindowDisease;
    private int sickCircleId;

    @Override
    protected int initLayout() {
        return R.layout.activity_release_circles;
    }

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
        //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //悬赏额度的开关
        swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    xuanshangeduLinear.setVisibility(View.VISIBLE);
                } else {
                    xuanshangeduLinear.setVisibility(View.GONE);
                }
            }
        });
        //开始时间
        releaseCircleIvStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        releaseCircleTvStartTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        //结束时间
        releaseCircleIvEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        releaseCircleTvEndTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        releaseCircleIvChooseDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopuWindows(view);
            }
        });
        //对应病症
        releaseCircleIvChooseDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindowDisease(v);
            }
        });

        //打开相册
        releaseCircleIvUploadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReleaseCirclesActivity.this, "打开相册", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        //删除选中图片
        releaseCircleIvDeletePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseCircleIvUploadPicture.setImageResource(R.mipmap.add);
            }
        });

//        shapeLoadingDialog = new ShapeLoadingDialog.Builder(ReleaseCirclesActivity.this)
//                .loadText("上传图片中...")
//                .build();
        initDate();
    }

    private void initDate() {
        userId = (int) SpUtils.get(this, Constant.Sp_userId, 0);
        sessionId = (String) SpUtils.get(this, Constant.Sp_sessionId, "");
        //点击发布圈子
        releaseCircleBtnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //标题
                String title = releaseCircleEtTitle.getText().toString().trim();
                //病症详情
                String detail = releaseCircleEtDetail.getText().toString().trim();
                //病症描述
                String disease = releaseCircleTvChooseDisease.getText().toString().trim();
                //治疗医院
                String treatmentHospital = releaseCircleEtTreatmentHospital.getText().toString().trim();
                //治疗开始时间 格式’2018-3-26’
                String treatmentStartTime = releaseCircleTvStartTime.getText().toString().trim();
                //	治疗结束时间 格式’2018-6-26’
                String treatmentEndTime = releaseCircleTvEndTime.getText().toString().trim();

                String treatmentProcess = releaseCircleEtTreatmentProcess.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "标题不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(detail)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请输入病症详情", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(disease)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "病症描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(disease)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "病症描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentStartTime)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请选择治疗开始时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentEndTime)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请选择治疗结束时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentHospital)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请输入治疗医院", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentProcess)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "治疗过程描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                Map<String, Object> map = new HashMap<>();
                map.put("title", title);
                map.put("departmentId", id);
                map.put("disease", disease);
                map.put("detail", detail);
                map.put("treatmentHospital", treatmentHospital);
                map.put("treatmentStartTime", treatmentStartTime);
                map.put("treatmentEndTime", treatmentEndTime);
                map.put("treatmentProcess", treatmentProcess);
                map.put("amount", 0);

                //调发布圈子接口
                mPresenter.onReplease(userId + "", sessionId, map);
//                shapeLoadingDialog.show();
            }
        });
    }

    private void initPopWindowDisease(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_popip_disease, null, false);
        popup_recycler_disease = view.findViewById(R.id.popup_recycler_disease);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        popWindowDisease = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindowDisease.setAnimationStyle(R.anim.anim_pop);  //设置加载动画
        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popWindowDisease.setTouchable(true);
        popWindowDisease.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindowDisease.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindowDisease.showAsDropDown(v, 50, 0);

        //根据科室查询对应病症
        mPresenter.onDisease(id);
    }

    private void initPopuWindows(View view) {
        View v = LayoutInflater.from(this).inflate(R.layout.item_popip_department, null, false);
        popup_recycler_department = v.findViewById(R.id.popup_recycler_department);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        popupWindow = new PopupWindow(v,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.anim.anim_pop);  //设置加载动画
        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popupWindow.showAsDropDown(view, 50, 0);
        mPresenter.onHome();
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_list_Bean) {
            Circle_list_Bean circle_list_bean = (Circle_list_Bean) obj;
            List<Circle_list_Bean.ResultBean> result = circle_list_bean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            ConsultationTwoAdapter consultationTwoAdapter = new ConsultationTwoAdapter(result, this);
            popup_recycler_department.setLayoutManager(linearLayoutManager);
            popup_recycler_department.setAdapter(consultationTwoAdapter);
            consultationTwoAdapter.setSetOnItemClickListen(new ConsultationTwoAdapter.SetOnItemClickListen() {
                @Override
                public void setOnItemClik(int i) {
                    id = result.get(i).getId();
                    releaseCircleTvChooseDepartment.setText(result.get(i).getDepartmentName());
                    Toast.makeText(ReleaseCirclesActivity.this, result.get(i).getDepartmentName(), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            });
        } else if (obj instanceof DiseaseBean) {
            DiseaseBean diseaseBean = (DiseaseBean) obj;
            List<DiseaseBean.ResultBean> result = diseaseBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            IllnessAdapter illnessAdapter = new IllnessAdapter(result, this);
            popup_recycler_disease.setLayoutManager(linearLayoutManager);
            popup_recycler_disease.setAdapter(illnessAdapter);
            illnessAdapter.setSetOnItemClicks(new IllnessAdapter.SetOnItemClicks() {
                @Override
                public void setOnItems(int i) {
                    String name = result.get(i).getName();
                    releaseCircleTvChooseDisease.setText(name + "");
                    popWindowDisease.dismiss();
                }
            });
        } else if (obj instanceof RepleaseCircleBean) {
            RepleaseCircleBean repleaseCircleBean = (RepleaseCircleBean) obj;
            if (repleaseCircleBean.getStatus().equals("0000")) {
                Toast.makeText(this, repleaseCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
                sickCircleId = repleaseCircleBean.getResult();
                Log.i("sickCircleId", "publishSuccess: " + "sickCircleId" + sickCircleId);
                if (picture != null) {
                    mPresenter.onPicture(userId + "", sessionId, sickCircleId, picture);
                } else {
                    //做任务
                    mPresenter.onDoTask(userId + "", sessionId, 1003);
//                    shapeLoadingDialog.dismiss();
                    finish();
                }
                notifyAll();
            } else {
                Toast.makeText(this, repleaseCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else if (obj instanceof DoTaskBean) {
            DoTaskBean doTaskBean = (DoTaskBean) obj;
            if (doTaskBean.getStatus().equals("0000")) {
                Toast.makeText(this, "每日首发病友圈完成!快去领取奖励吧", Toast.LENGTH_SHORT).show();
                mPresenter.onPicture(userId + "", sessionId, sickCircleId, picture);
            }
        } else if (obj instanceof PictureBean) {
            PictureBean pictureBean = (PictureBean) obj;
            if (pictureBean.getStatus().equals("0000")) {
                Toast.makeText(this, pictureBean.getMessage(), Toast.LENGTH_SHORT).show();
                //做任务
                mPresenter.onDoTask(userId + "", sessionId, 1003);
//                shapeLoadingDialog.dismiss();
                finish();
            } else {
                Toast.makeText(this, pictureBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是不是选中图片了
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {
                    //用一个工具类获取图片的绝对路径,我会粘到下方
                    String path = ImageUtil.getPath(this, uri);
                    Glide.with(this).load(path)
                            .placeholder(R.mipmap.add)
                            .error(R.mipmap.add)
                            .into(releaseCircleIvUploadPicture);
                    if (path != null) {
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        picture = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
                    }
                }
            } else {
                Toast.makeText(this, "取消相册", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
