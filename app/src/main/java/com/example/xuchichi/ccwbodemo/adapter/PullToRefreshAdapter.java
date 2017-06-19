package com.example.xuchichi.ccwbodemo.adapter;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.chichi.ccwbodemo.R;
import com.example.chichi.mylibrary.BaseQuickAdapter;
import com.example.chichi.mylibrary.BaseViewHolder;
import com.example.xuchichi.ccwbodemo.data.DataServer;
import com.example.xuchichi.ccwbodemo.entitys.Status;
import com.example.xuchichi.ccwbodemo.utils.SpannableStringUtils;
import com.example.xuchichi.ccwbodemo.utils.ToastUtils;
import com.example.xuchichi.ccwbodemo.utils.Utils;


/**
 * 文 件 名: PullToRefreshAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 19:55
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class PullToRefreshAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public PullToRefreshAdapter() {
        super( R.layout.layout_animation, DataServer.getSampleData(10));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition()%
                3){
            case 0:
                helper.setImageResource(R.id.img,R.mipmap.ic_launcher);
                break;
            case 1:
                helper.setImageResource(R.id.img,R.mipmap.ic_launcher);
                break;
            case 2:
                helper.setImageResource(R.id.img,R.mipmap.ic_launcher);
                break;
        }
        helper.setText(R.id.tweetName,"Hoteis in Rio de Janeiro");
        String msg="\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ( (TextView)helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ( (TextView)helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };


}
