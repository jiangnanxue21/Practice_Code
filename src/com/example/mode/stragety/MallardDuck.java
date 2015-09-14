package com.example.mode.stragety;

import com.example.mode.stragety.impl.FlyNoWay;

/**
 * Created by xue on 15/9/14.
 */
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }

    public MallardDuck(){
        super.setFlyingStragety(new FlyNoWay());
    }

}
