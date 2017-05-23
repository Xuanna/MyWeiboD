package com.example.xuchichi.ccwbodemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.xuchichi.ccwbodemo.base.BaseFragment;

import java.util.List;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> mlist;

    public ViewpagerAdapter(FragmentManager fm, List<BaseFragment> mlist) {
        super(fm);
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}
