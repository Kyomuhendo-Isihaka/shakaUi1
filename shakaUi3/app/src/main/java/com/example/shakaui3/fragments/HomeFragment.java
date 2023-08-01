package com.example.shakaui3.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.shakaui3.Adapter.HomeAdapter;
import com.example.shakaui3.Domains.HomeItemDomain;
import com.example.shakaui3.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<HomeItemDomain> homeList;

    private HomeAdapter homeAdapter;
    private RecyclerView home_recycleView;
    private Button add_activity_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView= inflater.inflate(R.layout.fragment_home, container, false);
       homeList = generateHomeItems();

       home_recycleView = rootView.findViewById(R.id.home_recycleView);
       home_recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
       homeAdapter = new HomeAdapter(homeList);
       home_recycleView.setAdapter(homeAdapter);

       return rootView;

        }

        private List<HomeItemDomain> generateHomeItems(){
            List<HomeItemDomain> homeItems = new ArrayList<>();
            homeItems.add(new HomeItemDomain(getContext(),"1","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"2","Hey"));
            homeItems.add(new HomeItemDomain(getContext(),"3","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"4","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"5","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"6","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"7","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"8","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"9","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"10","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"11","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"12","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"13","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"14","Hello"));
            homeItems.add(new HomeItemDomain(getContext(),"15","Hello"));

            return homeItems;
        }





}