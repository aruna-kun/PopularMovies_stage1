package com.udacity.aruna.mypopularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.udacity.aruna.mypopularmovies.MainActivityFragement.KEY_OVERVIEW;
import static com.udacity.aruna.mypopularmovies.MainActivityFragement.KEY_POSTER;
import static com.udacity.aruna.mypopularmovies.MainActivityFragement.KEY_RELEASEDATE;
import static com.udacity.aruna.mypopularmovies.MainActivityFragement.KEY_TITLE;
import static com.udacity.aruna.mypopularmovies.MainActivityFragement.KEY_VOTE;


public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        Intent intentThatStartedThisActivity = getIntent();
        if (null != intentThatStartedThisActivity) {

            String title = intentThatStartedThisActivity.getStringExtra(KEY_TITLE);
            TextView mDisplayText = findViewById(R.id.title);
            mDisplayText.setText(title);

            String overview = intentThatStartedThisActivity.getStringExtra(KEY_OVERVIEW);
            TextView mOverview = findViewById(R.id.overview);
            mOverview.setText(overview);

            String rating = intentThatStartedThisActivity.getStringExtra(KEY_VOTE);
            TextView mRating = findViewById(R.id.average_vote);
            mRating.setText(rating + "/10");


            String releaseDate = intentThatStartedThisActivity.getStringExtra(KEY_RELEASEDATE);
            TextView mReleaseDate = findViewById(R.id.release_date);
            mReleaseDate.setText(releaseDate);

            String posterPath = intentThatStartedThisActivity.getStringExtra(KEY_POSTER);
            String imageUrl = "http://image.tmdb.org/t/p/w780" + posterPath;


            ImageView imageView = findViewById(R.id.imageView);
            // Picasso.with(getContext()).load(moviePoster.image).into(imageView);
            Picasso.with(MovieDetailsActivity.this).load(imageUrl).into(imageView);

            TextView synopsisHeading = findViewById(R.id.Synopsis_Details);

            String synopsis = "Synopsis";
            SpannableString content = new SpannableString(synopsis);
            content.setSpan(new UnderlineSpan(), 0, synopsis.length(), 0);
            synopsisHeading.setText(content);


        }

    }
}