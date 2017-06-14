package com.example.xuchichi.ccwbodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.base.BaseActivity;

public class MainCenterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_center);
        init();
    }
    public void init(){
       Animation animation= AnimationUtils.loadAnimation(this,R.anim.all_degree);
        animation.start();
    }

}
