package com.laoxu.mvpframework.contract;

import com.laoxu.mvpframework.base.entity.BaseEntity;
import com.laoxu.mvpframework.base.mvp.IBaseModel;
import com.laoxu.mvpframework.base.mvp.IBaseView;
import com.laoxu.mvpframework.model.entity.LoginEntity;

import java.util.Map;

public interface ILoginContract {

    interface IModel extends IBaseModel {

        void login(Map<String,String> params , ModelCallback modelCallback);

        interface ModelCallback{
            void success(LoginEntity loginEntity);
            void failure(Throwable throwable);
        }

    }
    interface IView extends IBaseView {

        void success(LoginEntity loginEntity);
        void failure(Throwable throwable);

    }

    interface IPresenter{

        void login(Map<String,String> params);

    }
}
