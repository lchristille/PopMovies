package it.oltrenuovefrontiere.popmovies.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import it.oltrenuovefrontiere.popmovies.R;
import it.oltrenuovefrontiere.popmovies.model.Movie;

/**
 * Created by NewArt on 15/02/2017.
 */

// https://www.raywenderlich.com/126528/android-recyclerview-tutorial

public class movieGridApdater extends RecyclerView.Adapter<movieGridApdater.ViewHolder> {

    private List<Movie> mMovieList;
    private static final String posterSize = "w780";
    private static final String baseUrlForPoster = "http://image.tmdb.org/t/p/";

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie currentMovie = mMovieList.get(position);
        holder.mTvTitle.setText(currentMovie.title);
        Picasso.with(holder.context)
                .load(getUrlForPoster(currentMovie.poster_path))
                .into(holder.mIvPoster);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public movieGridApdater(List<Movie> list) {
        super();
        mMovieList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmcard, parent, false);
        return new ViewHolder(inflatedView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTitle;
        ImageView mIvPoster;
        Context context;

        public ViewHolder(View v) {
            super(v);
            this.mTvTitle = (TextView) v.findViewById(R.id.tv_title);
            this.mIvPoster = (ImageView) v.findViewById(R.id.iv_poster);
            this.context = v.getContext();
        }

    }

    private String getUrlForPoster(String posterPath) {
        return baseUrlForPoster + posterSize + posterPath;
    }

}
