package id.radikz.mvvm_movie.retrofit;

import id.radikz.mvvm_movie.response.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("movie")
    Call<MovieResponse> getMovieList(@Query("api_key") String query);

}
