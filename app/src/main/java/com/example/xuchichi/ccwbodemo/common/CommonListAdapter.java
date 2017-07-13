package com.example.xuchichi.ccwbodemo.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by xuchichi on 2017/7/13.
 */
public abstract  class CommonListAdapter<E,T> extends BaseAdapter {
    Context context;
    int layout;
    List<E> mData;
    @Override
    public int getCount() {
        if(mData!=null){
            return mData.size();
        }else{
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        T holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(layout,null);
            holder=bindHolder(convertView);
            convertView.setTag(holder);
        }else{
         holder= (T) convertView.getTag();
        }
        return convertView;
    }

    public abstract T bindHolder(View view);
}
