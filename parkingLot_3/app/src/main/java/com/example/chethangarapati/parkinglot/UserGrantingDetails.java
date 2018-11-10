package com.example.chethangarapati.parkinglot;

import java.net.PasswordAuthentication;

public class UserGrantingDetails {
    private String address,date,parkingno,fee,start_time;
    public String end_time,house_type;



    public UserGrantingDetails(String address, String date, String parkingno, String fee, String start_time, String end_time, String house_type)  {
        this.address = address;
        this.date = date;
        this.parkingno = parkingno;
        this.fee = fee;
        this.start_time = start_time;
        this.end_time = end_time;
        this.house_type = house_type;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getParkingno() {
        return parkingno;
    }

    public void setParkingno(String parkingno) {
        this.parkingno = parkingno;
    }
    public String getFee(){return fee; }

    public void setFee(String fee) {
        this.fee = fee;
    }
    public String getStart_time(){ return start_time; }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getEnd_time(){return end_time;}

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String gethouse_type(){ return house_type; }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }
}
