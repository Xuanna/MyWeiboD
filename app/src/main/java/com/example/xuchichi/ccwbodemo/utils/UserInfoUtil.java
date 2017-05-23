package com.example.xuchichi.ccwbodemo.utils;

import com.example.xuchichi.ccwbodemo.Myapplication;
import com.example.xuchichi.ccwbodemo.entitys.UserInfo;

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
     * 获取用户信息
     * @return
     */
    public static UserInfo getUserInfo(){
        String str= Myapplication.getInstance().perferencesUtil.getShareString("SAVE_USER");
        UserInfo userInfo= (UserInfo) GsonTools.stringToObject(str);
        return  userInfo;
    }
}
