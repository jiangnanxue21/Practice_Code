package com.example.mode.stragety.impl;

import com.example.mode.stragety.FlyingStragety;

/**
 * Created by xue on 15/9/14.
 */
public class FlyWithWin implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("我用翅膀飞行");
    }
}
