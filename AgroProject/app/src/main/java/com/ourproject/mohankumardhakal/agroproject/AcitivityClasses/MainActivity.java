package com.ourproject.mohankumardhakal.agroproject.AcitivityClasses;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ourproject.mohankumardhakal.agroproject.FragmentClasses.CustomerPostsFrame;
import com.ourproject.mohankumardhakal.agroproject.FragmentClasses.PieSupplyChartFragment;
import com.ourproject.mohankumardhakal.agroproject.R;

public class MainActivity extends AppCompatActivity {
    Button bfarmer, bcustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bfarmer = findViewById(R.id.farmer);
        bcustomer = findViewById(R.id.customer);


        bfarmer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Farmer_login.class);
                startActivityForResult(myIntent, 0);
            }
        });

        bcustomer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Customer_signin.class);
                startActivityForResult(myIntent, 0);
            }
        });

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent test=new Intent(getApplicationContext(),home_activity.class);
                startActivity(test);
            }
        });

    }


}