package com.android.myfirstandroidapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsViewHolder> {
    private List<Fruit> fruits;

    public FruitsAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public FruitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        return new FruitsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsViewHolder holder, int position) {
        Fruit currentFruit = fruits.get(position);
        holder.getTextViewName().setText(currentFruit.getName());
        holder.getTextViewColor().setText(currentFruit.getColor());
        if(currentFruit.getUrlPicture() != null) {
            Picasso.get().load(currentFruit.getUrlPicture()).into(holder.getImageViewFruit());
        } else {
            Picasso.get().load(R.drawable.android).into(holder.getImageViewFruit());
        }
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }
}
