package com.wd.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @name Health
 * @class name：com.wd.common
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 13:50
 * @change
 * @chang time
 * @class describe
 */
public class BaseAPPlication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
