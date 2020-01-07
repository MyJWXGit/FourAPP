package com.wd.health.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.Update_Message_Activity;
import com.wd.health.bean.SetSignBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MyMessage_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetSignActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.btn_finish_sign)
    Button btnFinishSign;
    @BindView(R2.id.image_height)
    ImageView imageHeight;
    @BindView(R2.id.text_progress)
    TextView textProgress;
    @BindView(R2.id.sign_seekbar)
    SeekBar signSeekbar;
    @BindView(R2.id.image_weight)
    ImageView imageWeight;
    @BindView(R2.id.text2_progress)
    TextView text2Progress;
    @BindView(R2.id.we_seekbar)
    SeekBar weSeekbar;
    @BindView(R2.id.age_weight)
    ImageView ageWeight;
    @BindView(R2.id.text3_progress)
    TextView text3Progress;
    @BindView(R2.id.age_seekbar)
    SeekBar ageSeekbar;
    private int height;
    private int weight;
    private int age;
    private AlertDialog alertDialog;

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
        signSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textProgress.setText(50+progress+"cm");
                int position = signSeekbar.getProgress()-200;
                int x = seekBar.getWidth();
                int seekbarWidth = signSeekbar.getWidth();
                float width = (position*x)/200+seekbarWidth; //seekbar当前位置的宽度
                textProgress.setX(width);
                // Toast.makeText(SignActivity.this, "" + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(SignActivity.this, "开始：" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                height = seekBar.getProgress();

            }
        });

        ageSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text3Progress.setText(18+progress+"");
                int position = ageSeekbar.getProgress()-102;
                int x = seekBar.getWidth();
                int seekbarWidth = ageSeekbar.getWidth();
                float width = (position*x)/102+seekbarWidth; //seekbar当前位置的宽度
                text3Progress.setX(width);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age = seekBar.getProgress();

            }
        });

        weSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text2Progress.setText(30+progress+"kg");
                int position = weSeekbar.getProgress()-120;
                int x = seekBar.getWidth();
                int seekbarWidth = weSeekbar.getWidth();
                float width = (position*x)/120+seekbarWidth; //seekbar当前位置的宽度
                text2Progress.setX(width);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                weight = seekBar.getProgress();
            }
        });
        alertDialog = new AlertDialog.Builder(this)
                .setMessage("您的信息将会被更改")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.onSet_Sign(age,height,weight);
                        Intent intent = new Intent(SetSignActivity.this, Update_Message_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create();
    }

    @Override
    protected int initLayout() {
        return R.layout.message_activity_set_sign;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof SetSignBean){
            SetSignBean setSignBean = (SetSignBean) data;
            String message = setSignBean.getMessage();
            ToastUtils.show(SetSignActivity.this,message, Toast.LENGTH_LONG);

        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }



    @OnClick({R2.id.fanhui, R2.id.btn_finish_sign})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.fanhui) {
            finish();
        } else if (id == R.id.btn_finish_sign) {
            alertDialog.show();
        }
    }
}
