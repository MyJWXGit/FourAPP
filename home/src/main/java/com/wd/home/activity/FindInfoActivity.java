package com.wd.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.wd.common.base.BaseActivity;
import com.wd.home.R;
import com.wd.home.api.Constant;
import com.wd.home.bean.FindInfoBean;
import com.wd.home.contract.Contract;
import com.wd.home.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindInfoActivity extends BaseActivity<HomePresenter> implements Contract.IView {
    private WebView webView;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
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
        return R.layout.activity_find_info;
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onSuccess(Object obj) {
        FindInfoBean bean = (FindInfoBean) obj;
        FindInfoBean.ResultBean result = bean.getResult();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(null, result.getContent(), "html/text", "utf-8", null);
        webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onError(Throwable e) {

    }
}
