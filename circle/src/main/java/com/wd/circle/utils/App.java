package com.wd.circle.utils;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplication;
import com.wd.common.app.BaseApplicationImp;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 14:46
 * @change
 * @chang time
 * @class describe
 */
public class App extends BaseApplication implements BaseApplicationImp {
    public static Context context;

    @Override
    public void onCreate(Application application) {
        context = application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
