package com.example.xuchichi.ccwbodemo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.CommonUtil;

import butterknife.ButterKnife;

/**
 * Created by xuchichi on 2017/5/23.
 */
public abstract class BaseFragment extends Fragment {
    protected abstract int getLayout();
    protected  abstract void initView(View view);
    View rootView;
    Context mContext;
    BaseActivity baseActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = CommonUtil.getInstance().getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(),container,false);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        ButterKnife.inject(this, rootView);
        initView(rootView);
        return rootView;

    }

    public void loadData(){};
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            loadData();
        }
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            baseActivity = (BaseActivity) activity;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
