package com.laoxu.mvpframework.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.laoxu.lib_core.base.BaseActivity;
import com.laoxu.lib_core.base.entity.BaseEntity;
import com.laoxu.lib_core.base.mvp.BasePresenter;
import com.laoxu.mvpframework.R;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.presenter.user.UserPresenter;

import java.util.HashMap;

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
        return new UserPresenter(this);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(BaseEntity baseEntity) {

        showToast(baseEntity.message);

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
        HashMap<String,Object> params = new HashMap<>();
        params.put("phone","18678765654");
        params.put("pwd","111111");
        if (presenter!=null){
            presenter.reg(params);
        }
    }
}
