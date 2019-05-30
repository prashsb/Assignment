package com.winjit.assignement.model;

import java.util.List;

public class state_data {

    private String state;
    private double latitude;
    private double longitude;
    private int total;
    private List<applicants_data> data;

    public state_data(String state, double latitude, double longitude,
                      int total, List<applicants_data> data) {
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.total = total;
        this.data = data;
    }

    public state_data() {
    }

    public String getState() {
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getTotal() {
        return total;
    }

    public List<applicants_data> getData() {
        return data;
    }
}
