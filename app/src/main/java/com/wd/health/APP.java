package com.wd.health;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.common.BaseAPPlication;
import com.wd.common.app.App;

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
public class APP extends App {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
