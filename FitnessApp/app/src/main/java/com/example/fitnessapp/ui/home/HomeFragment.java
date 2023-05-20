package com.example.fitnessapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.fitnessapp.R;
import com.example.fitnessapp.data.MyDB;
import com.example.fitnessapp.data.SzemelyDao;
import com.example.fitnessapp.data.models.Testresz;
import com.example.fitnessapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MyDB myDB;
    private EditText editTextSearch;
    private Spinner spinnerTestresz;
    private Button btnSearchByString;
    private Button btnFilterByBpart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        editTextSearch = binding.editTextSearch;
        spinnerTestresz = binding.spinnerTestresz;
        btnFilterByBpart = binding.buttonFilterByBpart;
        btnSearchByString = binding.buttonSearchLikeString;
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view!=null) {
            myDB = MyDB.getDb(getActivity());
            if (myDB.szemelyDao().countOfPerson() == 0) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_dashboard);
                return;
            }
            List<String> testreszList = new ArrayList<>();
            testreszList.add("Bármely testrész");
            for(Testresz testresz : myDB.testreszDao().getTestreszek())
                testreszList.add(testresz.megnev);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, testreszList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTestresz.setAdapter(arrayAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}