package com.laoxu.mvpframework.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.laoxu.mvpframework.R;
import com.laoxu.mvpframework.base.BaseActivity;
import com.laoxu.mvpframework.base.entity.BaseEntity;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.network.VolleyUtils;
import com.laoxu.mvpframework.presenter.user.UserPresenter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity<UserPresenter> implements UserContract.IView {

//    private UserPresenter userPresenter;

    @Override
    protected void initData() {



    }

    @Override
    protected void initView() {

    }

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(BaseEntity baseEntity) {

        showToast(baseEntity.message);

        //跳转到登录页面


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(Throwable throwable) {

    }

    /**
     * 点击注册按钮
     * @param view
     */
    public void reg(View view) {
        Map<String,String> params = new HashMap<>();
        params.put("phone","18678765654");
        params.put("pwd","111111");
        if (presenter!=null){
            presenter.reg(params);
        }


    }

    /**
     * 测试get请求
     * @param view
     */
    public void get(View view) {
        Map<String,String> params = new HashMap<>();
        params.put("keyword","1");
        params.put("page","1");
        params.put("count","10");
//http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=shouji&page=1&count=10
        VolleyUtils.getInstance().doGet(params, "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword", new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                showToast(response);
            }

            @Override
            public void failure(Throwable error) {

            }
        });

    }
}
