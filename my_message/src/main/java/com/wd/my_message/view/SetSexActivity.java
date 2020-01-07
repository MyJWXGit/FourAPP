package com.wd.my_message.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.my_message.R;
import com.wd.my_message.R2;
import com.wd.my_message.Update_Message_Activity;
import com.wd.my_message.bean.SetSexBean;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetSexActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.biaoti)
    RelativeLayout biaoti;
    @BindView(R2.id.radio_nan1)
    RadioButton radioNan1;
    @BindView(R2.id.radio_nan2)
    RadioButton radioNan2;
    @BindView(R2.id.radio_nv1)
    RadioButton radioNv1;
    @BindView(R2.id.radio_nv2)
    RadioButton radioNv2;
    @BindView(R2.id.check_nan1)
    ImageView checkNan1;
    @BindView(R2.id.check_nan2)
    ImageView checkNan2;
    @BindView(R2.id.check_nv1)
    ImageView checkNv1;
    @BindView(R2.id.check_nv2)
    ImageView checkNv2;
    @BindView(R2.id.Set_Sex_btn)
    Button SetSexBtn;
    private AlertDialog alertDialog;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        alertDialog = new AlertDialog.Builder(this)
                .setMessage("您的信息将会被更改")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (radioNan1.isChecked()||radioNan2.isChecked()) {
                            mPresenter.onSet_Sex(1);
                        }else if (radioNv1.isChecked()||radioNv2.isChecked()){
                            mPresenter.onSet_Sex(2);
                        }
                        Intent intent = new Intent(SetSexActivity.this, Update_Message_Activity.class);
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
        return R.layout.activity_set_sex;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof SetSexBean){
            SetSexBean setSexBean = (SetSexBean) data;
            String message = setSexBean.getMessage();
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

    @OnClick({R2.id.fanhui, R2.id.radio_nan1, R2.id.radio_nan2, R2.id.radio_nv1, R2.id.radio_nv2,R2.id.Set_Sex_btn})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.fanhui) {
            finish();
        } else if (id == R.id.radio_nan1) {
            if (radioNan1.isChecked()) {
                checkNan1.setVisibility(View.VISIBLE);
                checkNan2.setVisibility(View.INVISIBLE);
                checkNv1.setVisibility(View.INVISIBLE);
                checkNv2.setVisibility(View.INVISIBLE);
            }
        } else if (id == R.id.radio_nan2) {
            if (radioNan2.isChecked()) {
                checkNan1.setVisibility(View.INVISIBLE);
                checkNan2.setVisibility(View.VISIBLE);
                checkNv1.setVisibility(View.INVISIBLE);
                checkNv2.setVisibility(View.INVISIBLE);
            }
        } else if (id == R.id.radio_nv1) {
            if (radioNv1.isChecked()) {
                checkNan1.setVisibility(View.INVISIBLE);
                checkNan2.setVisibility(View.INVISIBLE);
                checkNv1.setVisibility(View.VISIBLE);
                checkNv2.setVisibility(View.INVISIBLE);
            }
        } else if (id == R.id.radio_nv2) {
            if (radioNv2.isChecked()) {
                checkNan1.setVisibility(View.INVISIBLE);
                checkNan2.setVisibility(View.INVISIBLE);
                checkNv1.setVisibility(View.INVISIBLE);
                checkNv2.setVisibility(View.VISIBLE);
            }
        }else if (id ==R.id.Set_Sex_btn){
            alertDialog.show();
        }
    }

}
