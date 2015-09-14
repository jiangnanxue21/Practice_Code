package com.example.mode.stragety;

/**
 * Created by xue on 15/9/14.
 */
public abstract class Duck {

    public void quack()
    {
        System.out.println("嘎嘎嘎");
    }

    public abstract void display();

    private FlyingStragety flyingStragety ;
    public void setFlyingStragety(FlyingStragety flyingStragety)
    {
        this.flyingStragety = flyingStragety ;
    }

    public void fly(){
        flyingStragety.performFly();
    }

}
