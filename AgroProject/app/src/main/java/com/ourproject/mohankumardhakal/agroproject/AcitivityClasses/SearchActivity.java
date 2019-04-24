package com.ourproject.mohankumardhakal.agroproject.AcitivityClasses;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ourproject.mohankumardhakal.agroproject.HelperClasses.BottomNavigationViewHHelper;
import com.ourproject.mohankumardhakal.agroproject.R;

public class SearchActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_house:
                        Intent house = new Intent(getApplicationContext(), home_activity.class);
                        startActivity(house);
                        item.setChecked(true);
                        finish();
                        break;

                    case R.id.ic_search:

                        Intent search = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(search);
                        item.setChecked(true);
                        finish();
                        break;

                    case R.id.ic_profile:
                        Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(profile);
                        item.setChecked(true);
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent house = new Intent(getApplicationContext(), home_activity.class);
        startActivity(house);
        finish();
    }
}