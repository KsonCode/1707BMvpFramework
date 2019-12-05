package com.laoxu.mvpframework.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
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

    private ImageView glideIv;

    @Override
    protected void initData() {



    }

    @Override
    protected void initView() {

        glideIv = findViewById(R.id.iv_glide);

        //with：上下文，作用是绑定activity或freament的上下文（生命周期）
        Glide.with(this).
                //加载资源：网络，本地资源
                load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6fdfdfdfdfdfdfdfdhhy/it/u=2850768982,4202597320&fm=26&gp=0.jpg")
                .centerCrop()//剧中jian qie
                .circleCrop()//圆形
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
//                .skipMemoryCache(true)//跳过缓存
                .placeholder(R.mipmap.ic_launcher)//占位图：加载过程中的占位图
                .error(R.mipmap.ic_launcher)//占位图：加载失败的图

                //设置到控件（imageview）
                .into(glideIv);


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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleyUtils.getInstance().cacelCalls();
    }
}
