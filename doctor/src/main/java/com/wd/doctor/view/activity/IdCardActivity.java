package com.wd.doctor.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.ToastUtils;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.encrypt.RsaCoder;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.utils.FileUtil;
import com.wd.doctor.utils.SPUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * date:2019/12/24
 * author:金豪(Lenovo)
 * function:
 */
public class IdCardActivity extends BaseActivity<LoginPresenter> implements Contract.IView {
    @BindView(R2.id.img_id_card_back)
    ImageView imgIdCardBack;
    @BindView(R2.id.img_id_card_front)
    ImageView imgIdCardFront;
    @BindView(R2.id.img_back)
    ImageView imgBack;
    @BindView(R2.id.img_camera_id_card_front)
    ImageView imgCameraIdCardFront;
    @BindView(R2.id.img_camera_id_card_back)
    ImageView imgCameraIdCardBack;
    @BindView(R2.id.btn_next_id_card)
    Button btnNextIdCard;
    @BindView(R2.id.btn_finish_id_card)
    Button btnFinishIdCard;
    @BindView(R2.id.linear_id_card_front)
    LinearLayout linearIdCardFront;
    @BindView(R2.id.linear_id_card_back)
    LinearLayout linearIdCardBack;
    @BindView(R2.id.img_cuowu_front)
    ImageView imgCuowuFront;
    @BindView(R2.id.img_cuowu_back)
    ImageView imgCuowuBack;
    public static final String TAG = "IdCardActivity";
    private static final int REQUEST_CODE_CAMERA = 103;
    private SPUtils idCard;
    private SPUtils idCard2;
    private String name;
    private String sex;
    private String nation;
    private String num;
    private String birthday;
    private String address;
    private String issueAuthority;
    private int doctorId;
    private String sessionId;


    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        SharedPreferences jin = getSharedPreferences("jin", Context.MODE_PRIVATE);
        doctorId = jin.getInt("doctorId", 0);
        sessionId = jin.getString("sessionId", "");
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_id_card;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onError(Throwable e) {

    }

