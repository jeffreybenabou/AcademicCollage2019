package com.jeffrey.academiccollage.advancePrograming.RecyclerExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeffrey.academiccollage.R;

import java.util.ArrayList;

public class Adapter extends  RecyclerView.Adapter<Adapter.ViewHolder>{


    private ArrayList<Vacation> vacations=new ArrayList<>();


    public Adapter(ArrayList<Vacation> vacations){
        this.vacations=vacations;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vacation,parent,false);

        return new Adapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(vacations.get(position).getNameOfDestination());
        holder.desc.setText(vacations.get(position).getMoreDetailed());
        holder.price.setText(vacations.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return vacations.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public ImageView link;
        public TextView price;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            title=itemView.findViewById(R.id.title_of_vacation);
            desc=itemView.findViewById(R.id.description_of_vacation);
            price=itemView.findViewById(R.id.price_of_vacation);
        }
    }
}
