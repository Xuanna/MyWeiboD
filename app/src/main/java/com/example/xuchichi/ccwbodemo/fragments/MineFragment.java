package com.example.xuchichi.ccwbodemo.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.base.*;
import com.example.xuchichi.ccwbodemo.entitys.UserInfo;
import com.example.xuchichi.ccwbodemo.utils.UserInfoUtil;
import com.example.xuchichi.ccwbodemo.view.CircleImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MineFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment {

    @InjectView(R.id.iv_head)
    CircleImageView ivHead;
    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.description)
    TextView description;
    @InjectView(R.id.tv_dot)
    TextView tvDot;
    @InjectView(R.id.tv_weiNum)
    TextView tvWeiNum;
    @InjectView(R.id.llWeibo)
    LinearLayout llWeibo;
    @InjectView(R.id.tv_followNum)
    TextView tvFollowNum;
    @InjectView(R.id.llFollow)
    LinearLayout llFollow;
    @InjectView(R.id.tv_fansNum)
    TextView tvFansNum;
    @InjectView(R.id.llFans)
    LinearLayout llFans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    public void init() {
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        tvUsername.setText(userInfo.name);
        description.setText(userInfo.description);
    }

    @Override
    public void loadData() {
        super.loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
