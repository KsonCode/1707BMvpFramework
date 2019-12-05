package com.laoxu.mvpframework.view.activity;

import android.view.View;
import android.widget.ImageView;


import com.laoxu.mvpframework.R;
import com.laoxu.mvpframework.base.BaseActivity;
import com.laoxu.mvpframework.base.entity.BaseEntity;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.utils.network.VolleyUtils;
import com.laoxu.mvpframework.presenter.user.UserPresenter;
import com.laoxu.mvpframework.utils.glide.GlideUtils;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity<UserPresenter> implements UserContract.IView {

//    private UserPresenter userPresenter;

    private ImageView glideIv;

    @Override
    protected void initData() {
//        userPresenter = new UserPresenter();

    }

    @Override
    protected void initView() {

        glideIv = findViewById(R.id.iv_glide);

//        //with：上下文，作用是绑定activity或freament的上下文（生命周期）
//        Glide.with(this).
//                //加载资源：网络，本地资源
//                load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575536233682&di=e7a6c593d4f08b9523cc5d10a87809db&imgtype=0&src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F93de9d45e44e1a88e2c4ea48f3e265cd.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100")
//                .centerCrop()//剧中jian qie
//                .circleCrop()//圆形
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
////                .skipMemoryCache(true)//跳过缓存
//                .placeholder(R.mipmap.ic_launcher)//占位图：加载过程中的占位图
//                .error(R.mipmap.ic_launcher)//占位图：加载失败的图
//                //设置到控件（imageview）
//                .into(glideIv);

        GlideUtils.getInstance().showCircleImage(this,"",glideIv);
//        VolleyUtils.getInstance().requestImage("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=213116030,3323089670&fm=15&gp=0.jpg",glideIv);


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
        if (presenter!=null){
            presenter.detach();//解绑
        }
    }
}
