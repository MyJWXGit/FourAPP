package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.wd.common.api.Constant;
import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.presenter.HomePresenter;

import java.text.SimpleDateFormat;

import com.wd.health.R2;
import com.wd.home.contract.Contract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindInfoActivity extends BaseActivity<HomePresenter> implements Contract.IView {
    @BindView(R2.id.text_name)
    TextView textName;
    @BindView(R2.id.text_Author)
    TextView textAuthor;
    @BindView(R2.id.text_date)
    TextView textDate;
    @BindView(R2.id.text_time)
    TextView textTime;
    private WebView webView;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        webView = findViewById(R.id.web_view);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int infoId = intent.getIntExtra(Constant.INFOID, 0);
        mPresenter.onFindInfo(infoId);
    }

    @Override
    protected int initLayout() {
        Transition transition = new TransitionSet().addTransition(new Explode());
        getWindow().setEnterTransition(transition.setDuration(2000));
        getWindow().setExitTransition(new Explode().setDuration(2000));
        return R.layout.home_activity_find_info;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        FindInfoBean bean = (FindInfoBean) obj;
        FindInfoBean.ResultBean result = bean.getResult();
        textName.setText(result.getTitle());
        textAuthor.setText(result.getSource());

        long releaseTime = result.getReleaseTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        textDate.setText(simpleDateFormat.format(releaseTime));


        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        textTime.setText(simpleDateFormat1.format(releaseTime));

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(null, result.getContent(), "html/text", "utf-8", null);
        webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onError(Throwable e) {

    }
}
