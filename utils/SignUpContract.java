package com.example.demoapp.utils;

public interface SignUpContract {
    interface View {
        void signUpSuccess();
        void signUpFailure(String error);
    }
    interface Presenter {
        void handleSignUp(String userName, String password, String retypePassword);
    }
}
