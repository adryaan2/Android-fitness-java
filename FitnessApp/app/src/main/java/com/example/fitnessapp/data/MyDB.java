package com.example.fitnessapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fitnessapp.data.models.Gyakorlat;
import com.example.fitnessapp.data.models.GyakorlatTestreszKapcsolat;
import com.example.fitnessapp.data.models.SzemelyAdat;
import com.example.fitnessapp.data.models.Testresz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Gyakorlat.class, SzemelyAdat.class, Testresz.class, GyakorlatTestreszKapcsolat.class}, version = 2)
public abstract class MyDB extends RoomDatabase {
    public abstract GyakorlatDao gyakorlatDao();
    public abstract SzemelyDao szemelyDao();

    private static volatile MyDB myDb;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MyDB getDb(final Context context){
        if(myDb==null){
            synchronized (MyDB.class) {
                if(myDb==null){
                    /*myDb = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDB.class,
                                    "database_name.db")
                            .openHelperFactory(new AssetSQLiteOpenHelperFactory())
                            .allowMainThreadQueries()
                            .build();*/
                    myDb = Room.databaseBuilder(context.getApplicationContext(),
                            MyDB.class,
                            "FitnessAppDb.db").createFromAsset("databases/FitnessAppDb.db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return myDb;
    }
}
