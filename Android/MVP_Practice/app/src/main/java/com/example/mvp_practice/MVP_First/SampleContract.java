package com.example.mvp_practice.MVP_First;

import com.example.mvp_practice.MainActivity;

public interface SampleContract {

    interface View{
    }

    interface Presenter{
        void setView();
        void setView(MainActivity mainActivity);
    }
}
