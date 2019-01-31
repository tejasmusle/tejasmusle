package com.example.myapplication;

public class userdata {

    private  String Name;
    private  String dob;
    private  String ph;
    private  String email;
    private  String pass;


    public userdata(String name, String dob, String ph, String email, String pass) {
        Name = name;
        this.dob = dob;
        this.ph = ph;
        this.email = email;
        this.pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

