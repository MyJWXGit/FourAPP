package com.wd.my_message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.wd.common.app.BaseApplication;
import com.wd.common.base.BaseActivity;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.utils.FileUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AutonymActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {
    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    private SharedPreferences sp1;
    private SharedPreferences sp;
    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.image_just)
    ImageView imageJust;
    @BindView(R2.id.image_against)
    ImageView imageAgainst;
    @BindView(R2.id.but_submit)
    Button but_submit;

    @Override
    protected MyMessage_Presenter providePresenter() {
        return new MyMessage_Presenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //获取SP
        sp = getSharedPreferences("front", MODE_PRIVATE);
        sp1 = getSharedPreferences("back", MODE_PRIVATE);
        initAccessTokenWithAkSk();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_autonym;
    }

    @Override
    public void onSuccess(Object data) {

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
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.fanhui, R2.id.image_just, R2.id.image_against, R2.id.but_submit})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        int id = view.getId();
        if (id == R.id.fanhui) {
            finish();
        } else if (id == R.id.image_just) {//正面
            intent = new Intent(AutonymActivity.this, CameraActivity.class);
            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                    FileUtil.getSaveFile(getApplication()).getAbsolutePath());
            intent.putExtra(CameraActivity.KEY_NATIVE_ENABLE, true);
            // KEY_NATIVE_MANUAL设置了之后CameraActivity中不再自动初始化和释放模型
            // 请手动使用CameraNativeHelper初始化和释放模型
            // 推荐这样做，可以避免一些activity切换导致的不必要的异常
            intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL, true);
            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        } else if (id == R.id.image_against) {//反面
            intent = new Intent(AutonymActivity.this, CameraActivity.class);
            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                    FileUtil.getSaveFile(getApplication()).getAbsolutePath());
            intent.putExtra(CameraActivity.KEY_NATIVE_ENABLE, true);
            // KEY_NATIVE_MANUAL设置了之后CameraActivity中不再自动初始化和释放模型
            // 请手动使用CameraNativeHelper初始化和释放模型
            // 推荐这样做，可以避免一些activity切换导致的不必要的异常
            intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL, true);
            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                    }
                }
            }
        }
    }

    //解析图片
    private void recIDCard(final String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(40);
        OCR.getInstance(AutonymActivity.this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {
            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {
                    String name = "";
                    String sex = "";
                    String nation = "";
                    String num = "";
                    String address = "";
                    String issueAuthority = "";
                    String expiryDate = "";
                    String birthday = "";
                    if (result.getName() != null) {
                        name = result.getName().toString();
                    }
                    if (result.getGender() != null) {
                        sex = result.getGender().toString();
                    }
                    if (result.getEthnic() != null) {
                        nation = result.getEthnic().toString();
                    }
                    if (result.getIdNumber() != null) {
                        num = result.getIdNumber().toString();
                    }
                    if (result.getAddress() != null) {
                        address = result.getAddress().toString();
                    }
                    if (result.getIssueAuthority() != null) {
                        issueAuthority = result.getIssueAuthority().toString();
                    }
                    if (result.getExpiryDate() != null) {
                        expiryDate = result.getExpiryDate().toString();
                    }
                    if (result.getBirthday() != null) {
                        birthday = result.getBirthday().toString();
                    }
                    if (idCardSide.equals("front")) {
                        Toast.makeText(AutonymActivity.this, "姓名: " + name + "\n" +
                                "性别: " + sex + "\n" +
                                "民族: " + nation + "\n" +
                                "身份证号码: " + num + "\n" +
                                "住址: " + address + "\n", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean("frontyes", true);
                        editor.putBoolean("", false);
                        editor.putString("name", name);
                        editor.putString("sex", sex);
                        editor.putString("address", address);
                        editor.putString("num", num);
                        editor.commit();
                    } else if (idCardSide.equals("back")) {
                        Toast.makeText(AutonymActivity.this, "签发机关: " + issueAuthority + "\n" +
                                "到期时间: " + expiryDate + "\n", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor1 = sp1.edit();
                        editor1.putString("expiryDate", expiryDate);
                        editor1.putBoolean("backyes", true);
                        editor1.commit();
                        getIntentOne();
                    }
                }
            }

            //判断跳转
            private void getIntentOne() {
                if (sp.getBoolean("frontyes", true) && sp1.getBoolean("backyes", true)) {
                    startActivity(new Intent(AutonymActivity.this, ConfirmActivity.class));
                }
            }

            @Override
            public void onError(OCRError ocrError) {

            }
        });
    }

    //初始化
    public static void initAccessTokenWithAkSk() {
        OCR.getInstance(APP.context).initAccessTokenWithAkSk(
                new OnResultListener<AccessToken>() {
                    @Override
                    public void onResult(AccessToken result) {
                        // 本地自动识别需要初始化
                        initLicense();
                        Log.d("MainActivity", "onResult: " + result.toString());
                        Toast.makeText(APP.context, "初始化失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(OCRError error) {
                        error.printStackTrace();
                        Log.e("MainActivity", "onError: " + error.getMessage());
                        Toast.makeText(APP.context, "初始化认证失败,请检查 key", Toast.LENGTH_SHORT).show();
                    }
                }, APP.context,
                // 需要自己配置 https://console.bce.baidu.com
                "2FKGrPppc5GO8opMcVIXGihP",
                // 需要自己配置 https://console.bce.baidu.com
                "AgGgIWwuaE4Fo2I6Pzl1deuRvCUqVAHg");
    }

    //初始化回调监听
    private static void initLicense() {
        CameraNativeHelper.init(APP.context, OCR.getInstance(APP.context).getLicense(),
                new CameraNativeHelper.CameraNativeInitCallback() {
                    @Override
                    public void onError(int errorCode, Throwable e) {
                        final String msg;
                        switch (errorCode) {
                            case CameraView.NATIVE_SOLOAD_FAIL:
                                msg = "加载so失败，请确保apk中存在ui部分的so";
                                break;
                            case CameraView.NATIVE_AUTH_FAIL:
                                msg = "授权本地质量控制token获取失败";
                                break;
                            case CameraView.NATIVE_INIT_FAIL:
                                msg = "本地质量控制";
                                break;
                            default:
                                msg = String.valueOf(errorCode);
                        }
                        Toast.makeText(APP.context, "初始化失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
