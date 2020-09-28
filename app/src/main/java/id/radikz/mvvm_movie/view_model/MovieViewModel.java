package id.radikz.mvvm_movie.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import id.radikz.mvvm_movie.repository.MovieRepository;
import id.radikz.mvvm_movie.response.MovieResponse;


public class MovieViewModel extends AndroidViewModel {

    private MovieRepository articleRepository;
    private static final String API_KEY = "ef89e61c8a5eab5624af0b6b8802021e";

    private LiveData<MovieResponse> articleResponseLiveData;


    public MovieViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new MovieRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles(API_KEY);
    }

    public LiveData<MovieResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;

    }
}
