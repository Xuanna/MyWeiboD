package com.example.xuchichi.ccwbodemo.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chichi.ccwbodemo.R;

/**
 * A fragment with a Google +1 button.
 */
public class WeiboFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weibo, container, false);
        return view;
    }

}
