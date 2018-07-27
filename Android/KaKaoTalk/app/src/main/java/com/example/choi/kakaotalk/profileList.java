package com.example.choi.kakaotalk;

public class profileList {

    private int profileImage;
    private String name;
    private String mood;

    public profileList(int profileImage, String name, String mood) {
        this.profileImage = profileImage;
        this.name = name;
        this.mood = mood;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
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
