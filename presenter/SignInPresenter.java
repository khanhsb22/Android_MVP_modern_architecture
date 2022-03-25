package com.example.demoapp.presenter;

import com.example.demoapp.model.UserInfo;
import com.example.demoapp.utils.SignInContract;

public class SignInPresenter implements SignInContract.Presenter {
    private SignInContract.View view;

    public void setView(SignInContract.View view) {
        this.view = view;
    }

    @Override
    public void handleSignIn(String userName, String password, UserInfo userInfo) {
        if (userName.equals(userInfo.getUsername()) && password.equals(userInfo.getPassword())) {
            view.signInSuccess();
            return;
        }
        view.signInFailure("Username or password not valid !");
    }
}
