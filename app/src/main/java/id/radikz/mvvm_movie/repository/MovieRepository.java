package id.radikz.mvvm_movie.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import id.radikz.mvvm_movie.response.MovieResponse;
import id.radikz.mvvm_movie.retrofit.ApiRequest;
import id.radikz.mvvm_movie.retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static final String TAG = MovieRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public MovieRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<MovieResponse> getMovieArticles(String query) {
        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        apiRequest.getMovieList(query)
                .enqueue(new Callback<MovieResponse>() {


                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);


                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
