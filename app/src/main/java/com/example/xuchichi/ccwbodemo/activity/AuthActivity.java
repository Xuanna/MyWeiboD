package com.example.xuchichi.ccwbodemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.base.BaseActivity;
import com.example.xuchichi.ccwbodemo.entitys.UserInfo;
import com.example.xuchichi.ccwbodemo.utils.UserInfoUtil;
import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthActivity extends BaseActivity {

    @InjectView(R.id.btn_auth)
    Button btnAuth;
    @InjectView(R.id.btn_authlogin)
    Button btnAuthlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.inject(this);
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            Gson gson = new Gson();
            String str = gson.toJson(data);
            UserInfo userInfo = gson.fromJson(str, UserInfo.class);
            UserInfoUtil.saveUserInfo(userInfo);
            Log.e("complete", str);
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.btn_auth, R.id.btn_authlogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_auth:
                auth("https://api.weibo.com/oauth2/authorize");
                break;
            case R.id.btn_authlogin:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, umAuthListener);
                break;
        }
    }

    public void auth(String url) {
        RequestBody requestBody = new FormBody.Builder()
//                    .add("access_token",UserInfoUtil.getUserInfo().access_token)
//                .add("uid","")
//                .add("screen_name","")
                .add("client_id", "2321418893")
                .add("redirect_uri", "")//http://sns.xuchichi.com/sina2/callback
                .add("scope", "")
                .add("state", "")
                .add("display", "mobile")
                .add("forcelogin", "")
                .add("language", "")
                .build();
        Request request = new Request.Builder().url(url)
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("fail", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()){
                    Log.e("succressFail", new Gson().toJson(response.body()));
                }else{
                    Headers responseHeaders = response.headers();
                    for (int i = 0; i < responseHeaders.size(); i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    Log.e("succress", new Gson().toJson(response.body().toString()));
                    Log.e("succress", new Gson().toJson(response.body()));
                }

            }
        });
    }
}
