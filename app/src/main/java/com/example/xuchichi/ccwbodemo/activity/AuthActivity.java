package com.example.xuchichi.ccwbodemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chichi.ccwbodemo.R;
import com.example.xuchichi.ccwbodemo.MainActivity;
import com.example.xuchichi.ccwbodemo.base.BaseActivity;
import com.example.xuchichi.ccwbodemo.callback.StringDialogCallback;
import com.example.xuchichi.ccwbodemo.model.UserInfo;
import com.example.xuchichi.ccwbodemo.utils.UserInfoUtil;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.IOException;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthActivity extends BaseActivity {

    @InjectView(R.id.btn_auth)
    Button btnAuth;
    @InjectView(R.id.btn_authlogin)
    Button btnAuthlogin;
    @InjectView(R.id.btn_wbShare)
    Button btnWbShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.inject(this);
    }

    /**
     * 分享回调
     */
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(AuthActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(AuthActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(AuthActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * 授权回调
     */
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
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this);
    }

    @OnClick({R.id.btn_auth, R.id.btn_authlogin, R.id.btn_wbShare})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_auth:

                OkGo.<String>post("https://api.weibo.com/oauth2/authorize")//https://api.weibo.com/oauth2/authorize
                        .tag(this)
//                        .params("username","piaa12")
//                        .params("password","123123a")
                        .params("client_id", "2321418893")
                        .params("redirect_uri", "http://www.baidu.com/")//
                        .isMultipart(true)
                        .execute(new StringDialogCallback(this) {
                            @Override
                            public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                                Log.e("onSuccess", response.toString());
                            }

                            @Override
                            public void onError(com.lzy.okgo.model.Response<String> response) {
                                super.onError(response);
                                Log.e("onError", response.toString());
                            }
                        });
//                auth("https://api.weibo.com/oauth2/authorize");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
////                        net();
////                        auth("https://api.weibo.com/oauth2/authorize");
//                    }
//                }).start();
                break;
            case R.id.btn_authlogin:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, umAuthListener);
                break;
            case R.id.btn_wbShare:
                UMImage image = new UMImage(AuthActivity.this, R.drawable.cast_abc_scrubber_control_to_pressed_mtrl_005);//资源文件
                new ShareAction(AuthActivity.this).setPlatform(SHARE_MEDIA.SINA)
//                        .withText("hello")
                        .withMedia(image)
                        .setCallback(umShareListener)
                        .share();
                break;
        }
    }

    public void auth(String url) {
        RequestBody requestBody = new FormBody.Builder()
                .add("client_id", "2321418893")
                .add("redirect_uri", "http://www.baidu.com/")//
//                .add("scope", "")
//                .add("state", "")
//                .add("display", "mobile")
//                .add("forcelogin", "")
//                .add("language", "")
                .build();
        Request request = new Request.Builder()
                .url(url)
//                .url(url + "?client_id=2321418893&redirect_uri=http://www.baidu.com/")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("fail", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Log.e("succressFail", new Gson().toJson(response.body()));
                } else {
                    Headers responseHeaders = response.headers();
                    for (int i = 0; i < responseHeaders.size(); i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    Log.e("succress", new Gson().toJson(response.toString()));
                    Log.e("succress", response.toString());
                    //3cabdbd12d3fd2f8a7d5b9041971a4be
                    //3cabdbd12d3fd2f8a7d5b9041971a4be
                }

            }
        });
    }
}
