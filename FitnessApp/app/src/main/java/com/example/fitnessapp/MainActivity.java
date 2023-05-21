package com.example.fitnessapp;

import android.os.Bundle;
import android.util.Log;

import com.example.fitnessapp.data.GyakorlatDao;
import com.example.fitnessapp.data.MyDB;
import com.example.fitnessapp.data.SzemelyDao;
import com.example.fitnessapp.data.TestreszEdzesekkel;
import com.example.fitnessapp.data.models.Gyakorlat;
import com.example.fitnessapp.data.models.SzemelyAdat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.fitnessapp.databinding.ActivityMainBinding;

import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    MyDB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        myDB= MyDB.getDb(this);
        GyakorlatDao gyakDao = myDB.gyakorlatDao();
        //szemelyDao.addPerson(new SzemelyAdat(5,"Név",21,true, 170,34.565,223.34));
        //szemelyDao.addPerson(new SzemelyAdat(6,"Nééév",21,false, 170,24.565,223.34));
        for(Gyakorlat akt : gyakDao.getAllGyakorlat()){
            //Log.d("testresz",akt.testresz.megnev+": "+akt.gyakorlatok.get(0).gyakorlatNev);
            //akt.gyakorlatok.stream().map(x->x.gyakorlatNev).collect(Collectors.joining(", "))
            Log.d("gyakrolat",akt.gyakorlatId+": "+akt.gyakorlatNev+" "+akt.ismetlesekSzama+"x");
        }
        Log.d("gyakSzam",""+gyakDao.getAllGyakorlat().length);

        for(TestreszEdzesekkel akt : gyakDao.getTestreszekEdzesekkel()){
            //Log.d("testresz",akt.testresz.megnev+": "+akt.gyakorlatok.get(0).gyakorlatNev);
            Log.d("testresz",akt.testresz.megnev + ": " + akt.gyakorlatok.stream().map(x->x.gyakorlatNev).collect(Collectors.joining(", ")));
        }

        for(Gyakorlat akt : gyakDao.getGyakorlatByNev("fekvő")){
            //Log.d("testresz",akt.testresz.megnev+": "+akt.gyakorlatok.get(0).gyakorlatNev);
            //akt.gyakorlatok.stream().map(x->x.gyakorlatNev).collect(Collectors.joining(", "))
            Log.d("szűrt: 'fekvő'",akt.gyakorlatId+": "+akt.gyakorlatNev+" "+akt.ismetlesekSzama+"x");
        }

        SzemelyDao szemelyDao = myDB.szemelyDao();
        for(SzemelyAdat akt : szemelyDao.getAllPerson())
            Log.d("szemelyek",akt.szemelyId+" "+akt.nev+" "+akt.suly+" kg "+akt.kaloria+" kcal");

        szemelyDao.updatePerson(new SzemelyAdat(1,"Jómagam",21,false,172,63.81,2410.2));

        for(SzemelyAdat akt : szemelyDao.getAllPerson())
            Log.d("frissített személyek",akt.szemelyId+" "+akt.nev+" "+akt.suly+" kg "+akt.kaloria+" kcal");

        TestreszEdzesekkel hasEdzes = gyakDao.getTestreszEdzesekkelById(3);
        Log.d("edzés: has",hasEdzes.testresz.megnev + ": " + hasEdzes.gyakorlatok.stream().map(x->x.gyakorlatNev).collect(Collectors.joining(", ")));


    }

}