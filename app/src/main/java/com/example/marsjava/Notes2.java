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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class Notes2 extends AppCompatActivity {
    String pass = MainActivity.pass;

    private DatabaseReference mDatabase;
    String code2 = MainActivity.code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("summary").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.drnote);
                String name = String.valueOf(task.getResult().getValue());
                note.setText(name);
            }
        });


        ImageButton back = findViewById(R.id.notes_menu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Notes2.this,login.class));
            }
        });

        DatabaseReference appt = FirebaseDatabase.getInstance().getReference("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child("1677654946").child("Visits");
        appt.addListenerForSingleValueEvent(new ValueEventListener() {
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

                    } else if(count == 3) {
                        thirdKey = childSnapshot.getKey();

                    } else if(count == 4) {
                        fourthKey = childSnapshot.getKey();

                    } else if(count == 5) {
                        fifthKey = childSnapshot.getKey();

                    } else {
                        // Ignore the remaining keys
                    }
                    TextView title = findViewById(R.id.title_text);


                    TextView date1 = findViewById(R.id.date_text);


                    TextView note1 = findViewById(R.id.drnote);


                    String key1 = String.valueOf(firstKey);
                    String key2 = String.valueOf(secondKey);
                    String key3 = String.valueOf(thirdKey);
                    String key4 = String.valueOf(fourthKey);
                    String key5 = String.valueOf(fifthKey);

                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            title.setText(value);
                        }
                    });


                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            date1.setText(value);
                        }
                    });


                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("summary").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            note1.setText(value);
                        }
                    });


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // This method is called if there is an error reading the data
            }
        });

    }
}