package com.wd.doctor.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.wd.common.base.BaseFragment;
import com.wd.common.base.BasePresenter;
import com.wd.common.utils.Logger;
import com.wd.doctor.R;
import com.wd.doctor.bean.PhotographBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.utils.SPUtils;
import com.wd.doctor.view.activity.ImageUtil;
import com.wd.doctor.view.activity.message.MessageActivity;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * date:2019/12/18
 * author:金豪(Lenovo)
 * function:
 */
public class PictureFragmenttwo extends BaseFragment<LoginPresenter> implements Contract.IView {
    private ImageView shangchuan;
    private LinearLayout butedk;
    private int doctorId;
    private String sessionId;
    private MultipartBody.Part picture;
    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.picturefragmenttwo;
    }

    @Override
    protected void initView(View view) {
        shangchuan=view.findViewById(R.id.shangchuan);
        butedk=view.findViewById(R.id.butedk);
        Intent intent = getActivity().getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");


    }

    @Override
    protected void initData() {
        shangchuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View inflate = getLayoutInflater().inflate(R.layout.popwpictwo, null);
                PopupWindow popupWindow=new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(butedk,0,-160);
                View xiangji = inflate.findViewById(R.id.xiangji);
                View xiangce = inflate.findViewById(R.id.xiangce);
                View quxiao = inflate.findViewById(R.id.quxiao);
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       popupWindow.dismiss();
                    }
                });
                xiangce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, 1);
                    }
                });
            }
        });
        butedk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.Photograph(doctorId,sessionId,picture);
                Intent intent=new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
               getActivity().finish();
            }
        });
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        PhotographBean bean= (PhotographBean) obj;
        if (bean.getStatus().equals("0000")) {
            Toast.makeText(getActivity(), "每日首发病友圈完成!快去领取奖励吧", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onError(Throwable e) {

    }

  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是不是选中图片了
        if (requestCode == 1) {
            if (resultCode == getActivity().RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {
                    //用一个工具类获取图片的绝对路径,我会粘到下方
                    String path = ImageUtil.getPath(getActivity(), uri);

                    if (path != null) {
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        picture = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                        mPresenter.Photograph(doctorId, sessionId,picture);
                    }
                }
            } else {
                Toast.makeText(getActivity(), "取消相册", Toast.LENGTH_SHORT).show();
            }
        }
    }*/
  @Override
  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      super.onActivityResult(requestCode, resultCode, data);

      //判断是不是选中图片了
      if (requestCode == 1) {
          if (resultCode == Activity.RESULT_OK) {
              Uri uri = data.getData();
              if (uri != null) {
                  //用一个工具类获取图片的绝对路径,我会粘到下方
                  String path = ImageUtil.getPath(getActivity(), uri);
                 // Logger.d(TAG, "ath" + path);
                  SPUtils spImagePhoto = new SPUtils(getActivity(), "ImagePhoto");
                  spImagePhoto.putString("ImagePhotoPath", path);
                  Glide.with(getActivity()).load(path)
                          .placeholder(R.mipmap.ic_launcher_round)
                          .error(R.mipmap.ic_launcher)
                          .into(shangchuan);//设置要展示的图片
                 // setRelaPhotoPic.setVisibility(View.GONE);
                  if (path != null) {
                      //转换为file类型
                      File file = new File(path);
                      //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                      RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                      picture = MultipartBody.Part.createFormData("imagePic", file.getName(), requestBody);

                  }
              }
          } else {
              Toast.makeText(getActivity(), "取消相册", Toast.LENGTH_SHORT).show();
          }
      }
  }
}
