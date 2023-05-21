package com.example.fitnessapp.data;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;

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
