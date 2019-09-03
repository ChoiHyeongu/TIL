package com.example.githubapiwithretrofit.presenter;

public interface Presenter {

    interface View{
        void setProfileImage();
        void setUsername();
        void setMaxContribution();
        void setTodayContribution();
        void setRepoCount();
        void setFollowers();
        void setFollwing();
        void setBio();
    }

    interface Present{
        void getProfileImage(String username);
        void getUsername(String username);
        void getMaxContribution(String username);
        void getTodayContribution(String username);
        void getRepoCount(String username);
        void getFollowers(String username);
        void getFollwing(String username);
        void setBio(String username);
    }
}
