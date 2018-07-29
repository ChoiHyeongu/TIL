package com.example.choi.kakaotalk;

import android.widget.ImageView;

public class FriendItem {

    int resId;
    String name;
    String mood;

    public FriendItem(int resId, String name, String mood) {
        this.resId = resId;
        this.name = name;
        this.mood = mood;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
