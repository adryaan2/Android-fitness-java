package com.example.fitnessapp.data;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.fitnessapp.data.models.Gyakorlat;
import com.example.fitnessapp.data.models.GyakorlatTestreszKapcsolat;
import com.example.fitnessapp.data.models.Testresz;

import java.util.List;

public class TestreszEdzesekkel {
    @Embedded
    public Testresz testresz;

    @Relation(
            parentColumn = "testreszId",
            entityColumn = "gyakorlatId",
            associateBy = @Junction(GyakorlatTestreszKapcsolat.class)
    )
    public List<Gyakorlat> gyakorlatok;
}
