package com.example.mvp_practice.MVP_First;

public class SamplePresenter implements SampleContract.Presenter {

    private SampleContract view;

    @Override
    public void setView() {
        this.view = view;
    }
}
