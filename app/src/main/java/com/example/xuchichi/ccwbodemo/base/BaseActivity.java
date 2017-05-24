package com.example.xuchichi.ccwbodemo.base;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.xuchichi.ccwbodemo.Myapplication;
import com.example.xuchichi.ccwbodemo.cache.ACache;
import com.example.xuchichi.ccwbodemo.utils.SharePerferencesUtil;

import okhttp3.OkHttpClient;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class BaseActivity extends AppCompatActivity {
    ACache aCache;
    public SharePerferencesUtil mSpUtil;

    public OkHttpClient okHttpClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aCache = ACache.get(this);
        mSpUtil = Myapplication.getInstance().perferencesUtil;
        Myapplication.getInstance().addActivity(this);
        init();
    }

    public void init() {
        okHttpClient=new OkHttpClient();
        if (Build.VERSION.SDK_INT >= 21) {//SYSTEM_UI_FLAG_LAYOUT_STABLE透明式状态栏 SYSTEM_UI_FLAG_HIDE_NAVIGATION
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
