package com.example.xuchichi.ccwbodemo.base;

import android.support.v4.app.Fragment;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class BaseFragment extends Fragment {
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            loadData();
        }
    }
    public void loadData(){};
//    @Override
//    public boolean getUserVisibleHint(boolean get) {
//        return super.getUserVisibleHint();
//    }
}
