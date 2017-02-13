package it.oltrenuovefrontiere.popmovies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import it.oltrenuovefrontiere.popmovies.model.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtTestTextView;
    MovieDbRequest request = new MovieDbRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTestTextView = (TextView) findViewById(R.id.testTextView);
        List<Movie> list = request.submitRequest(requestType.MOST_POPULAR);
        if (!list.isEmpty()) {
            txtTestTextView.setText(list.get(0).title);
        }
    }
}


