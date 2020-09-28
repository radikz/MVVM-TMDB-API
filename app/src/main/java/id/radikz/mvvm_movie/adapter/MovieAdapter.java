package id.radikz.mvvm_movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.radikz.mvvm_movie.R;
import id.radikz.mvvm_movie.model.Movie;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Movie> articleArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_movie_article,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(articleArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textMovieName;
        private TextView textMovieDate;
        private TextView textMovieRating;
        private ImageView imageMovie;

        ViewHolder(@NonNull View view) {
            super(view);

            textMovieName = view.findViewById(R.id.item_movie_title);
            textMovieDate = view.findViewById(R.id.item_movie_release_date);
            textMovieRating = view.findViewById(R.id.item_movie_rating);
            imageMovie = view.findViewById(R.id.item_movie_poster);
        }

        void bind(Movie movie) {
            textMovieName.setText(movie.getTitle());
            textMovieDate.setText(movie.getReleaseDate());

            textMovieRating.setText(String.valueOf(movie.getRating()) );

            Glide.with(context)
                    .load("http://image.tmdb.org/t/p/w154" + movie.getPosterPath())
                    .error(R.mipmap.ic_launcher)
                    .into(imageMovie);

        }
    }
}
