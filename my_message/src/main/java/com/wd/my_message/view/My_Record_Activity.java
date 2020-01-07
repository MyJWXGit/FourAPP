package com.wd.my_message.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.bean.DeleteArchivesBean;
import com.wd.my_message.bean.UserArchivesBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.record.Update_RecordActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class My_Record_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.message_fanhui)
    ImageView messageFanhui;
    @BindView(R2.id.vvv)
    View vvv;
    @BindView(R2.id.text_bingzheng)
    TextView textBingzheng;
    @BindView(R2.id.text_neike)
    TextView textNeike;
    @BindView(R2.id.text_xiangqing)
    TextView textXiangqing;
    @BindView(R2.id.text_tiantan)
    TextView textTiantan;
    @BindView(R2.id.text_riqi)
    TextView textRiqi;
    @BindView(R2.id.text_jingli)
    TextView textJingli;
    @BindView(R2.id.info_img)
    ImageView infoImg;
    @BindView(R2.id.my_archives_relat)
    RelativeLayout myArchivesLinear;
    @BindView(R2.id.button_delete)
    Button buttonDelete;
    @BindView(R2.id.button_bianji)
    Button buttonBianji;
    @BindView(R2.id.message_include_img)
    SimpleDraweeView messageIncludeImg;
    @BindView(R2.id.message_include_text)
    TextView messageIncludeText;
    @BindView(R2.id.myfile_button)
    Button myfileButton;
    @BindView(R2.id.message_include_relat)
    RelativeLayout messageIncludeRelat;
    private UserArchivesBean.ResultBean result;
    private int id;
    private String format;
    private String format1;

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
        mPresenter.onMyFile();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_my__record_;
    }

    @OnClick({R2.id.message_fanhui, R2.id.button_delete, R2.id.button_bianji, R2.id.myfile_button})
    public void onViewClicked(View view) {
        int viewId = view.getId();
        if (viewId == R.id.message_fanhui) {
            finish();
            //shanchu 删除
        } else if (viewId == R.id.button_delete) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);
            final AlertDialog dialog = builder.create();
            //此处设置位置窗体大小
            View inflate = View.inflate(this, R.layout.layout_dialog, null);
            dialog.setView(inflate);
            dialog.show();//显示对话框
            Button quxiaoButton = inflate.findViewById(R.id.dialog_quxiao_button);
            Button querenButton = inflate.findViewById(R.id.dialog_queding_button);
            //取消
            quxiaoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            //确定
            querenButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.onDeleteFile(id);
                    dialog.dismiss();
                }
            });

            //编辑
        } else if (viewId == R.id.button_bianji) {
            Intent intent1 = new Intent(My_Record_Activity.this, Update_RecordActivity.class);
            intent1.putExtra("id", result.getId());
            intent1.putExtra("diseaseMain", result.getDiseaseMain());
            intent1.putExtra("diseaseNow", result.getDiseaseNow());
            intent1.putExtra("diseaseBefore", result.getDiseaseBefore());
            intent1.putExtra("treatmentHospitalRecent", result.getTreatmentHospitalRecent());
            intent1.putExtra("treatmentProcess", result.getTreatmentProcess());
            intent1.putExtra("treatmentStartTime", format);
            intent1.putExtra("treatmentEndTime", format1);
            startActivityForResult(intent1, 1000);
            //点击添加
        } else if (viewId == R.id.myfile_button) {
            Intent intent = new Intent(My_Record_Activity.this, RecordActivity.class);
            startActivity(intent);
        }
    }
    //回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000&& resultCode == 2000){
            //接受回传的值
            textBingzheng.setText(data.getStringExtra("main"));
            textNeike.setText(data.getStringExtra("now"));
            textXiangqing.setText(data.getStringExtra("before"));
            textTiantan.setText(data.getStringExtra("recent"));
            textJingli.setText(data.getStringExtra("process"));
            String starttimes = data.getStringExtra("starttimes");
            String endtimes = data.getStringExtra("endtimes");
            textRiqi.setText(starttimes+"-"+endtimes);

        }

    }
    @Override
    public void onSuccess(Object data) {
        if (data instanceof UserArchivesBean){
            UserArchivesBean userArchivesBean= (UserArchivesBean) data;
            if (userArchivesBean.getStatus().equals("0000")){
                result = userArchivesBean.getResult();
                if (result!=null){
                    id = result.getId();
                    myArchivesLinear.setVisibility(View.VISIBLE);
                    messageIncludeRelat.setVisibility(View.GONE);

                    textBingzheng.setText(result.getDiseaseMain());
                    textNeike.setText(result.getDiseaseNow());
                    textXiangqing.setText(result.getDiseaseBefore());
                    textTiantan.setText(result.getTreatmentHospitalRecent());
                    textJingli.setText(result.getTreatmentProcess());
                    Date date = new Date(result.getTreatmentStartTime());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = new Date(result.getTreatmentEndTime());
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    textRiqi.setText(simpleDateFormat.format(date)+"-"+simpleDateFormat1.format(date1));
                    format = simpleDateFormat.format(date);
                    format1 = simpleDateFormat1.format(date1);
                    Glide.with(this)
                            .load(result.getPicture())
                            .placeholder(R.mipmap.none_comment)
                            .into(infoImg);
                }else {
                    myArchivesLinear.setVisibility(View.GONE);
                    messageIncludeRelat.setVisibility(View.VISIBLE);
                }
            }else {
                Toast.makeText(this, userArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }else if (data instanceof DeleteArchivesBean){
            DeleteArchivesBean deleteArchivesBean = (DeleteArchivesBean) data;
            if ( deleteArchivesBean.getStatus().equals("0000")){
                Toast.makeText(this,  deleteArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
                mPresenter.onMyFile();
            }else{
                Toast.makeText(this,  deleteArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
