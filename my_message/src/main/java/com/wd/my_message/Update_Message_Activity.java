package com.wd.my_message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.utils.ImageUtil;
import com.wd.my_message.view.AutonymActivity;
import com.wd.my_message.bean.ImageBean;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Update_Message_Activity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(com.wd.health.R2.id.fanhui)
    ImageView fanhui;
    @BindView(com.wd.health.R2.id.my_information_Avatar)
    SimpleDraweeView myInformationAvatar;
    @BindView(com.wd.health.R2.id.my_information_Avatar_a)
    RelativeLayout myInformationAvatarA;
    @BindView(com.wd.health.R2.id.my_information_name)
    TextView myInformationName;
    @BindView(com.wd.health.R2.id.a2)
    ImageView a2;
    @BindView(com.wd.health.R2.id.my_information_name_a)
    RelativeLayout myInformationNameA;
    @BindView(com.wd.health.R2.id.my_information_gender)
    ImageView myInformationGender;
    @BindView(com.wd.health.R2.id.b1)
    ImageView b1;
    @BindView(com.wd.health.R2.id.my_information_gender_a)
    RelativeLayout myInformationGenderA;
    @BindView(com.wd.health.R2.id.my_information_height)
    TextView myInformationHeight;
    @BindView(com.wd.health.R2.id.my_information_bodyweight)
    TextView myInformationBodyweight;
    @BindView(com.wd.health.R2.id.my_information_age)
    TextView myInformationAge;
    @BindView(com.wd.health.R2.id.b2)
    ImageView b2;
    @BindView(com.wd.health.R2.id.my_information_Sign)
    RelativeLayout myInformationSign;
    @BindView(com.wd.health.R2.id.my_information_mailbox)
    TextView myInformationMailbox;
    @BindView(com.wd.health.R2.id.my_information_mailbox_a)
    RelativeLayout myInformationMailboxA;
    @BindView(com.wd.health.R2.id.my_information_weixin)
    TextView myInformationWeixin;
    @BindView(com.wd.health.R2.id.c2)
    ImageView c2;
    @BindView(com.wd.health.R2.id.my_information_weixin_a)
    RelativeLayout myInformationWeixinA;
    @BindView(com.wd.health.R2.id.my_information_Certification)
    TextView myInformationCertification;
    @BindView(com.wd.health.R2.id.d1)
    ImageView d1;
    @BindView(com.wd.health.R2.id.my_information_Certification_a)
    RelativeLayout myInformationCertificationA;
    @BindView(com.wd.health.R2.id.my_information_Bankcard)
    TextView myInformationBankcard;
    @BindView(com.wd.health.R2.id.d2)
    ImageView d2;
    @BindView(com.wd.health.R2.id.my_information_Bankcard_a)
    RelativeLayout myInformationBankcardA;

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

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_update_message;
    }

    @OnClick({com.wd.health.R2.id.fanhui, com.wd.health.R2.id.my_information_Avatar, R2.id.my_information_Certification_a})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.fanhui) {
            finish();
        } else if (id == R.id.my_information_Avatar) {
            initPopupWindow();
        } else if (id == R.id.my_information_Certification_a) {
            Intent intent = new Intent(Update_Message_Activity.this, AutonymActivity.class);
            startActivity(intent);
        }
    }

    private void initPopupWindow() {
        Button butShoot, butPhoto, butFinish;
        // 生成 View 对象
        View view = View.inflate(this, R.layout.pic_popupwindow_xml, null);
        butFinish = view.findViewById(R.id.but_finish);
        butPhoto = view.findViewById(R.id.but_photo);
        butShoot = view.findViewById(R.id.but_shoot);
        // PopUpWindow 传入 ContentView
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addBackground(popupWindow);
        //相册
        butPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Update_Message_Activity.this, "打开相册", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                popupWindow.dismiss();
            }
        });
        //拍摄
        butShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        butFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(view, Gravity.TOP, 0, 0);
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);
        popupWindow.showAtLocation(view, Gravity.TOP, 0, 0);
    }

    private void addBackground(PopupWindow popupWindow) {
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;//调节透明度
        getWindow().setAttributes(lp);
        //dismiss时恢复原样
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
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
                    if (path != null) {
                        myInformationAvatar.setImageURI(path);
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        MultipartBody.Part picture = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
                        mPresenter.onImage_PIC(picture);
                    }
                }
            } else {
                Toast.makeText(this, "取消相册", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof ImageBean) {
            ImageBean bean = (ImageBean) data;
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
}
