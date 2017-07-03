package com.example.xuchichi.ccwbodemo.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.chichi.ccwbodemo.BR;
import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.adapter.MyListAdapter;
import com.example.xuchichi.ccwbodemo.model.MsgListInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment with a Google +1 button.
 */
public class MsgFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment {

    List<MsgListInfo> list = new ArrayList<>();
    @InjectView(R.id.listview)
    ListView listview;
    MyListAdapter<MsgListInfo> adapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_msg;
    }

    public void initData() {
        MsgListInfo msgListInfo = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        MsgListInfo msgListInfo1 = new MsgListInfo("追剧大咖", "谢谢关注!看剧私信剧名即可,第一时间更新剧集!剧评、剧探、剧时尚！", "0", "11:50");
        MsgListInfo msgListInfo2 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        list.add(msgListInfo);
        list.add(msgListInfo1);
        list.add(msgListInfo2);
    }

    @Override
    protected void initView(View view) {
        initData();
        initAdapter();
        addHead();
    }

    public void initAdapter() {
        listview.setOnScrollListener(onScrollListener);
        adapter=new MyListAdapter<>(getContext(),R.layout.item_msg, BR.msgInfo,list);
        listview.setAdapter(adapter);
    }
    ProgressBar progressBar;

    public void addHead() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_progress, null);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        listview.addHeaderView(view);
    }

    AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            switch (scrollState) {
                case SCROLL_STATE_TOUCH_SCROLL://触摸滑动
                    break;
                case SCROLL_STATE_FLING://惯性滑动
                    break;
                case SCROLL_STATE_IDLE://停止滑动
                    break;

            }
        }

        int lastFirstVisibleItem;

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            if (firstVisibleItem > lastFirstVisibleItem) {//上拉

            }
            if (firstVisibleItem < lastFirstVisibleItem) {//下拉
                progressBar.setVisibility(View.VISIBLE);
            }
            if (visibleItemCount + firstVisibleItem == totalItemCount) {//滑动到底部

            }
            lastFirstVisibleItem = firstVisibleItem;

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
