package com.exemple.danieletavernelli.mt.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class Utente implements Parcelable {

    private String username;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public Utente createFromParcel(Parcel parcel) {

           return new Utente(parcel);

        }

        @Override
        public Utente[] newArray(int i) {
            return new Utente[i];
        }
    };

    public Utente( ) {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Utente(Parcel in) {
        this.username = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
    }
}
