package com.example.fitnessapp.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Testresz {
    @PrimaryKey
    public int testreszId;

    @NonNull
    public String megnev;
}
