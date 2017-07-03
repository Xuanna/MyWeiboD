package com.example.xuchichi.ccwbodemo.model;

/**
 * Created by xuchichi on 2017/6/20.
 */
public class MsgListInfo {
    public String msgTitle;
    public String mgsContent;
    public String msgNum;
    public String time;

    public MsgListInfo(String msgTitle, String mgsContent, String msgNum, String time) {
        this.msgTitle = msgTitle;
        this.mgsContent = mgsContent;
        this.msgNum = msgNum;
        this.time = time;
    }
    public boolean notZero(){
        if(Integer.parseInt(msgNum)>0){
            return false;
        }else{
             return true;
        }
    }
    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMgsContent() {
        return mgsContent;
    }

    public void setMgsContent(String mgsContent) {
        this.mgsContent = mgsContent;
    }

    public String getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(String msgNum) {
        this.msgNum = msgNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
