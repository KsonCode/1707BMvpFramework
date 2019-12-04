package com.laoxu.lib_core.base.mvp;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * p层基类
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {


    protected M  model;
    private WeakReference<V> weakReference;
    public BasePresenter(V v){

        weakReference = new WeakReference<>(v);

        model = initModel();

    }

    /**
     * 让子类初始化相应的model对象
     * @return
     */
    protected abstract M initModel();


    /**
     * 解绑，释放view资源，释放的this
     */
    public void detach(){

        if (weakReference!=null){
            weakReference.clear();//清空数据
        }

    }

    /**
     * 获取弱引用包装的view对象
     * @return
     */
    public V getView(){
        return weakReference.get();//得到弱引用的view 对象
    }


}
