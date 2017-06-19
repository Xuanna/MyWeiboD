package com.example.xuchichi.ccwbodemo;

import android.content.Context;

/**
 * Created by xuchichi on 2017/6/19.
 */
public class CommonUtil {
    public static CommonUtil instance=new CommonUtil();
    public static Context context;

    public static CommonUtil getInstance(){
        return instance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
