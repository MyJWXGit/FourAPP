package com.wd.doctor.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseFragment;
import com.wd.doctor.R;
import com.wd.doctor.bean.ImagePicBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.present.LoginPresenter;
import com.wd.doctor.view.activity.MainActivity;
import com.wd.doctor.view.activity.SystemActivity;
import com.wd.doctor.view.activity.message.MessageActivity;
import com.wd.doctor.view.adapter.SystemAdapter;

/**
 * date:2019/12/18
 * author:金豪(Lenovo)
 * function:
 */
public class PictureFragmentone extends BaseFragment<LoginPresenter> implements Contract.IView {
    private RecyclerView recyfdf;
    private Button butedk;
    private String imagePic;
    private int doctorId;
    private String sessionId;
    private boolean isFirstLoading = true;
    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.picturefragmentone;
    }

    @Override
    protected void initView(View view) {
        butedk=view.findViewById(R.id.butedk);
        recyfdf=view.findViewById(R.id.recyfdf);
        Intent intent = getActivity().getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        sessionId = intent.getStringExtra("sessionId");
    }

    @Override
    protected void initData() {
        mPresenter.Imagep();
        recyfdf.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        ImagePicBean bean= (ImagePicBean) obj;
        SystemAdapter adapter=new SystemAdapter(bean.getResult(),getActivity());
        recyfdf.setAdapter(adapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyfdf);
        adapter.setOnImagePic(new SystemAdapter.onImagePic() {
            @Override
            public void setPic(int position) {
                imagePic = bean.getResult().get(position).getImagePic();

            }
        });
        adapter.notifyDataSetChanged();

        butedk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imagePic!=null) {
                    mPresenter.Uploading(doctorId,sessionId,imagePic);
                    Intent intent = new Intent(getActivity(), MessageActivity.class);
                    startActivity(intent);
                // getActivity(). finish();
                }else {
                    Toast.makeText(getActivity(), "你没有选择照片", Toast.LENGTH_SHORT).show();
                }
                //adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isFirstLoading) {
            //如果不是第一次加载，刷新数据
            initLayout();
        }

        isFirstLoading = false;
    }
}
