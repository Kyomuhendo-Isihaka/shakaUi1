package com.example.shakaui3.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shakaui3.LoginActivity;
import com.example.shakaui3.MyDbHelper;
import com.example.shakaui3.R;

public class ProfileFragment extends Fragment {

    private MyDbHelper myDbHelper;
    TextView userName, userEmail;

    TextView logoutBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profile, container, false);
        logoutBtn = view.findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(view1 -> {
            startActivity(new Intent(getContext(),LoginActivity.class));
        });

        myDbHelper = new MyDbHelper(getContext());
        storedDataAccess();

        userName = view.findViewById(R.id.userName);
        userEmail = view.findViewById(R.id.userEmail);

//        userName.setText(userName);








        return view;
    }

    void storedDataAccess() {
        Cursor cursor = myDbHelper.readAllData();
        if (cursor.getCount() == 1) {
           String user_id = cursor.getString(0);
           String  username=cursor.getString(1);
           String userEmail=cursor.getString(2);
           String userPassword=cursor.getString(3);



        }
    }
}