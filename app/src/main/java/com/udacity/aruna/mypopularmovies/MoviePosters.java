package com.udacity.aruna.mypopularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aruna.
 */

public class MoviePosters implements Parcelable {



    int image; // drawable reference id
    String posterPath;
    String mTitle;
    String overView;
    String voteAverage;
    String releaseDate;


    public MoviePosters(int image,String posterPath, String mTitle,String overView,String voteAverage, String releaseDate){
        this.image=image;
        this.posterPath=posterPath;
        this.mTitle=mTitle;
        this.overView = overView;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    private MoviePosters(Parcel in){
        image = in.readInt();
        posterPath = in.readString();
        mTitle=in.readString();
        overView = in.readString();
        voteAverage= in.readString();
        releaseDate = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        parcel.writeString(mTitle);
        parcel.writeString(overView);
        parcel.writeString(voteAverage);
        parcel.writeString(releaseDate);
        parcel.writeInt(image);

    }

    public final Parcelable.Creator<MoviePosters> CREATOR = new Parcelable.Creator<MoviePosters>() {
        @Override
        public MoviePosters createFromParcel(Parcel parcel) {
            return new MoviePosters(parcel);
        }

        @Override
        public MoviePosters[] newArray(int i) {
            return new MoviePosters[i];
        }

    };


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
