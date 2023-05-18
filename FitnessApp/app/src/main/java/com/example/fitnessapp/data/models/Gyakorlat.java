package com.example.fitnessapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gyakorlatok")
public class Gyakorlat {
    @PrimaryKey
    public int gyakorlatId;

    public String gyakorlatNev;

    public String leiras;

    public int ismetlesekSzama;

    public String mediaURL;
}
