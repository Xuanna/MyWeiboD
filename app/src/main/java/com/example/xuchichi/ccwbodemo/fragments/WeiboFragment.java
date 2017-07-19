package com.example.xuchichi.ccwbodemo.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.chichi.ccwbodemo.BR;
import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.MainActivity;
import com.example.xuchichi.ccwbodemo.adapter.MyListAdapter;
import com.example.xuchichi.ccwbodemo.base.*;
import com.example.xuchichi.ccwbodemo.callback.StringDialogCallback;
import com.example.xuchichi.ccwbodemo.model.ListNewWeiboInfo;
import com.example.xuchichi.ccwbodemo.utils.OkLogger;
import com.example.xuchichi.ccwbodemo.utils.UserInfoUtil;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment with a Google +1 button.
 */
public class WeiboFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment {
    MainActivity mainActivity;
    @InjectView(R.id.listview)
    ListView listview;
    MyListAdapter<ListNewWeiboInfo.StatusesBean> listAdapter;
    List<ListNewWeiboInfo.StatusesBean> list=new ArrayList<>();
    @Override
    protected int getLayout() {
        return R.layout.fragment_weibo;
    }

    @Override
    protected void initView(View view) {
//        listAdapter = new MyListAdapter<>(getContext(), R.layout.item_weibo, BR.weiboList, list);
    }
    ListNewWeiboInfo weiboInfo;
    //获取当前登录用户及其所关注（授权）用户的最新微博
    public void myFolloWList() {
        OkGo.<String>get(" https://api.weibo.com/2/statuses/home_timeline.json")
                .tag(this)
                .params("access_token", UserInfoUtil.getAccesToken())
                .params("count", 1)
                .execute(new StringDialogCallback(getContext()) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        weiboInfo=new Gson().fromJson(response.toString(),ListNewWeiboInfo.class);
                        list.addAll(weiboInfo.statuses);
                        OkLogger.e("success", response.toString());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        OkLogger.e("onError", response.toString());
                    }
                });
    }

    @Override
    public void loadData() {
        super.loadData();
//        myFolloWList();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
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
