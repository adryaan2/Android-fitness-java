package com.example.fitnessapp.data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.fitnessapp.data.models.Testresz;

@Dao
public interface TestreszDao {
    @Query("SELECT * FROM Testresz")
    public Testresz[] getTestreszek();
}
