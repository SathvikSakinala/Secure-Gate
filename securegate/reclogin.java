package com.example.securegate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class reclogin extends AppCompatActivity {
    EditText email,password;
    Button btnlogin2;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclogin);
        getSupportActionBar().setTitle("LOGIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        btnlogin2 = findViewById(R.id.btnlogin2);

        firebaseDatabase = firebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(reclogin.this, "You are logged in", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(reclogin.this, Homepage.class);
                    startActivity(i);

                } else {
                    Toast.makeText(reclogin.this, "Please login", Toast.LENGTH_SHORT).show();
                }
            }
        };


        btnlogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pwd = password.getText().toString();

                if (mail.isEmpty()) {
                    email.setError("Please provide email");
                    email.requestFocus();

                } else if (pwd.isEmpty()) {
                    password.setError("Please provide password");
                    password.requestFocus();

                } else if (mail.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(reclogin.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

                } else if (!(mail.isEmpty() && pwd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(mail, pwd)
                            .addOnCompleteListener(reclogin.this,
                                    new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {

                                            if (!task.isSuccessful()) {
                                                Toast.makeText(reclogin.this, "Login error", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Intent inttohome = new Intent(reclogin.this, Homepage.class);
                                                startActivity(inttohome);
                                            }
                                        }

                                    });
                } else {
                    Toast.makeText(reclogin.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


   /*@Override
    protected void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthStateListener);
    }*/

}