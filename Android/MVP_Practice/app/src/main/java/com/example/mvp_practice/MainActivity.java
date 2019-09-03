package com.example.mvp_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvp_practice.MVP_First.SampleContract;
import com.example.mvp_practice.MVP_First.SamplePresenter;
import com.example.mvp_practice.MVP_Two.SamplePresenterImpl;

public class MainActivity extends AppCompatActivity implements SampleContract.View{

    private SampleContract.Presenter presenter;
    private com.example.mvp_practice.MVP_Two.SamplePresenter presenter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new SamplePresenter();
        presenter.setView(this);

        presenter2 = new SamplePresenterImpl((com.example.mvp_practice.MVP_Two.SamplePresenter.View) this);
        presenter2.loadItem();

        //presenter.loadItem();
    }

    
}
