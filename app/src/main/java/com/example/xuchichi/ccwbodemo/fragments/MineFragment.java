package com.example.xuchichi.ccwbodemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chichi.ccwbodemo.R;

import butterknife.ButterKnife;


public class MineFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        init();
        ButterKnife.inject(this, view);
        return view;
    }

    public void init() {
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
