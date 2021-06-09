package com.example.kidcare;

public class Admin {
    public String fullname;

    public String staffid;
    public String emailad;
    public Admin(){

    }
    public Admin(String fullname,String admisnno,String emailad){

        this.fullname=fullname;
        this.staffid = admisnno;
        this.emailad = emailad;
    }
}
