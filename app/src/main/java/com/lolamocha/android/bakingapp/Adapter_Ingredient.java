package com.lolamocha.android.bakingapp;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Adapter_Ingredient extends RecyclerView.Adapter<Adapter_Ingredient.MyViewHolder> {

    private List<Ingredient> ingredients;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ing_info_lvrow_tv)
        TextView name_tv;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public Adapter_Ingredient(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredients_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);

        holder.name_tv.setText(new StringBuilder()
                .append(Integer.toString(position + 1))
                .append(". ")
                .append(ingredient.getIngredient())
                .append(", ")
                .append(ingredient.getQuantity())
                .append(" ")
                .append(ingredient.getMeasure())
                .toString());
    }

    @Override
    public int getItemCount() {

        return ingredients.size();
    }
}
