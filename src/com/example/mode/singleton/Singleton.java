package com.example.mode.singleton;

/**
 * Created by xue on 15/9/11.
 */
public class Singleton {

    private Singleton(){

    }
    private static Singleton sing = new Singleton();
    public static Singleton getInstance(){
        return sing ;
    }
}
