package com.example.fitnessapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fitnessapp.data.models.SzemelyAdat;

@Dao
public interface SzemelyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addPerson(SzemelyAdat szemely);

    @Update
    public void updatePerson(SzemelyAdat szemely);

    @Query("SELECT * FROM SzemelyAdat")
    public SzemelyAdat[] getAllPerson();
}
