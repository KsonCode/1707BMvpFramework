package com.laoxu.mvpframework.contract;


import com.laoxu.mvpframework.base.entity.BaseEntity;
import com.laoxu.mvpframework.base.mvp.IBaseModel;
import com.laoxu.mvpframework.base.mvp.IBaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * 契约类
 */
public interface UserContract {

    interface IModel extends IBaseModel {

        void reg(Map<String,String> params , ModelCallback modelCallback);

        interface ModelCallback{
            void success(BaseEntity baseEntity);
            void failure(Throwable throwable);
        }

    }
    interface IView extends IBaseView {

        void success(BaseEntity baseEntity);
        void failure(Throwable throwable);

    }

    interface IPresenter{

        void reg(Map<String,String> params);

    }
}
