package com.laoxu.mvpframework.model.entity;

import com.laoxu.mvpframework.base.entity.BaseEntity;

public class LoginEntity  {

    public String message;
    public String status;
    public Login result;

    public static class Login{
        public String headPic;
        public String nickName;
        public String phone;
        public String sessionId;
        public String sex;
        public String userId;
    }



}
