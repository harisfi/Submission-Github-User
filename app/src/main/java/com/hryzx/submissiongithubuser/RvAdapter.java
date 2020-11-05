package com.hryzx.submissiongithubuser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvHolder> {
    ArrayList<RvModels> models;
    Context context;

    public RvAdapter(Context context, ArrayList<RvModels> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new RvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RvHolder holder, final int position) {
        holder.tvName.setText(models.get(position).getName());
        holder.tvUsername.setText(models.get(position).getUsername());
        holder.tvLocation.setText(models.get(position).getLocation());
        holder.imgAvatar.setImageResource(models.get(position).getAvatar());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("parcel", models.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}