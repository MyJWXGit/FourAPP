package com.wd.doctor;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplicationImp;

/**
 * date:2019/12/13
 * author:金豪(Lenovo)
 * function:
 */
public class App implements BaseApplicationImp {
    public static Context context;

    @Override
    public void onCreate(Application application) {
        context = application;
    }
}
