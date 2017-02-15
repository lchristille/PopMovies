package it.oltrenuovefrontiere.popmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import it.oltrenuovefrontiere.popmovies.model.Movie;
import it.oltrenuovefrontiere.popmovies.view.movieGridApdater;

public class MainActivity extends AppCompatActivity {

    MovieDbRequest request = new MovieDbRequest();
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private movieGridApdater mMovieGridApdater;
    requestType currentRequestType = requestType.MOST_POPULAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movieGrid);
        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        setGridView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.sortingmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.st_mostPopular:
                currentRequestType = requestType.MOST_POPULAR;
                setGridView();
                break;
            case R.id.st_bestRated:
                currentRequestType = requestType.HIGHEST_RATED;
                setGridView();
                break;
        }
        return true;
    }

    public void setGridView() {
        List<Movie> list = request.submitRequest(currentRequestType);
        if (!list.isEmpty()) {
            mMovieGridApdater = new movieGridApdater(list);
            mRecyclerView.setAdapter(mMovieGridApdater);
            mRecyclerView.getAdapter().notifyDataSetChanged();
            mRecyclerView.scrollTo(0,0);
        }
    }
}


