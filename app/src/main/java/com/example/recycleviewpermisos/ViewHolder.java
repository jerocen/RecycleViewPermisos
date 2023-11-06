package com.example.recycleviewpermisos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder
{
    ImageView imageView;
    TextView nameView, emailView;
    public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView)
    {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
    }
}
