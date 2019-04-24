package com.ourproject.mohankumardhakal.agroproject.AcitivityClasses;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ourproject.mohankumardhakal.agroproject.HelperClasses.CInfo_setter;
import com.ourproject.mohankumardhakal.agroproject.R;

public class customer_info_entry extends AppCompatActivity {
    String first_name, Last_name, bio, address, Userid,phoneno,job;
    EditText fname, lname, desc, addr,phone,Job;
    Button Submit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info_entry);

        fname = findViewById(R.id.Fname);
        lname = findViewById(R.id.Lname);
        desc = findViewById(R.id.description);
        addr = findViewById(R.id.Address);
        Submit = findViewById(R.id.submitcustomer);
        phone=findViewById(R.id.contacts);
        Job=findViewById(R.id.jobs);

        //Database initialization
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("customer_info");

        //getting the UID
        FirebaseUser currentfirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Userid = currentfirebaseUser.getUid();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit_customer_info(Userid);
            }
        });

    }

    private void submit_customer_info(String Uid) {
        first_name = fname.getText().toString();
        Last_name = lname.getText().toString();
        address = addr.getText().toString();
        bio = desc.getText().toString();
        job=Job.getText().toString();
        phoneno=phone.getText().toString();


        if (first_name == "" || Last_name == "" || address == "" || bio == ""||job==""||phoneno=="") {
            Toast.makeText(this, "Please make sure to enter all the fields before clicking submit", Toast.LENGTH_SHORT).show();
        } else {
            CInfo_setter cInfo_setter = new CInfo_setter(first_name, Last_name, address, bio,job,phoneno,Userid);
            databaseReference.child(Userid).setValue(cInfo_setter).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Successfully added to the database", Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(getApplicationContext(), Customer_signin.class);
                        startActivity(i1);
                    } else {
                        Toast.makeText(getApplicationContext(), "Database addition unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
