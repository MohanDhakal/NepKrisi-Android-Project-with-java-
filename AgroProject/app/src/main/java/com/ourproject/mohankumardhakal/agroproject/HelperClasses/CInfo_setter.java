package com.ourproject.mohankumardhakal.agroproject.HelperClasses;

public class CInfo_setter {
    String firstname;
    String lastname;
    String address;
    String bio;
    String contact;
    String job;
    String userid;

    public String getFirstname() {
        return firstname;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {

        return userid;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getBio() {
        return bio;
    }

    public String getContact() {
        return contact;
    }

    public String getJob() {
        return job;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public CInfo_setter(String firstname, String lastname, String address, String bio, String job, String contact,String userid) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.address = address;
        this.bio = bio;

        this.contact=contact;
        this.job=job;
        this.userid=userid;
    }


}
