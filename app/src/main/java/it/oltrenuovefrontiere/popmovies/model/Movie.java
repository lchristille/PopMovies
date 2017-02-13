package it.oltrenuovefrontiere.popmovies.model;

/**
 * Created by lucachristille on 12/02/17.
 */

public class Movie {
    public final String poster_path;
    public final Boolean adult;
    public final String overview;
    public final String release_date;
    public final int[] genre_ids;
    public final int id;
    public final String original_title;
    public final String original_language;
    public final String title;
    public final String backdrop_path;
    public final Double popularity;
    public final int vote_count;
    public final Boolean video;
    public final Float vote_average;

    public Movie(String poster_path, Boolean adult, String overview, String release_date, int[] genre_ids, int id, String original_title, String original_language, String title, String backdrop_path, Double popularity, int vote_count, Boolean video, Float vote_average) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
    }

    public Movie(String title) {
        this.poster_path = null;
        this.adult = null;
        this.overview = null;
        this.release_date = null;
        this.genre_ids = null;
        this.id = 0;
        this.original_title = null;
        this.original_language = null;
        this.title = title;
        this.backdrop_path = null;
        this.popularity = null;
        this.vote_count = 0;
        this.video = null;
        this.vote_average = null;
    }
}
