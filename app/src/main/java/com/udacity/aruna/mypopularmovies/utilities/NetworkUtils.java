package com.udacity.aruna.mypopularmovies.utilities;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.util.Log;

import com.udacity.aruna.mypopularmovies.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.Scanner;



/**
 * Created by Aruna.
 */

public class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();


    public static URL buildUrl(String sort) {
        URL url = null;
        Uri builtUri = Uri.parse("http://api.themoviedb.org/")
                .buildUpon()
                .path("3/movie/")
                .appendPath(sort)
                .appendQueryParameter(Constants.API_KEY, Constants.KEY_VALUE)
                .build()
                ;



        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "Built URI " + url);

        return url;

    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static boolean isNetworkAvailable(Context context) {

        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return (connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null) != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }

}
