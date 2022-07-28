package com.example.securegate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class request extends AppCompatActivity {

    Button btnreq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        btnreq= findViewById(R.id.btnreq);
        btnreq.setOnClickListener (new View.OnClickListener()

        {
            public void onClick(View view) {

                {

                    Toast.makeText(request.this, "Requests has been clicked", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(request.this, guereq.class);
                    startActivity(intent);
                }
            }   } );
    }
}