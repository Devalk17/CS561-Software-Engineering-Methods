 package com.example.chethangarapati.parkinglot;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
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

    public Boolean house;

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
                updatedb();
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void updatedb(){
        final String house_type;
        final String parkingnum;
        if(house){
            house_type = "Individual House";
            parkingnum = "None";
        }
        else{
            house_type = "Apartment";
            parkingnum = parkingno.getText().toString();
        }
        String Address = address.getText().toString();
        String Date = datefield.getText().toString();
        String Fee = fee.getText().toString();

        String starttimehours = Integer.toString(startTime.getHour());
        String starttimemins = Integer.toString(startTime.getMinute());
        String am_pm = (startTime.getHour() < 12) ? "AM" : "PM";
        final String starttime = starttimehours+":"+starttimemins+" " + am_pm;

        String endTimehours = Integer.toString(endTime.getHour());
        String endTimemins = Integer.toString(endTime.getMinute());
        String am_pmend = (endTime.getHour() < 12) ? "AM" : "PM";
        final String endtime = endTimehours+":"+endTimemins+" " + am_pm;

        uGD = new UserGrantingDetails(Address,Date,parkingnum,Fee,starttime,endtime,house_type);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues(starttime,endtime,parkingnum,house_type);
              //  mAuth.signInWithEmailAndPassword(FirebaseAuth.getInstance().getCurrentUser().getEmail(),FirebaseAuth.getInstance().getCurrentUser())
                ref.child(FirebaseAuth.getInstance().getCurrentUser().getEmail().toString()).child("Granting Info").setValue(uGD);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    //get to set
    public void getValues(String starttime, String endTime,String pnum , String ht){
        uGD.setAddress(address.getText().toString());
        uGD.setDate(datefield.getText().toString());
        uGD.setFee(fee.getText().toString());
        uGD.setStart_time(starttime);
        uGD.setEnd_time(endTime);
        uGD.setParkingno(pnum);
        uGD.setHouse_type(ht);
    }
}



