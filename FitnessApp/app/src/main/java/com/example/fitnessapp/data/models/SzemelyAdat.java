package com.example.fitnessapp.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SzemelyAdat {
    @PrimaryKey
    public int szemelyId;

    @ColumnInfo
    public String nev;

    @ColumnInfo
    public int kor;

    @ColumnInfo
    public boolean nem;

    @ColumnInfo
    public int magassag;

    @ColumnInfo
    public double suly;

    @ColumnInfo
    public double kaloria;
}
