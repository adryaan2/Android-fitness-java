package com.example.fitnessapp.data.models;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface TestreszDao {
    @Query("SELECT * FROM Testresz")
    public Testresz[] getTestreszek();
}
