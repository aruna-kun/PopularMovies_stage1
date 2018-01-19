package com.udacity.aruna.mypopularmovies;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aruna.
 */

class ImageFlavourAdaptor extends ArrayAdapter<MoviePosters> {
    // --Commented out by Inspection (1/18/2018 6:21 AM):private static final String LOG_TAG = ImageFlavourAdaptor.class.getSimpleName();

    //MoviePosters m;

    public ImageFlavourAdaptor(Activity context, List<MoviePosters> moviePosterList) {
        super(context, 0, moviePosterList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.movie_items, parent, false);
        }


        MoviePosters moviePoster = getItem(position);
        ImageView imageView = convertView.findViewById(R.id.movie_image);
        String posterPath = moviePoster != null ? moviePoster.posterPath : null;
        String url = "http://image.tmdb.org/t/p/w185" + posterPath;
        Picasso.with(getContext()).load(url).into(imageView);

        return convertView;

    }


}
