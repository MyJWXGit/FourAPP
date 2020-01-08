package com.wd.my_message.view;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.TimePickerView;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.my_message.contract.Contract;
import com.wd.my_message.My_Home_Activity;
import com.wd.my_message.bean.AddArchivesBean;
import com.wd.my_message.presenter.MyMessage_Presenter;
import com.wd.my_message.view.record.TuAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RecordActivity extends BaseActivity<MyMessage_Presenter> implements Contract.IView {

    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.diseaseMain)
    EditText diseaseMain;
    @BindView(R2.id.line1)
    LinearLayout line1;
    @BindView(R2.id.diseaseNow)
    EditText diseaseNow;
    @BindView(R2.id.lin2)
    LinearLayout lin2;
    @BindView(R2.id.diseaseBefore)
    EditText diseaseBefore;
    @BindView(R2.id.lin3)
    LinearLayout lin3;
    @BindView(R2.id.treatmentHospitalRecent)
    EditText treatmentHospitalRecent;
    @BindView(R2.id.lin4)
    LinearLayout lin4;
    @BindView(R2.id.start)
    TextView start;
    @BindView(R2.id.edit_starttime)
    TextView editStarttime;
    @BindView(R2.id.start_image)
    ImageView startImage;
    @BindView(R2.id.startTime)
    RelativeLayout startTime;
    @BindView(R2.id.lin5)
    LinearLayout lin5;
    @BindView(R2.id.end)
    TextView end;
    @BindView(R2.id.edit_endtime)
    TextView editEndtime;
    @BindView(R2.id.end_image)
    ImageView endImage;
    @BindView(R2.id.endTime)
    RelativeLayout endTime;
    @BindView(R2.id.lin6)
    LinearLayout lin6;
    @BindView(R2.id.treatmentProcess)
    EditText treatmentProcess;
    @BindView(R2.id.lin7)
    LinearLayout lin7;
    @BindView(R2.id.bo_image_list)
    RecyclerView boImageList;
    @BindView(R2.id.add_image)
    ImageView addImage;
    @BindView(R2.id.addFiles)
    Button addFiles;
    @BindView(R2.id.lin8)
    LinearLayout lin8;
    private TimePickerView pvTime;
    private List<File> fileList =new ArrayList<>();
    private Map<String,MultipartBody.Part> partList = new ArrayMap<>();
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
        //点击返回按钮进行销毁当前页面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //开始时间格式
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });
        //结束时间格式
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate1();
            }
        });
        //点击添加按钮
        addFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecordActivity.this, "添加", Toast.LENGTH_SHORT).show();
                //主要病症
                String main = diseaseMain.getText().toString().trim();
                //现病史
                String now = diseaseNow.getText().toString().trim();
                //既往史
                String before = diseaseBefore.getText().toString().trim();
                //最近治疗医院
                String recent = treatmentHospitalRecent.getText().toString().trim();
                //治疗过程
                String process = treatmentProcess.getText().toString().trim();
                String startte = editStarttime.getText().toString().trim();
                String endte = editEndtime.getText().toString().trim();
                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put("diseaseMain",main);
                hashMap.put("diseaseNow",now);
                hashMap.put("diseaseBefore",before);
                hashMap.put("treatmentHospitalRecent",recent);
                hashMap.put("treatmentProcess",process);
                hashMap.put("treatmentStartTime",startte);
                hashMap.put("treatmentEndTime",endte);
                mPresenter.onInsertFile(hashMap);
            }
        });
        //点击图片进入相册
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fileList.size() >=6){
                    Toast.makeText(RecordActivity.this, "最多选取6张", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent1.setType("image/*");
                    startActivityForResult(intent1, 1);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1 & data !=null){
            Uri dataData = data.getData();

            String[] str={MediaStore.Images.Media.DATA};
            //获取内容解析器
            ContentResolver contentResolver = getContentResolver();
            Cursor cursor = contentResolver.query(dataData, str, null, null, null);
            //移至第一位
            cursor.moveToFirst();
            //获取下标
            int columnIndex = cursor.getColumnIndex(str[0]);
            String cursorString = cursor.getString(columnIndex);
            File file = new File(cursorString);
            fileList.add(file);

            //图片的布局
            GridLayoutManager gridLayoutManager = new GridLayoutManager(RecordActivity.this, 2);
            boImageList.setLayoutManager(gridLayoutManager);
            //适配器
            TuAdapter tuAdapter = new TuAdapter(fileList,RecordActivity.this);
            boImageList.setAdapter(tuAdapter);

            //格式
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"), file);
            //创建表格数据
            MultipartBody.Part part = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
            partList.containsKey(part);

            mPresenter.onUploadPiture(partList);


        }
    }

    private void selectDate1() {
        //时间选择器
        TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                String start = getTimeriqi(date);
                editStarttime.setText(start);
            }
        }).setType(new boolean[]{true, true, true, true, true, false})
                .setCancelColor(getResources().getColor(R.color.c1))
                .setSubmitColor(getResources().getColor(R.color.c1)).build();
        //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        timePickerView.setDate(Calendar.getInstance());
        timePickerView.show();
    }

    private void selectDate() {
        //时间选择器
        TimePickerView timePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                String start = getTimeriqi(date);
                editEndtime.setText(start);
            }
        }).setType(new boolean[]{true, true, true, true, true, false})
                .setCancelColor(getResources().getColor(R.color.c1))
                .setSubmitColor(getResources().getColor(R.color.c1)).build();
        //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        timePickerView.setDate(Calendar.getInstance());
        timePickerView.show();
    }

    private static String getTimeriqi(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_record;
    }

    @Override
    public void onSuccess(Object data) {
        if (data instanceof AddArchivesBean){
            AddArchivesBean addArchivesBean= (AddArchivesBean) data;
            if (addArchivesBean.getStatus().equals("0000")){
                Toast.makeText(this, addArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
                mPresenter.onDoTask(1004);
                startActivity(new Intent(this, My_Home_Activity.class));
            }else {
                Toast.makeText(this, addArchivesBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
