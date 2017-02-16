package it.oltrenuovefrontiere.popmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lucachristille on 12/02/17.
 */

public class Movie implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    private Movie(Parcel in) {
        this.poster_path = in.readString();
        this.adult = Boolean.parseBoolean(in.readString());
        this.overview = in.readString();
        this.release_date = in.readString();
        this.genre_ids = in.readIntArray();
        this.id = in.readInt();
        this.original_title = in.readString();
        this.original_language = in.readString();
        this.title = in.readString();
        this.backdrop_path = in.readString();
        this.popularity = in.readDouble();
        this.vote_count = in.readInt();
        this.video = Boolean.parseBoolean(in.readString());
        this.vote_average = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(poster_path);
        dest.writeString(adult.toString());
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeIntArray(genre_ids);
        dest.writeInt(id);
        dest.writeString(original_title);
        dest.writeString(original_language);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeDouble(popularity);
        dest.writeInt(vote_count);
        dest.writeBooleanArray(video.toString());
        dest.writeFloat(vote_average);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    }
}
