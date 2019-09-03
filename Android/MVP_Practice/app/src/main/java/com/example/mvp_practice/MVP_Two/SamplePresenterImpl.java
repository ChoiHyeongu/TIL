package com.example.mvp_practice.MVP_Two;

import java.util.ArrayList;

public class SamplePresenterImpl implements SamplePresenter {

    View view;

    public SamplePresenterImpl(View view) {
        this.view = view;
    }

    @Override
    public void loadItem() {
        ArrayList<String> list = new ArrayList<>();
        view.updateView(list);
    }
}
