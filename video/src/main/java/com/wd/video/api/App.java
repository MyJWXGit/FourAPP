package com.wd.video.api;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.BaseAPPlication;

/*
 *author:郭昊坤
 *date:2019/12/13
 *function:*/public class App extends BaseAPPlication {
     private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        Fresco.initialize(this);
    }
}
