package com.example.xuchichi.ccwbodemo.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.xuchichi.ccwbodemo.CommonUtil;
import com.example.xuchichi.ccwbodemo.Myapplication;
import com.example.xuchichi.ccwbodemo.cache.ACache;
import com.example.xuchichi.ccwbodemo.utils.SharePerferencesUtil;
import com.example.xuchichi.ccwbodemo.utils.Utils;
import com.umeng.socialize.UMShareAPI;

import okhttp3.OkHttpClient;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class BaseActivity extends AppCompatActivity {
    ACache aCache;
    public SharePerferencesUtil mSpUtil;
    public OkHttpClient okHttpClient;
    CommonUtil commonUtil;
    public static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        aCache = ACache.get(this);
        mSpUtil = Myapplication.getInstance().perferencesUtil;
        Myapplication.getInstance().addActivity(this);
        init();
        commonUtil=CommonUtil.getInstance();
//        adaptTheme(true);
//        StatusBarLightMode(this);
    }

    public void init() {
        context=this;
        okHttpClient = new OkHttpClient();
//        Window window = getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Toast.makeText(this,"if",Toast.LENGTH_LONG).show();
//            Log.e("init","if");
//           //透明状态栏
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
//            View childAt = contentView.getChildAt(0);
//            if (childAt != null) {
//                childAt.setFitsSystemWindows(true);
//            }
//            //给statusbar着色
//            View view = new View(this);
//            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(this)));
//            contentView.addView(view);
//        //透明导航栏
////            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }else{
//            Toast.makeText(this,"else",Toast.LENGTH_LONG).show();
//            Log.e("init","else");
//        }
    }
    /**
     * 透明状态栏
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void adaptTheme(final boolean isTranslucentStatusFitSystemWindowTrue) {
        if (isTranslucentStatusFitSystemWindowTrue) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }


    /**
     * 设置状态栏黑色字体图标，
     * 6.0以上版本Android
     */
    public void StatusBarLightMode(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    private static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
