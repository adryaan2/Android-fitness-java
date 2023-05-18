package com.example.fitnessapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Testresz {
    @PrimaryKey
    public int testreszId;

    @NotNull
    public String megnev;
}
