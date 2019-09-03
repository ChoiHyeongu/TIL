package com.example.mvp_practice.MVP_Two;

import java.util.List;

public interface SamplePresenter {

    void loadItem();

    interface View{
        void updateView(List<String> items);
    }
}
