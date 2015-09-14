package com.example.mode.templete;

/**
 * Created by xue on 15/9/13.
 */
public class Tea extends RefreshBeverage {
    @Override
    protected void brew() {
        System.out.println("浸泡茶叶");
    }

    @Override
    protected void addCondiments() {

        System.out.println("加入柠檬");
    }
}
