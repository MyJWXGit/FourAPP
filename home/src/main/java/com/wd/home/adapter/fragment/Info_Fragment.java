package com.wd.home.adapter.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.wd.common.api.Constant;
import com.wd.common.base.BaseFragment;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.home.activity.Doctor_detailsActivity;
import com.wd.home.activity.SendMessageActivity;
import com.wd.home.bean.ConsultBean;
import com.wd.home.bean.DoctorListBean;
import com.wd.home.bean.EndInquiryBean;
import com.wd.home.presenter.Fragment_Presenter;
import com.wd.home.bean.InquiryRecordBean;
import com.wd.home.bean.UserWalletBean;
import com.wd.home.contract.Contract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @name Health
 * @class name：com.wd.home.adapter.fragment
 * @class describe
 * @anthor 24673
 * @time 2019/12/20 21:54
 * @change
 * @chang time
 * @class describe
 */
public class Info_Fragment extends BaseFragment<Fragment_Presenter> implements Contract.IView {
    private static final String TAG = "SickFrag";
    @BindView(R2.id.tablayout)
    TabLayout tablayout;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.work)
    TextView work;
    @BindView(R2.id.address)
    TextView address;
    @BindView(R2.id.good)
    TextView good;
    @BindView(R2.id.number)
    TextView number;
    @BindView(R2.id.more)
    ImageView more;
    @BindView(R2.id.money)
    TextView money;
    @BindView(R2.id.btn_go)
    Button btnGo;
    @BindView(R2.id.up)
    ImageView up;
    @BindView(R2.id.recy)
    RecyclerView recy;
    @BindView(R2.id.next)
    ImageView next;
    @BindView(R2.id.page)
    TextView page;
    @BindView(R2.id.image)
    SimpleDraweeView image;
    private int id;
    private int position;
    private String doctorId;
    private int count = 1;
    private List<DoctorListBean.ResultBean> result;
    private int servicePrice;

    @Override
    protected Fragment_Presenter providePresenter() {
        return new Fragment_Presenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_infp;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void initData() {
        id = getArguments().getInt("id");
        mPresenter.onDoctorList(id, 1, 1, 4);

        tablayout.addTab(tablayout.newTab().setText("综合"));
        tablayout.addTab(tablayout.newTab().setText("好评"));
        tablayout.addTab(tablayout.newTab().setText("咨询数"));
        tablayout.addTab(tablayout.newTab().setText("价格"));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (position == 0) {
                    mPresenter.onDoctorList(id, 1, 1, 4);
                }
                if (position == 1) {
                    mPresenter.onDoctorList(id, 2, 1, 4);
                }
                if (position == 2) {
                    mPresenter.onDoctorList(id, 3, 1, 4);
                }
                if (position == 3) {
                    mPresenter.onDoctorList(id, 4, 1, 4);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Doctor_detailsActivity.class);
                intent.putExtra(Constant.doctorId, doctorId);
                startActivity(intent);
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(doctorId);
                mPresenter.getConsult(156);
            }
        });
    }

    private void initPopupWindow() {
        View view = View.inflate(getContext(), R.layout.popupwindow_layout, null);
        Button cancel = view.findViewById(R.id.cancel);
        Button Recharge = view.findViewById(R.id.Recharge);

        final PopupWindow popupWindow = new PopupWindow(view, GridLayoutManager.LayoutParams.MATCH_PARENT, GridLayoutManager.LayoutParams.MATCH_PARENT);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击选择完收回PopupWidow
                popupWindow.dismiss();
            }
        });
        Recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onInquiryRecord();
                //点击选择完收回PopupWidow
                popupWindow.dismiss();
            }
        });

        //动画样式
        popupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        //显示位置
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 200, 0);
    }

    private void initPopupWindow_inquiry() {
        View view = View.inflate(getContext(), R.layout.popupwindow_inquiry, null);
        Button cancel = view.findViewById(R.id.cancel);
        Button Recharge = view.findViewById(R.id.Recharge);

        final PopupWindow popupWindow = new PopupWindow(view, GridLayoutManager.LayoutParams.MATCH_PARENT, GridLayoutManager.LayoutParams.MATCH_PARENT);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击选择完收回PopupWidow
                popupWindow.dismiss();
            }
        });
        Recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "联系管理员充值", Toast.LENGTH_SHORT).show();
                //点击选择完收回PopupWidow
                popupWindow.dismiss();
            }
        });

        //动画样式
        popupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        //显示位置
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof DoctorListBean) {
            DoctorListBean bean = (DoctorListBean) obj;
            result = bean.getResult();
            doctorId = result.get(0).getDoctorId();
            image.setImageURI(result.get(0).getImagePic());
            name.setText(result.get(0).getDoctorName() + "");
            address.setText(result.get(0).getInauguralHospital());
            good.setText("好评率 " + result.get(0).getPraise());
            number.setText("服务患者数 " + result.get(0).getPraiseNum());
            money.setText(result.get(0).getServicePrice() + "H币/次");
            page.setText("" + count);
            servicePrice = bean.getResult().get(0).getServicePrice();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recy.setLayoutManager(linearLayoutManager);
            InfoAdapter myAdapter = new InfoAdapter(result, getActivity());
            recy.setAdapter(myAdapter);
            if (count <= 1) {
                up.setVisibility(View.GONE);
            } else {
                up.setVisibility(View.VISIBLE);
            }
            if (result.size() <= 3) {
                next.setVisibility(View.GONE);
            } else {
                next.setVisibility(View.VISIBLE);
            }
            myAdapter.setOnCLickListener(new InfoAdapter.OnCLickListener() {
                @Override
                public void onclick(int position) {
                    doctorId = result.get(position).getDoctorId();
                    image.setImageURI(result.get(position).getImagePic());
                    name.setText(result.get(position).getDoctorName() + "");
                    address.setText(result.get(position).getInauguralHospital());
                    good.setText("好评率 " + result.get(position).getPraise());
                    number.setText("服务患者数 " + result.get(position).getPraiseNum());
                    money.setText(result.get(position).getServicePrice() + "H币/次");
                }
            });
        } else if (obj instanceof ConsultBean) {
            ConsultBean bean = (ConsultBean) obj;
            String status = bean.getStatus();
            if (status.equals("0000")) {
                Intent intent = new Intent(getActivity(), SendMessageActivity.class);
                startActivity(intent);
            } else if (status.equals("8001")) {
                Toast.makeText(getContext(), bean.getMessage(), Toast.LENGTH_SHORT).show();
                initPopupWindow();
            }
        } else if (obj instanceof InquiryRecordBean) {//查看当前问诊
            InquiryRecordBean bean = (InquiryRecordBean) obj;
            int recordId = bean.getResult().getRecordId();
            mPresenter.onEndInquiry(recordId);
        } else if (obj instanceof EndInquiryBean) {  //结束问诊
            EndInquiryBean bean = (EndInquiryBean) obj;
            if (bean.getStatus().equals("0000")) {
                mPresenter.onUserWallet();
            }
        } else if (obj instanceof UserWalletBean) {
            UserWalletBean bean = (UserWalletBean) obj;
            int result = bean.getResult();
            if (result > servicePrice) {

            } else {
                initPopupWindow_inquiry();
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