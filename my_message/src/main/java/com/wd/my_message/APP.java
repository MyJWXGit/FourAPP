package com.wd.my_message;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplication;
import com.wd.common.app.BaseApplicationImp;

/**
 * @name Health
 * @class name：com.wd.my_message
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 16:34
 * @change
 * @chang time
 * @class describe
 */
public class APP extends BaseApplication implements BaseApplicationImp {
    public static Context context;

    @Override
    public void onCreate(Application application) {
        context = application;
        Fresco.initialize(context);
    }
}
