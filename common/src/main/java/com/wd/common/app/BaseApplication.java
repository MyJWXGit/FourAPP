package com.wd.common.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @name Health
 * @class name：com.wd.common.app
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 16:05
 * @change
 * @chang time
 * @class describe
 */
public class BaseApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化全局配置
        initGlobalConfig();

        // 初始化模块配置
        initModuleConfit();
    }

    private void initGlobalConfig() {
        // 初始化ARouter
        initARouter();
    }

    private void initModuleConfit() {
        for (String modules : ModuleConfig.MODULELIST) {
            try {
                Class clz = Class.forName(modules);
                Object obj = clz.newInstance();
                if (obj instanceof BaseApplicationImp) {
                    ((BaseApplicationImp) obj).onCreate(this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private void initARouter() {
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
        //初始化Fresco
        Fresco.initialize(this);
    }
}
