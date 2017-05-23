package com.example.xuchichi.ccwbodemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class SharePerferencesUtil<T>{
    final String shared_pre_data="shared_pre_data";
    SharedPreferences preferences;
    
    public SharePerferencesUtil(Context context) {
        preferences=context.getSharedPreferences(shared_pre_data,Context.MODE_PRIVATE);
    }
    public List<T> getShareList(String key){
        String str= preferences.getString(key,"");
        if(!TextUtils.isEmpty(str)){
            Type type = new TypeToken<List<T>>(){}.getType();
            return  new Gson().fromJson(str,type);
        }
        return null;
    }

    public String getShareString(String key){
       String str= preferences.getString(key,"");
        if(!TextUtils.isEmpty(str)){
            return  str;
        }
        return  "";
    }
    public float getShareFloat(String key){
        float aFloat= preferences.getFloat(key,0);
        if(aFloat>0){
            return  aFloat;
        }
        return  0;
    }
    public int getShareInt(String key){
        int anInt= preferences.getInt(key,0);
        if(anInt>0){
            return  anInt;
        }
        return  0;
    }

    public boolean getShareBoolean(String key,boolean defValue){
       boolean aBoolean= preferences.getBoolean(key,defValue);
        return  aBoolean;
    }
    public long getShareLong(String key){
        long aLong= preferences.getLong(key,0);
        return  aLong;
    }

    public void setShareInt(String key,int value){
        preferences.edit().putInt(key,value).commit();
    }
    public void setShareString(String key,String value){
        preferences.edit().putString(key,value).commit();
    }
    public void setShareFloat(String key,float value){
        preferences.edit().putFloat(key,value).commit();
    }
    public void setShareBoolean(String key,boolean value){
        preferences.edit().putBoolean(key,value).commit();
    }
    public void setShareLong(String key,long value){
        preferences.edit().putLong(key,value).commit();
    }
    public void setShareSet(String key,Set<String> value){
        preferences.edit().putStringSet(key,value).commit();
    }
    public void setShareList(String key, List<T> list){
        preferences.edit().putString(key,new Gson().toJson(list));
    }
}
