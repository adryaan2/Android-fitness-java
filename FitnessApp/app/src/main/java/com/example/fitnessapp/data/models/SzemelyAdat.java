package com.example.fitnessapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SzemelyAdat {
    @PrimaryKey
    public int szemelyId;

    public String nev;

    public int kor;

    public boolean nem;

    public int magassag;

    public double suly;

    public double kaloria;
}
