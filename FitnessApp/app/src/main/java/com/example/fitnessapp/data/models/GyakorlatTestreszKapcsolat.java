package com.example.fitnessapp.data.models;

import androidx.room.Entity;

@Entity(primaryKeys = {"testreszId", "gyakorlatId"})
public class GyakorlatTestreszKapcsolat {
    public int testreszId;
    public int gyakorlatId;
}
