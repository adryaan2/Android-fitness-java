package com.example.fitnessapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.fitnessapp.data.models.Gyakorlat;

import java.util.List;

@Dao
public interface GyakorlatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addGyakorlat(Gyakorlat ujGyakorlat);

    @Query("SELECT * FROM gyakorlat")
    public Gyakorlat[] getAllGyakorlat();

    @Query("SELECT * FROM gyakorlat WHERE gyakorlatNev LIKE '%'||:keres||'%'")
    public Gyakorlat[] getGyakorlatByNev(String keres);

    @Transaction
    @Query("SELECT * FROM Testresz")
    public List<TestreszEdzesekkel> getTestreszekEdzesekkel();

    @Transaction
    @Query("SELECT * FROM Testresz WHERE Testresz.testreszId=:testreszId")
    public TestreszEdzesekkel getTestreszEdzesekkelById(int testreszId);
}
