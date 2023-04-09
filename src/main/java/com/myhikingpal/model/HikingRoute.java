package com.myhikingpal.model;

public class HikingRoute {
    
    private String startLocation;
    private String endLocation;
    private String[] transportOptions = {"Car", "Bus", "Walk", "Bicycle"};
    private float distance;


    //TODO: ADD DATABASE SELECTION FOR ROUTES

    public HikingRoute(){
        this.distance = 0;
    }

    public HikingRoute getRoute(){

        return this;
    }
}
