package com.wd.health.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.Update_Message_Activity;
import com.wd.health.bean.Set_NameBean;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.MyMessage_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetNameActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.biaoti)
    RelativeLayout biaoti;
    @BindView(R2.id.Set_Name_edit)
    EditText SetNameEdit;
    @BindView(R2.id.Set_Name_btn)
    Button SetNameBtn;
    private String trim;
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

        alertDialog = new AlertDialog.Builder(this)
                .setMessage("您的信息将会被更改")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.onSet_Name(trim);
                        Intent intent = new Intent();
                        intent.setClass(SetNameActivity.this, Update_Message_Activity.class);
                        intent.putExtra("name",trim);
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
        return R.layout.activity_set_name;

    }

    @Override
    public void onSuccess(Object data) {
        Set_NameBean set_nameBean = (Set_NameBean) data;
        String message = set_nameBean.getMessage();

        Toast.makeText(SetNameActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R2.id.fanhui, R2.id.Set_Name_edit, R2.id.Set_Name_btn})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.fanhui) {
            finish();
        } else if (id == R.id.Set_Name_edit) {
        } else if (id == R.id.Set_Name_btn) {
            trim = SetNameEdit.getText().toString().trim();
            alertDialog.show();
        }
    }
}
