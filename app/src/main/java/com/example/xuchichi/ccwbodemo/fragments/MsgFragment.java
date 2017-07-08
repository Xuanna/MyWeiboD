package com.example.xuchichi.ccwbodemo.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import java.util.logging.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment with a Google +1 button.
 */
public class MsgFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment implements View.OnTouchListener{

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
        MsgListInfo msgListInfo3 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        MsgListInfo msgListInfo4 = new MsgListInfo("追剧大咖", "谢谢关注!看剧私信剧名即可,第一时间更新剧集!剧评、剧探、剧时尚！", "0", "11:50");
        MsgListInfo msgListInfo5 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        MsgListInfo msgListInfo6 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        MsgListInfo msgListInfo7 = new MsgListInfo("追剧大咖", "谢谢关注!看剧私信剧名即可,第一时间更新剧集!剧评、剧探、剧时尚！", "0", "11:50");
        MsgListInfo msgListInfo8 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        MsgListInfo msgListInfo9 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        MsgListInfo msgListInfo10 = new MsgListInfo("追剧大咖", "谢谢关注!看剧私信剧名即可,第一时间更新剧集!剧评、剧探、剧时尚！", "0", "11:50");
        MsgListInfo msgListInfo11 = new MsgListInfo("新浪新闻", "罗晋录节目唐嫣叮嘱一句撒娇的小委屈亮了", "10", "12:12");
        list.add(msgListInfo);
        list.add(msgListInfo1);
        list.add(msgListInfo2);
        list.add(msgListInfo3);
        list.add(msgListInfo4);
        list.add(msgListInfo5);
        list.add(msgListInfo6);
        list.add(msgListInfo7);
        list.add(msgListInfo8);
        list.add(msgListInfo9);
        list.add(msgListInfo10);
        list.add(msgListInfo11);
    }

    @Override
    protected void initView(View view) {
        initData();
        addHead();
        addFooter();
        initAdapter();

    }

    public void initAdapter() {
        listview.setOnScrollListener(onScrollListener);
        listview.setOnTouchListener(this);
        adapter = new MyListAdapter<>(getContext(), R.layout.item_msg, BR.msgInfo, list);
        listview.setAdapter(adapter);
    }

    ProgressBar progressBar, progressBar2;

    public void addHead() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_progress, null);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        listview.addHeaderView(view);
        headHeight=view.getMeasuredHeight();
    }

    public void addFooter() {
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.layout_progress, null);
        progressBar2 = (ProgressBar) view2.findViewById(R.id.progressBar);
        listview.addFooterView(view2);
    }

    Handler handler = new Handler();

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
            if (firstVisibleItem <lastFirstVisibleItem) {//下拉
                progressBar.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                    }
                }, 3000);
            }
            if (visibleItemCount + firstVisibleItem == totalItemCount) {//滑动到底部
                progressBar2.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar2.setVisibility(View.GONE);
                    }
                }, 3000);
            }
            lastFirstVisibleItem = firstVisibleItem;

        }
    };
    int downY,moveY;
    int headHeight;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downY= (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveY= (int) event.getRawY();
                if(moveY-downY>headHeight){
                    progressBar.setVisibility(View.VISIBLE);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                        }
                    }, 3000);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }

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
