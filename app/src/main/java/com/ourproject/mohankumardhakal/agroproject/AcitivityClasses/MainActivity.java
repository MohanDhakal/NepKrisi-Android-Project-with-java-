package com.ourproject.mohankumardhakal.agroproject.AcitivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ourproject.mohankumardhakal.agroproject.R;

public class MainActivity extends AppCompatActivity {
    Button bfarmer, bcustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

        setContentView(R.layout.activity_main);
        bfarmer = findViewById(R.id.farmer);
        bcustomer = findViewById(R.id.customer);


        bfarmer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Farmer_login.class);
                startActivity(myIntent);
                finish();
            }
        });

        bcustomer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Customer_signin.class);
                startActivity(myIntent);
                finish();
            }
        });

    }
}