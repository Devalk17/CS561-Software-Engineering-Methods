package com.example.chethangarapati.parkinglot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayAdap extends ArrayAdapter<User> {
    public ArrayAdap(Context context, ArrayList<User> users) {
        super(context, 0, users );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_renter_details, parent, false);
        }

        TextView emailt = (TextView) convertView.findViewById(R.id.email);
        TextView phonenumbert = (TextView) convertView.findViewById(R.id.phonenumber);
        TextView addresst = (TextView) convertView.findViewById(R.id.address);
        TextView starttimet = (TextView) convertView.findViewById(R.id.starttime);
        TextView endtimet = (TextView) convertView.findViewById(R.id.endtime);
        TextView datet = (TextView) convertView.findViewById(R.id.date);
        TextView feet = (TextView) convertView.findViewById(R.id.fee);
        TextView ht = (TextView) convertView.findViewById(R.id.housetype);
        TextView pn = (TextView) convertView.findViewById(R.id.parkingno);

        emailt.setText("E-mail: "+user.getUserInfo().getUserEmail());
        phonenumbert.setText("No: "+user.getUserInfo().getUserPhone());
        addresst.setText("Address: "+user.getGrantingInfo().getAddress());
        starttimet.setText("Start Time: "+user.getGrantingInfo().getStartTime());
        endtimet.setText("End Time:"+user.getGrantingInfo().getEndTime());
        datet.setText("Date: "+user.getGrantingInfo().getParkingDate());
        feet.setText("Fee($): "+user.getGrantingInfo().getParkingFee());
        ht.setText("House Type:"+user.getGrantingInfo().getHouseType());
        pn.setText("Parking NO:"+user.getGrantingInfo().getParkingNo());

        return convertView;
    }
}