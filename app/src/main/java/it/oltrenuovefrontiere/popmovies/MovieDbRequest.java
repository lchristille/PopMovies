package it.oltrenuovefrontiere.popmovies;

import android.os.AsyncTask;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import it.oltrenuovefrontiere.popmovies.model.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static it.oltrenuovefrontiere.popmovies.requestType.HIGHEST_RATED;
import static it.oltrenuovefrontiere.popmovies.requestType.MOST_POPULAR;

/**
 * Created by lucachristille on 09/02/17.
 */

public class MovieDbRequest {
    private final String apiKey = "f758f1f79dd3db1f578c6cf7e5f82e0a";
    private final String baseURL = "https://api.themoviedb.org/3/movie/";
    private final String queryString_MostPopular = "popular";
    private final String queryString_HighestRated = "top_rated";
    private final String queryString_apiKey = "?api_key=";

    public List<Movie> submitRequest(requestType _t) {
        String response;
        try {
            response = new eventHandler().execute(urlConstructor(_t)).get();
        } catch (InterruptedException e) {
            response = "";
        } catch (ExecutionException e) {
            response = "";
        }
        return listFromJSON(response);
    }

    protected String urlConstructor(requestType _t) {
        switch (_t) {
            case MOST_POPULAR:
                return baseURL + queryString_MostPopular + queryString_apiKey + apiKey;
            case HIGHEST_RATED:
                return baseURL + queryString_HighestRated + queryString_apiKey + apiKey;
            default:
                return "";
        }
    }

    public List<Movie> listFromJSON(String _i) {
        JsonResponse response;
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<JsonResponse> jsonResponseAdapter = moshi.adapter(JsonResponse.class);
        try {
            response = jsonResponseAdapter.fromJson(_i);
        } catch (IOException e) {
            response = new JsonResponse(0, new Movie("It is impossible to connect to internet. Try again later"));
        }
        return response.results;
    }

    private static class JsonResponse {
        public final int page;
        public List<Movie> results;

        public JsonResponse(int page, List<Movie> results) {
            this.page = page;
            this.results = results;
        }

        public JsonResponse(int page, Movie results) {
            this.page = page;
            List<Movie> movies = new ArrayList<>();
            movies.add(results);
            this.results = movies;
        }
    }

    public class eventHandler extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(final String... params) {
            OkHttpClient client = new OkHttpClient();

            try {
                Request request = new Request.Builder()
                        .url(params[0])
                        .build();

                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                System.out.println("error");
            }
            return "";
        }
    }

}
