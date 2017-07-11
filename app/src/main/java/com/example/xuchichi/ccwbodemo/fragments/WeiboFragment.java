package com.example.xuchichi.ccwbodemo.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.base.*;
import com.example.xuchichi.ccwbodemo.callback.StringDialogCallback;
import com.example.xuchichi.ccwbodemo.utils.UserInfoUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A fragment with a Google +1 button.
 */
public class WeiboFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_weibo;
    }

    @Override
    protected void initView(View view) {

    }
    //获取当前登录用户及其所关注（授权）用户的最新微博
    public void myFolloWList() {
        OkGo.get(" https://api.weibo.com/2/statuses/home_timeline.json")
                .tag(this)
                .params("access_token", UserInfoUtil.getAccesToken())
                .execute(new StringDialogCallback(getActivity()) {

                    @Override
                    public void onError(Response<String> response) {
                    }

                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
//        https://api.weibo.com/2/statuses/home_timeline.json
    }
}
