package com.example.recycleviewpermisos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<ViewHolder>
{
    Context context;
    List<Item> items;

    public Adapter(Context context, List<Item> items)
    {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_permission, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.nameView.setText(items.get(position).getPermissionName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}