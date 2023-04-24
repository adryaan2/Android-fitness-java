package com.example.fitnessapp.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Testresz.class,
        parentColumns = "testreszId",
        childColumns = "testreszId",
        onDelete = ForeignKey.CASCADE)
})
public class Gyakorlat {
    @PrimaryKey
    public int gyakorlatId;

    @ColumnInfo
    public int testreszId;

    @ColumnInfo
    public String gyakorlatNev;

    @ColumnInfo
    public String leires;

    @ColumnInfo
    public int ismetlesekSzama;

    @ColumnInfo
    public String videoURL;
}
