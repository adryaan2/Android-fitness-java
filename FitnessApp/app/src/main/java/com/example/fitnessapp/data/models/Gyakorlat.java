package com.example.fitnessapp.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Gyakorlat {
    @PrimaryKey
    public int gyakorlatId;

    @NonNull
    public String gyakorlatNev;

    @NonNull
    public String leiras;

    public int ismetlesekSzama;

    public String mediaURL;


    public int getGyakorlatId() {
        return gyakorlatId;
    }

    @NonNull
    public String getGyakorlatNev() {
        return gyakorlatNev;
    }

    @NonNull
    public String getLeiras() {
        return leiras;
    }

    public int getIsmetlesekSzama() {
        return ismetlesekSzama;
    }

    public String getMediaURL() {
        return mediaURL;
    }
}
