package com.myhikingpal.model;

public class HikingDayRoute extends HikingRoute {       //! Inheritance

    public HikingDayRoute(){

        super();
    }
    

    @Override
    public HikingRoute getRoute(){      //! Polymorphism

        System.out.println("The chosen location is .....");
        return this;
    }
}
