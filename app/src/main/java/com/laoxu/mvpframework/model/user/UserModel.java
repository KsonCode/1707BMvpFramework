package com.laoxu.mvpframework.model.user;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.laoxu.lib_core.base.api.Api;
import com.laoxu.lib_core.base.entity.BaseEntity;
import com.laoxu.mvpframework.api.UserApi;
import com.laoxu.mvpframework.contract.UserContract;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogRecord;

public class UserModel implements UserContract.IModel {
    Handler handler = new Handler();
    @Override
    public void reg(final HashMap<String, Object> params, final ModelCallback modelCallback) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(UserApi.REG_API);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    if (params != null && params.size() > 0) {
                        //动态添加请求体数据
                        for (Map.Entry<String, Object> stringObjectEntry : params.entrySet()) {
                            httpURLConnection.addRequestProperty(stringObjectEntry.getKey(), (String) stringObjectEntry.getValue());
                        }
                    }
                    System.out.println("code:" + httpURLConnection.getResponseCode());
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        final String result = io2String(inputStream);
                        Log.i("w", result);

                        final BaseEntity baseEntity = new Gson().fromJson(result,BaseEntity.class);

                        //切换到主线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                modelCallback.success(baseEntity);
                            }
                        });



                    } else {
                        Log.e("tag", "请求失败");
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            modelCallback.failure(e);
                        }
                    });

                }
            }
        }).start();


    }

    // 流转  字符串
    private String io2String(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);


        return json;
    }
}
