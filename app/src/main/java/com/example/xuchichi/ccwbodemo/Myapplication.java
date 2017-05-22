package com.example.xuchichi.ccwbodemo;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by xuchichi on 2017/5/22.
 */
public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
    }
    {
        PlatformConfig.setSinaWeibo("2321418893","b816046ccd66e5aa0ca020973193ff8c","http://sns.xuchichi.com/sina2/callback");
    }
}
