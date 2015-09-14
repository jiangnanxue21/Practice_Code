package com.example.mode.singleton;

/**
 * Created by xue on 15/9/11.
 */
public class Singleton2 {
    private Singleton2(){

    }
    private static Singleton2 instance ;
    public static Singleton2 getInstance(){
        if (instance==null)
            instance =  new Singleton2();
        return instance;

    }
}
