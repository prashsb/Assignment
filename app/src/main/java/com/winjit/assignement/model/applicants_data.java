package com.winjit.assignement.model;

public class applicants_data {

    private String name, state, address, pan_no;
    private int mobile, adhar_no;

    public applicants_data() {
    }


    public applicants_data(String name, String state, String address,
                           String pan_no, int mobile, int adhar_no) {
        this.name = name;
        this.state = state;
        this.address = address;
        this.pan_no = pan_no;
        this.mobile = mobile;
        this.adhar_no = adhar_no;
    }


    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public String getPan_no() {
        return pan_no;
    }

    public int getMobile() {
        return mobile;
    }

    public int getAdhar_no() {
        return adhar_no;
    }
}