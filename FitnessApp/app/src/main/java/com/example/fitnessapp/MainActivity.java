package com.example.fitnessapp;

import android.os.Bundle;
import android.util.Log;

import com.example.fitnessapp.data.MyDB;
import com.example.fitnessapp.data.SzemelyDao;
import com.example.fitnessapp.data.models.SzemelyAdat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.example.fitnessapp.databinding.ActivityMainBinding;

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

        myDB= Room.databaseBuilder(getApplicationContext(),
                MyDB.class, "dbfajl")
                .build();
        SzemelyDao szemelyDao = myDB.szemelyDao();
        szemelyDao.addPerson(new SzemelyAdat(1,"Név",21,true, 170,34.565,223.34));
        szemelyDao.addPerson(new SzemelyAdat(2,"Nééév",21,false, 170,24.565,223.34));
        for(SzemelyAdat akt : szemelyDao.getAllPerson()){
            Log.d("szemely",akt.szemelyId+" "+akt.nev+" "+akt.nem+" "+akt.suly+" kg ");
        }
    }

}