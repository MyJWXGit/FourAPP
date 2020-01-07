package com.wd.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.view.Change_Password_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.head_text_name)
    TextView headTextName;
    @BindView(R2.id.relay_layout)
    RelativeLayout relayLayout;
    @BindView(R2.id.setting_image_view)
    SimpleDraweeView settingImageView;
    @BindView(R2.id.setting_text_name)
    TextView settingTextName;
    @BindView(R2.id.setting_image_name)
    LinearLayout settingImageName;
    @BindView(R2.id.setting_image_layout)
    RelativeLayout settingImageLayout;
    @BindView(R2.id.setting_image_pwd)
    RelativeLayout settingImagePwd;
    @BindView(R2.id.setting_text_clear)
    TextView settingTextClear;
    @BindView(R2.id.setting_image_clear)
    RelativeLayout settingImageClear;
    @BindView(R2.id.setting_image_ping_lian)
    RelativeLayout settingImagePingLian;
    @BindView(R2.id.setting_image_new_app)
    RelativeLayout settingImageNewApp;
    @BindView(R2.id.setting_image_ping_help)
    RelativeLayout settingImagePingHelp;
    @BindView(R2.id.setting_image_my)
    RelativeLayout settingImageMy;
    @BindView(R2.id.setting_image_new_invite)
    RelativeLayout settingImageNewInvite;
    @BindView(R2.id.setting_image_login)
    RelativeLayout settingImageLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }

    @OnClick({R2.id.head_details_back, R2.id.head_text_name, R2.id.relay_layout, R2.id.setting_image_view, R2.id.setting_text_name, R2.id.setting_image_name, R2.id.setting_image_layout, R2.id.setting_image_pwd, R2.id.setting_text_clear, R2.id.setting_image_clear, R2.id.setting_image_ping_lian, R2.id.setting_image_new_app, R2.id.setting_image_ping_help, R2.id.setting_image_my, R2.id.setting_image_new_invite, R2.id.setting_image_login})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.head_details_back) {
            finish();
        } else if (id == R.id.head_text_name) {

        } else if (id == R.id.relay_layout) {

        } else if (id == R.id.setting_image_view) {
        } else if (id == R.id.setting_text_name) {
        } else if (id == R.id.setting_image_name) {
        } else if (id == R.id.setting_image_layout) {
            Intent intent = new Intent(SettingsActivity.this, Update_Message_Activity.class);
            startActivity(intent);
        } else if (id == R.id.setting_image_pwd) {
            Intent intent = new Intent(SettingsActivity.this, Change_Password_Activity.class);
            startActivity(intent);
        } else if (id == R.id.setting_text_clear) {
        } else if (id == R.id.setting_image_clear) {
        } else if (id == R.id.setting_image_ping_lian) {
        } else if (id == R.id.setting_image_new_app) {
        } else if (id == R.id.setting_image_ping_help) {
        } else if (id == R.id.setting_image_my) {
        } else if (id == R.id.setting_image_new_invite) {
        } else if (id == R.id.setting_image_login) {
        }
    }
}
