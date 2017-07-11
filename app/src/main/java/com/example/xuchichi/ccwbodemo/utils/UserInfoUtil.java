package com.example.xuchichi.ccwbodemo.utils;

import android.text.TextUtils;

import com.example.xuchichi.ccwbodemo.Myapplication;
import com.example.xuchichi.ccwbodemo.model.UserInfo;

/**
 * Created by xuchichi on 2017/5/23.
 */
public class UserInfoUtil {
    /**
     * 保存用戶信息
     * @param userInfo
     */
    public static void saveUserInfo(UserInfo userInfo){
        String json=GsonTools.objectToString(userInfo);
        Myapplication.getInstance().perferencesUtil.setShareString("SAVE_USER",json);
    }

    /**
     * 保存Token
     * @param accessToken
     */
    public static  void savaAccesToken(String accessToken){
        Myapplication.getInstance().perferencesUtil.setShareString("access_token",accessToken);
    }
    /**
     *获取Token
     */
    public static String  getAccesToken(){
        String token=Myapplication.getInstance().perferencesUtil.getShareString("access_token");
        return token;
    }
    /**
     * 获取用户信息
     * @return
     */
    public static UserInfo getUserInfo(){
        String str= Myapplication.getInstance().perferencesUtil.getShareString("SAVE_USER");
        return  GsonTools.stringToObject(str,UserInfo.class);
    }
}
