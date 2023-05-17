package com.example.fitnessapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gyakorlatok")
public class Gyakorlat {
    @PrimaryKey
    public int gyakorlatId;

    public int testreszId;

    public String gyakorlatNev;

    public String leires;

    public int ismetlesekSzama;

    public String mediaURL;
}
