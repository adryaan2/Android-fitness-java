package com.example.fitnessapp.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Testresz {
    @PrimaryKey
    public int testreszId;
    @ColumnInfo
    public String megnev;
}
