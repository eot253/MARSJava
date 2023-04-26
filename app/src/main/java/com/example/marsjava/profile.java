package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class profile extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = database.getReference();
    String pass = MainActivity.pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child("1677654946").child("Medications");



        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called when the data is changed in the database
                // You can iterate over the children of the snapshot to get the last five keys
                Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                int count = 0;
                String fifthKey = null;
                String fourthKey = null;
                String thirdKey = null;
                String secondKey = null;
                String firstKey = null;
                while(iterator.hasNext()) {
                    DataSnapshot childSnapshot = iterator.next();
                    count++;
                    if(count == 1) {
                        firstKey = childSnapshot.getKey();
                    } else if(count == 2) {
                        secondKey = childSnapshot.getKey();
                        TextView test = findViewById(R.id.profile_name);
                        test.setText(fifthKey);
                    } else if(count == 3) {
                        thirdKey = childSnapshot.getKey();
                    } else if(count == 4) {
                        fourthKey = childSnapshot.getKey();
                    } else if(count == 5) {
                        fifthKey = childSnapshot.getKey();
                    } else {
                        // Ignore the remaining keys
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // This method is called if there is an error reading the data
            }
        });








    }
}

