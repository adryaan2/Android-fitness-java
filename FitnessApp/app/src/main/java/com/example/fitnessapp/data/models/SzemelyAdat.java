package com.example.fitnessapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SzemelyAdat {
    @PrimaryKey
    public int szemelyId;

    public String nev;

    public int kor;

    /**
     * true=nő,
     * false=férfi
     */
    public boolean nem;

    public int magassag;

    public double suly;

    public double kaloria;

    public SzemelyAdat(int szemelyId, String nev, int kor, boolean nem, int magassag, double suly, double kaloria) {
        this.szemelyId = szemelyId;
        this.nev = nev;
        this.kor = kor;
        this.nem = nem;
        this.magassag = magassag;
        this.suly = suly;
        this.kaloria = kaloria;
    }
}
