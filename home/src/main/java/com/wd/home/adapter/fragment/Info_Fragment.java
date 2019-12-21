package com.wd.home.adapter.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.base.BaseFragment;
import com.wd.home.R;
import com.wd.home.R2;
import com.wd.home.adapter.DoctorAdapter;
import com.wd.home.bean.DoctorListBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.Fragment_Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R2.id.tv_zh)
    TextView tvZh;
    @BindView(R2.id.tv_hp)
    TextView tvHp;
    @BindView(R2.id.tv_zxs)
    TextView tvZxs;
    @BindView(R2.id.tv_price)
    TextView tvPrice;
    @BindView(R2.id.sdv_pic)
    SimpleDraweeView sdvPic;
    @BindView(R2.id.tv_name)
    TextView tvName;
    @BindView(R2.id.tv_jobTitle)
    TextView tvJobTitle;
    @BindView(R2.id.tv_inauguralHospital)
    TextView tvInauguralHospital;
    @BindView(R2.id.tv_praiseNum)
    TextView tvPraiseNum;
    @BindView(R2.id.tv_serverNum)
    TextView tvServerNum;
    @BindView(R2.id.tv_servicePrice)
    TextView tvServicePrice;
    @BindView(R2.id.tv_ask)
    TextView tvAsk;
    @BindView(R2.id.sdv_left)
    SimpleDraweeView sdvLeft;
    @BindView(R2.id.sdv_right)
    SimpleDraweeView sdvRight;
    @BindView(R2.id.rv_doctor)
    RecyclerView rvDoctor;
    @BindView(R2.id.tv_pageNum)
    TextView tvPageNum;
    private int id;

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
        mPresenter.onDoctorList(id, 1, 1, 5);
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof DoctorListBean) {
            DoctorListBean bean = (DoctorListBean) obj;
            List<DoctorListBean.ResultBean> result = bean.getResult();
            sdvPic.setImageURI(result.get(0).getImagePic());
            tvName.setText(result.get(0).getDoctorName());
            tvInauguralHospital.setText(result.get(0).getInauguralHospital());
            tvJobTitle.setText(result.get(0).getJobTitle());
            tvPraiseNum.setText("好评率   " + result.get(0).getPraise() + "%");
            tvServerNum.setText("服务患者数   " + result.get(0).getServerNum());
            tvServicePrice.setText(result.get(0).getServicePrice() + "H币/次");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            DoctorAdapter doctorAdapter = new DoctorAdapter(getContext(), result);
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    @OnClick({R2.id.tv_zh, R2.id.tv_hp, R2.id.tv_zxs, R2.id.tv_price})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.tv_zh) {
            mPresenter.onDoctorList(id, 1, 1, 5);
        } else if (id == R.id.tv_hp) {
            mPresenter.onDoctorList(id, 2, 1, 5);
        } else if (id == R.id.tv_zxs) {
            mPresenter.onDoctorList(id, 3, 1, 5);
        } else if (id == R.id.tv_price) {
            mPresenter.onDoctorList(id, 4, 1, 5);
        }
    }
}
