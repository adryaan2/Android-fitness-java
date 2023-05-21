package com.example.fitnessapp.data;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.data.models.Gyakorlat;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Gyakorlat> gyakorlat;

    public MyAdapter(List<Gyakorlat> gyakorlat) {
        this.gyakorlat = (List<Gyakorlat>) gyakorlat;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_one_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Gyakorlat gyakorlat1 = gyakorlat.get(position);
        holder.keptext.setText(gyakorlat1.mediaURL);
        holder.elemtext.setText(gyakorlat1.gyakorlatNev);
        holder.ismetlestext.setText(String.valueOf(gyakorlat1.getIsmetlesekSzama()));
    }

    @Override
    public int getItemCount() {
        return gyakorlat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView keptext;
        TextView elemtext;
        TextView ismetlestext;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            keptext = itemView.findViewById(R.id.kepTextView);
            elemtext = itemView.findViewById(R.id.elemTextView);
            ismetlestext = itemView.findViewById(R.id.ismetlesTextView);
        }
    }
}
