package com.example.marsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class menu_drop extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drop);

        ImageButton back = findViewById(R.id.back_doc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu_drop.this,login.class));
            }
        });


        Button meds = findViewById(R.id.meds_menu);
        meds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu_drop.this,Medicine.class));
            }
        });

        Button appt = findViewById(R.id.appt_menu);
        appt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu_drop.this,Appointments.class));
            }
        });

        Button notes = findViewById(R.id.docnotes_menu);
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu_drop.this,Notes.class));
            }
        });


    }









}