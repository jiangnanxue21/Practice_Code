package com.example.mode.stragety;

import com.example.mode.stragety.impl.FlyNoWay;

/**
 * Created by xue on 15/9/14.
 */
public class BigYellow extends Duck {

    @Override
    public void display() {
        System.out.println("我是大黄鸭");
    }

    public BigYellow() {
        super.setFlyingStragety(new FlyNoWay());
    }
}
