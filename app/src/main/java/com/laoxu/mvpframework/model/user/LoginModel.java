package com.laoxu.mvpframework.model.user;

import com.google.gson.Gson;
import com.laoxu.mvpframework.api.UserApi;
import com.laoxu.mvpframework.contract.ILoginContract;
import com.laoxu.mvpframework.model.entity.LoginEntity;
import com.laoxu.mvpframework.utils.network.VolleyUtils;

import java.util.Map;

public class LoginModel implements ILoginContract.IModel {
    @Override
    public void login(Map<String, String> params, final ModelCallback modelCallback) {

        VolleyUtils.getInstance().doPost(params, UserApi.LOGIN_API, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                if (modelCallback!=null){
                    LoginEntity loginEntity = new Gson().fromJson(response,LoginEntity.class);
                    modelCallback.success(loginEntity);
                }
            }

            @Override
            public void failure(Throwable error) {
                modelCallback.failure(error);

            }
        });
    }
}
