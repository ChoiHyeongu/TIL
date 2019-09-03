package com.example.githubapiwithretrofit.util;

import com.example.githubapiwithretrofit.model.GithubProfile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/ChoiHyeongu")
    Call<GithubProfile> getUser();
}
