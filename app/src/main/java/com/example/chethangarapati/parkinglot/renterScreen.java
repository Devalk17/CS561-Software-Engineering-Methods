
package com.example.chethangarapati.parkinglot;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class renterScreen extends AppCompatActivity {

    private ListView listview;

    private DatabaseReference ref;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;

    ArrayList<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_screen);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User Details");

        listview = (ListView)findViewById(R.id.renterslist);
        final ArrayAdap adapter = new ArrayAdap(this, userList);

        listview.setAdapter(adapter);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    User user1 = ds.getValue(User.class);
                    if (user1.getGrantingInfo() == null){
                    }
                    else {
                        userList.add(user1);
                    }
                }
                //adapter.addAll(userList);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        }
    }

