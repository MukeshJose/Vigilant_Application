package com.example.vigilantapplication.model;

import com.google.gson.annotations.SerializedName;

public class DriverHistory {

    public String id;
    public String user_name;
    @SerializedName("File")
    public String file;
    @SerializedName("PhoneNumber")
    public String phoneNumber;
    @SerializedName("Email")
    public String email;
    @SerializedName("Address")
    public String address;
    @SerializedName("District")
    public String district;
    @SerializedName("Subject")
    public String subject;
    @SerializedName("Description")
    public String description;
    @SerializedName("Suspect Name")
    public String suspectName;
    @SerializedName("SuspectDistrict")
    public String suspectDistrict;
    public String office_name;
    @SerializedName("Location")
    public String location;
    @SerializedName("Department")
    public String department;
    @SerializedName("Designation")
    public String designation;
    @SerializedName("Type")
    public String type;
    public String status;
    public String date;
}
