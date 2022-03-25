package com.example.demoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.model.UserInfo;
import com.example.demoapp.presenter.SignInPresenter;
import com.example.demoapp.utils.SignInContract;

public class MainActivity extends AppCompatActivity implements SignInContract.View {
    private ActivityMainBinding binding;
    private SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initPresenter();

        UserInfo userInfo = new UserInfo("account1", "mvp");

        binding.buttonSignIn.setOnClickListener(view -> {
            login(userInfo);
        });

        binding.buttonSignUp.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity2.class));
        });
    }

    private void login(UserInfo userInfo) {
        String userName = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        signInPresenter.handleSignIn(userName, password, userInfo);
    }

    private void initPresenter() {
        signInPresenter = new SignInPresenter();
        signInPresenter.setView(this);
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(this, "Sign in success !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}