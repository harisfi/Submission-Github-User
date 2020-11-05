package com.hryzx.submissiongithubuser;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ItemClickListener itemClickListener;
    TextView tvName, tvUsername, tvLocation;
    ImageView imgAvatar;

    RvHolder(@NonNull View itemView) {
        super(itemView);

        this.imgAvatar = itemView.findViewById(R.id.imageV);
        this.tvName = itemView.findViewById(R.id.titleV);
        this.tvUsername = itemView.findViewById(R.id.titleV1);
        this.tvLocation = itemView.findViewById(R.id.desc);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}