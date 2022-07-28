package com.example.securegate;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    Button btnlogin1;
    Button btnlogin2;
    Button btnlogin3;
    private FirebaseAuth firebaseAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin1 = findViewById(R.id.btnlogin1);
        btnlogin2 = findViewById(R.id.btnlogin2);
        btnlogin3= findViewById(R.id.btnlogin3);
        btnlogin1.setOnClickListener (new View.OnClickListener()

                {
            public void onClick(View view) {

                {

                    Toast.makeText(MainActivity.this, "Residencial Login has been clicked", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, reclogin.class);
                    startActivity(intent);
                }
            }   } );
        btnlogin2.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View view) {

                {

                    Toast.makeText(MainActivity.this, "guest Login has been clicked", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, guelogin.class);
                    startActivity(intent);
                }
            }   } );
        btnlogin3.setOnClickListener (new View.OnClickListener()

        {
            public void onClick(View view) {

                {

                    Toast.makeText(MainActivity.this, "register has been clicked", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }   } );
    }}
