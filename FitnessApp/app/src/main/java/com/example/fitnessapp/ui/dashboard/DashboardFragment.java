package com.example.fitnessapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.fitnessapp.R;
import com.example.fitnessapp.data.MyDB;
import com.example.fitnessapp.data.SzemelyDao;
import com.example.fitnessapp.data.models.SzemelyAdat;
import com.example.fitnessapp.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TextView nincsAdatTxt;
    private TextView textViewBMR;
    private EditText editTextNev;
    private EditText editTextSuly;
    private EditText editTextMag;
    private RadioGroup radioGroupNem;
    private EditText editTextKor;
    private Button buttonMentes;
    private MyDB myDB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        nincsAdatTxt = binding.noDataHint;
        editTextKor = binding.editTextAge;
        editTextMag = binding.editTextHeight;
        editTextNev = binding.editTextPersonName;
        editTextSuly = binding.editTextWeight;
        radioGroupNem = binding.radioGroupSex;
        buttonMentes = binding.buttonSave;
        textViewBMR = binding.textViewBMR;
        myDB=MyDB.getDb(getContext());
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        buttonMentes.setOnClickListener(v->mentesClick(v));
        View view = getView();
        if(view!=null){
            SzemelyDao szemelyDao = myDB.szemelyDao();
            if(szemelyDao.countOfPerson()==0) {
                nincsAdatTxt.setVisibility(View.VISIBLE);
                return;
            }
            nincsAdatTxt.setVisibility(View.INVISIBLE);
            SzemelyAdat user = szemelyDao.getPersonById(1);
            editTextSuly.setText(String.valueOf(user.suly));
            editTextNev.setText(String.valueOf(user.nev));
            editTextMag.setText(String.valueOf(user.magassag));
            editTextKor.setText(String.valueOf(user.kor));
            textViewBMR.setText(String.valueOf(user.kaloria)+" kcal");
            if(user.nem)
                radioGroupNem.check(R.id.radioButtonGirl);
            else
                radioGroupNem.check(R.id.radioButtonBoy);
        }
    }

    void mentesClick(View view){
        SzemelyAdat ujSzemely;
        String nev = String.valueOf(editTextNev.getText()).trim();
        int kor = -1;
        int mag =-1;
        double suly = -1;


        String temp = editTextKor.getText().toString().trim();
        if(! "".equals(temp)){
            kor = Integer.parseInt(temp);
        }
        temp = editTextMag.getText().toString().trim();
        if(! "".equals(temp)){
            mag = Integer.parseInt(temp);
        }
        temp = editTextSuly.getText().toString().trim();
        if(! "".equals(temp)){
            suly = Double.parseDouble(temp);
        }
        boolean nem = radioGroupNem.getCheckedRadioButtonId() == R.id.radioButtonGirl;
        double bmr = -1;
        if(nem)
            bmr=447.593+(9.247*suly)+(3.098*mag)-(4.33*kor);
        else
            bmr=88.362+(13.397*suly)+(4.799*mag)-(5.677*kor);
        bmr=kerekit(bmr,2);
        ujSzemely = new SzemelyAdat(1,nev,kor,nem,mag,suly,bmr);
        myDB.szemelyDao().addPerson(ujSzemely);
        /*//frissüljön
        onStart();
         */
        //átirányítás főoldalra
        Navigation.findNavController(view).popBackStack();
        Toast.makeText(getActivity(),"Adatait mentettük",Toast.LENGTH_LONG).show();
    }

    public static double kerekit(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}