package it.oltrenuovefrontiere.popmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import it.oltrenuovefrontiere.popmovies.model.Movie;
import it.oltrenuovefrontiere.popmovies.view.movieGridApdater;

public class MainActivity extends AppCompatActivity {

    MovieDbRequest request = new MovieDbRequest();
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private movieGridApdater mMovieGridApdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movieGrid);
        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        List<Movie> list = request.submitRequest(requestType.MOST_POPULAR);
        if (!list.isEmpty()) {
            mMovieGridApdater = new movieGridApdater(list);
            mRecyclerView.setAdapter(mMovieGridApdater);
        }
    }
}


