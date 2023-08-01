package com.example.shakaui3.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shakaui3.Domains.HomeItemDomain;
import com.example.shakaui3.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<HomeItemDomain> homeList;

    public HomeAdapter(List<HomeItemDomain> homeList) {
        this.homeList = homeList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeItemDomain homeItemDomain = homeList.get(position);
        holder.activity_id.setText(homeItemDomain.getActivity_id());
        holder.activity_title.setText(homeItemDomain.getActivity_title());

    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{
        TextView activity_id, activity_title;


        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            activity_id = itemView.findViewById(R.id.activity_id);
            activity_title = itemView.findViewById(R.id.activityTitle);
        }
    }
}










