package com.example.securegate;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Homepage extends AppCompatActivity {
    Button btnrequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        btnrequest = findViewById(R.id.btnrequest);
        btnrequest.setOnClickListener (new View.OnClickListener()

        {
            public void onClick(View view) {

                {

                    Toast.makeText(Homepage.this, " requests", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Homepage.this, request.class);
                    startActivity(intent);
                }
            }   } );
    }
}