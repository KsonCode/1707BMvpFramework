package com.laoxu.mvpframework.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.laoxu.mvpframework.R;
import com.laoxu.mvpframework.base.BaseActivity;
import com.laoxu.mvpframework.base.mvp.BasePresenter;
import com.laoxu.mvpframework.contract.ILoginContract;
import com.laoxu.mvpframework.model.entity.LoginEntity;
import com.laoxu.mvpframework.presenter.user.LoginPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * 单一职责原则
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginContract.IView , View.OnClickListener {

    private EditText mPhoneEt,mPwdEt;
    private Button loginBtn;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {

        mPhoneEt = findViewById(R.id.et_phone);
        mPwdEt = findViewById(R.id.et_pwd);
        loginBtn = findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this);

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * 登录成功
     * @param loginEntity
     */
    @Override
    public void success(LoginEntity loginEntity) {
        //跳转某个页面
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void failure(Throwable error) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_login:

                if (mPhoneEt.getText().toString().length()==0){
                    showToast("手机号不能为空");
                    break;
                }
                if (mPwdEt.getText().toString().length()==0){
                    showToast("密码不能为空");
                    break;
                }
                Map<String,String> params = new HashMap<>();
                params.put("phone",mPhoneEt.getText().toString());
                params.put("pwd",mPwdEt.getText().toString());


                presenter.login(params);
                break;
        }

    }
}
