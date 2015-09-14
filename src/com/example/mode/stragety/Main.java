package com.example.mode.stragety;

/**
 * Created by xue on 15/9/14.
 */
public class Main {
    public static void main(String[] args) {
        BigYellow by = new BigYellow() ;
        by.display();
        by.fly();
        by.quack();
        System.out.println("=============");
        MallardDuck md = new MallardDuck() ;
        md.display();
        md.fly();
        md.quack();
    }
}
