package com.example.xuchichi.ccwbodemo.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class GsonTools {

    public static String  objectToString(Object object){
        Gson gson=new Gson();
        String str=gson.toJson(object);
        return  str;
    }
    public static Object stringToObject(String strJson){
        Gson gson=new Gson();
        Type type=new TypeToken<Object>(){}.getType();
       return gson.fromJson(strJson,type);
    }
}
