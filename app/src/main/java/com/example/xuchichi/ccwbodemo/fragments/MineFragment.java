package com.example.xuchichi.ccwbodemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.model.UserInfo;
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
    @InjectView(R.id.ll_newFriend)
    LinearLayout llNewFriend;
    @InjectView(R.id.ll_myablum)
    LinearLayout llMyablum;
    @InjectView(R.id.ll_myLike)
    LinearLayout llMyLike;
    @InjectView(R.id.ll_wallet)
    LinearLayout llWallet;
    @InjectView(R.id.ll_sport)
    LinearLayout llSport;
    @InjectView(R.id.ll_freeFlow)
    LinearLayout llFreeFlow;
    @InjectView(R.id.ll_fansService)
    LinearLayout llFansService;
    @InjectView(R.id.ll_fansTitle)
    LinearLayout llFansTitle;
    @InjectView(R.id.ll_customerCenter)
    LinearLayout llCustomerCenter;
    @InjectView(R.id.ll_draft)
    LinearLayout llDraft;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
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
    protected void initView(View view) {
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
