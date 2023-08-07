package com.example.shakaui3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shakaui3.fragments.AddActivityFragment;
import com.example.shakaui3.fragments.HomeFragment;
import com.example.shakaui3.fragments.MessageFragment;
import com.example.shakaui3.fragments.ProfileFragment;
import com.example.shakaui3.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDbHelper myDbHelper;
    ArrayList<String>user_id, username, userEmail, userPassword;
    BottomNavigationView bottomBar;
    FloatingActionButton downArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            loadFragment(new HomeFragment());
        }

        getData();
        storedDataAccess();

        bottomBar = findViewById(R.id.bottomNavView);
        bottomBar.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId==R.id.home_menu){
                loadFragment(new HomeFragment());
                return true;
            }else if(itemId==R.id.profile){
                loadFragment(new ProfileFragment());
            } else if (itemId == R.id.message) {
                loadFragment(new MessageFragment());
            } else if (itemId == R.id.settings) {
                loadFragment(new SettingsFragment());
            } else if (itemId == R.id.main_menu) {
                loadFragment(new HomeFragment());

            }
            return false;
        });

        downArrow = findViewById(R.id.downArrow);
        downArrow.setOnClickListener(view -> loadFragment(new HomeFragment()));


    }

    public void getData(){
        myDbHelper = new MyDbHelper(MainActivity.this);
        user_id = new ArrayList<>();
        username = new ArrayList<>();
        userEmail = new ArrayList<>();
        userPassword = new ArrayList<>();
    }

    void storedDataAccess(){
        Cursor cursor = myDbHelper.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                user_id.add(cursor.getString(0));
                username.add(cursor.getString(1));
                userEmail.add(cursor.getString(2));
                userPassword.add(cursor.getString(3));
            }
        }
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}