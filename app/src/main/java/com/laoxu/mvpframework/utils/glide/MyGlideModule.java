package com.laoxu.mvpframework.utils.glide;

import android.content.Context;
import android.os.Environment;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;

/**
 * 自定义设置内存缓存大小和磁盘缓存大小及路径
 */
@GlideModule
public class MyGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);
        int memorySize = 1024 * 1024 * 20;//内存大小，20M
        int diskMemorySize = 1024 * 1024 * 200;//磁盘缓存大小

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/wdmall/glideCache");
            if (!file.exists()) {//文件夹不存在，创建
                file.mkdirs();//创建多级目录
            }
            String path = file.getAbsolutePath();
            System.out.println("path===" + file.getAbsolutePath());
            //第一个参数上下文，第二个本地磁盘（sdcard）路径，第三个大小
            builder.setDiskCache(new DiskLruCacheFactory(path, diskMemorySize));
        }

        builder.setMemoryCache(new LruResourceCache(memorySize));//内存缓存大小，lru算法：最近最少使用算法

    }
}
