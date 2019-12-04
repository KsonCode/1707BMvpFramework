package com.laoxu.mvpframework.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laoxu.mvpframework.base.mvp.BasePresenter;
import com.laoxu.mvpframework.base.mvp.IBaseView;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        presenter = initPresenter();
        if (presenter!=null){
            presenter.attach(this);
        }
        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    /**
     * 初始化presenter对象
     */
    protected abstract P initPresenter();


    protected abstract int bindLayoutId();

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
