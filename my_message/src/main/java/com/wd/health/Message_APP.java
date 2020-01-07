package com.wd.health;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

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
public class Message_APP extends BaseApplication implements BaseApplicationImp {
    public static Context context;
    private static final String TAG = "Message_APP";

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onCreate(Application application) {
        context = application;
        Fresco.initialize(context);
        String packageName = context.getPackageName();
        Log.i(TAG, "onCreate: " + packageName);
    }
}
