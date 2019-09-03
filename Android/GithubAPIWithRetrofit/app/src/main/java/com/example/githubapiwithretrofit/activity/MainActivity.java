package com.example.githubapiwithretrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.githubapiwithretrofit.R;
import com.example.githubapiwithretrofit.presenter.Presenter;
import com.example.githubapiwithretrofit.presenter.ProfilePresenter;

public class MainActivity extends AppCompatActivity implements Presenter.View {

    ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePresenter = new ProfilePresenter();
        profilePresenter.attachView(this);

        profilePresenter.loadUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        profilePresenter.detachView();
    }
}
