package it.oltrenuovefrontiere.popmovies;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lucachristille on 09/02/17.
 */

public class MovieDbRequest {
    private final static String apiKey = "f758f1f79dd3db1f578c6cf7e5f82e0a";
    private final static String baseURL = "https://api.themoviedb.org/3/movie/";
    private final static String queryString_MostPopular = "popular";
    private final static String queryString_HighestRated = "top_rated";
    private final static String queryString_apiKey = "?api_key=";

    public String submitRequest(requestType _t) {
        switch (_t) {
            case MOST_POPULAR:
                return submitQueryString(queryString_MostPopular);
            case HIGHEST_RATED:
                return submitQueryString(queryString_HighestRated);
        }
    }

    private OkHttpClient httpClient() {
        return new OkHttpClient();
    }

    private String urlConstructor(String queryString) {
        return baseURL + queryString + queryString_apiKey + apiKey;
    }

    private Response getResponseFromUrl(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        return httpClient().newCall(request).execute();
    }

    private String submitQueryString(String queryString) {
        String url = urlConstructor(queryString);
        try {
            getResponseFromUrl(url).body().string();
        } catch (IOException e) {
            return "";
        }
    }


}
