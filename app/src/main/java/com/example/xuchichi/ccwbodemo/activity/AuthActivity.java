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
import com.example.xuchichi.ccwbodemo.entitys.UserInfo;
import com.example.xuchichi.ccwbodemo.utils.UserInfoUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
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

    @OnClick({R.id.btn_auth, R.id.btn_authlogin, R.id.btn_wbShare})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_auth:
                auth("https://api.weibo.com/oauth2/authorize");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        net();
////                        auth("https://api.weibo.com/oauth2/authorize");
//                    }
//                }).start();
                break;
            case R.id.btn_authlogin:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, umAuthListener);
                break;
            case R.id.btn_wbShare:
//                new ShareAction(AuthActivity.this).withText("hello")
//                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
//                        .setCallback(umShareListener).open();
                new ShareAction(AuthActivity.this).setPlatform(SHARE_MEDIA.SINA)
                        .withText("hello")
                        .setCallback(umShareListener)
                        .share();
//                new ShareAction(AuthActivity.this).withText("hello")
//                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
//                        .setCallback(umShareListener).open();
                break;
        }
    }

    public void net() {
        try {
            URL url = new URL("https://api.weibo.com/oauth2/authorize");
            URLConnection connection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            Map<String, String> mapParam = new HashMap<>();
            mapParam.put("client_id", "2321418893");
            mapParam.put("redirect_uri", "http://www.baidu.com/");
//            mapParam.put("scope", "");
//            mapParam.put("state", "");
//            mapParam.put("display", "");
//            mapParam.put("forcelogin", "");
//            mapParam.put("language", "");

            StringBuffer params = new StringBuffer();
            Iterator it = mapParam.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry element = (Map.Entry) it.next();
                params.append(element.getKey());
                params.append("=");
                params.append(element.getValue());
                params.append("&");
            }
            if (params.length() > 0) {
                params.deleteCharAt(params.length() - 1);
            }

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Length", String
                    .valueOf(params.toString().getBytes("UTF-8")));
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(mapParam.toString());
            // flush输出流的缓冲
            printWriter.flush();
            httpURLConnection.connect();
            try {
                if (httpURLConnection.getResponseCode() == 200) {
                    //得到输入流
                    InputStream is = httpURLConnection.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while (-1 != (len = is.read(buffer))) {
                        baos.write(buffer, 0, len);
                        baos.flush();
                    }
                    Log.e("e", "baos=" + baos.toString("utf-8"));
                } else {
                    Toast.makeText(this, "bushi200", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void auth(String url) {
        RequestBody requestBody = new FormBody.Builder()
//                    .add("access_token",UserInfoUtil.getUserInfo().access_token)
//                .add("uid","")
//                .add("screen_name","")
                .add("client_id", "2321418893")
                .add("redirect_uri", "http://sns.xuchichi.com/sina2/callback")//
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
                if (!response.isSuccessful()) {
                    Log.e("succressFail", new Gson().toJson(response.body()));
                } else {
                    Headers responseHeaders = response.headers();
                    for (int i = 0; i < responseHeaders.size(); i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    Type type = new TypeToken<UserInfo>() {
                    }.getType();
                    String str = new Gson().toJson(response.body().toString());
                    Log.e("succress", response.body().toString());
                }

            }
        });
    }
}
