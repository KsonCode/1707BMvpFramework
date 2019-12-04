package com.laoxu.mvpframework.presenter.user;

import com.laoxu.lib_core.base.entity.BaseEntity;
import com.laoxu.lib_core.base.mvp.BasePresenter;
import com.laoxu.lib_core.base.mvp.IBaseModel;
import com.laoxu.lib_core.base.mvp.IBaseView;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.model.user.UserModel;

import java.util.HashMap;

public class UserPresenter extends BasePresenter<UserModel, UserContract.IView> implements UserContract.IPresenter {


    public UserPresenter(UserContract.IView iView) {
        super(iView);
    }

    @Override
    protected UserModel initModel() {
        return new UserModel();
    }

    @Override
    public void reg(HashMap<String, Object> params) {

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
