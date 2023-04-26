package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

public class login extends AppCompatActivity {

    String code2 = MainActivity.code;
    public String name;
    String pass = MainActivity.pass;

    private DatabaseReference mDatabase;
    private PendingIntent pendingIntent;
    private Calendar calendar;
    private AlarmManager alarmManager;
    public String Time_1;

    public Integer hour_1;
    public Integer hour_2;

    public static String nameMed_1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        //view buttons
        ImageButton view = findViewById(R.id.view);
        ImageButton view2 = findViewById(R.id.view1);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,allappt.class));
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,allnotes.class));
            }
        });

        //Hide non-used medicines
        hide();
        calendar = Calendar.getInstance();


        //patient name

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView test = findViewById(R.id.test2);
                String name = String.valueOf(task.getResult().getValue());
                test.setText(name);

            }
        });



        //Medicines in menu
        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Button inb = findViewById(R.id.inbutton1);
                //nameMed_1 = String.valueOf(task.getResult().getValue());
                //inb.setText(nameMed_1);
                if (task.isSuccessful()){
                    //inb.setVisibility(View.VISIBLE);
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("time").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            Time_1 = String.valueOf(task.getResult().getValue());
                            hour_1 = Integer.parseInt(Time_1);
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            calendar.set(Calendar.HOUR_OF_DAY, hour_1);
                            //calendar.set(Calendar.MINUTE, 12);
                            setAlarm();
                        }
                    });

                }

            }
        });



        Button inb = findViewById(R.id.inbutton1);
        inb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,Med1.class));
            }
        });
        Button medMenu2 = findViewById(R.id.inbutton2);
        medMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,Med2.class));
            }
        });

        Button medm3 = findViewById(R.id.inbutton3);
        Button medm4 = findViewById(R.id.inbutton4);
        Button medm5 =  findViewById(R.id.inbutton5);

        medm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Med3.class));
            }
        });
        medm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Med4.class));
            }
        });
        medm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Med5.class));
            }
        });



        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Button inb = findViewById(R.id.inbutton2);
                //inb.setText(String.valueOf(task.getResult().getValue()));
                if (task.isSuccessful()){
                    //inb.setVisibility(View.VISIBLE);
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("time").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            Time_1 = String.valueOf(task.getResult().getValue());
                            hour_2 = Integer.parseInt(Time_1);
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            calendar.set(Calendar.HOUR_OF_DAY, 20);
                            calendar.set(Calendar.MINUTE,  17);
                            setAlarm();
                        }
                    });

                }
            }
        });


        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Button inb = findViewById(R.id.inbutton3);
                //nameMed_1 = String.valueOf(task.getResult().getValue());
                //inb.setText(nameMed_1);
                if (task.isSuccessful()){
                    //inb.setVisibility(View.VISIBLE);
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("time").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            Time_1 = String.valueOf(task.getResult().getValue());
                            hour_1 = Integer.parseInt(Time_1);
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            calendar.set(Calendar.HOUR_OF_DAY, hour_1);
                            //calendar.set(Calendar.MINUTE, 12);
                            setAlarm();
                        }
                    });

                }

            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                //Button inb = findViewById(R.id.inbutton4);
                //nameMed_1 = String.valueOf(task.getResult().getValue());
                //inb.setText(nameMed_1);
                if (task.isSuccessful()){
                    //inb.setVisibility(View.VISIBLE);
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("time").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            Time_1 = String.valueOf(task.getResult().getValue());
                            hour_1 = Integer.parseInt(Time_1);
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            calendar.set(Calendar.HOUR_OF_DAY, hour_1);
                            //calendar.set(Calendar.MINUTE, 12);
                            setAlarm();
                        }
                    });

                }

            }
        });




        //doctor notes
        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("summary").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.note);
                String name = String.valueOf(task.getResult().getValue());
                //note.setText(name);
            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("summary").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.note1);
                String name = String.valueOf(task.getResult().getValue());
                //note.setText(name);
            }
        });

        //Appointment titles
        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.Appt);
                String name = String.valueOf(task.getResult().getValue());
                //note.setText(name);
            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.Appt2);
                String name = String.valueOf(task.getResult().getValue());
                //note.setText(name);
            }
        });

        // Dates for appointments

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.date1);
                String name = String.valueOf(task.getResult().getValue());
                note.setText(name);
            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child("01-03-2023 01:15:46").child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView note = findViewById(R.id.date2);
                String name = String.valueOf(task.getResult().getValue());
                note.setText(name);
            }
        });

        //go to profile
        ImageButton profile = findViewById(R.id.profilebutton);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,profile.class));
            }
        });

        //notes button
        ImageButton noteb1 = findViewById(R.id.notebutton1);
        noteb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Notes2.class));
            }
        });

        ImageButton noteb2 = findViewById(R.id.notebutton2);
        noteb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Notes.class));
            }
        });

        //appointments buttons
        ImageButton apptb1 = findViewById(R.id.apptbutton1);
        apptb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Aptmm1.class));
            }
        });
        ImageButton apptb2 = findViewById(R.id.apptbutton2);
        apptb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Aptmm2.class));
            }
        });

        //Notifications
        // Set the time when the notification should be triggered
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 20); // Set the hour of the day (24-hour format)
        calendar.set(Calendar.MINUTE, 17);

        // Create an intent for the notification
        Intent intent = new Intent(this, notreceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // Schedule the alarm
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        //test
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
                        Button inb = findViewById(R.id.inbutton1);
                        if (firstKey != null){
                            inb.setVisibility(View.VISIBLE);

                        }


                    } else if(count == 2) {
                        secondKey = childSnapshot.getKey();
                        Button inb = findViewById(R.id.inbutton2);
                        if (secondKey != null){
                            inb.setVisibility(View.VISIBLE);
                        }

                    } else if(count == 3) {
                        thirdKey = childSnapshot.getKey();
                        Button inb = findViewById(R.id.inbutton3);
                        if (thirdKey != null){
                            inb.setVisibility(View.VISIBLE);
                        }

                    } else if(count == 4) {
                        fourthKey = childSnapshot.getKey();
                        Button inb = findViewById(R.id.inbutton4);
                        if (fourthKey != null){
                            inb.setVisibility(View.VISIBLE);
                        }

                    } else if(count == 5) {
                        fifthKey = childSnapshot.getKey();
                        Button inb = findViewById(R.id.inbutton5);
                        if (fifthKey != null){
                            inb.setVisibility(View.VISIBLE);
                        }

                    } else {
                        // Ignore the remaining keys
                    }

                    String key1 = String.valueOf(firstKey);
                    String key2 = String.valueOf(secondKey);
                    String key3 = String.valueOf(thirdKey);
                    String key4 = String.valueOf(fourthKey);
                    String key5 = String.valueOf(fifthKey);

                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key1).child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null") {
                                Button inb = findViewById(R.id.inbutton1);
                                inb.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key2).child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null") {
                                Button inb = findViewById(R.id.inbutton2);
                                inb.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key3).child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null") {
                                Button inb = findViewById(R.id.inbutton3);
                                inb.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key4).child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null") {
                                Button inb = findViewById(R.id.inbutton4);
                                inb.setText(value);
                            }
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key5).child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null") {
                                Button inb = findViewById(R.id.inbutton5);
                                inb.setText(value);
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
                    TextView title = findViewById(R.id.Appt);
                    TextView title2 = findViewById(R.id.Appt2);

                    TextView date1 = findViewById(R.id.date1);
                    TextView date2 = findViewById(R.id.date2);

                    TextView note1 = findViewById(R.id.note);
                    TextView note2 = findViewById(R.id.note1);

                    String key1 = String.valueOf(firstKey);
                    String key2 = String.valueOf(secondKey);

                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key1).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            title.setText(value);
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("visit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            title2.setText(value);
                        }
                    });

                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key1).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            date1.setText(value);
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("visit_date").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            date2.setText(value);
                        }
                    });

                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key1).child("summary").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            note1.setText(value);
                        }
                    });
                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Visits").child(key2).child("summary").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            note2.setText(value);
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

    private void hide() {
        Button b1 = findViewById(R.id.inbutton1);
        Button b2 = findViewById(R.id.inbutton2);
        Button b3 = findViewById(R.id.inbutton3);
        Button b4 = findViewById(R.id.inbutton4);
        Button b5 = findViewById(R.id.inbutton5);
        Button b6 = findViewById(R.id.inbutton6);
        Button b7 = findViewById(R.id.inbutton7);
        Button b8 = findViewById(R.id.inbutton8);
        Button b9 = findViewById(R.id.inbutton9);
        Button b10 = findViewById(R.id.inbutton10);

        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.GONE);
        b8.setVisibility(View.GONE);
        b9.setVisibility(View.GONE);
        b10.setVisibility(View.GONE);



    }

    private void setAlarm() {

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }


}