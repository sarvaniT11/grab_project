package com.sarvani.news_app.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sarvani.news_app.repository.ArticleRepository;
import com.sarvani.news_app.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveDataLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        articleRepository = new ArticleRepository();
        articleResponseLiveDataLiveData = articleRepository.getDashboardNews();
    }

    public LiveData<ArticleResponse>getBashboardNewsResponseLiveData(){
        return articleResponseLiveDataLiveData;

    }
}
