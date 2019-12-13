package com.wd.doctor;

import android.app.Application;

import com.wd.common.utils.ToastUtils;

/**
 * date:2019/12/13
 * author:金豪(Lenovo)
 * function:
 */
public class App extends Application {
    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;


    }

    public static App getAppContext(){
        return sContext;
    }

}
