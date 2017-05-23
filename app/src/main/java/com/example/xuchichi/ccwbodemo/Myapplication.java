package com.example.xuchichi.ccwbodemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.xuchichi.ccwbodemo.utils.SharePerferencesUtil;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuchichi on 2017/5/22.
 */
public class Myapplication extends MultiDexApplication{
    List<Activity> activityList=new LinkedList<>();
    public SharePerferencesUtil perferencesUtil;
    public static Myapplication myapplication;
    /**
     * 分割 Dex 支持
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
        perferencesUtil=new SharePerferencesUtil(this);
        myapplication=this;
    }
    {
        PlatformConfig.setSinaWeibo("2321418893","b816046ccd66e5aa0ca020973193ff8c","http://sns.xuchichi.com/sina2/callback");
    }
    public static  Myapplication getInstance() {
        return myapplication;
    }
    public void addActivity(Activity activity){
        if(activity!=null){
            activityList.add(activity);
        }

    }
    public void finishAllActivity(){
        for (Activity activity : activityList) {
            if(activity!=null){
                activity.finish();
            }
        }
    }
}
