package com.example.shakaui3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText username, userEmail, userPass;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.userName);
        userEmail = findViewById(R.id.email);
        userPass = findViewById(R.id.userPass);

        signUpUser();

    }

    private void signUpUser() {
        signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDbHelper myDb = new MyDbHelper(SignUpActivity.this);
                myDb.signUp(username.getText().toString().trim(), userEmail.getText().toString().trim(),
                        userPass.getText().toString().trim());

             startActivity(new Intent(SignUpActivity.this,LoginActivity.class));

            }
        });
    }
}
