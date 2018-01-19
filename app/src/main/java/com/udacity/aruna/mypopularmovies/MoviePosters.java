package com.udacity.aruna.mypopularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aruna.
 */

public class MoviePosters implements Parcelable {



    private final int image; // drawable reference id
    final String posterPath;
    private final String mTitle;
    private final String overView;
    private final String voteAverage;
    private final String releaseDate;


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


// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public int getImage() {
//        return image;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public void setImage(int image) {
//        this.image = image;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

    public String getPosterPath() {
        return posterPath;
    }

// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public void setPosterPath(String posterPath) {
//        this.posterPath = posterPath;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

    public String getmTitle() {
        return mTitle;
    }

// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public void setmTitle(String mTitle) {
//        this.mTitle = mTitle;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

    public String getOverView() {
        return overView;
    }

// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public void setOverView(String overView) {
//        this.overView = overView;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

    public String getVoteAverage() {
        return voteAverage;
    }

// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public void setVoteAverage(String voteAverage) {
//        this.voteAverage = voteAverage;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

    public String getReleaseDate() {
        return releaseDate;
    }

// --Commented out by Inspection START (1/19/2018 4:35 AM):
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
// --Commented out by Inspection STOP (1/19/2018 4:35 AM)

}
