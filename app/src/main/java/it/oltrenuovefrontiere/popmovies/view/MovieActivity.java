package it.oltrenuovefrontiere.popmovies.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import it.oltrenuovefrontiere.popmovies.R;

public class MovieActivity extends AppCompatActivity {

    private ImageView mPoster;
    private TextView mFilmTitle;
    private TextView mReleaseDate;
    private TextView mVoteAverage;
    private TextView mPlotSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mPoster = (ImageView) findViewById(R.id.iv_poster);
        mFilmTitle = (TextView) findViewById(R.id.tv_filmTitle);
        mReleaseDate = (TextView) findViewById(R.id.tv_releaseDate);
        mVoteAverage = (TextView) findViewById(R.id.tv_voteAverage);
        mPlotSynopsis = (TextView) findViewById(R.id.tv_plotSynopsis);
    }
}
