package com.wd.doctor.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseActivity;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.bean.UserparticularsBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParticulatsActivity extends BaseActivity<LoginPresenter> implements Contract.IView {


   /* @BindView(R2.id.inmgee)
    ImageView inmgee;
    @BindView(R2.id.back_blck)
    ImageView backBlck;
    @BindView(R2.id.HeadPic)
    SimpleDraweeView HeadPic;
    @BindView(R2.id.userheiget)
    TextView userheiget;
    @BindView(R2.id.userdethte)
    LinearLayout userdethte;
    @BindView(R2.id.userwidth)
    TextView userwidth;
    @BindView(R2.id.userdndswrsa)
    LinearLayout userdndswrsa;
    @BindView(R2.id.userage)
    TextView userage;
    @BindView(R2.id.useraeword)
    LinearLayout useraeword;
    @BindView(R2.id.diseaseMain)
    TextView diseaseMain;
    @BindView(R2.id.diseaseNow)
    TextView diseaseNow;
    @BindView(R2.id.diseaseBefore)
    TextView diseaseBefore;
    @BindView(R2.id.zhil)
    TextView zhil;
    @BindView(R2.id.treatmentHospitalRecent)
    TextView treatmentHospitalRecent;
    @BindView(R2.id.time)
    TextView time;
    @BindView(R2.id.bingzh)
    TextView bingzh;
    @BindView(R2.id.picture)
    SimpleDraweeView picture;
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.usersex)
    TextView usersex;
*/

   private ImageView back_blck;
   private SimpleDraweeView HeadPic;
   private TextView text_name,userheiget,userwidth,usersex,userage;
    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        back_blck=findViewById(R.id.back_blck);
        HeadPic=findViewById(R.id.HeadPic);
        text_name=findViewById(R.id.text_name);
        userheiget=findViewById(R.id.userheiget);
        userwidth=findViewById(R.id.userwidth);
        usersex=findViewById(R.id.usersex);
        userage=findViewById(R.id.userage);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int doctorId = intent.getIntExtra("doctorId", 0);
        int userId = intent.getIntExtra("userId", 0);
        String sessionId = intent.getStringExtra("sessionId");
        mPresenter.UserParti(doctorId, sessionId, userId);
        back_blck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_userdetails;
    }

    @Override
    public void onSuccess(Object obj) {
        UserparticularsBean bean = (UserparticularsBean) obj;
        HeadPic.setImageURI(bean.getResult().getUserHeadPic());
        text_name.setText(bean.getResult().getNickName());
        userheiget.setText(bean.getResult().getHeight()+"cm");
        userwidth.setText(bean.getResult().getWeight()+"kg");
        int sex = bean.getResult().getSex();
        if (sex == 1){
            usersex.setText("男");
        }else if (sex==2){
            usersex.setText("女");
        }
        userage.setText(bean.getResult().getAge()+"岁");
        //diseaseMain.setText(bean.getResult().);

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }


}

