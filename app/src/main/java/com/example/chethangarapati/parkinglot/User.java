package com.example.chethangarapati.parkinglot;

public class User {



    GrantingInfo grantingInfo;

    public User() {
    }

    public GrantingInfo getGrantingInfo() {
        return grantingInfo;
    }

    public void setGrantingInfo(GrantingInfo grantingInfo) {
        this.grantingInfo = grantingInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    UserInfo userInfo;
    public static class GrantingInfo
    {
        String address;
        String startTime;
        String endTime;
        String parkingFee;
        String parkingDate;
        String houseType;
        String parkingNo;



        public GrantingInfo() {
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getParkingFee() {
            return parkingFee;
        }

        public void setParkingFee(String parkingFee) {
            this.parkingFee = parkingFee;
        }

        public String getParkingDate() {
            return parkingDate;
        }

        public void setParkingDate(String parkingDate) {
            this.parkingDate = parkingDate;
        }
        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public String getParkingNo() {
            return parkingNo;
        }

        public void setParkingNo(String parkingNo) {
            this.parkingNo = parkingNo;
        }


    }
    public static class UserInfo
    {
        String userEmail;
        String userPhone;

        public String getUserNickName() {
            return userNickName;
        }

        public void setUserNickName(String userNickName) {
            this.userNickName = userNickName;
        }

        String userNickName;

        public UserInfo() {
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }
    }
}
