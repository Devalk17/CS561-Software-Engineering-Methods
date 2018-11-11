package com.example.chethangarapati.parkinglot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class thankYou extends AppCompatActivity {

    private Button home,logout;

    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        home = findViewById(R.id.button);
        logout = findViewById(R.id.logout);

        Auth = FirebaseAuth.getInstance();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ms = new Intent(thankYou.this , MainScreen.class);
                startActivity(ms);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.signOut();
                Intent login = new Intent(thankYou.this,loginScreen.class);
                startActivity(login);
            }
        });
    }
}
