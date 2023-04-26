package com.example.marsjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marsjava.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextUniquecode, textInputEditTextPassword;
    Button buttonLogin;
    ProgressBar progressBar;


    ActivityMainBinding binding;
    public static String pass,code;
    FirebaseDatabase db;
    DatabaseReference reference;


    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        mDatabase = FirebaseDatabase.getInstance().getReference();

        Button buttonLogin = findViewById(R.id.login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, login.class));
                EditText codeText = findViewById(R.id.codeInput);
                code = codeText.getText().toString();
                EditText passText = findViewById(R.id.passInput);
                pass = passText.getText().toString();
                mDatabase.child("users").child("cU5PT7MBEqfQ3uLaREPDHMvAzm73").child("patient").child(pass).child("Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {

                        if (!task.isSuccessful()){
                            Log.e("firebase","Error",task.getException());
                        } else if (String.valueOf(task.getResult().getValue()).equals(code)) {
                            startActivity(new Intent(MainActivity.this, login.class));




                        }

                           //TextView textView = (TextView)findViewById(R.id.textView);
                           //textView.setText(String.valueOf(task.getResult().getValue()));
                           //textView.setText(code);


                    }
                });
            }






        });


    }
}