package com.example.xuchichi.ccwbodemo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.base.*;
import com.google.android.gms.plus.PlusOneButton;


public class MineFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }
}
