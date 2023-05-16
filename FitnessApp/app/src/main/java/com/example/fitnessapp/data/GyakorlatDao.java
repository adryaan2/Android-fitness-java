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

    @Query("SELECT * FROM gyakorlatok")
    public Gyakorlat[] getAllGyakorlat();

    @Query("SELECT * FROM gyakorlatok WHERE gyakorlatNev LIKE '%'||:keres||'%'")
    public Gyakorlat[] getGyakorlatByNev(String keres);

    @Query("SELECT * FROM gyakorlatok WHERE testreszId=:testreszId")
    public Gyakorlat[] getGyakorlatByTestreszId(int testreszId);

    @Transaction
    @Query("SELECT * FROM Testresz")
    public List<TestreszEdzesekkel> getTestreszekEdzesekkel();
}
