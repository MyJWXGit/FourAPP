
package com.wd.video.api;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.app.BaseApplication;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class APP extends BaseApplication {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Fresco.initialize(this);
    }
}