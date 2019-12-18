package com.wd.home;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplicationImp;

/**
 * @name Health
 * @class name：com.wd.home
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 17:43
 * @change
 * @chang time
 * @class describe
 */
public class APP implements BaseApplicationImp {
    public static Context context;

    @Override
    public void onCreate(Application application) {
        context = application;
    }
}
