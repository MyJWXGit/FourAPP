package com.wd.home;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplication;
import com.wd.common.app.BaseApplicationImp;

import cn.jpush.im.android.api.JMessageClient;

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
public class Home_APP extends BaseApplication implements BaseApplicationImp {
    public static Context context;

    @Override
    public void onCreate(Application application) {
        context = application;
        JMessageClient.setDebugMode(true);
        JMessageClient.init(context);
    }
}
