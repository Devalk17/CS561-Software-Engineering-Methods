package com.example.chethangarapati.parkinglot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainScreen extends AppCompatActivity {

    private ImageButton renterButton, granterButton,logout,history;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        renterButton = findViewById(R.id.renterButton);
        granterButton = findViewById(R.id.granterButton);
        logout = findViewById(R.id.logoutbutton);
        history = findViewById(R.id.historybutton);

        Auth = FirebaseAuth.getInstance();

        renterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent rintent = new Intent(MainScreen.this , renterScreen.class);
                startActivity(rintent);
            }
        });

        granterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gintent = new Intent(MainScreen.this,granterScreen.class);
                startActivity(gintent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.signOut();
                Intent login = new Intent(MainScreen.this,loginScreen.class);
                startActivity(login);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hintent = new Intent(MainScreen.this,historyScreen.class);
                startActivity(hintent);

            }
        });
    }
}
