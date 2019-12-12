package com.wd.common.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


public class App extends Application {
    //全局上下文
    public static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }

    public static App getAppContext() {
        return sContext;
    }
}
