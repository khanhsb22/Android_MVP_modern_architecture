package com.example.demoapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ActivityMain2Binding;
import com.example.demoapp.presenter.SignUpPresenter;
import com.example.demoapp.utils.SignUpContract;

public class MainActivity2 extends AppCompatActivity implements SignUpContract.View {
    private ActivityMain2Binding binding;
    private SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initPresenter();
        binding.buttonSubmitSignUp.setOnClickListener(view -> {
            signUp();
        });
    }

    private void signUp() {
        String userName = binding.edtSignUpUserName.getText().toString();
        String password = binding.edtSignUpPassword.getText().toString();
        String retypePassword = binding.edtSignUpRetypePassword.getText().toString();
        signUpPresenter.handleSignUp(userName, password, retypePassword);
    }

    private void initPresenter() {
        signUpPresenter = new SignUpPresenter();
        signUpPresenter.setView(this);
    }

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Sign up account success !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signUpFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}