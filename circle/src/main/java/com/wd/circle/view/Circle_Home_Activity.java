package com.wd.circle.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.circle.R;
import com.wd.circle.api.Constant;
import com.wd.circle.bean.Circle_list_Bean;
import com.wd.circle.bean.Circle_lists_Bean;
import com.wd.circle.bean.SearchCircleBean;
import com.wd.circle.contract.Contract;
import com.wd.circle.presenter.MainPresenter;
import com.wd.circle.utils.ObservableScrollView;
import com.wd.circle.view.adapter.Circle_List_Adapter;
import com.wd.circle.view.adapter.Circle_Lists_Adapter;
import com.wd.circle.view.adapter.Search_Circle_Adapter;
import com.wd.common.base.BaseActivity;
import com.wd.common.utils.SpUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Circle_Home_Activity extends BaseActivity<MainPresenter> implements Contract.IView, ObservableScrollView.ScrollViewListener {


    @BindView(R.id.circle_touxiang)
    SimpleDraweeView circleTouxiang;
    @BindView(R.id.circle_message)
    ImageView circleMessage;
    @BindView(R.id.circle_recy1)
    RecyclerView circleRecy1;
    @BindView(R.id.circle_recy2)
    RecyclerView circleRecy2;
    @BindView(R.id.patient_relative_titlebar)
    RelativeLayout patientRelativeTitlebar;
    @BindView(R.id.patient_tv_department_name)
    TextView patientTvDepartmentName;
    @BindView(R.id.patient_iv_user_news)
    ImageView patientIvUserNews;
    @BindView(R.id.patient_relative_serach)
    RelativeLayout patientRelativeSerach;
    @BindView(R.id.patient_iv_search)
    ImageView patientIvSearch;
    @BindView(R.id.patient_linear_layout)
    LinearLayout patientLinearLayout;
    @BindView(R.id.patient_scorll_view)
    ObservableScrollView patientScorllView;
    @BindView(R.id.citcle_edit)
    EditText citcleEdit;
    private int height;
    private List<Circle_list_Bean.ResultBean> result;

    private Unbinder bind;
    private int id;

    @Override
    protected int initLayout() {
        return R.layout.activity_circle__home_;
    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        String o = (String) SpUtils.get(this, Constant.Sp_touxiang, "");
        circleTouxiang.setImageURI(o);
        mPresenter.onHome();
        initListener();
        patientScorllView.setScrollViewListener(this);
        citcleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String trim = citcleEdit.getText().toString().trim();
                mPresenter.onSearch(trim);
                mPresenter.onHomes(id, 1, 15);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initListener() {
        //获取控件的视图观察者,一遍通过视图观察者得到控件的宽高属性
        ViewTreeObserver viewTreeObserver = patientLinearLayout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                //此时就可以得到控件的高度
                height = patientLinearLayout.getHeight();
                //我们做的第一件事情就是移除监听,卸磨杀驴,减少内存的消耗
                patientLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof Circle_list_Bean) {
            Circle_list_Bean circle_list_bean = (Circle_list_Bean) obj;
            result = circle_list_bean.getResult();
            Log.d("sss", circle_list_bean + "");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            circleRecy1.setLayoutManager(linearLayoutManager);
            Circle_List_Adapter circle_list_adapter = new Circle_List_Adapter(result, Circle_Home_Activity.this);
            circleRecy1.setAdapter(circle_list_adapter);

            circle_list_adapter.setSetOnItemClick(new Circle_List_Adapter.SetOnItemClick() {
                @Override
                public void setOnItem(int i) {
                    id = result.get(i).getId();
                    patientTvDepartmentName.setText(result.get(i).getDepartmentName());
                    mPresenter.onHomes(id, 1, 15);
                }
            });
        } else if (obj instanceof Circle_lists_Bean) {
            Circle_lists_Bean bean = (Circle_lists_Bean) obj;
            List<Circle_lists_Bean.ResultBean> result = bean.getResult();
            Circle_Lists_Adapter circle_lists_adapter = new Circle_Lists_Adapter(result, Circle_Home_Activity.this);
            circleRecy2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            circleRecy2.setAdapter(circle_lists_adapter);
            circle_lists_adapter.setSetOnItems(new Circle_Lists_Adapter.SetOnItems() {
                @Override
                public void setOns(int i) {
                    int sickCircleId = result.get(i).getSickCircleId();
                    Intent intent = new Intent(Circle_Home_Activity.this,Circle_Details_Activity.class);
                    intent.putExtra("sickCircleId",sickCircleId);
                    startActivity(intent);
                }
            });
        }else if (obj instanceof SearchCircleBean){
            SearchCircleBean searchCircleBean= (SearchCircleBean) obj;
            List<SearchCircleBean.ResultBean> result = searchCircleBean.getResult();
            Search_Circle_Adapter search_circle_adapter=new Search_Circle_Adapter(result,Circle_Home_Activity.this);
            circleRecy2.setAdapter(search_circle_adapter);
            search_circle_adapter.setSetOnItems(new Search_Circle_Adapter.SetOnItems() {
                @Override
                public void setOns(int i) {
                    int sickCircleId = result.get(i).getSickCircleId();
                    Intent intent = new Intent(Circle_Home_Activity.this,Circle_Details_Activity.class);
                    intent.putExtra("sickCircleId",sickCircleId);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
        if (t <= 10) {
            //设置标题隐藏
            patientRelativeTitlebar.setVisibility(View.VISIBLE);
            //设置搜索框显示
            patientRelativeSerach.setVisibility(View.GONE);
        } else if (t > 10 && t < height) {
            //设置搜索框隐藏
            patientRelativeSerach.setVisibility(View.VISIBLE);

            //标题显示
            patientRelativeTitlebar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
