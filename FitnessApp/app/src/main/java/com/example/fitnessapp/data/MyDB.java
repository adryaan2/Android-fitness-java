package com.example.fitnessapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.fitnessapp.data.models.Gyakorlat;
import com.example.fitnessapp.data.models.GyakorlatTestreszKapcsolat;
import com.example.fitnessapp.data.models.SzemelyAdat;
import com.example.fitnessapp.data.models.Testresz;

@Database(entities = {Gyakorlat.class, SzemelyAdat.class, Testresz.class, GyakorlatTestreszKapcsolat.class}, version = 1)
public abstract class MyDB extends RoomDatabase {
    public abstract GyakorlatDao gyakorlatDao();
    public abstract SzemelyDao szemelyDao();
}
