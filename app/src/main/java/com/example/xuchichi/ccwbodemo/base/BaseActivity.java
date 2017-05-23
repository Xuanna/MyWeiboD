package com.example.xuchichi.ccwbodemo.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.xuchichi.ccwbodemo.Myapplication;
import com.example.xuchichi.ccwbodemo.cache.ACache;
import com.example.xuchichi.ccwbodemo.utils.SharePerferencesUtil;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class BaseActivity extends AppCompatActivity {
    ACache aCache;
    public SharePerferencesUtil mSpUtil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aCache=ACache.get(this);
        mSpUtil= Myapplication.getInstance().perferencesUtil;
        Myapplication.getInstance().addActivity(this);
    }
}
