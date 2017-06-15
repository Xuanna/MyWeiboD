package com.example.xuchichi.ccwbodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.activity.MainCenterActivity;
import com.example.xuchichi.ccwbodemo.adapter.ViewpagerAdapter;
import com.example.xuchichi.ccwbodemo.base.BaseActivity;
import com.example.xuchichi.ccwbodemo.base.BaseFragment;
import com.example.xuchichi.ccwbodemo.fragments.FindFragment;
import com.example.xuchichi.ccwbodemo.fragments.MineFragment;
import com.example.xuchichi.ccwbodemo.fragments.MsgFragment;
import com.example.xuchichi.ccwbodemo.fragments.WeiboFragment;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.ll_weibo)
    LinearLayout llWeibo;
    @InjectView(R.id.ll_msg)
    LinearLayout llMsg;
    @InjectView(R.id.center)
    LinearLayout center;
    @InjectView(R.id.ll_find)
    LinearLayout llFind;
    @InjectView(R.id.ll_mine)
    LinearLayout llMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initViewpager();
    }
    public void initViewpager(){
        List<BaseFragment> list=new ArrayList<>();
        list.add(new WeiboFragment());
        list.add(new MsgFragment());
        list.add(new FindFragment());
        list.add(new MineFragment());
        ViewpagerAdapter adapter=new ViewpagerAdapter(getSupportFragmentManager(),list);
        viewpager.setAdapter(adapter);
    }
    @OnClick({R.id.ll_weibo, R.id.ll_msg, R.id.center, R.id.ll_find, R.id.ll_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_weibo:
                clickIndex(0);
                break;
            case R.id.ll_msg:
                clickIndex(1);
                break;
            case R.id.center:
                startActivity(new Intent(this, MainCenterActivity.class));
                overridePendingTransition(R.anim.from_bottom,R.anim.from_bottom);
                break;
            case R.id.ll_find:
                clickIndex(2);
                break;
            case R.id.ll_mine:
                clickIndex(3);
                break;
        }
    }
    public  void clickIndex(int index){
        viewpager.setCurrentItem(index);
        switch (index){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

        }
    }

}
