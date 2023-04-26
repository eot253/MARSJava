package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class allappt extends AppCompatActivity {

    private DatabaseReference mDatabase;

    String code2 = MainActivity.code;
    String pass = MainActivity.pass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allappt);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        ImageButton back = findViewById(R.id.backmed);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allappt.this,login.class));
            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    TextView med1_t = findViewById(R.id.med1_t);
                    med1_t.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });
        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    TextView med1_t = findViewById(R.id.med2_t);
                    med1_t.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });

        //buttons to appt
        ImageButton ap1 = findViewById(R.id.imageButton2);
        ImageButton ap2 = findViewById(R.id.imageButton3);
        ImageButton ap3 = findViewById(R.id.imageButton4);
        ImageButton ap4 = findViewById(R.id.imageButton5);
        ImageButton ap5 = findViewById(R.id.imageButton6);

        ap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allappt.this,Aptmm1.class));
            }
        });
        ap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allappt.this,Aptmm2.class));
            }
        });
        ap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allappt.this,Apptm3.class));
            }
        });
        ap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allappt.this,Apptm4.class));
            }
        });
        ap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allappt.this,Apptm5.class));
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
                    TextView title = findViewById(R.id.med1_t);
                    TextView title2 = findViewById(R.id.med2_t);
                    TextView title3 = findViewById(R.id.med3_t);
                    TextView title4 = findViewById(R.id.med4_t);
                    TextView title5 = findViewById(R.id.med5_t);

                    TextView date1 = findViewById(R.id.onoff1);
                    TextView date2 = findViewById(R.id.onoff);
                    TextView date3 = findViewById(R.id.onoff2);
                    TextView date4 = findViewById(R.id.onoff3);
                    TextView date5 = findViewById(R.id.onoff4);

                    String key1 = String.valueOf(firstKey);
                    String key2 = String.valueOf(secondKey);
                    String key3 = String.valueOf(thirdKey);
                    String key4 = String.valueOf(fourthKey);
                    String key5 = String.valueOf(fifthKey);


                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key1).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                title.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                title2.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key3).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                title3.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key4).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                title4.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key5).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                title5.setText(value);
                            }
                        }
                    });

                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key1).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                date1.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                date2.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key3).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                date3.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key4).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                date4.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key5).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                date5.setText(value);
                            }
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