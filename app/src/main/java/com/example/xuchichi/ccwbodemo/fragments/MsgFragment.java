package com.example.xuchichi.ccwbodemo.fragments;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.chichi.ccwbodemo.R;
import com.example.chichi.mylibrary.BaseQuickAdapter;
import com.example.xuchichi.ccwbodemo.adapter.PullToRefreshAdapter;
import com.example.xuchichi.ccwbodemo.base.*;
import com.example.xuchichi.ccwbodemo.listener.OnItemClickListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment with a Google +1 button.
 */
public class MsgFragment extends com.example.xuchichi.ccwbodemo.base.BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener {


    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.SwipeRefreshLayout)
    android.support.v4.widget.SwipeRefreshLayout SwipeRefreshLayout;

    PullToRefreshAdapter pullToRefreshAdapter;

    private int mCurrentCounter = 0;

    @Override
    protected int getLayout() {
        return R.layout.fragment_msg;
    }

    /**
     * 下拉刷新
     */
    android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener onRefreshListener=new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

        }
    };
    @Override
    protected void initView(View view) {
        SwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        initAdapter();
        addHead();
    }
    public void addHead(){
        View view=LayoutInflater.from(getContext()).inflate(R.layout.layout_msg_head1,null);
        pullToRefreshAdapter.addHeaderView(view);
    }
    /**
     * 上拉加载
     */
    @Override
    public void onLoadMoreRequested() {

    }
    private void initAdapter() {
        pullToRefreshAdapter = new PullToRefreshAdapter();
        pullToRefreshAdapter.setOnLoadMoreListener(this, recyclerView);
        pullToRefreshAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        pullToRefreshAdapter.setPreLoadNumber(3);
        recyclerView.setAdapter(pullToRefreshAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCurrentCounter = pullToRefreshAdapter.getData().size();

        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
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
}
