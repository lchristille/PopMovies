package it.oltrenuovefrontiere.popmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieDbRequest request = new MovieDbRequest();
        String response = request.submitRequest(requestType.HIGHEST_RATED);
        Log.v(response);
    }
}
