package com.example.chethangarapati.parkinglot;

import java.net.PasswordAuthentication;

public class UserGrantingDetails {
    String address,parkingDate,parkingNo,parkingFee,startTime;
    String endTime,houseType;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParkingDate() {
        return parkingDate;
    }

    public void setParkingDate(String parkingDate) {
        this.parkingDate = parkingDate;
    }

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public String getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(String parkingFee) {
        this.parkingFee = parkingFee;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public UserGrantingDetails(String address, String date, String parkingno, String fee, String start_time, String end_time, String house_type)  {
        this.address = address;
        this.parkingDate = date;
        this.parkingNo = parkingno;
        this.parkingFee = fee;
        this.startTime = start_time;
        this.endTime = end_time;
        this.houseType = house_type;

    }


}
