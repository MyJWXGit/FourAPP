package com.wd.common.app;

/**
 * @name Health
 * @class name：com.wd.common.app
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 16:06
 * @change
 * @chang time
 * @class describe
 */
public interface ModuleConfig {
    static final String MODULE_PDFREADER = "com.wd.common.app.BaseApplication";
    static final String MODULE_LAUNCHER_app = "com.wd.health.APP";
    static final String MODULE_LAUNCHER_my_message = "com.wd.my_message.Message_APP";
    static final String MODULE_LAUNCHER_video = "com.wd.video.api.APP";
    static final String MODULE_LAUNCHER_home = "com.wd.home.APP";

    public static final String[] MODULELIST = {
            MODULE_LAUNCHER_app,
            MODULE_LAUNCHER_my_message,
            MODULE_LAUNCHER_video,
            MODULE_LAUNCHER_home,
            MODULE_PDFREADER
    };
}
