package com.sarvani.news_app.retrofit;

import com.sarvani.news_app.model.Article;
import com.sarvani.news_app.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.sarvani.news_app.constants.AppConstants.API_KEY;

public interface ApiRequest {
    @GET("top-headlines?country=in&Category=Default&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadLines();


}
