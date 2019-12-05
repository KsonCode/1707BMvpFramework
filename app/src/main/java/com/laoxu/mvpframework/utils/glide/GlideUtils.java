package com.laoxu.mvpframework.utils.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.laoxu.mvpframework.R;
import com.laoxu.mvpframework.app.App;

/**
 * glide的二次封装，单例模式，java有23种
 */
public class GlideUtils {
    //静态私有属性
    private static GlideUtils instance;


    //私有构造方法
    private GlideUtils(){

    }

    //暴露给调用者使用的方法；创建当前对象的方法
    public static GlideUtils getInstance(){
        if (instance==null){
            synchronized (GlideUtils.class){
                if (instance==null){
                    instance = new GlideUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 缓存有，圆角有，占位图有
     */
    public void showImage(Context context, String url, ImageView imageView){

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);

    }
    /**
     * 圆形图
     */
    public void showCircleImage(Context context, String url, ImageView imageView){

        Glide.with(context)
                .load(url)
                .circleCrop()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);

    }

    /**
     * 是否应用缓存
     */
    public void showCacheImage(Context context, String url, ImageView imageView,boolean isCache){

        Glide.with(context)
                .load(url)
                .circleCrop()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(isCache)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);

    }

}
