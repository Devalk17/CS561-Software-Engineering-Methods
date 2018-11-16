package com.example.chethangarapati.parkinglot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class historyScreen extends AppCompatActivity {

    private Button granterhis, renterhis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_screen);

        granterhis = findViewById(R.id.grant);
        renterhis = findViewById(R.id.rent);

        granterhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gIntent = new Intent(historyScreen.this,granterhistory.class);
                startActivity(gIntent);
            }
        });

        renterhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rintent = new Intent(historyScreen.this,rentedHistory.class);
                startActivity(rintent);
            }
        });
    }
}
