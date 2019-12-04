package com.laoxu.lib_core.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laoxu.lib_core.base.mvp.BasePresenter;

import java.util.List;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        presenter = initPresenter();
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
