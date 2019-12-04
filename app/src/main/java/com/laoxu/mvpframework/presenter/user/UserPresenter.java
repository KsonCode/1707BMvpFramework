package com.laoxu.mvpframework.presenter.user;

import com.laoxu.mvpframework.base.entity.BaseEntity;
import com.laoxu.mvpframework.base.mvp.BasePresenter;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.model.user.UserModel;

import java.util.HashMap;
import java.util.Map;

public class UserPresenter extends BasePresenter<UserModel, UserContract.IView> implements UserContract.IPresenter {

    @Override
    protected UserModel initModel() {
        return new UserModel();
    }

    @Override
    public void reg(Map<String, String> params) {

        model.reg(params, new UserContract.IModel.ModelCallback() {
            @Override
            public void success(BaseEntity baseEntity) {
                getView().success(baseEntity);
            }

            @Override
            public void failure(Throwable throwable) {

                getView().failure(throwable);
            }
        });

    }
}
