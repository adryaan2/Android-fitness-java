package com.example.fitnessapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.data.MyAdapter;
import com.example.fitnessapp.data.MyDB;
import com.example.fitnessapp.data.TestreszEdzesekkel;
import com.example.fitnessapp.data.models.Gyakorlat;
import com.example.fitnessapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;

    MyDB myDB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerView;
        myDB = MyDB.getDb(getActivity());

        List<TestreszEdzesekkel> EdzesLista = myDB.gyakorlatDao().getTestreszekEdzesekkel();

        List<Gyakorlat> EdzesLista2 = new ArrayList<>();

        for(Gyakorlat gyakorlat: myDB.gyakorlatDao().getAllGyakorlat())
            EdzesLista2.add(gyakorlat);
        MyAdapter adapter = new MyAdapter(EdzesLista2);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}