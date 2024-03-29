package com.example.foodapp.Adaptor;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.foodapp.Domain.TrendingDomain;
import com.example.foodapp.R;
import com.example.foodapp.ShowDetailActivity;

import java.util.ArrayList;

public class TrendingAdaptor extends RecyclerView.Adapter<TrendingAdaptor.ViewHolder> {

    ArrayList<TrendingDomain> trendingFood;

    public TrendingAdaptor(ArrayList<TrendingDomain> trendingFood) {
        
        this.trendingFood = trendingFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View inflate =  LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_trending,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        holder.title.setText(trendingFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(trendingFood.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(trendingFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", trendingFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return trendingFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}
