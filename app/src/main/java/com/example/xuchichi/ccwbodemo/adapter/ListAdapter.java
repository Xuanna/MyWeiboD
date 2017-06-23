package com.example.xuchichi.ccwbodemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.entitys.MsgListInfo;

import java.util.List;

/**
 * Created by xuchichi on 2017/6/20.
 */
public class ListAdapter extends BaseAdapter {
    Context context;
    List<MsgListInfo> mlist;

    public ListAdapter(Context context, List<MsgListInfo> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
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
        ViewDataBinding dataBinding;
        if(convertView==null){
            dataBinding= DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.item_msg,parent,false);
        }else{
            dataBinding=DataBindingUtil.getBinding(convertView);
        }
        dataBinding.setVariable(R.layout.item_msg,mlist.get(position));
        return dataBinding.getRoot();
    }
}
