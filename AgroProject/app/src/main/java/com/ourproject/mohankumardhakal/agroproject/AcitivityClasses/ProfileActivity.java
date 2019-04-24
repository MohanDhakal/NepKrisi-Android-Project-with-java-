package com.ourproject.mohankumardhakal.agroproject.AcitivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ourproject.mohankumardhakal.agroproject.HelperClasses.BottomNavigationViewHHelper;
import com.ourproject.mohankumardhakal.agroproject.HelperClasses.CInfo_setter;
import com.ourproject.mohankumardhakal.agroproject.R;

public class ProfileActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    BottomNavigationView bottomNavigationView;

    TextView pfname, plname, paddress, pBio, pphon, pj;
    String Uid;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_toolbar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing the profile attributes
        pfname = findViewById(R.id.pfirst_name);
        plname = findViewById(R.id.plast_name);
        paddress = findViewById(R.id.plocation);
        pBio = findViewById(R.id.pbio);
        pphon = findViewById(R.id.pphone);
        pj = findViewById(R.id.pjob);
        FirebaseUser currentfirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Uid = currentfirebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("customer_info");

        //Setting up bottom navigation view

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

        //Read from database
        databaseReference.orderByChild("userid").equalTo(Uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot infosnapshot : dataSnapshot.getChildren()) {
                    String firstname = infosnapshot.child("firstname").getValue().toString();
                    String lastname = infosnapshot.child("lastname").getValue().toString();
                    String address = infosnapshot.child("address").getValue().toString();
                    String bio = infosnapshot.child("bio").getValue().toString();
                    String job = infosnapshot.child("job").getValue().toString();
                    String contact = infosnapshot.child("contact").getValue().toString();


                    pfname.setText(firstname);
                    plname.setText(lastname);
                    paddress.setText(address);
                    pBio.setText(bio);
                    pphon.setText(contact);
                    pj.setText(job);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.profiletoolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().

                setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onBackPressed() {
        Intent house = new Intent(getApplicationContext(), home_activity.class);
        startActivity(house);
        finish();
    }
}
