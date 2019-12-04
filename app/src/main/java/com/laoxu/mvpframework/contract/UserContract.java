package com.laoxu.mvpframework.contract;

import com.laoxu.lib_core.base.entity.BaseEntity;
import com.laoxu.lib_core.base.mvp.IBaseModel;
import com.laoxu.lib_core.base.mvp.IBaseView;

import java.util.HashMap;

/**
 * 契约类
 */
public interface UserContract {

    interface IModel extends IBaseModel {

        void reg(HashMap<String,Object> params ,ModelCallback modelCallback);

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

        void reg(HashMap<String,Object> params);

    }
}
