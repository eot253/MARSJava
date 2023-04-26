package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Medicine extends AppCompatActivity {

    private DatabaseReference mDatabase;

    String code2 = MainActivity.code;
    String pass = MainActivity.pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    TextView med1_t = findViewById(R.id.med1_t);
                    med1_t.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    TextView med2_t = findViewById(R.id.med2_t);
                    med2_t.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });



        ImageButton medback = findViewById(R.id.backmed);
        medback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Medicine.this, login.class));
            }
        });


    }
}