package com.ourproject.mohankumardhakal.agroproject.HelperClasses;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ourproject.mohankumardhakal.agroproject.AcitivityClasses.ProfileActivity;
import com.ourproject.mohankumardhakal.agroproject.AcitivityClasses.SearchActivity;
import com.ourproject.mohankumardhakal.agroproject.AcitivityClasses.home_activity;
import com.ourproject.mohankumardhakal.agroproject.R;

public class BottomNavigationViewHHelper {

    public static final String TAG = "BottomNavigationView";


    public static void enableNavigation(final Context context, final BottomNavigationView view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.ic_house:
                        Intent house = new Intent(context, home_activity.class);
                        context.startActivity(house);
                        break;

                    case R.id.ic_search:

                        Intent search = new Intent(context, SearchActivity.class);
                        context.startActivity(search);
                        break;

                    case R.id.ic_profile:
                        Intent profile =new Intent(context,ProfileActivity.class);
                        context.startActivity(profile);
                        break;
                }
                return false;
            }
        });
    }
}
