 package com.example.chethangarapati.parkinglot;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class granterScreen extends AppCompatActivity {

    private Switch typehouse;
    private EditText datefield, parkingno, fee, address;

    private TimePicker startTime, endTime;

    private Button grantTheSpot;


    private FirebaseAuth mAuth;


    private FirebaseDatabase database;
    private DatabaseReference ref;

    public Boolean house = false;

    UserGrantingDetails uGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_granter_screen);

        typehouse = (Switch) findViewById(R.id.switchtype);
        datefield = (EditText) findViewById(R.id.date);
        parkingno = (EditText) findViewById(R.id.parkingno);
        fee = (EditText) findViewById(R.id.feeGranter);
        address = (EditText) findViewById(R.id.addressgranter);
        startTime = (TimePicker) findViewById(R.id.startTimer);
        endTime = (TimePicker) findViewById(R.id.endTimer);
        grantTheSpot = (Button) findViewById(R.id.granterfinalbutton);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User Details");

        typehouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    parkingno.setVisibility(View.VISIBLE);
                    house = Boolean.FALSE;
                } else {
                    parkingno.setVisibility(View.GONE);
                    house = Boolean.TRUE;
                }
            }
        });


        grantTheSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Date = datefield.getText().toString();

                String starttimehours = Integer.toString(startTime.getHour());
                String starttimemins = Integer.toString(startTime.getMinute());
                String am_pm = (startTime.getHour() < 12) ? "AM" : "PM";
                final String starttime = starttimehours+":"+starttimemins+" " + am_pm;

                String endTimehours = Integer.toString(endTime.getHour());
                String endTimemins = Integer.toString(endTime.getMinute());
                String am_pmend = (endTime.getHour() < 12) ? "AM" : "PM";
                final String endtime = endTimehours+":"+endTimemins+" " + am_pmend;
                AlertDialog.Builder warning = new AlertDialog.Builder(granterScreen.this);
                warning.setTitle("Confirmation").setMessage("Do you want to Rent the Spot from "+starttime+" to "+endtime+" on "+Date+" ?").setCancelable(false).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {updatedb();
                        Intent ty = new Intent(granterScreen.this,thankYou.class);
                        startActivity(ty);

                    }
                }).setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
                }
        });
    }

        public void updatedb () {
            //Log.d("executing", "in db");
            Toast.makeText(getApplicationContext(), "in db", Toast.LENGTH_SHORT).show();
            final String house_type;
            final String parkingnum;
            if (house) {
                house_type = "Individual House";
                parkingnum = "None";
            } else {
                house_type = "Apartment";
                parkingnum = parkingno.getText().toString();
            }
            String Address = address.getText().toString();
            String Date = datefield.getText().toString();
            String Fee = fee.getText().toString();
            Log.d("executing", house.toString());
            //Log.d("executing",parkingnum);
            Log.d("executing", Date);

            String starttimehours = Integer.toString(startTime.getHour());
            String starttimemins = Integer.toString(startTime.getMinute());
            String am_pm = (startTime.getHour() < 12) ? "AM" : "PM";
            final String starttime = starttimehours + ":" + starttimemins + " " + am_pm;

            String endTimehours = Integer.toString(endTime.getHour());
            String endTimemins = Integer.toString(endTime.getMinute());
            String am_pmend = (endTime.getHour() < 12) ? "AM" : "PM";
            final String endtime = endTimehours + ":" + endTimemins + " " + am_pm;

            Log.d("executing", endtime);

            uGD = new UserGrantingDetails(Address, Date, parkingnum, Fee, starttime, endtime, house_type);


            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    getValues(starttime, endtime, parkingnum, house_type);
                    final FirebaseUser curUser = mAuth.getCurrentUser();
                    //  mAuth.signInWithEmailAndPassword(FirebaseAuth.getInstance().getCurrentUser().getEmail(),FirebaseAuth.getInstance().getCurrentUser())
                    ref.child(curUser.getUid()).child("grantingInfo").setValue(uGD);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        //get to set
        public void getValues (String starttime, String endTime, String pnum, String ht){
            uGD.setAddress(address.getText().toString());
            uGD.setParkingDate(datefield.getText().toString());
            uGD.setParkingFee(fee.getText().toString());
            uGD.setStartTime(starttime);
            uGD.setEndTime(endTime);
            uGD.setParkingNo(pnum);
            uGD.setHouseType(ht);
        }

    }




