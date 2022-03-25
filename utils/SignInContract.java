package com.example.demoapp.utils;

import com.example.demoapp.model.UserInfo;

public interface SignInContract {
    interface View {
        void signInSuccess();
        void signInFailure(String error);
    }
    interface Presenter {
        void handleSignIn(String userName, String password, UserInfo userInfo);
    }
}
