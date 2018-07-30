package com.example.choi.kakaotalk;

public class ProfileItem {

    private int profileImage;
    private String profileName;
    private String profileMood;

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileMood() {
        return profileMood;
    }

    public void setProfileMood(String profileMood) {
        this.profileMood = profileMood;
    }

    public ProfileItem(int profileImage, String profileName, String profileMood) {
        this.profileImage = profileImage;
        this.profileName = profileName;
        this.profileMood = profileMood;
    }
}
