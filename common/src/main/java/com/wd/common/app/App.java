package com.wd.common.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


public class App extends Application {
    //全局上下文
    public static App sContext;
    private boolean isModule = true;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        if (isModule) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(sContext); // As early as possible, it is recommended to initialize in the Application
    }

    public static App getAppContext() {
        return sContext;
    }
}
