package com.udacity.aruna.mypopularmovies.utilities;

import com.udacity.aruna.mypopularmovies.MoviePosters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aruna on 12/12/2017.
 */

public class MovieUtilities {

    public static String[] getMoviesFromJson(String movieListJsonStr)
            throws JSONException {
        final String movieResults = "results";
        // final String movieTitle="original_title";
        final String moviePoster = "poster_path";
        String[] parsedMovieData;

        JSONObject results = new JSONObject(movieListJsonStr);
        JSONArray titleResults = results.getJSONArray(movieResults);
        parsedMovieData = new String[titleResults.length()];

        for (int i = 0; i < titleResults.length(); i++) {
            String posterPath;

            JSONObject eachMovie = titleResults.getJSONObject(i);
            //String title=eachMovie.getString(movieTitle);
            posterPath = eachMovie.getString(moviePoster);
            parsedMovieData[i] = posterPath;


        }
        return parsedMovieData;
    }

    public static List<MoviePosters> getMovieInfo(String movieListJsonStr)
            throws JSONException {
        final String movieResults = "results";
        final String movieTitle = "original_title";
        final String moviePoster = "poster_path";
        final String overview = "overview";
        final String rating = "vote_average";
        final String releaseDate = "release_date";

        JSONObject results = new JSONObject(movieListJsonStr);
        JSONArray titleResults = results.getJSONArray(movieResults);

        List<MoviePosters> mDetailsList = new ArrayList<>();

        for (int i = 0; i < titleResults.length(); i++) {

            JSONObject eachMovie = titleResults.getJSONObject(i);

            mDetailsList.add(new MoviePosters(i, eachMovie.getString(moviePoster), eachMovie.getString(movieTitle), eachMovie.getString(overview), eachMovie.getString(rating), eachMovie.getString(releaseDate)));
        }
        return mDetailsList;
    }

}
