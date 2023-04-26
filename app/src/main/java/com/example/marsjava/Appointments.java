package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Appointments extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String code2 = MainActivity.code;
    String pass = MainActivity.pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView appt_1 = findViewById(R.id.appt_title3);
                appt_1.setText(String.valueOf(task.getResult().getValue()));

            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView date_1 = findViewById(R.id.date);
                date_1.setText(String.valueOf(task.getResult().getValue()));

            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView appt_2 = findViewById(R.id.appt_title2);
                appt_2.setText(String.valueOf(task.getResult().getValue()));

            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView date_2 = findViewById(R.id.date3);
                date_2.setText(String.valueOf(task.getResult().getValue()));

            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView appt_2 = findViewById(R.id.appt_title4);
                appt_2.setText(String.valueOf(task.getResult().getValue()));

            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView date_2 = findViewById(R.id.date4);
                date_2.setText(String.valueOf(task.getResult().getValue()));

            }
        });


        ImageButton back  = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Appointments.this,login.class));
            }
        });



    }
}