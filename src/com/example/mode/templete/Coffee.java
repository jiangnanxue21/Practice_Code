package com.example.mode.templete;

/**
 * Created by xue on 15/9/13.
 */
public class Coffee extends RefreshBeverage {
    @Override
    protected void brew() {
        System.out.println("泡咖啡");
    }

    @Override
    protected void addCondiments() {

        System.out.println("加入糖和牛奶");
    }
}
