package com.laoxu.lib_core.base.mvp;

/**
 * view层基类
 */
public interface IBaseView {

    void showLoading();//显示加载进度提示
    void hideLoading();//隐藏
    void failure(Throwable error);//失败


}
