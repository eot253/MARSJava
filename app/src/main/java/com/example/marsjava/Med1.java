package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.os.Build;
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

public class Med1 extends AppCompatActivity {

    private DatabaseReference mDatabase;
    String code2 = MainActivity.code;
    String pass = MainActivity.pass;

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;


    private PendingIntent pendingIntent;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private String name;
    private String time;
    private Integer hour_1;

    String onoff = "On";

    String current;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med1);

        calendar = Calendar.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Switch check = findViewById(R.id.switch1);
        Boolean state = check.isChecked();

        if (state == false){
            alarmManager.cancel(pendingIntent);
            onoff = "Off";
        }

        current = onoff;



        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Mars", "Mars_Channel", NotificationManager.IMPORTANCE_HIGH);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Mars")
                .setSmallIcon(R.drawable.background_splash)
                .setContentText("Notification test")
                .setContentTitle("Title one");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);


        ImageButton back = findViewById(R.id.backmed1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Med1.this, login.class));
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView title = findViewById(R.id.med3title);
                name = String.valueOf(task.getResult().getValue());
                title.setText(name);
            }
        });

        mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child("Medication").child("time").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                TextView settings = findViewById(R.id.med1_setting);
                time = String.valueOf(task.getResult().getValue());
                hour_1 = Integer.parseInt(time);
                if (hour_1 > 12){
                    hour_1 = hour_1 - 12;
                    settings.setText(name + " everyday at " + hour_1 + " PM");
                }else {
                    settings.setText(name + " everyday at " + hour_1 + " AM");
                }

            }
        });

        DatabaseReference appt = FirebaseDatabase.getInstance().getReference("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child("1677654946").child("Medications");
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
                    TextView title = findViewById(R.id.med3title);



                    TextView date1 = findViewById(R.id.onoff1);


                    String key1 = String.valueOf(firstKey);
                    String key2 = String.valueOf(secondKey);
                    String key3 = String.valueOf(thirdKey);
                    String key4 = String.valueOf(fourthKey);
                    String key5 = String.valueOf(fifthKey);


                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key1).child("med_name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                title.setText(value);
                                name = value;
                            }
                        }
                    });


                    mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Medications").child(key1).child("time").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            String value = String.valueOf(task.getResult().getValue());
                            if (value != "null"){
                                TextView settings = findViewById(R.id.med1_setting);
                                time = String.valueOf(task.getResult().getValue());
                                hour_1 = Integer.parseInt(time);
                                if (hour_1 > 12){
                                    hour_1 = hour_1 - 12;
                                    settings.setText(name + " everyday at " + hour_1 + " PM");
                                }else {
                                    settings.setText(name + " everyday at " + hour_1 + " AM");
                                }
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

    private void setAlarm() {

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }


}