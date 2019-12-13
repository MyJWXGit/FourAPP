package com.wd.circle.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @name Health
 * @class name：${妙国青}
 * @class describe
 * @anthor dell
 * @time 2019/12/13 14:46
 * @change
 * @chang time
 * @class describe
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
