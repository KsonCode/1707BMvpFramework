package com.laoxu.mvpframework.model.user;

import com.google.gson.Gson;

import com.laoxu.mvpframework.api.UserApi;
import com.laoxu.mvpframework.app.App;
import com.laoxu.mvpframework.base.entity.BaseEntity;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.network.VolleyUtils;


import java.util.Map;

public class UserModel implements UserContract.IModel {

    /**
     * phonee=1212121313&pwd=111111
     * @param params
     * @param modelCallback
     */
    @Override
    public void reg(final Map<String, String> params, final ModelCallback modelCallback) {

        VolleyUtils.getInstance().doPost(params, UserApi.REG_API, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                if (modelCallback!=null){

                    BaseEntity baseEntity = new Gson().fromJson(response,BaseEntity.class);
                    modelCallback.success(baseEntity);
                }
            }

            @Override
            public void failure(Throwable error) {

                modelCallback.failure(error);
            }
        });
//        //第一步，创建请求队列
//        RequestQueue requestQueue = Volley.newRequestQueue(App.getContext());
//        //第二步构建请求对象,并设置请求参数：手机号和密码
//        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, UserApi.REG_API, new Response.Listener<String>() {
//            /**
//             * 成功的回调
//             *
//             * @param response
//             */
//            @Override
//            public void onResponse(String response) {
//                System.out.println("threadName:"+Thread.currentThread().getName());
//                //json串，响应体
//                BaseEntity baseEntity = new Gson().fromJson(response,BaseEntity.class);
//
//                modelCallback.success(baseEntity);
//
//            }
//        }, new Response.ErrorListener() {
//            /**
//             * 失败的回调
//             * @param error
//             */
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                modelCallback.failure(error);
//            }
//        }){
//            /**
//             * 设置请求参数的方法
//             * @return
//             * @throws AuthFailureError
//             */
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                return params;
//            }
//        };
//
//        //第三步，把请求对象添加到队列
//        requestQueue.add(stringRequest);




    }

}
