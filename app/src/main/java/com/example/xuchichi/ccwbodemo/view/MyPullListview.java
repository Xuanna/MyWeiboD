package com.example.xuchichi.ccwbodemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.chichi.ccwbodemo.R;

/**
 * Created by xuchichi on 2017/7/7.
 */
public class MyPullListview extends ListView implements View.OnTouchListener{
    View header;//下拉頭部view
    ProgressBar progressBar;
    int hideHeaderHeight;
    MarginLayoutParams headerLayoutParams;

    public MyPullListview(Context context) {
        super(context);
    }

    public MyPullListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        header = LayoutInflater.from(context).inflate(R.layout.layout_progress, null);
        progressBar = (ProgressBar) header.findViewById(R.id.progressBar);
        addHeaderView(header);
    }

    public MyPullListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        hideHeaderHeight = -header.getHeight();
        headerLayoutParams = (MarginLayoutParams) header.getLayoutParams();
        headerLayoutParams.topMargin = hideHeaderHeight;
        getChildAt(1);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}
