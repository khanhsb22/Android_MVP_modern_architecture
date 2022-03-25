package com.example.demoapp.presenter;

import com.example.demoapp.utils.SignUpContract;

public class SignUpPresenter implements SignUpContract.Presenter {
    private SignUpContract.View view;

    public void setView(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void handleSignUp(String userName, String password, String retypePassword) {
        if (userName.length() < 3) {
            view.signUpFailure("Username must >= 3 character !");
        } else if (password.length() < 3) {
            view.signUpFailure("Password must >= 3 character !");
        } else if (!retypePassword.equals(password)) {
            view.signUpFailure("Retype password not correct !");
        } else {
            view.signUpSuccess();
        }
    }
}
