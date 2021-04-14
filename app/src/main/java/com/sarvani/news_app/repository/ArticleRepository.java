package com.sarvani.news_app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sarvani.news_app.response.ArticleResponse;
import com.sarvani.news_app.retrofit.ApiRequest;
import com.sarvani.news_app.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;


    public ArticleRepository(ApiRequest apiRequest) {
        this.apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDashboardNews(){
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getTopHeadLines().enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                if(response.body()!=null){
                    data.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                data.setValue(null);

            }
        });
        return data;
    }
}