     @OnClick({R2.id.img_back, R2.id.img_camera_id_card_front, R2.id.img_camera_id_card_back, R2.id.btn_next_id_card, R2.id.btn_finish_id_card,
             R2.id.img_cuowu_front, R2.id.img_cuowu_back})
     public void onClick(View view) {
         switch (view.getId()) {
             case R.id.img_back:
                 finish();
                 break;
             case R.id.img_camera_id_card_front:
                 Toast.makeText(this, "11111111", Toast.LENGTH_SHORT).show();
                 Intent intent2 = new Intent(IdCardActivity.this, CameraActivity.class);
                 intent2.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                         FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                 intent2.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                 startActivityForResult(intent2, REQUEST_CODE_CAMERA);
                 break;
             case R.id.img_camera_id_card_back:
                 Intent intent = new Intent(IdCardActivity.this, CameraActivity.class);
                 intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                         FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                 intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
                 startActivityForResult(intent, REQUEST_CODE_CAMERA);
                 break;
             case R.id.btn_next_id_card:
                 btnFinishIdCard.setVisibility(View.VISIBLE);
                 btnNextIdCard.setVisibility(View.GONE);
                 imgCuowuFront.setVisibility(View.VISIBLE);
                 imgCuowuBack.setVisibility(View.VISIBLE);
                 break;
             case R.id.btn_finish_id_card:
                 try {
                     name = RsaCoder.encryptByPublicKey(name);
                     sex = RsaCoder.encryptByPublicKey(sex);
                     nation = RsaCoder.encryptByPublicKey(nation);
                     birthday = RsaCoder.encryptByPublicKey(birthday);
                     address = RsaCoder.encryptByPublicKey(address);
                     num = RsaCoder.encryptByPublicKey(num);
                     issueAuthority = RsaCoder.encryptByPublicKey(issueAuthority);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 JSONArray jsonArray = new JSONArray();
                 JSONObject jsonObject = new JSONObject();
                 try {
                     jsonObject.put("doctorId",doctorId);
                     jsonObject.put("name",name);
                     jsonObject.put("sex",sex);
                     jsonObject.put("nation",nation);
                     jsonObject.put("birthday",birthday);
                     jsonObject.put("address",address);
                     jsonObject.put("num",num);
                     jsonObject.put("issueAuthority",issueAuthority);
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
                 JSONArray put = jsonArray.put(jsonObject);
                 Map<String,Object> BodyMap = new HashMap<>();
                 BodyMap.put("BodyMap", put);
                 mPresenter.BindDoctor(doctorId,sessionId,BodyMap);
                 break;
             case R.id.img_cuowu_front:
                 imgIdCardFront.setImageDrawable(null);
                 imgCuowuFront.setVisibility(View.GONE);
                 linearIdCardFront.setVisibility(View.VISIBLE);
                 break;
             case R.id.img_cuowu_back:
                 imgIdCardBack.setImageDrawable(null);
                 imgCuowuBack.setVisibility(View.GONE);
                 linearIdCardBack.setVisibility(View.VISIBLE);
                 break;
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
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        imgIdCardFront.setImageBitmap(bitmap);
                        linearIdCardFront.setVisibility(View.GONE);
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        imgIdCardBack.setImageBitmap(bitmap);
                        linearIdCardBack.setVisibility(View.GONE);
                    }
                }
            }
        }
    }

    /**
     * 解析身份证图片
     *
     * @param filePath 图片路径
     * @a0GPi4bzLzuT9dDpU5Zp1Ce7InFDAjUw param idCardSide 身份证正反面
     */
    private void recIDCard(final String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(40);
        OCR.getInstance(IdCardActivity.this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {


            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {

                    name = "";
                    sex = "";
                    nation = "";
                    num = "";
                    birthday = "";
                    address = "";
                    issueAuthority = "";
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
                    if (result.getBirthday() != null) {
                        birthday = result.getBirthday().toString();
                    }
                    if (result.getAddress() != null) {
                        address = result.getAddress().toString();
                    }
                    if (result.getIssueAuthority() != null) {
                        issueAuthority = result.getIssueAuthority().toString();
                    }
                    if (idCardSide.equals("front")) {
                        Toast.makeText(IdCardActivity.this, "姓名: " + name + "\n" +
                                "性别: " + sex + "\n" +
                                "民族: " + nation + "\n" +
                                "身份证号码: " + num + "\n" +
                                "生日" + birthday + "\n" +
                                "住址: " + address + "\n", Toast.LENGTH_SHORT).show();
                      /*  ToastUtils.showLong("姓名: " + name + "\n" +
                                "性别: " + sex + "\n" +
                                "民族: " + nation + "\n" +
                                "身份证号码: " + num + "\n" +
                                "生日" + birthday + "\n" +
                                "住址: " + address + "\n");*/

                        /*idCard = new SPUtils(IdCardActivity.this, "IdCard");
                        idCard.SharedPreferenceput("frontyes",true);
                        idCard.SharedPreferenceput("",false);
                        idCard.SharedPreferenceput("name", name);
                        idCard.SharedPreferenceput("sex", sex);
                        idCard.SharedPreferenceput("birthday", birthday);
                        idCard.SharedPreferenceput("address", address);
                        idCard.SharedPreferenceput("num", num);*/
                    } else if (idCardSide.equals("back")) {
                        Toast.makeText(IdCardActivity.this, "签发机关: " + issueAuthority + "\n", Toast.LENGTH_SHORT).show();
                         // ToastUtils.showLong( "签发机关: " + issueAuthority + "\n" );
                        /*idCard2 = new SPUtils(IdCardActivity.this, "IdCard2");
                        idCard2.SharedPreferenceput("backyes",true);*/
                    }
                }
            }

            @Override
            public void onError(OCRError error) {
                Toast.makeText(IdCardActivity.this, "识别出错,请查看log错误代码", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "onError: " + error.getMessage());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

   /* @OnClick({R2.id.img_back, R2.id.img_id_card_front, R2.id.img_camera_id_card_front, R2.id.linear_id_card_front, R2.id.img_id_card_back, R2.id.img_camera_id_card_back, R2.id.linear_id_card_back, R2.id.btn_next_id_card, R2.id.btn_finish_id_card, R2.id.img_cuowu_front, R2.id.img_cuowu_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R2.id.img_back:
                break;
            case R2.id.img_id_card_front:
                break;
            case R2.id.img_camera_id_card_front:
                break;
            case R2.id.linear_id_card_front:
                break;
            case R2.id.img_id_card_back:
                break;
            case R2.id.img_camera_id_card_back:
                break;
            case R2.id.linear_id_card_back:
                break;
            case R2.id.btn_next_id_card:
                break;
            case R2.id.btn_finish_id_card:
                break;
            case R2.id.img_cuowu_front:
                break;
            case R2.id.img_cuowu_back:
                break;
        }
    }*/
}
