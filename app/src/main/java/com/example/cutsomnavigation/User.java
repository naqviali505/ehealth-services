package com.example.cutsomnavigation;

public class User
{

    String fname;
    String lname;
    String email;
    String pass;
    String gender;
    String status;


    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    User(String fname, String lname, String email, String pass, String gender, String status)
    {
//        this.id=id;
        this.email=email;
        this.fname=fname;
        this.lname=lname;
        this.pass=pass;
        this.gender=gender;
        this.status=status;
    }
}
