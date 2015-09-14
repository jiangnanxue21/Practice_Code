package com.example.junit;

/**
 * Created by xue on 15/9/10.
 */
public abstract class Beverage {
    String description = "Unknown Beverage" ;
    public String getDescription(){
        return description ;
    }
    public abstract double cost();
}
