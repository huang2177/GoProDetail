package com.huatai.goprodetail;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Huangshuang  2018/5/4 0004
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
