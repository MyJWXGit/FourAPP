package com.wd.doctor;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplication;
import com.wd.common.app.BaseApplicationImp;

/**
 * date:2019/12/13
 * author:金豪(Lenovo)
 * function:
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
