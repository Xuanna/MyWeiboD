package com.example.xuchichi.ccwbodemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by xuchichi on 2017/5/8.
 */
public class MyListAdapter<T> extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<T> list;

    public MyListAdapter(Context context, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewDataBinding viewDataBinding;
        if(convertView==null){
           viewDataBinding= DataBindingUtil.inflate(inflater,layoutId,parent,false);
        }else{
            viewDataBinding= DataBindingUtil.getBinding(convertView);
        }
        viewDataBinding.setVariable(variableId,list.get(position));
        return viewDataBinding.getRoot();
    }
}
