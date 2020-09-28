package id.radikz.mvvm_movie.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.radikz.mvvm_movie.model.Movie;


public class MovieResponse {

    @SerializedName("results")
    @Expose
    private List<Movie> items = null;

    public List<Movie> getItems() {
        return items;
    }

    public void setItems(List<Movie> items) {
        this.items = items;
    }

}
