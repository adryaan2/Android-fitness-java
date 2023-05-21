package com.example.fitnessapp.data;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.data.models.Gyakorlat;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Gyakorlat> gyakorlat;

    public MyAdapter(Context context, List<Gyakorlat> gyakorlat) {
        this.context = context;
        this.gyakorlat = (List<Gyakorlat>) gyakorlat;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_one_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.keptext.setText(gyakorlat.get(position).getMediaURL());
        holder.elemtext.setText(gyakorlat.get(position).getGyakorlatNev());
        holder.ismetlestext.setText(gyakorlat.get(position).getIsmetlesekSzama());
    }

    @Override
    public int getItemCount() {
        return gyakorlat.size();
    }
}
