package com.example.xuchichi.ccwbodemo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainCenterActivity extends BaseActivity {

    @InjectView(R.id.ll_bottom)
    LinearLayout llBottom;
    @InjectView(R.id.iv_img)
    ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_center);
        ButterKnife.inject(this);
        init();
    }

    public void init() {
        ivImg.setVisibility(View.GONE);
//        Animation animation=AnimationUtils.loadAnimation(this,R.anim.all_degree);
//        llBottom.startAnimation(animation);
//        animation.start();
    }

    @OnClick(R.id.ll_bottom)
    public void onClick() {
        overridePendingTransition(R.anim.from_top, 0);
        finish();
    }
}
