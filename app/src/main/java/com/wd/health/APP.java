package com.wd.health;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wd.common.app.BaseApplicationImp;
/**
 * @name Health
 * @class name：com.wd.health
 * @class describe
 * @anthor 24673
 * @time 2019/12/12 13:50
 * @change
 * @chang time
 * @class describe
 */
public class APP implements BaseApplicationImp {
    public static Context context;
    // APP_ID 替换为你的应用从官方网站申请到的合法appID
    private static final String APP_ID = "wxe3fcbe8a55cd33ff";

    // IWXAPI 是第三方app和微信通信的openApi接口
    public static IWXAPI api;

    @Override
    public void onCreate(Application application) {
        context = application;
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(APP.context, APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(APP_ID);
        MultiDex.install(application);
//        //建议动态监听微信启动广播进行注册到微信
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//                // 将该app注册到微信
//                api.registerApp(APP_ID);
//            }
//        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
    }
}
