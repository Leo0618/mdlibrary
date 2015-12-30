package cn.whereyougo.md;

import android.app.Application;

import cn.whereyougo.mdlibrary.app.ThemeManager;

public class MDApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeManager.init(this, 1, 0, null);
    }
}
