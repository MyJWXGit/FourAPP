package com.wd.common.app;

import android.app.Application;


public class App extends Application {
    //全局上下文
    public static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static App getAppContext() {
        return sContext;
    }
}
