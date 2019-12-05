package com.laoxu.mvpframework.presenter.user;

import com.laoxu.mvpframework.base.mvp.BasePresenter;
import com.laoxu.mvpframework.base.mvp.IBaseModel;
import com.laoxu.mvpframework.contract.ILoginContract;
import com.laoxu.mvpframework.contract.UserContract;
import com.laoxu.mvpframework.model.entity.LoginEntity;
import com.laoxu.mvpframework.model.user.LoginModel;

import java.util.Map;

public class LoginPresenter extends BasePresenter<LoginModel, ILoginContract.IView> implements ILoginContract.IPresenter {


    @Override
    public void login(Map<String, String> params) {

        model.login(params, new ILoginContract.IModel.ModelCallback() {
            @Override
            public void success(LoginEntity loginEntity) {
                getView().success(loginEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });


    }

    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }
}
