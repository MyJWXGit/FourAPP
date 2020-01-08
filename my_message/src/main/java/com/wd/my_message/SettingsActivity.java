package com.wd.my_message;

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
import com.wd.health.R2;
import com.wd.my_message.view.Change_Password_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(com.wd.health.R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(com.wd.health.R2.id.head_text_name)
    TextView headTextName;
    @BindView(com.wd.health.R2.id.relay_layout)
    RelativeLayout relayLayout;
    @BindView(com.wd.health.R2.id.setting_image_view)
    SimpleDraweeView settingImageView;
    @BindView(com.wd.health.R2.id.setting_text_name)
    TextView settingTextName;
    @BindView(com.wd.health.R2.id.setting_image_name)
    LinearLayout settingImageName;
    @BindView(com.wd.health.R2.id.setting_image_layout)
    RelativeLayout settingImageLayout;
    @BindView(com.wd.health.R2.id.setting_image_pwd)
    RelativeLayout settingImagePwd;
    @BindView(com.wd.health.R2.id.setting_text_clear)
    TextView settingTextClear;
    @BindView(com.wd.health.R2.id.setting_image_clear)
    RelativeLayout settingImageClear;
    @BindView(com.wd.health.R2.id.setting_image_ping_lian)
    RelativeLayout settingImagePingLian;
    @BindView(com.wd.health.R2.id.setting_image_new_app)
    RelativeLayout settingImageNewApp;
    @BindView(com.wd.health.R2.id.setting_image_ping_help)
    RelativeLayout settingImagePingHelp;
    @BindView(com.wd.health.R2.id.setting_image_my)
    RelativeLayout settingImageMy;
    @BindView(com.wd.health.R2.id.setting_image_new_invite)
    RelativeLayout settingImageNewInvite;
    @BindView(com.wd.health.R2.id.setting_image_login)
    RelativeLayout settingImageLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity_settings);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }

    @OnClick({com.wd.health.R2.id.head_details_back, com.wd.health.R2.id.head_text_name, com.wd.health.R2.id.relay_layout, com.wd.health.R2.id.setting_image_view, com.wd.health.R2.id.setting_text_name, com.wd.health.R2.id.setting_image_name, com.wd.health.R2.id.setting_image_layout, com.wd.health.R2.id.setting_image_pwd, com.wd.health.R2.id.setting_text_clear, com.wd.health.R2.id.setting_image_clear, com.wd.health.R2.id.setting_image_ping_lian, com.wd.health.R2.id.setting_image_new_app, com.wd.health.R2.id.setting_image_ping_help, com.wd.health.R2.id.setting_image_my, com.wd.health.R2.id.setting_image_new_invite, R2.id.setting_image_login})
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
